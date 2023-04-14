import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void experiment(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        Sort3 sort = new Sort3();
        sort.size = array.length;

        int[] quickSorted = sort.quickSortStart(Arrays.copyOf(array, array.length));
        stringBuilder.append("\nQS");
        printToCSV(stringBuilder, sort);

        int[] dualQuickSorted = sort.dualQuickSortStart(Arrays.copyOf(array, array.length));
        stringBuilder.append("\nDQS");
        Main3.printToCSV(stringBuilder, sort);

        stringBuilder.append("\n");
        try {
            BufferedWriter bwr = new BufferedWriter(new FileWriter("data.csv", true));
            bwr.write(String.valueOf(stringBuilder));
            bwr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printToCSV(StringBuilder stringBuilder, Sort3 sort) {
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
