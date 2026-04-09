package InClass.Lab7_Mario_Granados;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static int calcMinRun(int n) {
        int r = 0;
        while (n >= 64) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static int findRun(int[] arr, int start, int length) {
        if (start >= length - 1) {
            return length;
        }

        int end = start + 1;

        if (arr[end] >= arr[start]) {
            while (end < length && arr[end] >= arr[end - 1]) {
                end++;
            }
        } else {
            while (end < length && arr[end] < arr[end - 1]) {
                end++;
            }
            reverse(arr, start, end - 1);
        }
        return end;
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void timSort(int[] arr) {
        int n = arr.length;
        int minRun = calcMinRun(n);

        ArrayList<int[]> runs = new ArrayList<>();
        int index = 0;

        while (index < n) {
            int runEnd = findRun(arr, index, n);
            int runLength = runEnd - index;

            if (runLength < minRun) {
                int end = Math.min(index + minRun, n);
                insertionSort(arr, index, end - 1);
                runEnd = end;
            }

            runs.add(new int[]{index, runEnd});
            index = runEnd;
        }

        while (runs.size() > 1) {
            ArrayList<int[]> newRuns = new ArrayList<>();
            for (int i = 0; i < runs.size(); i += 2) {
                if (i + 1 < runs.size()) {
                    int left = runs.get(i)[0];
                    int right = runs.get(i + 1)[1] - 1;
                    MergeSort.merge(arr, left, runs.get(i)[1] - 1, right);
                    newRuns.add(new int[]{left, right + 1});
                } else {
                    newRuns.add(runs.get(i));
                }
            }
            runs = newRuns;
        }
    }

    public static void main(String[] args) {
        int[] arr = {42, 7, 19, 73, 3, 55, 28, 91, 10, 64, 2, 99, 35, 18, 50};
        System.out.println("Original:");
        System.out.println(Arrays.toString(arr));
        timSort(arr);
        System.out.println("Sorted:");
        System.out.println(Arrays.toString(arr));
    }
}
