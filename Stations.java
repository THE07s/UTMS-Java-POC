// --- Stations.java ---

import java.util.Vector;

/**
 * Stations gère la liste de toutes les stations du réseau.
 */
public class Stations {

    /**
     * Retourne la liste complète des stations.
     */
    private static Vector<Station> listeStations = new Vector<>();

    // Bloc statique : initialisation de toutes les stations
    static {
        // 1) Ashford Road
        listeStations.add(new Station(
                1,
                "Ashford Road",
                new String[]{"🛅 - Consignes", "👤 - Assistance", "♿️🚫 - Pas d'accéssibilité", "ℹ️  - Point d’information"},
                52, 39, 0.7884, 'N',
                1, 17, 55.4244, 'E'
        ));

        // 2) Brookside Avenue
        listeStations.add(new Station(
                2,
                "Brookside Avenue",
                new String[]{"👤 - Assistance"},
                52, 38, 52.9512, 'N',
                1, 17, 27.276, 'E'
        ));

        // 3) Castle Hill
        listeStations.add(new Station(
                3,
                "Castle Hill",
                new String[]{},
                52, 38, 55.6116, 'N',
                1, 18, 28.4184, 'E'
        ));

        // 4) Dunham End
        listeStations.add(new Station(
                4,
                "Dunham End",
                new String[]{},
                52, 38, 55.608, 'N',
                1, 16, 34.8996, 'E'
        ));

        // 5) Eastbourne West
        listeStations.add(new Station(
                5,
                "Eastbourne West",
                new String[]{},
                52, 38, 41.1936, 'N',
                1, 17, 14.1252, 'E'
        ));

        // 6) Fairfields
        listeStations.add(new Station(
                6,
                "Fairfields",
                new String[]{"👤 - Assistance"},
                52, 38, 45.9276, 'N',
                1, 17, 27.276, 'E'
        ));

        // 7) Grand Central
        listeStations.add(new Station(
                7,
                "Grand Central",
                new String[]{"🛒 - Zone commerciale", "🛅 - Consignes", "👤 - Assistance", "🚻 - Toilettes", "ℹ️  - Point d’information"},
                52, 38, 25.3716, 'N',
                1, 17, 20.5836, 'E'
        ));

        // 8) High Street
        listeStations.add(new Station(
                8,
                "High Street",
                new String[]{"🛒 - Zone commerciale"},
                52, 38, 38.5332, 'N',
                1, 18, 21.4956, 'E'
        ));

        // 9) Ivy Lane
        listeStations.add(new Station(
                9,
                "Ivy Lane",
                new String[]{},
                52, 38, 37.1328, 'N',
                1, 16, 52.2048, 'E'
        ));

        // 10) Jubilee Place
        listeStations.add(new Station(
                10,
                "Jubilee Place",
                new String[]{"👤 - Assistance"},
                52, 38, 39.336, 'N',
                1, 15, 50.832, 'E'
        ));

        // 11) King's Way
        listeStations.add(new Station(
                11,
                "King’s Way",
                new String[]{"👤 - Assistance", "♿️🚫 - Pas d'accéssibilité", "ℹ️  - Point d’information"},
                52, 38, 21.7608, 'N',
                1, 16, 44.13, 'E'
        ));

        // 12) Lakeside
        listeStations.add(new Station(
                12,
                "Lakeside",
                new String[]{},
                52, 38, 41.1936, 'N',
                1, 18, 0.9612, 'E'
        ));

        // 13) Market Place
        listeStations.add(new Station(
                13,
                "Market Place",
                new String[]{"🛒 - Zone commerciale", "👤 - Assistance", "♿️🚫 - Pas d'accéssibilité"},
                52, 38, 19.77, 'N',
                1, 17, 47.8104, 'E'
        ));

        // 14) Northgate Shopping Centre
        listeStations.add(new Station(
                14,
                "Northgate Shopping Centre",
                new String[]{"🛒 - Zone commerciale", "👤 - Assistance"},
                52, 38, 23.712, 'N',
                1, 18, 26.5716, 'E'
        ));

        // 15) Oakwoods
        listeStations.add(new Station(
                15,
                "Oakwoods",
                new String[]{},
                52, 38, 16.5516, 'N',
                1, 16, 58.404, 'E'
        ));

        // 16) Parkside Place
        listeStations.add(new Station(
                16,
                "Parkside Place",
                new String[]{},
                52, 38, 17.1132, 'N',
                1, 16, 23.5956, 'E'
        ));

        // 17) Queensbridge
        listeStations.add(new Station(
                17,
                "Queensbridge",
                new String[]{},
                52, 38, 1.0104, 'N',
                1, 16, 42.9744, 'E'
        ));

        // 18) Riverside
        listeStations.add(new Station(
                18,
                "Riverside",
                new String[]{},
                52, 37, 57.0864, 'N',
                1, 16, 24.5172, 'E'
        ));

        // 19) Southbank Place
        listeStations.add(new Station(
                19,
                "Southbank Place",
                new String[]{"🛒 - Zone commerciale", "♿️🚫 - Pas d'accéssibilité"},
                52, 37, 55.3368, 'N',
               1, 17, 18.9708, 'E'
        ));

        // 20) Town Hall
        listeStations.add(new Station(
                20,
                "Town Hall",
                new String[]{},
                52, 38, 14.4528, 'N',
                1, 17, 18.9708, 'E'
        ));

        // 21) Union Street
        listeStations.add(new Station(
                21,
                "Union Street",
                new String[]{"👤 - Assistance"},
                52, 37, 59.3292, 'N',
                1, 17, 44.2572, 'E'
        ));

        // 22) Victoria Docks
        listeStations.add(new Station(
                22,
                "Victoria Docks",
                new String[]{"🛅 - Consignes", "👤 - Assistance", "🚻 - Toilettes"},
                52, 38, 7.17, 'N',
                1, 18, 0.0396, 'E'
        ));

        // 23) Waterfront
        listeStations.add(new Station(
                23,
                "Waterfront",
                new String[]{},
                52, 37, 57.2268, 'N',
                1, 17, 56.8068, 'E'
        ));

        // 24) Xenobiotics Research Center
        listeStations.add(new Station(
                24,
                "Xenobiotics Research Center",
                new String[]{},
                52, 38, 9.2688, 'N',
                1, 18, 21.9384, 'E'
        ));

        // 25) York Road
        listeStations.add(new Station(
                25,
                "York Road",
                new String[]{},
                52, 38, 6.3312, 'N',
                1, 16, 10.6752, 'E'
        ));

        // 26) Zephyr Close
        listeStations.add(new Station(
                26,
                "Zephyr Close",
                new String[]{},
                52, 39, 5.4108, 'N',
                1, 16, 48.0504, 'E'
        ));
    }

    /** Affiche la liste des stations (ordre normal). */
    public static Vector<Station> getListeStations() {
        return listeStations;
    }

    /**
     * Affiche toutes les stations (ID + Nom) dans la console.
     */
    public static void listerToutesLesStations() {
        for (Station s : listeStations) {
            System.out.println(s.toString());
        }
    }

    /** Affiche la liste des stations (ordre inverse). */
    public static void listerToutesLesStationsInverse() {
        for (int i = listeStations.size() - 1; i >= 0; i--) {
            System.out.println(listeStations.get(i).toString());
        }
    }

    /**
     * Affiche les informations détaillées d'une station en fonction de son identifiant.
     *
     * @param identifiant Identifiant de la station.
     */
    public static void afficherInformationsStation(int identifiant) {
        for (Station s : listeStations) {
            if (s.getIdentifiant() == identifiant) {
                System.out.println(s.informationsDetaillees());
                return;
            }
        }
        System.out.println("Aucune station ne correspond à l'ID : " + identifiant);
    }

}