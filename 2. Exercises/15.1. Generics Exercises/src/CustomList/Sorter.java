package CustomList;
//BubbleSorter
public class Sorter {
    public static void sort(CustomList<?> customList) {
        int size = customList.getElements().size();
        for (int index = 0; index < size; index++) {
            String element = (String) customList.getElements().get(index);
            for (int nexIndex = index + 1; nexIndex < size; nexIndex++) {
                String nextElement = (String) customList.getElements().get(nexIndex);
                if (element.compareTo(nextElement) > 0){
                    customList.swap(index,nexIndex);
                }
            }
        }
    }
}
