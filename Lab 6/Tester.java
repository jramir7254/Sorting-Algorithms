import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {
    static String dictionaryFile = "dictionary.txt";
    public static void main(String[] args) throws InterruptedException {
        try(Scanner fileScanner = new Scanner(new File(dictionaryFile))) {
            int l = getLength(dictionaryFile);
            String[] s = new String[l];
            extractWords(fileScanner, s);

            // int sum = 0;
            // for(String str : s) {
            //     sum += str.length();
            // }

            // double avg = (double)sum / l;
            // System.out.println(avg);

            // System.out.println(SortingAlgorithms.getMax(s));

            long startTime = System.currentTimeMillis();
            SortingAlgorithms.radixSort(s);
            long estimatedTime = System.currentTimeMillis() - startTime;
            double seconds = (double)estimatedTime / 1_000;
            System.out.println(seconds);
            
            


       
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public static double testBubbleSort(String[] dictionary) {
        System.out.println("Started Bubble Sort");
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.bubbleSort(dictionary);
        long estimatedTime = System.currentTimeMillis() - startTime;
        double seconds = (double)estimatedTime / 1_000;
        System.out.println("Done...");
        return seconds;
    }

    public static double testSelectionSort(String[] dictionary) {
        System.out.println("Started Selection Sort");
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(dictionary);
        long estimatedTime = System.currentTimeMillis() - startTime;
        double seconds = (double)estimatedTime / 1_000;
        System.out.println("Done...");
        return seconds;
    }

    public static double testInsertionSort(String[] dictionary) {
        System.out.println("Started Insertion Sort");
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.insertionSort(dictionary);
        long estimatedTime = System.currentTimeMillis() - startTime;
        double seconds = (double)estimatedTime / 1_000;
        System.out.println("Done...");
        return seconds;
    }


    public static void extractWords(Scanner fileScanner, String[] a) {
        for(int i = 0; i < a.length; i++) {
            a[i] = fileScanner.nextLine();
        }
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
