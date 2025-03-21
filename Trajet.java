// --- Trajet.java ---

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Trajet gère le calcul d'itinéraires en utilisant les objets Station et Ligne.
*/
public class Trajet {
    private static final Graph<String> graphPrix;
    private static final Graph<String> graphDistance;
    private static final Graph<String> graphTemps;
    
    // Nouvelle map pour enregistrer le mode de transport associé à chaque arête (venant de ChatGPT)
    private static final HashMap<String, String> edgeModes = new HashMap<>();

    static {
        // Initialisation des graphes
        graphPrix = new Graph<>(true, true);
        graphDistance = new Graph<>(true, true);
        graphTemps = new Graph<>(true, true);

        // Ajout de tous les noeuds à partir des stations
        Stations.getListeStations().forEach(s -> {
            String nom = s.getNom();
            graphPrix.addNode(nom);
            graphDistance.addNode(nom);
            graphTemps.addNode(nom);
        });

        // Parcours des lignes pour ajouter les arêtes
        for (Ligne ligne : Lignes.getListeLignes()) {
            String modeTransport = ligne.getModeTransport();
            String[] stationsLigne = ligne.getListeStationsDesservies();
            for (int i = 0; i < stationsLigne.length - 1; i++) {
                String nom1 = stationsLigne[i];
                String nom2 = stationsLigne[i + 1];
                Station s1 = convertirStation(nom1);
                Station s2 = convertirStation(nom2);
                double distance = calculerDistance(s1, s2);
                double prix = calculerPrix(distance, modeTransport, Interface.getTypeUsager());
                double temps = calculerTemps(distance, modeTransport);
                double accessibilite = (calculerAccessibilite(s1) == 0 || calculerAccessibilite(s2) == 0) ? 0 : 1;

                // Gestion de l'arête orientée entre Riverside et Queensbridge
                if (nom1.equals("Queensbridge") && nom2.equals("Parkside Place")) {
                    addEdge(nom1, nom2, prix, distance, accessibilite, temps, modeTransport);
                } else if (nom1.equals("Parkside Place") && nom2.equals("Queensbridge")){
                    continue;
                } else {
                    addEdge(nom1, nom2, prix, distance, accessibilite, temps, modeTransport);
                    addEdge(nom2, nom1, prix, distance, accessibilite, temps, modeTransport);
                }
            }
        }

        // Ajout de l'arête entre Riverside et Queensbridge
        Station stationRiverside = convertirStation("Riverside");
        Station stationQueensbridge = convertirStation("Queensbridge");

        String modeTransport = "Bus";
        double distance = calculerDistance(stationRiverside, stationQueensbridge);
        double prix = calculerPrix(distance, modeTransport, Interface.getTypeUsager());
        double temps = calculerTemps(distance, modeTransport);
        double accessibilite = (calculerAccessibilite(stationRiverside) == 0 || calculerAccessibilite(stationQueensbridge) == 0) ? 0 : 1;

        addEdge("Riverside", "Queensbridge", prix, distance, accessibilite, temps, modeTransport);
        addEdge("Queensbridge", "Riverside", prix, distance, accessibilite, temps, modeTransport);
    }

