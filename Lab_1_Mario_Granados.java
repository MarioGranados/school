//Mario Granados lab 1
// Linear and Binary Search in Nanoseconds

public class Lab_1_Mario_Granados {
    public static void main(String[] args) {
        // Create a large array 1 - whaterver maxSize is;
        int maxSize = 100000000;

        int[] sampleArray = new int[maxSize];

        for (int i = 0; i < maxSize; i++) {
            sampleArray[i] = i + 1;
        }

        //algorithms return either 1 or -1
        int results;
        // targets to search for, try to use even numbers rather than odd numbers to avoid rounding issues. the first half will be linear search, the 
        //second half will be binary search
        int[] targets = {1, 2, 50000, -10, 500000, 7500, 99975556, -10};

        //linear search for the first half of the targets, due to lab 1 instructions
        System.out.println("\nLinear Search");
        for(int i = 0; i < targets.length / 2; i++) {
            results = linearSearch(sampleArray, targets[i]);
            if(results == -1) {
                System.out.println("Did not find target in the array!");
            }
        }

        //peform binary search for the second half of targets
        System.out.println("\nBinary Search");
        for(int i = targets.length / 2; i < targets.length ; i++) {
            results = binarySearch(sampleArray, targets[i], sampleArray[0], sampleArray[maxSize - 1]);
            if(results == -1) {
                System.out.println("Did not find target in the array!");    
            }
        }

    }
    // linear search method
    public static int linearSearch(int[] arr, int target) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("key: " + target + " Found at index: " + i + " in " + (System.nanoTime() - startTime)
                        + " nanoseconds");
                return i;
            }
        }
        return -1;
    }
    //binary search method
    public static int binarySearch(int[] arr, int target, int left, int right) {
        long startTime = System.nanoTime();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                System.out.println("Key: " + target + " Found at index: " + mid + " in " + (System.nanoTime() - startTime) + " nanoseconds");
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }
        }
        return -1;
    }

}
