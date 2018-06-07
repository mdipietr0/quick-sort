package com.michael;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[10000];
        for (int i = 0 ; i < a.length; i++){
            a[i] = (int) (Math.random() * 10000);
        }
        printIntArray(a);
        quickSort(a, 0, a.length - 1);
        printIntArray(a);
    }

    public static void printIntArray(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void quickSort(int[] a, int p, int r){
        if(p < r) {
            int q = randomizedPartition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q + 1, r);
        }
    }

    public static int partition(int[] a, int p, int r){
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if(a[j] <= x){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;
        return i+1;
    }

    public static int randomizedPartition(int[] a, int p, int r){
        int i = (int) (Math.random() * (r - p) + p);
        int temp = a[r];
        a[r] = a[i];
        a[i] = temp;
        return partition(a, p, r);
    }
}
