import java.util.Comparator;
import java.util.Random;

public class Sort2 {
    private Comparator<Integer> comparator;
    public int size;
    public int swaps;
    public int moves;
    public int comparations;

    public Sort2() {
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

    //INSERT SORT ALGORITHM
    public int[] insertSortStart(int[] toSort) {
        swaps = 0;
        moves = 0;
        comparations = 0;
        int i;
        int temp = toSort[0];

        for (int currentPosition = 1; currentPosition < toSort.length; currentPosition++) {
            insertSort(toSort, temp, currentPosition);
        }
        return toSort;
    }

    private void insertSort(int[] toSort, int temp, int currentPosition) {
        int currentPositionValue;
        int i;
        currentPositionValue = toSort[currentPosition];
        moves++;

        for (i = currentPosition; i > 0 && compare_and_count(currentPositionValue, temp = toSort[i - 1]); i--) {
            toSort[i] = temp;
            moves++;
        }
        toSort[i] = currentPositionValue;
        moves++;
    }


    //MERGE SORT ALGORITHM
    public int[] mergeSortStart(int[] toSort) {
        swaps = 0;
        moves = 0;
        comparations = 0;
        mergeSort(toSort);
        return toSort;
    }

    private int[] mergeSort(int[] toSort) {
        if (toSort.length > 1) {
            int leftSize = toSort.length / 2;
            int rightSize = toSort.length - leftSize;
            int[] arrayLeft = new int[leftSize];
            System.arraycopy(toSort, 0, arrayLeft, 0, leftSize);
            moves += arrayLeft.length;
            int[] arrayRight = new int[rightSize];
            System.arraycopy(toSort, leftSize, arrayRight, 0, rightSize);
            moves += arrayRight.length;
            mergeSort(arrayLeft);
            mergeSort(arrayRight);

            int rightIndex = 0;
            int leftIndex = 0;
            for (int i = 0; i < toSort.length; i++) {
                if (rightIndex < rightSize && leftIndex < leftSize) {
                    if (compare_and_count(arrayRight[rightIndex], arrayLeft[leftIndex])) {
                        toSort[i] = arrayRight[rightIndex];
                        moves++;
                        rightIndex++;
                    } else {
                        toSort[i] = arrayLeft[leftIndex];
                        moves++;
                        leftIndex++;
                    }
                } else if (rightIndex == rightSize) {
                    toSort[i] = arrayLeft[leftIndex];
                    moves++;
                    leftIndex++;
                } else {
                    toSort[i] = arrayRight[rightIndex];
                    moves++;
                    rightIndex++;
                }
            }
        }
        return toSort;

    }

    //QUICK SORT ALGORITHM
    public int[] quickSortStart(int[] toSort) {
        swaps = 0;
        moves = 0;
        comparations = 0;
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
}