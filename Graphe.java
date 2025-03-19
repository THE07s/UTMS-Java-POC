    
//Transfère notre graphe dans la méthode de WOODWARD


import java.util.*;

class Graphe {
    private Map<Character, List<Character>> listeAdjacence;
    public Graphe() {
        this.listeAdjacence = new HashMap<>();
    }

    public void addEdge(char from, char to) {
        listeAdjacence.putIfAbsent(from, new ArrayList<>());
        listeAdjacence.putIfAbsent(to, new ArrayList<>()); // S'assure que le sommet existe
        listeAdjacence.get(from).add(to);
        listeAdjacence.get(to).add(from); // Supposons un graphe **non orienté**
    }

    public void printGraph() {
        for (var entry : listeAdjacence.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[][] lignes = {
            // Copie intégrale de ta matrice d'adjacence
                    {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//A
                    {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//B
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//C
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},//D
                    {0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//E
                    {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//F
                    {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},//G
                    {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//H
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//I
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//J
                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},//K
                    {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//L
                    {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},//M
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},//N
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//O
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},//P
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Q
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},//R
                    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},//S
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},//T
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},//U
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0},//V
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},//W
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},//X
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//Y
                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} //Z
        };

        Graphe graph = new Graphe();
        for (int i = 0; i < lignes.length; i++) {
            for (int j = i + 1; j < lignes[i].length; j++) {
                if (lignes[i][j] != 0) { 
                    graph.addEdge((char) ('A' + i), (char) ('A' + j));
                }
            }
        }

        graph.printGraph();
    }





    public void ajouterArete(char depart, char arrivee) {
        listeAdjacence.putIfAbsent(depart, new ArrayList<>());
        listeAdjacence.putIfAbsent(arrivee, new ArrayList<>()); 
        listeAdjacence.get(depart).add(arrivee);
        listeAdjacence.get(arrivee).add(depart); 
    }

    public void afficherGraphe() {
        for (var entree : listeAdjacence.entrySet()) {
            System.out.print(entree.getKey() + " -> ");
            System.out.println(entree.getValue());
        }
    }

    public List<Character> cheminLePlusCourt(char depart, char arrivee) {
        Map<Character, Character> parent = new HashMap<>();
        Queue<Character> file = new LinkedList<>();
        Set<Character> visite = new HashSet<>();

        file.add(depart);
        visite.add(depart);
        parent.put(depart, null);

        while (!file.isEmpty()) {
            char courant = file.poll();

            if (courant == arrivee) {
                return reconstruireChemin(parent, depart, arrivee);
            }

            for (char voisin : listeAdjacence.getOrDefault(courant, new ArrayList<>())) {
                if (!visite.contains(voisin)) {
                    visite.add(voisin);
                    parent.put(voisin, courant);
                    file.add(voisin);
                }
            }
        }

        return new ArrayList<>(); // Retourne une liste vide si aucun chemin n'est trouvé
    }

    private List<Character> reconstruireChemin(Map<Character, Character> parent, char depart, char arrivee) {
        List<Character> chemin = new ArrayList<>();
        for (Character actuel = arrivee; actuel != null; actuel = parent.get(actuel)) {
            chemin.add(actuel);
        }
        Collections.reverse(chemin);
        return chemin;
    }
}
