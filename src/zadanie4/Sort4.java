import java.util.Arrays;
import java.util.Comparator;

public class Sort4 {
    private Comparator<Integer> comparator;
    public int size;
    public int swaps;
    public int moves;
    public int comparations;

    public int K ;

    public Sort4() {
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
        return mergeSort(toSort);
    }

    public int[] mergeSort(int[] toSort) {
        if (toSort.length > 1) {
            int leftSize = toSort.length / 2;
            int rightSize = toSort.length - leftSize;
            int[] arrayLeft = new int[leftSize];
            System.arraycopy(toSort, 0, arrayLeft, 0, leftSize);
            moves += arrayLeft.length;
            int[] arrayRight = new int[rightSize];
            System.arraycopy(toSort, leftSize, arrayRight, 0, rightSize);
            moves += arrayRight.length;
            arrayLeft = mergeSort(arrayLeft);
            arrayRight = mergeSort(arrayRight);
            toSort = merge(arrayLeft, arrayRight);
        }
        return toSort;
    }

    public int[] merge(int[] leftArray, int[] rightArray) {
        int beginning = 0;
        int n1 = leftArray.length ;
        int n2 = rightArray.length ;
        int [] A = new int[leftArray.length + rightArray.length];
        int index_R = 0;
        int index_L = 0;
        for (int i = beginning; i < A.length ; i++) {
            if (index_R < n2 && index_L < n1) {
                if (compare_and_count(rightArray[index_R], leftArray[index_L])) {
                    A[i] = rightArray[index_R];
                    moves++;
                    index_R++;
                } else {
                    A[i] = leftArray[index_L];
                    moves++;
                    index_L++;
                }
            } else if (index_R == n2) {
                A[i] = leftArray[index_L];
                moves++;
                index_L++;
            } else {
                A[i] = rightArray[index_R];
                moves++;
                index_R++;
            }
        }

        if (size < 40) {
            System.out.println("  After merge " + Arrays.toString(A));
        }
        return A;
    }

    //HYBRID SORT ALGORITHM
    public int[] hybridSortStart(int[] toSort) {
        swaps = 0;
        moves = 0;
        comparations = 0;
        hybridSort(toSort, 0, toSort.length - 1);
        return toSort;
    }

    public void hybridSort(int A[], int beginning, int end) {
        if (end - beginning > K) {
            int middle = (beginning + end) / 2;
            hybridSort(A, beginning, middle);
            hybridSort(A, middle + 1, end);

            int leftSize = middle - beginning +1;
            int rightSize = end - middle;
            int[] arrayLeft = new int[leftSize];
            System.arraycopy(A, beginning, arrayLeft, 0, leftSize);
            moves += arrayLeft.length;
            int[] arrayRight = new int[rightSize];
            System.arraycopy(A, middle +1, arrayRight, 0, rightSize);
            moves += arrayRight.length;
            merge(arrayLeft, arrayRight);

        } else {
            insertSortStart(Arrays.copyOfRange(A, beginning, end));
        }
    }
}