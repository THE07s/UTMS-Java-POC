import java.util.HashMap;
import java.util.Map;

public class Lignes {
    private static Graph<String> graphPrix;
    private static Graph<String> graphDistance;
    private static Graph<String> graphAccessibilite;
    private static Graph<String> graphTemps;

    static {
        graphPrix = new Graph<>(false, true);
        graphDistance = new Graph<>(false, true);
        graphAccessibilite = new Graph<>(false, true);
        graphTemps = new Graph<>(false, true);

        // Exemple de données pour les lignes
        String[] stations = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        // Ajouter des arêtes aux graphes
        for (String station : stations) {
            graphPrix.addNode(station);
            graphDistance.addNode(station);
            graphAccessibilite.addNode(station);
            graphTemps.addNode(station);
        }

        // Ajouter des exemples d'arêtes avec des poids différents pour chaque graphe
        addEdge("A", "B", 2.5, 1000, 1, 10);
        addEdge("A", "C", 3.0, 1500, 1, 15);
        addEdge("B", "D", 1.5, 500, 0, 5);
        // Ajoutez d'autres arêtes selon vos besoins
    }

    private static void addEdge(String from, String to, double prix, double distance, double accessibilite, double temps) {
        graphPrix.addEdge(from, to, prix);
        graphDistance.addEdge(from, to, distance);
        graphAccessibilite.addEdge(from, to, accessibilite);
        graphTemps.addEdge(from, to, temps);
    }

    public static void getLignes() {
        System.out.println("Les lignes sont cool");
    }

    public static void afficherInformationsLigne(int idLigne) {
        // TODO : implémenter la méthode
        throw new UnsupportedOperationException("Unimplemented method 'afficherInformationsLigne'");
    }

    public static void main(String[] args) {
        // Exemple d'utilisation
        System.out.println("Graph par prix:");
        System.out.println(graphPrix.representation());

        System.out.println("Graph par distance:");
        System.out.println(graphDistance.representation());

        System.out.println("Graph par accessibilité:");
        System.out.println(graphAccessibilite.representation());

        System.out.println("Graph par temps:");
        System.out.println(graphTemps.representation());
    }
}
