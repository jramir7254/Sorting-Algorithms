import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {
    static String dictionaryFile = "dictionary.txt";
    public static void main(String[] args) throws InterruptedException {
        try(Scanner fileScanner = new Scanner(new File(dictionaryFile))) {

            String[] dictionary = new String[getLength(dictionaryFile)];
            extractWords(fileScanner, dictionary);
            SortingAlgorithms.mergeSort(dictionary);

            Scanner q = new Scanner(new File("Sorted-Ascending.txt"));
            Scanner m = new Scanner(new File("Merge-Ascending.txt"));

            int l =  getLength(dictionaryFile);
            
            
            for(int i = 0; i < l; i++) {
                String qs = q.nextLine();
                String ms = m.nextLine();
                if(qs.equals(ms)) {
                    System.out.println("mathc");
                }
            }

            q.close();
            m.close();

            

            String[] a = dictionary.clone();
            String[] b = dictionary.clone();
            String[] c = dictionary.clone();
            String[] d = dictionary.clone();
            String[] e = dictionary.clone();
            String[] f = dictionary.clone();
            // String[] g = dictionary.clone();
            // String[] h = dictionary.clone();
            // String[] i = dictionary.clone();

            // String[] x = dictionary.clone();
            // String[] y = dictionary.clone();
            // String[] z = dictionary.clone();

            // System.out.println("Time to sort: " + testBubbleSort(a) + " seconds\n");
            // System.out.println("Time to sort: " + testBubbleSort(b) + " seconds\n");
            // System.out.println("Time to sort: " + testBubbleSort(x) + " seconds\n");
            // System.out.println("Time to sort: " + testSelectionSort(a) + " seconds\n");
            // System.out.println("Time to sort: " + testSelectionSort(b) + " seconds\n");
            // System.out.println("Time to sort: " + testSelectionSort(c) + " seconds\n");
            // System.out.println("Time to sort: " + testInsertionSort(e) + " seconds\n");
            // System.out.println("Time to sort: " + testInsertionSort(f) + " seconds\n");
            // System.out.println("Time to sort: " + testInsertionSort(z) + " seconds\n");
            // System.out.println("Time to sort: " + testBubbleSort(g) + " seconds\n");
            // System.out.println("Time to sort: " + testSelectionSort(h) + " seconds\n");
            // System.out.println("Time to sort: " + testInsertionSort(i) + " seconds\n");
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public static double testBubbleSort(String[] dictionary) {
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.bubbleSort(dictionary);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Start time: in ms: " + startTime + "\tEnd time: in ms: " + estimatedTime);
        double seconds = (double)estimatedTime / 1_000;
        return seconds;
    }

    public static double testSelectionSort(String[] dictionary) {
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(dictionary);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Start time: in ms: " + startTime + "\tEnd time: in ms: " + estimatedTime);
        double seconds = (double)estimatedTime / 1_000;
        return seconds;
    }

    public static double testInsertionSort(String[] dictionary) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.insertionSort(dictionary);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Start time: in ms: " + startTime + "\tEnd time: in ms: " + estimatedTime);
        double seconds = (double)estimatedTime / 1_000;
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
