import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author benjaminlewis-jones
 * A new thread that runs alongside the main thread
 * that runs the sorting algorithm
 */
public class SortingAlgorithms implements Runnable {

    /**
     * Based on an input a sorting function is called
     */
    @Override
    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.println("1. bubble sort\n" +
                "2. Selection sort\n" /*+
                "3. Merge Sort\n" +
                "4. Insertion sort"*/);

        System.out.print("which algorithm: ");

        switch (input.nextLine()) {
            case "1":
                bubbleSort();
                break;
            case "2":
                selectionSort();
                break;
//            case "3":
//                mergeSortStart();
//                break;
//            case "4":
//                insertionSort();
            default:
                System.out.println("input invalid");
        }

        bubbleSort();
    }


    /**
     * Performs a bubble sort on the points array
     */
    public void bubbleSort() {
        ArrayList<Integer> list = Point.getList();

        boolean swap = false;

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swap = true;

                    // wait to render
                    Point.setList(list);
                    Thread.currentThread().suspend();
                }
            }

            if (!swap) break;
        }
    }

    /**
     * Performs a selection sort on the points array
     */
    public void selectionSort() {
        ArrayList<Integer> list = Point.getList();

        int jMin;
        for (int i = 0; i < list.size() - 1; i++) {
            jMin = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(jMin))
                    jMin = j;
            }

            if (jMin != i) {
                int temp = list.get(i);
                list.set(i, list.get(jMin));
                list.set(jMin, temp);

                // wait to render
                Thread.currentThread().suspend();
                Point.setList(list);
            }
        }
    }

//    private void mergeSortStart() {
//        ArrayList<Integer> list = Point.getList();
//        Thread.currentThread().suspend();
//        Point.setList(list);
//    }
//
//
//    private void insertionSort() {
//        ArrayList<Integer> list = Point.getList();
//        Thread.currentThread().suspend();
//        Point.setList(list);
//    }
}
