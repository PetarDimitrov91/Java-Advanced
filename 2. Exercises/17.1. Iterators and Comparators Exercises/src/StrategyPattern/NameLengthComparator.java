package StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class NameLengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int result = Integer.compare(first.getName().length(), second.getName().length());
        if (result == 0) {
            result = Integer.compare(first.getName().toLowerCase(Locale.ROOT).charAt(0), second.getName().toLowerCase(Locale.ROOT).charAt(0));
        }
        return result;
    }
}