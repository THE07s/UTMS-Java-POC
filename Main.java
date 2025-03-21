// --- Main.java ---
/**
 * Classe principale de l'application.
 * <p>
 * Cette classe lance l'interface utilisateur de l'application en appelant
 * la méthode {@code montrerMenu()} de la classe {@link Interface} après avoir
 * effacé le terminal.
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        effacerTerminal();
        Interface.montrerMenu();
    }

    /**
     * Efface le contenu du terminal.
     * <p>
     * Cette méthode permet de nettoyer le terminal de commande en fonction du système d'exploitation :
     * <ul>
     *   <li>Sur Windows, la commande {@code cls} est utilisée.</li>
     *   <li>Sur les systèmes Unix/Linux/Mac, la séquence d'échappement ANSI est utilisée.</li>
     * </ul>
     * </p>
     *
     * @implNote Utilise {@link ProcessBuilder} pour exécuter la commande système appropriée.
     * @author ChatGPT
     */
    public static void effacerTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
