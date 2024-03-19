import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {
    static String mainFile = "Numbers.txt";
    public static void main(String[] args) {
        try(Scanner fileScanner = new Scanner(new File(mainFile))) {

            int l = getLength(mainFile);
            int[] a = new int[l];
            extractNumbers(fileScanner, a);
            
            System.out.println("Started");
            long startTime = System.currentTimeMillis();
            SortingAlgorithms.radixSort(a);
            long estimatedTime = System.currentTimeMillis() - startTime;
            double seconds = (double)estimatedTime / 1_000;
            System.out.println(seconds);
            System.out.println("Done");

            writeResults("Test-Nums.txt", a);

        }
        catch(IOException e) {
            System.out.println(e);
        }
    }


    public static void extractWords(Scanner fileScanner, String[] a) {
        for(int i = 0; i < a.length; i++) {
            a[i] = fileScanner.nextLine();
        }
    }

    public static void extractNumbers(Scanner fileScanner, int[] a) {
        for(int i = 0; i < a.length; i++) {
            a[i] = fileScanner.nextInt();
        }
    }

    public static void writeNumbers(String fileName, int max) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));

        for(int i = 1; i <= max; i++) {
            fw.append(i + "\n");
        }

        fw.close();
    }


    public static void writeResults(String fileName, int[] a) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));

        for(int i = 0; i < a.length; i++) {
            fw.append(a[i] + "\n");
        }

        fw.close();
    }

    public static int getLength(String fileName) throws FileNotFoundException {
        Scanner lenghtScanner = new Scanner(new File(fileName));
        int lines = 0;

        while(lenghtScanner.hasNextLine()) {
            lines++;
            lenghtScanner.nextLine();
        }

        lenghtScanner.close();
        return lines;
    }
}
