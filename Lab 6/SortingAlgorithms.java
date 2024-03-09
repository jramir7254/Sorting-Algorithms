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


    public static void insertionSort(String[] a) {
        for(int i = 0; i < a.length; i++) {
            int j = i;
            while(j > 0 && a[j].compareTo(a[j - 1]) < 0) {
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
                merged[mergedPos] = a[leftPos];
                leftPos++;
                mergedPos++;
            }
            else {
                merged[mergedPos] = a[rightPos];
                rightPos++;
                mergedPos++;
            }
        }

        while(leftPos <= mid) {
            merged[mergedPos] = a[leftPos];
            leftPos++;
            mergedPos++;
        }       

        while(rightPos <= right) {
            merged[mergedPos] = a[rightPos];
            rightPos++;
            mergedPos++;
        }
   
        for(mergedPos = 0; mergedPos < merged.length; mergedPos++) {
            a[left + mergedPos] = merged[mergedPos];
        } 
    }


    public static void quickSort(String[] a) {
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


    // quickSort helper method //
    private static int partition(String[] a, int left, String pivot, int right) {
        int leftPos = left - 1;
        int rightPos;

        for(rightPos = left; rightPos < right; rightPos++) {
            if(a[rightPos].compareTo(pivot) < 0) {
                leftPos++;
                swap(a, leftPos, rightPos);
            }
        }

        leftPos++;
        swap(a, leftPos, rightPos);

        return leftPos;
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


    public static int binarySearch(String[] a, String word) {
        return binarySearch(a, word, 0, a.length - 1);
    }


    private static int binarySearch(String[] a, String word, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;

            if(a[mid].equals(word))
                return mid;

            if(word.compareTo(a[mid]) < 0)
                return binarySearch(a, word, left, mid);

            return binarySearch(a, word, mid + 1, right);
        }
        return -1;
    }

    /*------------------------------ SWAP HELPER ------------------------------*/

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}