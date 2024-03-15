import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {
    static String dictionaryFile = "Numbers.txt";
    public static void main(String[] args) {
        try(Scanner fileScanner = new Scanner(new File(dictionaryFile))) {
            int l = getLength(dictionaryFile);
            int[] a = new int[l];
            extractNumbers(fileScanner, a);

            FileWriter fw = new FileWriter(new File("Lab 6\\Sorting Results\\QuickSortInt.txt"));
            
            
            //     fw.append(a[i] + "\n");
            // }));

            // for(int i = 0; i < 1_000_000; i++) {
            //     a[i] = i + 1;
            // }

            // Random r = new Random();

            // for(int i = 0; i < a.length; i++) {
            //     int rand = r.nextInt(1_000_000);
            //     int temp = a[i];
            //     a[i] = a[rand];
            //     a[rand] = temp;
            // }

            // for(int i = 0; i < a.length; i++) {
            //     fw.append(a[i] + "\n");
            // }

            //fw.close();

            long startTime = System.currentTimeMillis();
            SortingAlgorithms.quickSort(a);
            long estimatedTime = System.currentTimeMillis() - startTime;
            double seconds = (double)estimatedTime / 1_000;
            System.out.println(seconds);

            for(int i = 0; i < a.length; i++) {
                fw.append(a[i] + "\n");
            }
            fw.close();
            
            


       
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

    public static void extractNumbers(Scanner fileScanner, int[] a) {
        for(int i = 0; i < a.length; i++) {
            a[i] = fileScanner.nextInt();
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
