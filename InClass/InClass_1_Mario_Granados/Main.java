package InClass.InClass_1_Mario_Granados;

public class Main {
    public static Long AlgorithmA(int n) {
        Long startTime;
        Long endTime;
        Long elapsedTime;

        startTime = System.nanoTime();

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;

        }


        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;
        return elapsedTime;
    }

    public static int linearSearch(int target, int[] array){

        for(int i = 0; i < array.length; i++){
            if(target == array[i]){
                return i;
            } 
        }
        return -1;
    }

    public static int binarySearch(int target, int[] array, int low, int high){
        if(low > high) return -1;
        int middle = low + (high - low) / 2;

        if(array[middle] == target) {
            return middle;
        } else if (target < array[middle]) {
            return binarySearch(target, array, low, middle - 1);
        } else {
            return binarySearch(target, array, middle + 1, high);
        }
    }

    public static void displayLinearSearch(int target, int[] array) {
        Long startTime = System.nanoTime();
        int position = linearSearch(target, array);
        Long endTime = System.nanoTime();
        Long elapsedTime = endTime - startTime;

        System.out.println("key\t" + "position\t" + "Runtime\t");
        System.out.println(target + "\t " + position + "\t\t " + elapsedTime);
    }

    public static void displayBinarySearch(int target, int[] array) {
        Long startTime = System.nanoTime();
        int position = binarySearch(target, array, 0, array.length - 1);
        Long endTime = System.nanoTime();
        Long elapsedTime = endTime - startTime;

        System.out.println("key\t" + "position\t" + "Runtime\t");
        System.out.println(target + "\t " + position + "\t\t " + elapsedTime);
    }

    public static void main(String args[]) {
        int indeces = 10000000;
        int[] array = new int[indeces];
        for(int i = 0; i < indeces; i++){
            array[i] = i;
        }

        displayLinearSearch(1, array);
        displayLinearSearch(2, array);
        displayLinearSearch(5000000, array);
        displayLinearSearch(-10, array);

        displayBinarySearch(5000000, array);
        displayBinarySearch(7500000, array);
        displayBinarySearch(9997559, array);
        displayBinarySearch(-10, array);
    }
}