// --- Lignes.java ---

import java.util.Vector;

/**
 * La classe Lignes gère la liste de toutes les lignes du réseau.
 */
public class Lignes {

    /**
     * Retourne la liste complète des lignes.
     */
    private static final Vector<Ligne> listeLignes = new Vector<>();

    // Bloc statique : initialisation de toutes les lignes
    static {
        // 1) Millenium
        listeLignes.add(new Ligne(
                1,
                "Millenium",
                "Metro",
                new String[]{"Jubilee Place", "King’s Way", "Grand Central", "Market Place", "Northgate Shopping Centre"}
        ));

        // 2) Heritage
        listeLignes.add(new Ligne(
                2,
                "Heritage",
                "Metro",
                new String[]{"Ashford Road", "Brookside Avenue", "Fairfields", "Grand Central", "Town Hall", "Victoria Docks"}
        ));

        // 3) University
        listeLignes.add(new Ligne(
                3,
                "University",
                "Bus",
                new String[]{"Ashford Road", "Castle Hill", "High Street", "Northgate Shopping Centre", "Xenobiotics Research Center", "Victoria Docks"}
        ));

        // 4) Riverview
        listeLignes.add(new Ligne(
                4,
                "Riverview",
                "Bus",
                new String[]{"Southbank Place", "Union Street", "Waterfront", "Victoria Docks"}
        ));

        // 5) Parkland
        listeLignes.add(new Ligne(
                5,
                "Parkland",
                "Tram",
                new String[]{"Parkside Place", "Jubilee Place", "King’s Way", "Southbank Place", "Grand Central", "Eastbourne West", "Brookside Avenue"}
        ));

        // 6) Market
        listeLignes.add(new Ligne(
                6,
                "Market",
                "Tram",
                new String[]{"Eastbourne West", "Fairfields", "Market Place", "Victoria Docks"}
        ));

        // 7) Greenway
        listeLignes.add(new Ligne(
                7,
                "Greenway",
                "Bus",
                new String[]{"Zephyr Close", "Dunham End", "King’s Way", "Grand Central", "Fairfields", "Lakeside", "High Street"}
        ));

        // 8) Southern Loop
        listeLignes.add(new Ligne(
                8,
                "Southern Loop",
                "Bus",
                new String[]{"Eastbourne West", "Ivy Lane", "Oakwoods", "Queensbridge", "Parkside Place", "York Road", "Riverside"}
        ));
    }

    /**
     * Retourne la liste complète des lignes.
     */
    public static Vector<Ligne> getListeLignes() {
        return listeLignes;
    }

    /**
     * Affiche toutes les lignes (ID + Nom) dans la console.
     */
    public static void listerToutesLesLignes() {
        for (Ligne l : listeLignes) {
            System.out.println(l.toString());
        }
    }

    /**
     * Affiche les informations détaillées d'une ligne en fonction de son identifiant.
     *
     * @param identifiant Identifiant de la ligne.
     */
    public static void afficherInformationsLigne(int identifiant) {
        for (Ligne l : listeLignes) {
            if (l.getIdentifiant() == identifiant) {
                System.out.println(l.informationsDetaillees());
                return;
            }
        }
        System.out.println("Aucune ligne ne correspond à l'ID : " + identifiant);
    }
}