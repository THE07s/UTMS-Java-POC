public class Interface {
    public static void montrerMenu() {
        System.out.println("===========================================");
        System.out.println("|               MENU PRINCIPAL            |");
        System.out.println("===========================================");
        System.out.println("| 1) Afficher la liste des stations       |");
        System.out.println("| 2) Afficher les détails d'une station   |");
        System.out.println("| 3) Choisir un trajet à effectuer        |");
        System.out.println("| 4) Afficher les lignes                  |");
        System.out.println("| 5) Information prix ticket              |");
        System.out.println("| 6) Quitter                              |");
        System.out.println("===========================================");
        System.out.print("\n\nVeuillez choisir une option: ");
        String choix = System.console().readLine();
        System.out.print("\n\n\n\n");
        choixMenu(choix);
    }

    public static void choixMenu(String choix) {
        switch (choix) {
            case "1":
                Stations.getStations();
                System.out.print("\n\n\n\n\n");
                montrerMenu();
                break;
            case "2":
                Trajet.getTrajet();
                System.out.print("\n\n\n\n\n");
                montrerMenu();
                break;
            case "3":
                Lignes.getLignes();
                System.out.print("\n\n\n\n\n");
                montrerMenu();
                break;
            case "4":
                Prix.getPrixTicket();
                System.out.print("\n\n\n\n\n");
                montrerMenu();
                break;
            case "5":
                Stations.getDetailsStation(0);
                System.out.print("\n\n\n\n\n");
                montrerMenu();
                break;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide");
                System.out.print("\n\n\n\n\n");
                montrerMenu();
                break;
        }
    }
}
