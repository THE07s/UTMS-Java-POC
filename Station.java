import java.util.Arrays;

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
     *
     * @param identifiant           L'identifiant numérique de la station.
     * @param nom                   Le nom de la station.
     * @param servicesDisponibles   Les services disponibles à la station.
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

    // --- Getters (accesseurs) ---

    public int getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getServicesDisponibles() {
        return Arrays.toString(servicesDisponibles);
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

    public String toString() {
        return identifiant + ") " + nom;
    }

    /**
     * Retourne une chaîne détaillée des informations de la station.
     */
    public String informationsDetaillees() {
        return "Nom : " + nom + "\n"
             + "Services disponibles : " + this.getServicesDisponibles() + "\n"
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