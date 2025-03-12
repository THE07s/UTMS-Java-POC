public class Stations {
        
    public static String[] getStations() {
        String[] Stations = {
            "1) Ashford Road", 
            "2) Brookside Avenue", 
            "3) Castle Hill", 
            "4) Dunham End", 
            "5) Eastbourne West", 
            "6) Fairfields", 
            "7) GrandCentral", 
            "8) High Street", 
            "9) Ivy Lane", 
            "10) Jubilee Place", 
            "11) King's Way", 
            "12) Lakeside", 
            "13) Market Square", 
            "14) Northgate Shopping Centre", 
            "15) Oakwoods", 
            "16) Parkside Place", 
            "17) Queensbridge", 
            "18) Riverside", 
            "19) Southbank Place", 
            "20) Town Hall", 
            "21) Union Street", 
            "22) Victoria Docks", 
            "23) Waterfront", 
            "24) Xenobiotics Research Centre", 
            "25) York Road", 
            "26) Zephyr Close"
        };
    return Stations;
    }

    public static void getDetailsStation(Integer id) {
        String[] Stations = getStations();
        System.out.println(Stations[--id]);
    }
    
}
