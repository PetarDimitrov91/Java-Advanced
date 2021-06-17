package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Lake implements Iterable<Integer> {

    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private class Frog implements Iterator<Integer> {

        private int position = numbers.size() == 0 ? 0 : -2;

        private boolean isEvenPosition() {
            return position % 2 == 0;
        }

        @Override
        public boolean hasNext() {
            if (isEvenPosition() && numbers.size() > 2) {
                return true;
            } else if (!isEvenPosition() && numbers.size() > 2) {
                return position > numbers.size() - 2;
            } else {
                return position < numbers.size() - 1;
            }
        }

        @Override
        public Integer next() {
            position += 2;

            if (position > numbers.size() - 1) {
                position = 1;
            }
            return numbers.get(position);
        }
    }

    public void jump() {
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                evenNumbers.add(numbers.get(i).toString());
            } else {
                oddNumbers.add(numbers.get(i).toString());
            }
        }
        System.out.print(String.join(", ", evenNumbers));
        if (numbers.size() > 1) {
            System.out.print(", ");
        }
        System.out.print(String.join(", ", oddNumbers));

    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < numbers.size();
            }

            @Override
            public Integer next() {
                return numbers.get(index++);
            }
        };
    }
}
