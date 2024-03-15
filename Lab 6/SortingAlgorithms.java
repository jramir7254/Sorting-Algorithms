public class SortingAlgorithms {

    /*--------------------------- SORTING ALGORITHMS ---------------------------*/

    public static void bubbleSort(String[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length - 1 - i; j++) {
                if(a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length - 1 - i; j++) {
                if(a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
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
        for(int i = 0; i < a.length; i++) {
            int j = i;
            while(j > 0 && a[j].compareTo(a[j - 1]) < 0) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }

    public static void insertionSort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int j = i;
            while(j > 0 && a[j] < a[j - 1]) {
                swap(a, j--, j - 1);
            }
        }
    }


    public static void mergeSort(String[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(int[] a) {
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

    private static void mergeSort(int[] a, int left, int right) {
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

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }


    private static void quickSort(String[] a, int left, int right) {
        if(left < right) {
            String pivot = a[right];
            int piviotIndex = partition(a, left, pivot, right);

            quickSort(a, left, piviotIndex - 1);
            quickSort(a, piviotIndex + 1, right);
        }
    }

    private static void quickSort(int[] a, int left, int right) {
        if(left < right) {
            int pivot = a[right];
            int piviotIndex = partition(a, left, pivot, right);

            quickSort(a, left, piviotIndex - 1);
            quickSort(a, piviotIndex + 1, right);
        }
    }


    // quickSort helper method //
    private static int partition(String[] a, int left, String pivot, int right) {
        int leftPos = left - 1;
        int rightPos;

        for(rightPos = left; rightPos < right; rightPos++) {
            if(a[rightPos].compareTo(pivot) < 0) {
                swap(a, ++leftPos, rightPos);
            }
        }

        swap(a, ++leftPos, rightPos);

        return leftPos;
    }

    // quickSort helper method //
    private static int partition(int[] a, int left, int pivot, int right) {
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


    //---------------------------------------------------------------------------------------------------------------------------------------------------
    private static int getAvg(String[] a) {
        int sum = 0;
            for(String str : a) {
                sum += str.length();
            }

            return sum / a.length;
    }

    public static void radixSort(String[] arr) {
        final int MAX_CHAR = getMax(arr); // Assuming ASCII characters
        
        // Perform counting sort for each character position
        for (int digit = MAX_CHAR; digit >= 0; digit--) {
            countingSort(arr, digit);
        }
    }

    // Counting sort for a specific character position
    private static void countingSort(String[] arr, int digit) {
        final int ASCII_RANGE = 253; // ASCII characters range from 0 to 127
        
        // Initialize count array
        int[] count = new int[ASCII_RANGE];

        // Count occurrences of characters at the given position
        for (String str : arr) {
            int charValue = (digit < str.length()) ? str.charAt(digit) : 0; // If string is shorter, consider character value as 0
            count[charValue]++;
        }

        // Modify count array to store cumulative count
        for (int i = 1; i < ASCII_RANGE; i++) {
            count[i] += count[i - 1];
        }

        // Create a temporary array to store sorted strings
        String[] temp = new String[arr.length];

        // Build the sorted array
        for (int i = arr.length - 1; i >= 0; i--) {
            String str = arr[i];
            int charValue = (digit < str.length()) ? str.charAt(digit) : 0; // If string is shorter, consider character value as 0
            temp[count[charValue] - 1] = str;
            count[charValue]--;
        }

        // Copy the sorted strings back to the original array
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }

    public static int getMax(String[] a) {
        int maxLength = a[0].length();
        String m = "";
        for (int i = 0; i < a.length; i++) {
            if(a[i].length() > maxLength) {
                maxLength = a[i].length();
                m = a[i];
            }
        }
        System.out.println(m);
        return maxLength;
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


    public static int binarySearch(int[] a, int number) {
        return binarySearch(a, number, 0, a.length - 1);
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

    /*------------------------------ SWAP HELPERS ------------------------------*/

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
}