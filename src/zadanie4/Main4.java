import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void experiment(int[] array, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        Sort4 sort = new Sort4();
        sort.size = array.length;
        sort.K = k;
        if (sort.size < 40) {
            System.out.println("START");
            System.out.println(Arrays.toString(array));
        }

        int[] insertSorted = sort.insertSortStart(Arrays.copyOf(array, array.length));
        stringBuilder.append("\nIS");
        printToCSV(stringBuilder, sort);
        if (sort.size < 40) {
            System.out.println(".........................INSERT result:");
            System.out.println(Arrays.toString(insertSorted));

            System.out.println(".........................MERGING started: ");
        }
        int[] mergeSorted = sort.mergeSortStart(Arrays.copyOf(array, array.length));
        stringBuilder.append("\nMS");
        printToCSV(stringBuilder, sort);
        if (sort.size < 40) {
            System.out.println(".........................MERGE result: ");
            System.out.println(Arrays.toString(mergeSorted));
            System.out.println(".........................HYBRID started: ");
        }
        int[] hybridSorted = sort.hybridSortStart(Arrays.copyOf(array, array.length));
        stringBuilder.append("\nHS");
        printToCSV(stringBuilder, sort);
        if (sort.size < 40) {
            System.out.println(".........................HYBRID result: ");
            System.out.println(Arrays.toString(insertSorted));
        }

        stringBuilder.append("\n");
        try {
            BufferedWriter bwr = new BufferedWriter(new FileWriter("data.csv", true));
            bwr.write(String.valueOf(stringBuilder));
            bwr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printToCSV(StringBuilder stringBuilder, Sort4 sort) {
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
        try {
            int firstArg = Integer.parseInt(args[0]);
            experiment(intArray, firstArg);
        } catch (NumberFormatException e) {
        }
    }
}
