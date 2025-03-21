// --- Main.java ---
/**
 * Classe principale de l'application UTMS.
 * 
 * Lance l'interface utilisateur.
 */
public class Main {
    public static void main(String[] args) {
        effacerTerminal();
        Interface.montrerMenu();
    }

    /**
     * Efface le terminal.
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
