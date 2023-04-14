import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void experiment(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        Sort2 sort = new Sort2();
        sort.size = array.length;

        if (array.length <= 200) {
            int[] insertSorted = sort.insertSortStart(Arrays.copyOf(array, array.length));
            stringBuilder.append("\nIS");
            printToCSV(stringBuilder, sort);
        }

        int[] quickSorted = sort.quickSortStart(Arrays.copyOf(array, array.length));
        stringBuilder.append("\nQS");
        printToCSV(stringBuilder, sort);

        int[] mergeSorted = sort.mergeSortStart(Arrays.copyOf(array, array.length));
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

    public static void printToCSV(StringBuilder stringBuilder, Sort2 sort) {
        stringBuilder.append(";");
        stringBuilder.append(sort.size);
        stringBuilder.append(";");
        stringBuilder.append(sort.comparations);
        stringBuilder.append(";");
        stringBuilder.append(sort.moves + 3*sort.swaps);
        stringBuilder.append(";");
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