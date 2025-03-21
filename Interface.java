// --- Interface.java ---
/**
 * Interface du système UTMS.
 * 
 * Un menu principal pour interagir avec l'utilisateur.
 */
public class Interface {
    private static String typeUsager;
    private static int departId;
    private static int arriveeId;
    private static String choixCritere;

    /**
     * Affiche le menu principal et demande un choix utilisateur.
     */
    public static void montrerMenu() {
        System.out.println("===========================================================");
        System.out.println("|                       MENU PRINCIPAL                    |");
        System.out.println("===========================================================");
        System.out.println("| 1) Afficher la liste des stations                       |");
        System.out.println("| 2) Afficher les détails d'une station                   |");
        System.out.println("| 3) Choisir un trajet (accessibilité, distances, temps)  |");
        System.out.println("| 4) Afficher les lignes                                  |");
        System.out.println("| 5) Afficher le détail d'une ligne                       |");
        System.out.println("| 6) Information prix ticket                              |");
        System.out.println("| 7) Quitter                                              |");
        System.out.println("===========================================================");
        System.out.print("\nVeuillez choisir une option: ");
        String choix = System.console().readLine();
        System.out.print("\n\n");
        choixMenu(choix);
    }

    /**
     * Gère le choix de l'utilisateur dans le menu principal.
     * 
     * @param choix La réponse saisie par l'utilisateur.
     */
    public static void choixMenu(String choix) {
        switch (choix) {
            case "1":
                // Trier et afficher les stations dans l'ordre alphabétique inverse
                Main.effacerTerminal();
                System.out.println("===========================================================");
                System.out.println("|                     LISTE DE STATIONS                   |");
                System.out.println("===========================================================");
                System.out.println("| 1) Ordre alphabétique                                   |");
                System.out.println("| 2) Ordre anti-alphabétique                              |");
                System.out.println("===========================================================");
                System.out.print("\nVeuillez choisir une option: ");
                String choixListeStation = System.console().readLine();
                System.out.print(" ----->>> 👌\n");
                switch (choixListeStation) {
                    case "1":
                        Stations.listerToutesLesStations();
                        break;
                    case "2":
                        Stations.listerToutesLesStationsInverse();
                        break;
                }
                System.out.print("\n\n");
                montrerMenu();
                break;


            case "2":
                System.out.print("Entrez l'ID de la station: ");
                int idStation = Integer.parseInt(System.console().readLine());
                System.out.print(" ----->>> 👌\n");
                Stations.afficherInformationsStation(idStation);
                System.out.print("\n\n");
                montrerMenu();
                break;
                

            case "3":
                System.out.println("===========================================================");
                System.out.println("|               QUEL TYPE D'USAGER ÊTES-VOUS ?            |");
                System.out.println("===========================================================");
                System.out.println("| 1) Usager régulier                                      |");
                System.out.println("| 2) Étudiant                                             |");
                System.out.println("| 3) Usager en situation de handicap                      |");
                System.out.println("===========================================================");
                System.out.print("\nVeuillez choisir une option: ");
                typeUsager = System.console().readLine();
                System.out.print(" ----->>> 👌\n");

                System.out.print("ID de la station de départ : ");
                String departIdStr = System.console().readLine();
                departId = Integer.parseInt(departIdStr);
                
                System.out.print("ID de la station d'arrivée : ");
                String arriveeIdStr = System.console().readLine();
                arriveeId = Integer.parseInt(arriveeIdStr);

                System.out.println("===========================================================");
                System.out.println("|          QUEL EST VÔTRE CRITÈRE D'OPTIMISATION ?        |");
                System.out.println("===========================================================");
                System.out.println("| 1) Le prix                                              |");
                System.out.println("| 2) Le temps                                             |");
                System.out.println("| 3) La distance                                          |");
                System.out.println("===========================================================");
                System.out.print("\nVeuillez choisir une option: ");
                choixCritere = System.console().readLine();
                System.out.print(" ----->>> 👌\n");

                Trajet.produireItineraire();

                System.out.print("\n\n");
                montrerMenu();
                break;


            case "4":
                Main.effacerTerminal();
                Lignes.listerToutesLesLignes();
                System.out.print("\n\n");
                montrerMenu();
                break;


            case "5":
                System.out.print("Entrez l'ID de la ligne: ");
                int idLigne = Integer.parseInt(System.console().readLine());
                System.out.print(" ----->>> 👌\n");
                Lignes.afficherInformationsLigne(idLigne);
                System.out.print("\n\n");
                montrerMenu();
                break;


            case "6":
                Main.effacerTerminal();
                // Prix.getPrixTicket();
                // System.out.print("\n\n");
                // montrerMenu();
                break;


            case "7":
                Main.effacerTerminal();
                System.exit(0);
                break;


            default:
                Main.effacerTerminal();
                System.out.println("Choix invalide");
                System.out.print("\n\n");
                montrerMenu();
                break;
        }
    }

    /** Retourne le type d'usager sélectionné. */
    public static String getTypeUsager(){
        return typeUsager;
    }

    /** Retourne l'ID de la station de départ. */
    public static int getDepartId(){
        return departId;
    }

    /** Retourne l'ID de la station d'arrivée. */
    public static int getArriveeId(){
        return arriveeId;
    }

    /** Retourne le critère d'optimisation choisi. */
    public static String getChoixCritere(){
        return choixCritere;
    }
}