import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sort3 {
    private Comparator<Integer> comparator;
    public int size;
    public int swaps;
    public int moves;
    public int comparations;

    public Sort3() {
        comparator = Comparator.naturalOrder();
        swaps = 0;
        moves = 0;
        comparations = 0;
    }

    private Boolean compare_and_count(int currentPositionValue, int temp){
        comparations++;
        return comparator.compare(currentPositionValue, temp) < 0;
    }

    private void swap_and_count(int[] array, int index1, int index2) {
        swaps++;
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //QUICK SORT ALGORITHM
    public int[] quickSortStart(int[] toSort) {
        swaps = 0;
        moves = 0;
        comparations = 0;
        if (size < 40){
            System.out.println();
        }
        quickSort(toSort, 0, toSort.length - 1);
        return toSort;
    }

    private void quickSort(int[] toSort, int begin, int end) {
        if (begin < end) {
            int pivot = partition(toSort, begin, end);
            quickSort(toSort, begin, pivot - 1);
            quickSort(toSort, pivot + 1, end);

        }
    }

    private int partition(int[] array, int begin, int end) {
        if (size < 40){
            System.out.println("SingleQS step:" + Arrays.toString(array));
        }
        //System.out.println("partitioning "+begin + " "+ end);
        Random random = new Random();
        int pivotIndex = random.nextInt(begin, end);
        int pivotValue = array[pivotIndex];
        swap_and_count(array, pivotIndex, end);
        int firstBigger = begin;

        for (int j = begin; j < end; j++) {
            if (compare_and_count(array[j], pivotValue)) {
                swap_and_count(array, firstBigger, j);
                firstBigger++;
            }
        }
        swap_and_count(array, firstBigger, end);
        return firstBigger;
    }

    //DUAL QUICK SORT ALGORITHM
    public int[] dualQuickSortStart(int[] toSort) {
        swaps = 0;
        moves = 0;
        comparations = 0;
        if (size < 40){
            System.out.println();
        }
        dualQuickSort(toSort, 0, toSort.length - 1);
        return toSort;
    }

    private void dualQuickSort(int[] toSort, int begin, int end) {
        if (begin < end ) {
            int[] pivots = dual_partition(toSort, begin, end);
            dualQuickSort(toSort, begin, pivots[1]-1);
            dualQuickSort(toSort, pivots[1]+1, pivots[2] - 1);
            dualQuickSort(toSort, pivots[2] + 1, end);
        }
    }

    private int[] dual_partition(int[] array, int begin, int end) {
        if (size < 40){
            System.out.println("DualQS step:" + Arrays.toString(array));
        }

        if ( compare_and_count(array[end], array[begin]))
            swap_and_count(array, begin, end);
        int pivotP = array[begin];
        int pivotQ = array[end];
        moves += 2;

        int lastLeft = begin + 1;
        int lastRight = end - 1;
        int var = begin + 1;

        while (lastLeft <= lastRight){
            if (compare_and_count(array[lastLeft], pivotP)) {
                swap_and_count(array, lastLeft, var);
                var++;
            }
            else if ( !compare_and_count( array[lastLeft], pivotQ) ) {
                while ( compare_and_count(pivotQ, array[lastRight]) && lastLeft < lastRight)
                    lastRight--;

                swap_and_count(array, lastLeft, lastRight);
                lastRight--;

                if (compare_and_count(array[lastLeft], pivotP)) {
                    swap_and_count(array, lastLeft, var);
                    var++;
                }
            }
            lastLeft++;
        }
        var--;
        lastRight++;

        swap_and_count(array, begin, var);
        swap_and_count(array, end, lastRight);

        return new int[] {lastLeft, var, lastRight};
    }
}