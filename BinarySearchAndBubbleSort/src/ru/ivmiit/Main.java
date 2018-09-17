package ru.ivmiit;

/**
 * SPECIFICATION
 * Binary search wiki: https://en.wikipedia.org/wiki/Binary_search_algorithm
 * Bubble sort wiki: https://en.wikipedia.org/wiki/Bubble_sort
 *
 * @author Draqneel
 */
public class Main {
    /**
     * Binary search with recursion
     *
     * @param arr   - input collection
     * @param left  - left border
     * @param right - right border
     * @param value - searching value
     * @return index of searching value
     */
    public static int searchRec(int[] arr, int left, int right, int value) {
        // calculate index of middle element
        int mid = (left + right) / 2;
        // test on correct -2 - default error value
        if (left > right || arr[right] < value) {
            return -2;
        }
        // if value more then value with middle index - shift the border to the left
        if (arr[mid] > value) {
            return searchRec(arr, left, mid, value);
        }
        // if value more then value with middle index - shift the border to the right
        if (arr[mid] < value) {
            return searchRec(arr, mid, right, value);
        }
        if (arr[mid] == value) {
            return mid;
        }
        // return default value
        return -2;
    }

    /**
     * Binary search with iterative style
     *
     * @param arr   - input collection
     * @param value - searching value
     * @return index of searching value
     */
    public static int searchItr(int[] arr, int value) {
        /**
         * @link ru.ivmiit.Main#searchRec() - you can see the comments
         */
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] > value) {
                right = mid;
            }

            if (arr[mid] < value) {
                left = mid;
            }
        }
        return -2;
    }

    /**
     * Bubble sort realization
     * @param arr - input collection
     */
    public static void sort(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
