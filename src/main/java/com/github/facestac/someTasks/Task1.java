package com.github.facestac.someTasks;

/*

 */

import java.util.*;

public class Task1 {
    private int COUNT = 100000;

    public static void main(String[] args) {
        Task1 task = new Task1();
        
        int[] arr = task.setRandomValues();
//        task.printArray(arr);

        // candaceb
        long startTime = System.nanoTime();
        int n = task.getFirstUniqueByCandaceb(arr);
        System.out.println(n);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        double seconds = (double)timeElapsed / 1_000_000_000.0;
        System.out.println("timer1: " + seconds);

        // plummert
        long startTime2 = System.nanoTime();
        int n2 = task.getFirstUniqueByPlummert(arr);
        System.out.println(n2);
        long endTime2 = System.nanoTime();
        long timeElapsed2 = endTime2 - startTime2;
        double seconds2 = (double)timeElapsed2 / 1_000_000_000.0;
        System.out.println("timer2: " + seconds2);

        // facestac
        long startTime4 = System.nanoTime();
        int n4 = task.getFirstUniqueByFacestac(arr);
        System.out.println(n4);
        long endTime4 = System.nanoTime();
        long timeElapsed4 = endTime4 - startTime4;
        double seconds4 = (double)timeElapsed4 / 1_000_000_000.0;
        System.out.println("timer4: " + seconds4);

        // sort
        long startTime3 = System.nanoTime();
        int n3 = task.getFirstUniqueAfterSorting(arr);
        System.out.println(n3);
        long endTime3 = System.nanoTime();
        long timeElapsed3 = endTime3 - startTime3;
        double seconds3 = (double)timeElapsed3 / 1_000_000_000.0;
        System.out.println("timer3: " + seconds3);


    }


    private int[] setRandomValues() {
        Random rn = new Random();
        int maximum = 10;
        int minimum = 1;

        int[] arr = new int[COUNT];

        for (int i = 0; i < COUNT; i++) {
            int randomNum = rn.nextInt(maximum - minimum + 1) + minimum;
            arr[i] = randomNum;
        }
        return arr;
    }

    private void printArray(int[] arr) {
        for (var i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    private int getFirstUniqueByCandaceb(int[] arr) {
        for (int i : arr) {
            int repeatCount = 0;
            for (int j : arr) {
                if (i == j) repeatCount++;
            }

            if (repeatCount == 1) return i;
        }

        return -1;
    }

    private int getFirstUniqueByPlummert(int[] arr) {
        int maxValue = 0;
        for (int i : arr) {
            if (i > maxValue) maxValue = i;
        }

        int[] repeatCounterArr = new int[maxValue + 1];
        for (int i : arr) {
            repeatCounterArr[i]++;
        }

//        printArray(repeatCounterArr);

        for (int i = 0; i < repeatCounterArr.length; i++) {
            if (repeatCounterArr[i] == 1) return i;
        }

        return -1;
    }

    private int getFirstUniqueByFacestac(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

//        printArray(repeatCounterArr);

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (var i: map.keySet()) {
            if (map.get(i) == 1) return i;
//            System.out.println(key + " " + value);
        }

        return -1;
    }

    // search after sorting
    private int getFirstUniqueAfterSorting(int[] arr) {
        mergeSort(arr, arr.length);
//        printArray(arr);

        if (arr[0] != arr[1]) return arr[0];

        for (int i = 1; i < arr.length - 2; i++) {
            if (arr[i] != arr[i+1] && arr[i] != arr[i-1]) return arr[i];
        }

        if (arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];

        return -1;
    }



    // merge sort
    private void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(arr, l, r, mid, n - mid);
    }

    private void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
