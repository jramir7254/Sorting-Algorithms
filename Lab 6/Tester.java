import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Tester {
    static String numFile = "C:\\Users\\jrami\\Downloads\\GitHub\\Sorting-Algorithms\\Lab 6\\Integer-Variations\\Sorted-Nums.txt";
    static String wordFile = "words.txt";
    static int runs = -1, type = -1, algorithm = -1, length = -1;
    static boolean shuffle;
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            while(type != 3) {
                System.out.print("Test with Strings or Integers?\n1. Strings\n2. Integers\n3. Exit\n--> ");
                type = scan.nextInt();
                System.out.print("\nAlgorithm Selection?\n1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort\n4. Merge Sort\n5. Quick Sort\n6. Radix Sort\n--> ");
                algorithm = scan.nextInt();
                System.out.print("\nLength of Array?\n--> ");
                length = scan.nextInt();
                System.out.print("\nNumber of runs?\n--> ");
                runs = scan.nextInt();
                System.out.print("Shuffle between runs? (enter true or false)?\n--> ");
                shuffle = scan.nextBoolean();

                if(type == 1)
                    test(new String[length]);
                else 
                    test(new int[length]);
            }
        }
        catch(NoSuchElementException e) {
            System.out.println("you can't put that silly");
        }
    }

    
    public static void test(int[] a) {
        try {
            long startTime, endTime;
            double finalTime, totalTime = 0;
            extractItems(a, numFile);            
            for(int i = 1; i <= runs; i++) {
                if(shuffle) SortingAlgorithms.shuffle(a);
                System.out.println("Started run " + i);
                startTime = System.currentTimeMillis();
                SortingAlgorithms.selectedAlgorithm(algorithm, a);
                endTime = System.currentTimeMillis();
                finalTime = (double)(endTime - startTime) / 1_000;
                totalTime += finalTime;
                System.out.println("Ended run " + i);
                System.out.printf("Run %d took %.2f seconds%n", i, finalTime);
            }
            System.out.printf(Locale.US, "Average time to sort int array with %,d elements is %.2f seconds.%n", a.length, totalTime / runs);
        }
        catch (StackOverflowError e) {
            System.out.println("there was flow");
        }
    }

    public static double test(String[] a) {
        try {
            long startTime, endTime;
            double finalTime, totalTime = 0;
            extractItems(a, numFile);            
            for(int i = 0; i < runs; i++) {
                
                startTime = System.currentTimeMillis();
                SortingAlgorithms.selectedAlgorithm(algorithm, a);
                endTime = System.currentTimeMillis();
                finalTime = (endTime - startTime) / 1_000;
                totalTime += (double)finalTime;
                System.out.printf("Run %d took %.2f seconds%n", i + 1, finalTime);
            }
            return totalTime / 1_000;
        }
        catch (StackOverflowError e) {
            System.out.println("there was flow");
            return 0;
        }
    }

    // public static void warmup(Scanner scnr) throws IOException {
    //     System.out.println("Started warmup");
    //     int[] a = new int[10_000];
    //     for(int i = 0; i < 5; i++) {
    //         scnr = new Scanner(new File(numFile));
    //         extractItems(a, numFile);
    //         //SortingAlgorithms.shuffle(a);

    //         SortingAlgorithms.quickSort(a);
    //         scnr.close();
    //     }
    //     System.out.println("Finished warmup\n");
    // }


    public static void extractItems(String[] a, String fileName) {
        try(Scanner extract = new Scanner(new File(fileName))) {
            for(int i = 0; i < a.length; i++) {
                a[i] = extract.nextLine();
            }
        } 
        catch(IOException e) {
            System.out.printf("Error with extracting Strings from file \"%s.\"%n", fileName);
        }
    }


    public static void extractItems(int[] a, String fileName) {
        try(Scanner extract = new Scanner(new File(fileName))) {
            for(int i = 0; i < a.length; i++) {
                a[i] = extract.nextInt();
            }
        } 
        catch(IOException e) {
            System.out.printf("Error extracting Integers from file \"%s.\"%n", fileName);
        }  
    }


    public static void writeNumbers(String fileName, int max) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));

        for(int i = max; i > 0; i--) {
            fw.append(i + "\n");
        }

        fw.close();
    }


    public static void writeResults(String fileName, int[] a) {
        try(FileWriter resultWriter = new FileWriter(new File(fileName))){
            for(int i = 0; i < a.length - 1; i++) {
                resultWriter.append(a[i] + "\n");
            }
            resultWriter.append(a[a.length - 1] + "");
        }
        catch(IOException err) {
            System.out.printf("Error writing results to file \"%s.\" from Integer array.%n", fileName);
        }
    }


    public static void writeResults(String fileName, String[] a) {
        try(FileWriter resultWriter = new FileWriter(new File(fileName))){
            for(int i = 0; i < a.length - 1; i++) {
                resultWriter.append(a[i] + "\n");
            }
            resultWriter.append(a[a.length - 1]);
        }
        catch(IOException err) {
            System.out.printf("Error writing results to file \"%s.\" from String array.%n", fileName);
        }
    }


    public static int getLength(String fileName) {
        int length = 0;
        try(Scanner lenghtScanner = new Scanner(new File(fileName))) {
            while(lenghtScanner.hasNextLine()) {
                length++;
                lenghtScanner.nextLine();
            }
            return length;
        }
        catch(IOException err) {
            System.out.printf("Error getting length of file \"%s.\"%n", fileName);
            return length;
        } 
    }
}
