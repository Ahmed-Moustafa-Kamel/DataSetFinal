import java.util.Comparator;

public class SortByPopulatio implements Comparator<City> {
    public int compare(City a, City b)
    {

        return a.getPopulation()-b.getPopulation();
    }
}