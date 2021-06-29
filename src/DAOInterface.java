import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

public interface DAOInterface {
    public LinkedList<City> readCityFromCSV(String filename);
    public City createCity(String[] metadata);
    public LinkedList<Country> readCountryFromCSV(String filename);
    public Country createCountry(String[] metadata);
    public HashMap<String,LinkedList<String>> createdMap(LinkedList<Country> l1,LinkedList<City> l2);
    public City highestCapital(LinkedList<Country> l1,LinkedList<City> l2);
    public LinkedList<City> highPopulationCity(HashMap<String,LinkedList<City>> p);
    public Country highestPopulation(List<Country> a);
    public double average(List<Country> a);
    public List<Double> listOfCountriesPopulation(List<Country> a);
}