package ru.ivmiit;

public class Main {

    public static int searchRec(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right || arr[right] < value) {
            return -2;
        }
        if (arr[mid] > value) {
            return searchRec(arr, left, mid, value);
        }
        if (arr[mid] < value) {
            return searchRec(arr, mid, right, value);
        }
        if (arr[mid] == value) {
            return mid;
        }
        return -2;
    }

    public static int searchImp(int[] arr, int value) {
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
        int a[] = {10, 9, 8, 7, 6, 5};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        int result = searchImp(a, 9);
        System.out.println(result);
    }
}
