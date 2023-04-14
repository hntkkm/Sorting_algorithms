import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void experiment(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        Sort1 sort = new Sort1();
        sort.size = array.length;
        printArray(array);

        if (array.length <= 200) {
            System.out.println("InsertSort");
            int[] insertSorted = sort.insertSortStart(Arrays.copyOf(array, array.length));
            System.out.println("Number of comparations = " + sort.comparations);
            System.out.println("Number of moves = " + sort.moves);
            System.out.println("Number of swaps = " + sort.swaps);
            stringBuilder.append("\nIS");
            printToCSV(stringBuilder, sort);
        }

        System.out.println("QuickSort");
        int[] quickSorted = sort.quickSortStart(Arrays.copyOf(array, array.length));
        System.out.println("Number of comparations = " + sort.comparations);
        System.out.println("Number of moves = " + sort.moves);
        System.out.println("Number of swaps = " + sort.swaps);
        stringBuilder.append("\nQS");
        printToCSV(stringBuilder, sort);

        System.out.println("MergeSort");
        int[] mergeSorted = sort.mergeSortStart(Arrays.copyOf(array, array.length));
        System.out.println("Number of comparations = " + sort.comparations);
        System.out.println("Number of moves = " + sort.moves);
        System.out.println("Number of swaps = " + sort.swaps);
        stringBuilder.append("\nMS");
        printToCSV(stringBuilder, sort);


        stringBuilder.append("\n");
        try {
            BufferedWriter bwr = new BufferedWriter(new FileWriter("data.csv", true));
            bwr.write(String.valueOf(stringBuilder));
            bwr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printToCSV(StringBuilder stringBuilder, Sort1 sort) {
        stringBuilder.append(";");
        stringBuilder.append(sort.size);
        stringBuilder.append(";");
        stringBuilder.append(sort.comparations);
        stringBuilder.append(";");
        stringBuilder.append(sort.moves + 3*sort.swaps);
        stringBuilder.append(";");
    }

    public static void printArray(int[] array){
        if (array.length < 40 ) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] intArray = Arrays.stream(input).mapToInt(s -> {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                return Integer.MIN_VALUE;
            }
        }).toArray();
        experiment(intArray);
    }
}