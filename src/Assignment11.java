import java.util.ArrayList;
import java.util.List;
public class Assignment11 {
    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    T temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    public static <T extends Comparable<? super T>> void mergeSort(List<T> list) {
        if (list.size() <= 1)
            return;
        int middle = list.size() / 2;
        List<T> left = new ArrayList<>(list.subList(0, middle));
        List<T> right = new ArrayList<>(list.subList(middle, list.size()));
        mergeSort(left);
        mergeSort(right);
        merge(left, right, list);
    }    
    private static <T extends Comparable<? super T>> void merge(List<T> left, List<T> right, List<T> list) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
                list.set(mergedIndex++, left.get(leftIndex++));
            } else {
                list.set(mergedIndex++, right.get(rightIndex++));
            }
        }
        while (leftIndex < left.size()) {
            list.set(mergedIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            list.set(mergedIndex++, right.get(rightIndex++));
        }
    }
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Bubble Sort:");
        List<Integer> bubbleList = new ArrayList<>(List.of(5, 3, 8, 1, 2, 9, 4, 7, 6));
        bubbleSort(bubbleList);
        printList(bubbleList);
        System.out.println("\nMerge Sort:");
        List<Integer> mergeList = new ArrayList<>(List.of(5, 3, 8, 1, 2, 9, 4, 7, 6));
        mergeSort(mergeList);
        printList(mergeList);
    }
}