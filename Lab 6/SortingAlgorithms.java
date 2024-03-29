import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class SortingAlgorithms {

    public static void selectedAlgorithm(int s, int[] a) {
        switch (s) {
            case 1 : bubbleSort(a);
                break;
            case 2 : selectionSort(a);
                break;
            case 3 : insertionSort(a);
                break;
            case 4 : mergeSort(a);
                break;
            case 5 : quickSort(a);
                break;
            case 6 : radixSort(a);
                break;
            case 7 : linearSearch(a, s);
                break;
            case 8 : binarySearch(a, s);
                break;
        }
    }


    public static void selectedAlgorithm(int s, String[] a) {
        switch (s) {
            case 1 : bubbleSort(a);
                break;
            case 2 : selectionSort(a);
                break;
            case 3 : insertionSort(a);
                break;
            case 4 : mergeSort(a);
                break;
            case 5 : quickSort(a);
                break;
            case 6 : radixSort(a);
                break;
            case 7 : linearSearch(a, "");
                break;
            case 8 : binarySearch(a, "");
                break;
        }
    }

    /*--------------------------- SORTING ALGORITHMS ---------------------------*/

    public static void bubbleSort(String[] a) {
        boolean swapped = true;

        for(int i = 0; i < a.length - 1 && swapped; i++) {
            swapped = false;
            for(int j = 0; j < a.length - 1 - i; j++) {
                if(a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
        }
    }

    
    public static void bubbleSort(int[] a) {
        boolean swapped = true;

        for(int i = 0; i < a.length && swapped; i++) {
            swapped = false;
            for(int j = 0; j < a.length - 1 - i; j++) {
                if(a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
        }
    }


    public static void selectionSort(String[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            int indexSmallest = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo(a[indexSmallest]) < 0) {
                    indexSmallest = j;
                }
            }
            swap(a, i, indexSmallest);
        }
    }


    public static void selectionSort(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            int indexSmallest = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < a[indexSmallest]) {
                    indexSmallest = j;
                }
            }
            swap(a, i, indexSmallest);
        }
    }
 

    public static void insertionSort(String[] a) {
        for(int i = 1; i < a.length; i++) {
            int j = i;
            while(j > 0 && a[j].compareTo(a[j - 1]) < 0) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }


    public static void insertionSort(int[] a) {
        for(int i = 1; i < a.length; i++) {
            int j = i;
            while(j > 0 && a[j] < a[j - 1]) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }


    public static void mergeSort(String[] a) {
        mergeSort(a, 0, a.length - 1);
    }


    private static void mergeSort(String[] a, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);

            merge(a, left, mid, right);
        }
    }


    // mergeSort helper method //
    private static void merge(String[] a, int left, int mid, int right) {
        int leftPos = left, rightPos = mid + 1;
        int mergedPos = 0, mergeSize = right - left + 1;
        String[] merged = new String[mergeSize];

        while(leftPos <= mid && rightPos <= right) {
            if(a[leftPos].compareTo(a[rightPos]) < 0) {
                merged[mergedPos++] = a[leftPos++];
            }
            else { 
                merged[mergedPos++] = a[rightPos++];
            }
        }

        while(leftPos <= mid) {
            merged[mergedPos++] = a[leftPos++];
        }
   
        while(rightPos <= right) {
            merged[mergedPos++] = a[rightPos++];
        }

        for(mergedPos = 0; mergedPos < merged.length; mergedPos++) {
            a[left + mergedPos] = merged[mergedPos];
        }
    }


    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }


    private static void mergeSort(int[] a, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);

            merge(a, left, mid, right);
        }
    }


    // mergeSort helper method //
    private static void merge(int[] a, int left, int mid, int right) {
        int leftPos = left, rightPos = mid + 1;
        int mergedPos = 0, mergeSize = right - left + 1;
        int[] merged = new int[mergeSize];

        while(leftPos <= mid && rightPos <= right) {
            if(a[leftPos] < a[rightPos]) {
                merged[mergedPos++] = a[leftPos++];
            }
            else { 
                merged[mergedPos++] = a[rightPos++];
            }
        }

        while(leftPos <= mid) {
            merged[mergedPos++] = a[leftPos++];
        }
   
        while(rightPos <= right) {
            merged[mergedPos++] = a[rightPos++];
        }

        for(mergedPos = 0; mergedPos < merged.length; mergedPos++) {
            a[left + mergedPos] = merged[mergedPos];
        }
    }


    public static void quickSort(String[] a) {
        quickSort(a, 0, a.length - 1);
    }


    private static void quickSort(String[] a, int left, int right) throws StackOverflowError {
        if(left < right) {
            int piviotIndex = partition(a, left, right);

            quickSort(a, left, piviotIndex - 1);
            quickSort(a, piviotIndex + 1, right);
        }
    }


    // quickSort helper method //
    private static int partition(String[] a, int left, int right) {
        String pivot = a[right];
        int leftPos = left - 1;
        int rightPos;

        for(rightPos = left; rightPos < right; rightPos++) {
            if(a[rightPos].compareTo(pivot) < 0) {
                ++leftPos;
                swap(a, leftPos, rightPos);
            }
        }

        ++leftPos;
        swap(a, leftPos, rightPos);

        return leftPos;
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }


    private static void quickSort(int[] a, int left, int right) {
        if(left < right) {
            int piviotIndex = partition(a, left,right);

            quickSort(a, left, piviotIndex - 1);
            quickSort(a, piviotIndex + 1, right);
        }
    }


    // quickSort helper method //
    private static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int leftPos = left - 1;
        int rightPos;

        for(rightPos = left; rightPos < right; rightPos++) {
            if(a[rightPos] < pivot) {
                swap(a, ++leftPos, rightPos);
            }
        }

        swap(a, ++leftPos, rightPos);

        return leftPos;
    }


    public static void radixSort(String[] arr) {
        final int MAX_CHAR = getMax(arr); 
        
        for (int digit = MAX_CHAR; digit >= 0; digit--) {
            countingSort(arr, digit);
        }
    }


    private static void countingSort(String[] arr, int digit) {
        final int ASCII_RANGE = 255; 
        
        int[] count = new int[ASCII_RANGE];

        for(String str : arr) {
            int charValue = (digit < str.length()) ? str.charAt(digit) : 0; 
            count[charValue]++;
        }

        for(int i = 1; i < ASCII_RANGE; i++) {
            count[i] += count[i - 1];
        }

        String[] temp = new String[arr.length];


        for (int i = arr.length - 1; i >= 0; i--) {
            String str = arr[i];
            int charValue = (digit < str.length()) ? str.charAt(digit) : 0; 
            temp[count[charValue] - 1] = str;
            count[charValue]--;
        }

        System.arraycopy(temp, 0, arr, 0, arr.length);
    }

    
    public static void radixSort(int[] a) {
        int maxNum = getMax(a); 
        
        for (int exp = 1; maxNum / exp > 0; exp *= 10) {
            countingSort(a, exp);
        }
    }


    private static void countingSort(int[] a, int exp) {
        int output[] = new int[a.length]; 
        int count[] = new int[10];
        int l = a.length;
        Arrays.fill(count, 0);

        for(int i = 0; i < l; i++)
            count[(a[i] / exp) % 10]++;
     
        for(int i = 1; i < 10; i++)
            count[i] += count[i - 1];
     
        for(int i = l - 1; i >= 0; i--) {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10]--; 
        }
     
        for(int i = 0; i < l; i++)
            a[i] = output[i];
    }

    /*--------------------------- SEARCH ALGORITHMS ---------------------------*/

    public static int linearSearch(String[] a, String word) {
        for(int i = 0; i < a.length; i++) {
            if(a[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }


    public static int linearSearch(int[] a, int number) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] == number) {
                return i;
            }
        }
        return -1;
    }


    public static int binarySearch(String[] a, String word) {
        return binarySearch(a, word, 0, a.length - 1);
    }


    private static int binarySearch(String[] a, String word, int left, int right) {
        if(left >= right) 
            return -1;

        int mid = left + (right - left) / 2;

        if(a[mid].equals(word))
            return mid;

        if(word.compareTo(a[mid]) < 0)
            return binarySearch(a, word, left, mid);

        return binarySearch(a, word, mid + 1, right);
    }


    public static int binarySearch(int[] a, int number) {
        return binarySearch(a, number, 0, a.length - 1);
    }


    private static int binarySearch(int[] a, int number, int left, int right) {
        if(left >= right) 
            return -1;

        int mid = left + (right - left) / 2;

        if(a[mid] == number)
            return mid;

        if(number < (a[mid]))
            return binarySearch(a, number, left, mid);

        return binarySearch(a, number, mid + 1, right);
    }

    /*------------------------------ OTHER HELPERS ------------------------------*/

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void shuffle(String[] a) {
        Random rand = new Random();
        for(int i = a.length - 1; i > 0; i--) {
            int randIndex = rand.nextInt(i + 1);
            swap(a, i, randIndex);
        }
    }


    public static void shuffle(int[] a) {
        Random rand = new Random();
        for(int i = a.length - 1; i > 0; i--) {
            int randIndex = rand.nextInt(i + 1);
            swap(a, i, randIndex);
        }
    }


    public static int getMax(String[] a) {
        int maxLength = a[0].length();
        for (int i = 0; i < a.length; i++) {
            if(a[i].length() > maxLength) {
                maxLength = a[i].length();
            }
        }
        return maxLength;
    }


    public static int getMax(int[] a) {
        int maxNum = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i] > maxNum) {
                maxNum = a[i];
            }
        }
        return maxNum;
    }
}