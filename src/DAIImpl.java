import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.LinkedList;

public class DAIImpl {
    public LinkedList<City> readCityFromCSV(String filename) {
        LinkedList<City> cities = new LinkedList<>();
        try {
            FileReader r = new FileReader(filename);
            BufferedReader br = new BufferedReader(r);
            String line;
            do {
                line = br.readLine();
                if (line != null) {
                    String[] parts = line.split(",");
                    City obj = createCity(parts);
                    cities.add(obj);
                }
            } while (line != null);
            br.close();
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;

    }

    public City createCity(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        int population = Integer.parseInt(metadata[2]);
        String countryCode = metadata[3];
        return new City(id, name, population, countryCode);

    }

    public LinkedList<Country> readCountryFromCSV(String filename) {
        LinkedList<Country> countries = new LinkedList<>();
        try {
            FileReader r = new FileReader(filename);
            BufferedReader br = new BufferedReader(r);
            String line;
            do {
                line = br.readLine();
                if (line != null) {
                    String[] parts = line.split(",");
                    Country obj = createCountry(parts);
                    countries.add(obj);
                }
            } while (line != null);
            br.close();
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public Country createCountry(String[] metadata) {
        String code = metadata[0];
        String name = metadata[1];
        String continent = metadata[2];
        double surfaceArea = Double.parseDouble(metadata[4]);
        double population = Double.parseDouble(metadata[3]);
        double gnp = Double.parseDouble(metadata[5]);
        int capital = Integer.parseInt(metadata[6]);
        return new Country(code, name, continent, surfaceArea, population, gnp, capital);
    }

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
    public City highestCapital(LinkedList<Country> l1,LinkedList<City> l2){
        LinkedList<City> funPopu=new LinkedList<>();
        for(Country c:l1){
            for(City ci:l2){
                if(c.getCapital()==ci.getId())
                    funPopu.add(ci);
            }
        }
        funPopu.sort(new SortbyPopulation());
        return funPopu.getFirst();
    }
    public LinkedList<City> highPopulationCity(HashMap<String,LinkedList<City>> p){
        LinkedList<City> highestForEach=new LinkedList<>();
        for (Map.Entry<String,LinkedList<City>> entry : p.entrySet())
        {
            LinkedList<City> citiesSorted=new LinkedList<>();
            for(City c:entry.getValue()){
                citiesSorted.add(c);
            }
            citiesSorted.sort(new SortbyPopulation());
            highestForEach.add(citiesSorted.getFirst());
        }
        return highestForEach;
    }
    public class SortbyPopulation implements Comparator<City>{
        public int compare(City a, City b)
        {
            return b.getPopulation()-a.getPopulation();
        }
    }
    public Country highestPopulation(LinkedList<Country> a) {
        double s = 0;
        Country highest = null;
        for (Country i : a) {
            if (i.getPopulation() > s) {
                s = i.getPopulation();
                highest = i;
            }
        }
        return highest;
    }
    public double average(LinkedList<Country> a){
        double s=0;
        double av=0;
        for(Country i:a){
            av=i.getPopulation()+av;
            s+=1;
        }
        av=av/s;
        return av;
    }
    public List<Double> listOfCountriesPopulation(LinkedList<Country> a){
        List<Double> l1=new ArrayList<>();
        for(Country i:a){
            l1.add(i.getPopulation());
        }
        return l1;
    }

}