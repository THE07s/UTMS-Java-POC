import java.util.Arrays;

public class Ligne {

    // --- Attributs principaux ---
    private int identifiant;
    private String nom;
    private String modeTransport;
    private String[] stationsDesservies;

    /**
     * Constructeur de la classe Station.
     *
     * @param identifiant           L'identifiant numérique de la ligne.
     * @param nom                   Le nom de la ligne.
     * @param modeTransport         Les différents modes de transport disponibles.
     */
    public Ligne(int identifiant,
                 String nom,
                 String modeTransport,
                 String[] stationsDesservies) {

        this.identifiant = identifiant;
        this.nom = nom;
        this.modeTransport = modeTransport;
        this.stationsDesservies = stationsDesservies;
    }

    // --- Getters (accesseurs) ---

    public int getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getModeTransport() {
        return modeTransport;
    }

    public String getStationsDesservies() {
        return Arrays.toString(stationsDesservies);
    }

    public String[] getListeStationsDesservies() {
        return stationsDesservies;
    }

    public String toString() {
        return identifiant + ") " + nom;
    }

    /**
     * Retourne une chaîne détaillée des informations de la ligne.
     */
    public String informationsDetaillees() {
        return "Nom : " + nom + "\n"
             + "Mode de transport : " + this.getModeTransport() + "\n"
             + "Stations desservies : " + this.getStationsDesservies() + "\n";
    }
}