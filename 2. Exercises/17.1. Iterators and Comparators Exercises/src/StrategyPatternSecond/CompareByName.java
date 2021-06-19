package StrategyPatternSecond;

import StrategyPattern.Person;

import java.util.Comparator;
import java.util.Locale;

public class CompareByName implements Comparator<StrategyPattern.Person> {
    public int compare(StrategyPattern.Person a, Person b){
        int result = 0;
        result = Integer.compare(a.getName().length(),(b.getName().length()));
        if(result ==0){
            result = Integer.compare(a.getName().toLowerCase(Locale.ROOT).charAt(0), b.getName().toLowerCase(Locale.ROOT).charAt(0));
        }
        return result;
    }
}
