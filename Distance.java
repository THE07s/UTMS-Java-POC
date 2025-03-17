public class Distance {
    public static 

    static final double R = 6364673; // Rayon de la Terre en mètres
    static final double vitMetro = 500; // Vitesse moyenne du métro en m/s
    static final double vitTramo = 400;// Vitesse moyenne du Tram en m/s
    static final double vitBus = 300;// Vitesse moyenne du Bus en m/s

//Fonction transformant les degrés en radians
public static double degre2Radian(double degre) {
        return degre * Math.PI / 180.0;
    }

// Calcul distance entre deux points GPS avec Haversine (sortie en mètre)
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = toRadians(lat2 - lat1);
        double dLon = toRadians(lon2 - lon1);
        lat1 = toRadians(lat1);
        lat2 = toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance en mètres
    }

//Calcul des temps de trajet en fonction du transport
  public static double tempsTrajetMetro(double distance) {
        return distance / vitMetro;
    }

 public static double tempsTrajetTram(double distance) {
        return distance / vitTram;
    }

 public static double tempsTrajetBus(double distance) {
        return distance / vitBus;
    }

//Tableau des coordonnées
public static void coosstations(String[] args) {
        double[][] coosstations = {
            {52.65, 1.29984}, // Ashford Road
            {52.64804, 1.29199}, // Brookside Avenue
            {52.64878, 1.30789}, // Castle Hill
            {52.64878, 1.27636}, // Dunham End
            {52.64609, 1.28726}, // Eastbourne West 
            {52.64609, 1.28726}, // Fairfields
            {52.64038, 1.28888}, // Grand Central
            {52.64348, 1.30597}, // High Street
            {52.64365, 1.28117}, // Ivy Lane
            {52.64426, 1.26412}, // Jubilee Place
            {52.63938, 1.27892}, // King's Way
            {52.64477, 1.30027}, // Lakeside
            {52.63883, 1.29606}, // Market Place
            {52.63992, 1.30738}, // Northgate Shopping Centre
            {52.63793, 1.28289}, // Oakwoods
            {52.63753, 1.27322}, // Parkside Place
            {52.63361, 1.2786}, // Queensbridge
            {52.63252, 1.27348}, // Riverside
            {52.63204, 1.2886}, // Southbank Place
            {52.63735, 1.2886}, // Town Hall
            {52.63315, 1.29563}, // Union Street
            {52.63533, 1.30001}, // Victoria Docks
            {52.63256, 1.29911}, // Waterfront
            {52.63602, 1.30543}, // Xenobiotics Research Facility
            {52.63426, 1.26963}, // York Road
            {52.6515, 1.28001} // Zephyr Close
        };


        public static void TypeRoute() {
    int[][] Type={[Ashford Road]}
        
        int n = stations.length;
        double[][] tempsTrajet = new double[n][n];
        
        // Calcul du temps de trajet entre chaque paire de stations
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double distance = distance(stations[i][0], stations[i][1], stations[j][0], stations[j][1]);
                    tempsTrajets[i][j] = tempsTrajetMetro(distance);
                }
            }
        }

