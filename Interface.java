public class Interface {
    public static void montrerMenu() {
        System.out.println("=====================================");
        System.out.println("|          MENU PRINCIPAL           |");
        System.out.println("=====================================");
        System.out.println("| 1) Afficher la liste des stations |");
        System.out.println("| 2) Choisir un trajet à effectuer  |");
        System.out.println("| 3) Afficher les lignes            |");
        System.out.println("| 4) Information prix ticket        |");
        System.out.println("| 5) Quitter                        |");
        System.out.println("=====================================");
        System.out.print("\n\nVeuillez choisir une option: ");
        String choix = System.console().readLine();
        choixMenu(choix);
    }

    public static void choixMenu(String choix) {
        switch (choix) {
            case "1":
                Stations.getStations();
                montrerMenu();
                break;
            case "2":
                Trajet.getTrajet();
                montrerMenu();
                break;
            case "3":
                Lignes.getLignes();
                montrerMenu();
                break;
            case "4":
                Prix.getPrixTicket();
                montrerMenu();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide");
                montrerMenu();
                break;
        }
    }
}
