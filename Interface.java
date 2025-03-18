public class Interface {
    public static void montrerMenu() {
        System.out.println("==========================================================");
        System.out.println("|               MENU PRINCIPAL                            |");
        System.out.println("==========================================================");
        System.out.println("| 1) Afficher la liste des stations                       |");
        System.out.println("| 2) Afficher les détails d'une station                   |");
        System.out.println("| 3) Choisir un trajet (accessibilité, distances, temps)  |");
        System.out.println("| 4) Afficher les lignes                                  |");
        System.out.println("| 5) Afficher le détail d'une ligne                       |");
        System.out.println("| 6) Information prix ticket                              |");
        System.out.println("| 7) Quitter                                              |");
        System.out.println("==========================================================");
        System.out.print("\nVeuillez choisir une option: ");
        String choix = System.console().readLine();
        System.out.print("\n\n");
        choixMenu(choix);
    }

    public static void choixMenu(String choix) {
        switch (choix) {
            case "1":
                // Trier et afficher les stations dans l'ordre alphabétique inverse
                Stations.listerToutesLesStations();
                System.out.print("\n\n");
                montrerMenu();
                break;
            case "2":
                System.out.print("Entrez l'ID de la station: ");
                int idStation = Integer.parseInt(System.console().readLine());
                Stations.afficherInformationsStation(idStation);
                System.out.print("\n\n");
                montrerMenu();
                break;
            case "3":
                // Trajet prenant en compte les contraintes d’accessibilité et affichant distances et temps de trajet
                Trajet.getTrajet();
                System.out.print("\n\n");
                montrerMenu();
                break;
            case "4":
                Lignes.getLignes();
                System.out.print("\n\n");
                montrerMenu();
                break;
            case "5":
                System.out.print("Entrez l'ID de la ligne: ");
                int idLigne = Integer.parseInt(System.console().readLine());
                Lignes.afficherInformationsLigne(idLigne);
                System.out.print("\n\n");
                montrerMenu();
                break;
            case "6":
                Prix.getPrixTicket();
                System.out.print("\n\n");
                montrerMenu();
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide");
                System.out.print("\n\n");
                montrerMenu();
                break;
        }
    }
}