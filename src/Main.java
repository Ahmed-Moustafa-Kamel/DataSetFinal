import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        DAIImpl proDA0 = new DAIImpl();
        LinkedList<City> cities = proDA0.readCityFromCSV("C:\\Users\\lenovo\\OneDrive\\Desktop\\ITI\\9. Java & UML programming\\Day4\\Data_sets\\Cities.csv");
        LinkedList<Country> countries = proDA0.readCountryFromCSV("C:\\Users\\lenovo\\OneDrive\\Desktop\\ITI\\9. Java & UML programming\\Day4\\Data_sets\\Countries.csv");
        //HashMap<String,LinkedList<String>> myMaps=proDA0.createdMap(countries,cities);
        // System.out.println(myMaps);
        //System.out.println(cities);
        HashMap<String, LinkedList<City>> myMap = proDA0.createdMap(cities);
        System.out.println(proDA0.highestPopulation(countries)+"\n");
        System.out.println(proDA0.average(countries)+"\n");
        System.out.println(proDA0.listOfCountriesPopulation(countries)+"\n");
        System.out.println("list of cities in poland");
        System.out.println(myMap.get(" POL"));
        City obj=proDA0.highestCapital(countries,cities);
        System.out.println("                                       ");
        System.out.println("The highest population capital is: "+obj);
        LinkedList<City> highestforeach=proDA0.highPopulationCity(myMap);
        System.out.println(" ");
        System.out.println("highest city in each country");
        System.out.println(highestforeach);
        
    }
}   //for (City ct : cities) {