    /**
     * Recherche une station à partir de son nom.
     *
     * @param nom le nom de la station
     * @return la station correspondante ou null
     */
    private static Station convertirStation(String nom) {
        for (Station s : Stations.getListeStations()) {
            if (s.getNom().equals(nom)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Calcule la distance entre deux stations en utilisant la formule de Haversine.
     *
     * @param s1 la première station
     * @param s2 la deuxième station
     * @return la distance en mètres entre les deux stations
     */
    private static double calculerDistance(Station s1, Station s2) {
        double lat1 = Math.toRadians(getLatitudeDecimale(s1));
        double lat2 = Math.toRadians(getLatitudeDecimale(s2));
        double lon1 = Math.toRadians(getLongitudeDecimale(s1));
        double lon2 = Math.toRadians(getLongitudeDecimale(s2));
        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;
        double a = Math.pow(Math.sin(deltaLat / 2), 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double R = 6364673;
        return R * c;
    }

    /**
     * Renvoie la latitude décimale d'une station.
     *
     * @param s la station
     * @return la latitude en format décimal
     */
    private static double getLatitudeDecimale(Station s) {
        double minutesFraction = s.getMinutesLatitude() / 60.0;
        double secondesFraction = s.getSecondesLatitude() / 3600.0;
        double decimal = s.getDegresLatitude() + minutesFraction + secondesFraction;
        return decimal;
    }

    /**
     * Renvoie la longitude décimale d'une station.
     *
     * @param s la station
     * @return la longitude en format décimal
     */
    private static double getLongitudeDecimale(Station s) {
        double minutesFraction = s.getMinutesLongitude() / 60.0;
        double secondesFraction = s.getSecondesLongitude() / 3600.0;
        double decimal = s.getDegresLongitude() + minutesFraction + secondesFraction;
        return decimal;
    }

    /**
     * Ajoute une arête dans les graphes et enregistre le mode de transport associé.
     *
     * @param from           la station de départ
     * @param to             la station d'arrivée
     * @param prix           le coût associé à l'arête
     * @param distance       la distance entre les stations
     * @param accessibilite  l'accessibilité de l'arête (0 ou 1)
     * @param temps          le temps de trajet sur l'arête
     * @param modeTransport  le mode de transport utilisé
     */
    private static void addEdge(String from, String to, double prix, double distance, double accessibilite, double temps, String modeTransport) {
        graphPrix.addEdge(from, to, prix);
        graphDistance.addEdge(from, to, distance);
        graphTemps.addEdge(from, to, temps);
        edgeModes.put(from + "-" + to, modeTransport);
    }

    /**
     * Calcule le prix en fonction de la distance, du type de transport et du type d'usager pour le placer comme poids.
     */
    public static double calculerPrix(double distance, String typeTransport, String typeUsager) {
        double multiplicateur = 1.0;
        switch (typeTransport) {
            case "Metro":  multiplicateur = 1.2;    break;
            case "Tram":   multiplicateur = 1.0;    break;
            case "Bus":    multiplicateur = 0.8;    break;
        }
        switch (typeUsager) {
            case "3":  multiplicateur *= 0.5;   break;
            case "2":  multiplicateur *= 0.8;   break;
            case "1":  multiplicateur *= 1.0;   break;
        }
        return (distance / 1000) * multiplicateur;
    }

    public static double getTarifBase() {
        return 1.50;
    }

    public static double getIncrementPourSegment(String mode) {
        switch (mode) {
            case "Metro":   return 0.40;
            case "Tram":    return 0.30;
            case "Bus":     return 0.20;
            default:        return 0.0;
        }
    }

    public static double getReduction(String typeUsager) {
        switch (typeUsager) {
            case "3":   return 0.5;
            case "2":   return 0.8;
            case "1":   return 1.0;
            default:    return 1.0;
        }
    }

    /**
     * Calcule le temps de trajet.
     */
    public static double calculerTemps(double distance, String typeTransport) {
        double vitesse = 0;
        switch (typeTransport) {
            case "Metro":  vitesse = 500;   break;
            case "Tram":   vitesse = 400;   break;
            case "Bus":    vitesse = 300;   break;
        }
        return (distance / vitesse) + 60;
    }

    /**
     * Détermine l'accessibilité d'une station.
     * Si l'un des services disponibles contient le symbole "♿️🚫", la station est considérée comme
     * inaccessible.
     *
     * @param station la station à tester
     * @return 0 si la station n'est pas accessible, 1 sinon
     */
    public static double calculerAccessibilite(Station station) {
        for (String service : station.getServicesDisponibles().split(", ")) {
            if (service.trim().contains("♿️🚫")) {
                return 0;
            }
        }
        return 1;
    }

    /**
     * Donne l'itinéraire entre deux stations.
    */
    public static void produireItineraire() {
        Station departStation = chercherStationParId(Interface.getDepartId());
        Station arriveeStation = chercherStationParId(Interface.getArriveeId());
        
        if (departStation == null || arriveeStation == null) {
            System.out.println("L'une des stations spécifiées n'existe pas.");
            return;
        } else if (departStation.equals(arriveeStation)) {
            System.out.println("Les stations de départ et d'arrivée sont identiques.");
            return;
        } else if (calculerAccessibilite(departStation) == 0 || calculerAccessibilite(arriveeStation) == 0) {
            System.out.println("L'une des stations n'est pas accessible.");
            return;
        }
        
        String depart = departStation.getNom();
        String arrivee = arriveeStation.getNom();
        
        Graph<String> graphChoisi;
        switch (Interface.getChoixCritere()) {
            case "1":
                graphChoisi = graphPrix;
                break;
            case "2":
                graphChoisi = graphTemps;
                break;
            case "3":
                graphChoisi = graphDistance;
                break;
            default:
                System.out.println("Critère invalide. Utilisation du critère de prix par défaut.");
                graphChoisi = graphPrix;
                break;
        }
        
        ArrayList<String> chemin = graphChoisi.pathFollowed(depart, arrivee);
        if (chemin == null || chemin.isEmpty()) {
            System.out.println("Aucun itinéraire trouvé entre " + depart + " et " + arrivee);
            return;
        }
        
        double totalIncrement = 0;
        
        System.out.println("\nItinéraire de " + depart + " à " + arrivee + " 🧭 :");
        for (int i = 0; i < chemin.size() - 1; i++) {
            String from = chemin.get(i);
            String to = chemin.get(i + 1);
            String mode = edgeModes.get(from + "-" + to);
            Station sFrom = chercherStationParNom(from);
            Station sTo = chercherStationParNom(to);
            double dist = calculerDistance(sFrom, sTo);
            double coutSegment = getIncrementPourSegment(mode);
            totalIncrement += coutSegment;
            double temps = calculerTemps(dist, mode);
            
            System.out.println("De 📍" + from + " à 📍" + to + " (" + mode + ") : " +
                               "Distance = " + String.format("%.2f", dist) + " m, " +
                               "Temps = " + String.format("%.2f", temps) + " sec ");
        }
        
        double totalAvantReduction = getTarifBase() + totalIncrement;
        double totalPrix = totalAvantReduction * getReduction(Interface.getTypeUsager());
        
        System.out.println("Total : " + String.format("%.2f", totalPrix) + " €");
    }

    /**
     * Recherche une station à partir de son nom.
     *
     * @param nom le nom de la station recherchée
     * @return la station correspondante ou null
     */
    private static Station chercherStationParNom(String nom) {
        for (Station s : Stations.getListeStations()) {
            if (s.getNom().equalsIgnoreCase(nom)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Recherche une station à partir de son identifiant.
     *
     * @param id l'identifiant de la station
     * @return la station correspondante ou null
     */
    private static Station chercherStationParId(int id) {
        for (Station s : Stations.getListeStations()) {
            if (s.getIdentifiant() == id) { 
                return s;
            }
        }
        return null;
    }

    /**
     * Affiche les représentations de chaque graphe.
     */
    public static void getGraphes() {
        System.out.println("Graph par prix:");
        System.out.println(graphPrix.representation());
        System.out.println("Graph par distance:");
        System.out.println(graphDistance.representation());
        System.out.println("Graph par temps:");
        System.out.println(graphTemps.representation());
    }

}