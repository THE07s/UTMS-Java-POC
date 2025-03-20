public class Interface {
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
                String choix_liste_station = System.console().readLine();
                switch (choix_liste_station) {
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
                Main.effacerTerminal();
                Lignes.listerToutesLesLignes();
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
}