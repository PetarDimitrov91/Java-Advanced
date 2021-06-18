package StrategyPattern;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().compareTo(second.getName()) == 0) {
            if (first.getName().charAt(0) > second.getName().charAt(0)) {
                return 1;
            } else if (first.getName().charAt(0) < second.getName().charAt(0)) {
                return -1;
            }
            return 0;
        } else {
            return first.getName().compareTo(second.getName());
        }
    }
}
