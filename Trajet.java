import java.util.Vector;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;

public class Trajet {
    private static Graph<String> graphPrix;
    private static Graph<String> graphDistance;
    private static Graph<String> graphAccessibilite;
    private static Graph<String> graphTemps;
    
    // Nouvelle map pour enregistrer le mode de transport associé à chaque arête.
    private static HashMap<String, String> edgeModes = new HashMap<>();

    static {
        // Initialisation des graphes
        graphPrix = new Graph<>(true, true);
        graphDistance = new Graph<>(true, true);
        graphAccessibilite = new Graph<>(true, true);
        graphTemps = new Graph<>(true, true);

        // Ajout de tous les noeuds à partir des stations
        Stations.getListeStations().forEach(s -> {
            String nom = s.getNom();
            graphPrix.addNode(nom);
            graphDistance.addNode(nom);
            graphAccessibilite.addNode(nom);
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

                // Gestion des cas particuliers
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

        // Ajout de l'arête manquante entre Riverside et Queensbridge
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

    private static Station convertirStation(String nom) {
        for (Station s : Stations.getListeStations()) {
            if (s.getNom().equals(nom)) {
                return s;
            }
        }
        return null;
    }

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

    private static double getLatitudeDecimale(Station s) {
        double minutesFraction = s.getMinutesLatitude() / 60.0;
        double secondesFraction = s.getSecondesLatitude() / 3600.0;
        double decimal = s.getDegresLatitude() + minutesFraction + secondesFraction;
        return decimal;
    }

    private static double getLongitudeDecimale(Station s) {
        double minutesFraction = s.getMinutesLongitude() / 60.0;
        double secondesFraction = s.getSecondesLongitude() / 3600.0;
        double decimal = s.getDegresLongitude() + minutesFraction + secondesFraction;
        return decimal;
    }

    private static void addEdge(String from, String to, double prix, double distance, double accessibilite, double temps, String modeTransport) {
        graphPrix.addEdge(from, to, prix);
        graphDistance.addEdge(from, to, distance);
        graphAccessibilite.addEdge(from, to, accessibilite);
        graphTemps.addEdge(from, to, temps);
        edgeModes.put(from + "-" + to, modeTransport);
    }

    public static double calculerPrix(double distance, String typeTransport, String typeUsager) {
        double tarifBase = 1.50;
        double multiplicateur = 1.0;
        switch (typeTransport) {
            case "Metro":  multiplicateur = 1.2; break;
            case "Tram":   multiplicateur = 1.0; break;
            case "Bus":    multiplicateur = 0.8; break;
        }
        switch (typeUsager.toLowerCase()) {
            case "3":  multiplicateur *= 0.5; break;
            case "2":  multiplicateur *= 0.8; break;
            case "1":  multiplicateur *= 1.0; break;
        }
        return tarifBase + (distance / 1000) * multiplicateur;
    }

    public static double calculerTemps(double distance, String typeTransport) {
        double vitesse = 0;
        switch (typeTransport) {
            case "Metro":  vitesse = 500; break;
            case "Tram":   vitesse = 400; break;
            case "Bus":    vitesse = 300; break;
        }
        return (distance / vitesse) + 60;
    }

    public static double calculerAccessibilite(Station station) {
        for (String service : station.getServicesDisponibles().split(", ")) {
            if (service.trim().contains("♿️🚫")) {
                return 0;
            }
        }
        return 1;
    }

    // --- NOUVELLE MÉTHODE : Production d'un itinéraire personnalisé ---
    public static void produireItineraire() {
        // Demander à l'utilisateur l'id de la station de départ et d'arrivée
        System.out.print("ID de la station de départ : ");
        String departIdStr = System.console().readLine();
        int departId = Integer.parseInt(departIdStr);
        
        System.out.print("ID de la station d'arrivée : ");
        String arriveeIdStr = System.console().readLine();
        int arriveeId = Integer.parseInt(arriveeIdStr);
        
        // Récupérer les noms des stations à partir de leur id
        Station departStation = chercherStationParId(departId);
        Station arriveeStation = chercherStationParId(arriveeId);
        
        if(departStation == null || arriveeStation == null) {
            System.out.println("L'une des stations spécifiées n'existe pas.");
            return;
        }
        
        String depart = departStation.getNom();
        String arrivee = arriveeStation.getNom();
        
        // Demander le critère d'itinéraire
        System.out.println("Choisissez le critère d'optimisation :");
        System.out.println("1) Payer le moins cher");
        System.out.println("2) Aller le plus vite");
        System.out.println("3) Se déplacer sur la distance la plus courte");
        System.out.print("Votre choix : ");
        String choixCritere = System.console().readLine();
        
        Graph<String> graphChoisi;
        switch (choixCritere) {
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
                System.out.println("Critère invalide. Utilisation du critère 'moins cher' par défaut.");
                graphChoisi = graphPrix;
                break;
        }
        
        // Récupérer le chemin optimal (méthode Ford par exemple)
        ArrayList<String> chemin = graphChoisi.pathFollowed(depart, arrivee);
        if (chemin == null || chemin.isEmpty()) {
            System.out.println("Aucun itinéraire trouvé entre " + depart + " et " + arrivee);
            return;
        }
        
        double totalPrix = 0, totalTemps = 0, totalDistance = 0;
        
        // Affichage de l'itinéraire détaillé
        System.out.println("\nItinéraire de " + depart + " à " + arrivee + " :");
        for (int i = 0; i < chemin.size() - 1; i++) {
            String from = chemin.get(i);
            String to = chemin.get(i + 1);
            String mode = edgeModes.get(from + "-" + to);
            Station sFrom = chercherStationParNom(from);
            Station sTo = chercherStationParNom(to);
            double dist = calculerDistance(sFrom, sTo);
            double prix = calculerPrix(dist, mode, Interface.getTypeUsager());
            double temps = calculerTemps(dist, mode);
            System.out.println("De " + from + " à " + to + " (" + mode + ") : " +
                               "Distance = " + String.format("%.2f", dist) + " m, " +
                               "Temps = " + String.format("%.2f", temps) + " sec, " +
                               "Prix = " + String.format("%.2f", prix) + " €");
            totalPrix += prix;
            totalTemps += temps;
            totalDistance += dist;
        }
        
        System.out.println("\nTotal : Prix = " + String.format("%.2f", totalPrix) +
                           " €, Temps = " + String.format("%.2f", totalTemps) + " sec, " +
                           "Distance = " + String.format("%.2f", totalDistance) + " m");
    }

    // Méthode utilitaire pour retrouver une station par son nom dans Stations
    private static Station chercherStationParNom(String nom) {
        for (Station s : Stations.getListeStations()) {
            if (s.getNom().equalsIgnoreCase(nom)) {
                return s;
            }
        }
        return null;
    }

    // Nouvelle méthode pour chercher une station à partir de son id
    private static Station chercherStationParId(int id) {
        for (Station s : Stations.getListeStations()) {
            if (s.getId() == id) { // On suppose que la classe Station possède une méthode getId()
                return s;
            }
        }
        return null;
    }

    /**
     * Affiche les représentations textuelles de chaque graphe.
     */
    public static void getGraphes() {
        System.out.println("Graph par prix:");
        System.out.println(graphPrix.representation());
        System.out.println("Graph par distance:");
        System.out.println(graphDistance.representation());
        System.out.println("Graph par accessibilité:");
        System.out.println(graphAccessibilite.representation());
        System.out.println("Graph par temps:");
        System.out.println(graphTemps.representation());
    }

    // public static void main(String[] args) {
    //     // Par exemple, lancer la production d'itinéraire
    //     produireItineraire();
    // }
}