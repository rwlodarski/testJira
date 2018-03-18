import java.util.Comparator;

//nowy test
public class CustomComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.order.compareTo(o2.order);
    }
}
