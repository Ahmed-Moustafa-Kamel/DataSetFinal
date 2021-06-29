import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SortedCities {
    DAIImpl open=new DAIImpl();
    public LinkedList<City> Filter(String fileName , String country){
        LinkedList<City> cities= open.readCityFromCSV(fileName);
        LinkedList<City> matchedcities= new LinkedList<>();
        for(City i:cities){
            if((i.getCountryCode().trim()).equals(country)){
                matchedcities.add(i);

            }

            //  List<City> CitiesName = cities.stream().filter(b -> b.getCountryCode().trim()== Country).collect(toList());

        }
        return matchedcities;

    }
    // put filtered city in hash map

    public HashMap<String, LinkedList<City>> createdMap(LinkedList<City> l1) {
        HashMap<String, LinkedList<City>> myMap = new HashMap<>();
        for (City c :l1) {
            LinkedList<City> a = new LinkedList<>();
            if (!myMap.containsKey(c.getCountryCode())) {
                a.add(c);
                myMap.put(c.getCountryCode(),a);
            }
            else {
                myMap.get(c.getCountryCode()).add(c);
            }
        }
        return myMap;
    }


    //sort the hash map
    public LinkedList<City> sortedCity(HashMap<String,LinkedList<City>> p){
        LinkedList<City> citiesSorted=new LinkedList<>();
        for (Map.Entry<String,LinkedList<City>> entry : p.entrySet())
        {

            for(City c:entry.getValue()){
                citiesSorted.add(c);
            }
            citiesSorted.sort(new SortByPopulatio());

        }
        return citiesSorted;
    }
}
