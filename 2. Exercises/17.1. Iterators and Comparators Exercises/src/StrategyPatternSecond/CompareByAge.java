package StrategyPatternSecond;

import StrategyPattern.Person;

import java.util.Comparator;

public class CompareByAge implements Comparator<StrategyPattern.Person> {
    public int compare(StrategyPattern.Person a, Person b){
        return Integer.compare(a.getAge(),(b.getAge()));
    }
}
