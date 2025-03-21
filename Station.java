// --- Station.java ---

import java.util.Arrays;
import java.util.ArrayList;

/**
 * La classe Station représente une station du réseau de transport.
 * Elle contient un identifiant, un nom, une description des services,
 * la liste des lignes desservies, et des coordonnées scindées (lat/long).
 */
public class Station {

    // --- Attributs principaux ---
    private int identifiant;
    private String nom;
    private String[] servicesDisponibles;
    private String[] lignesDesservies;
    private String[] modesTransport;


    // --- Coordonnées latitude ---
    private int degresLatitude;
    private int minutesLatitude;
    private double secondesLatitude;
    private char directionLatitude; // 'N' ou 'S'

    // --- Coordonnées longitude ---
    private int degresLongitude;
    private int minutesLongitude;
    private double secondesLongitude;
    private char directionLongitude; // 'E' ou 'W'

    /**
     * Constructeur de la classe Station.
     * <p>
     * Initialise une nouvelle instance de Station en spécifiant l'identifiant, le nom, la liste des services disponibles, les lignes desservies, les modes de transport et les coordonnées de la station.
     * </p>
     *
     * @param identifiant           L'identifiant numérique de la station.
     * @param nom                   Le nom de la station.
     * @param servicesDisponibles   Les services disponibles à la station.
     * @param lignesDesservies      Les lignes desservies par la station.
     * @param modesTransport        Les modes de transport disponibles à la station.
     *
     * @param degLat                Degrés de la latitude.
     * @param minLat                Minutes de la latitude.
     * @param secLat                Secondes de la latitude.
     * @param dirLat                Direction de la latitude ('N' ou 'S').
     *
     * @param degLong               Degrés de la longitude.
     * @param minLong               Minutes de la longitude.
     * @param secLong               Secondes de la longitude.
     * @param dirLong               Direction de la longitude ('E' ou 'W').
     */
    public Station(int identifiant,
                   String nom,
                   String[] servicesDisponibles,
                   int degLat,
                   int minLat,
                   double secLat,
                   char dirLat,
                   int degLong,
                   int minLong,
                   double secLong,
                   char dirLong) {

        this.identifiant = identifiant;
        this.nom = nom;
        this.servicesDisponibles = servicesDisponibles;

        this.degresLatitude = degLat;
        this.minutesLatitude = minLat;
        this.secondesLatitude = secLat;
        this.directionLatitude = dirLat;

        this.degresLongitude = degLong;
        this.minutesLongitude = minLong;
        this.secondesLongitude = secLong;
        this.directionLongitude = dirLong;
    }

    // --- Getters ---


    /** Retourne l'identifiant de la station. */
    public int getIdentifiant() {
        return identifiant;
    }

    /** Retourne le nom de la station. */
    public String getNom() {
        return nom;
    }

    /** Retourne les services disponibles sous forme de chaîne. */
    public String getServicesDisponibles() {
        return Arrays.toString(servicesDisponibles);
    }

    /** Retourne les lignes desservies sous forme de chaîne. */
    public String getLignesDesservies() {
        ArrayList<String> lignesList = new ArrayList<>();
        for (Ligne ligne : Lignes.getListeLignes()) {
            if (Arrays.asList(ligne.getListeStationsDesservies()).contains(nom)) {
                lignesList.add(ligne.getNom());
            }
        }
        lignesDesservies = lignesList.toArray(new String[0]);
        return Arrays.toString(lignesDesservies);
    }
    
    /** Retourne les modes de transport disponibles sous forme de chaîne. */
    public String getModesTransport() {
        ArrayList<String> modesList = new ArrayList<>();
        for (Ligne ligne : Lignes.getListeLignes()) {
            if (Arrays.asList(ligne.getListeStationsDesservies()).contains(nom)) {
                modesList.add(ligne.getModeTransport());
            }
        }
        modesTransport = modesList.toArray(new String[0]);
        return Arrays.toString(modesTransport);
    }
    
    public int getDegresLatitude() {
        return degresLatitude;
    }

    public int getMinutesLatitude() {
        return minutesLatitude;
    }

    public double getSecondesLatitude() {
        return secondesLatitude;
    }

    public char getDirectionLatitude() {
        return directionLatitude;
    }

    public int getDegresLongitude() {
        return degresLongitude;
    }

    public int getMinutesLongitude() {
        return minutesLongitude;
    }

    public double getSecondesLongitude() {
        return secondesLongitude;
    }

    public char getDirectionLongitude() {
        return directionLongitude;
    }

    /** Renvoie une représentation simple de la station. */
    public String toString() {
        return identifiant + ") " + nom;
    }

    /**
     * Retourne une description détaillée de la station.
     * <p>
     * La description inclut le nom, les services disponibles et les coordonnées complètes.
     * </p>
     *
     * @return une chaîne qui détataille ltaes infortamations de la station.
     */
    public String informationsDetaillees() {
        return "Nom : " + nom + "\n"
             + "Services disponibles : " + this.getServicesDisponibles() + "\n"
             + "Lignes desservies : " + this.getLignesDesservies() + "\n"
             + "Modes de transport : " + this.getModesTransport() + "\n"
             + "Coordonnées : "
             + degresLatitude + "° "
             + minutesLatitude + "' "
             + secondesLatitude + "\" "
             + directionLatitude + " , "
             + degresLongitude + "° "
             + minutesLongitude + "' "
             + secondesLongitude + "\" "
             + directionLongitude;
    }
}