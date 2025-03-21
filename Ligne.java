// --- Ligne.java ---

import java.util.Arrays;

/**
 * La classe Ligne représente une ligne de transport.
 * Elle contient un identifiant, un nom, un mode de transport et la liste des stations desservies.
 */
public class Ligne {
    private final int identifiant;
    private final String nom;
    private final String modeTransport;
    private final String[] stationsDesservies;

    /**
     * Constructeur de Ligne.
     * 
     * @param identifiant L'identifiant de la ligne.
     * @param nom Le nom de la ligne.
     * @param modeTransport Le mode de transport (Metro, Bus, Tram, etc.).
     * @param stationsDesservies Le tableau des noms de stations desservies.
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
     * Retourne une description détaillée de la ligne.
     */
    public String informationsDetaillees() {
        return "Nom : " + nom + "\n"
             + "Mode de transport : " + this.getModeTransport() + "\n"
             + "Stations desservies : " + this.getStationsDesservies() + "\n";
    }
}