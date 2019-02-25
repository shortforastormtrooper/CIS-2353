// Darryl Green
// CIS 2353 
// Winter 2018 
// Prof. John P. Baugh
package testingsort;

import java.util.Random;

public class TestingSort 
{

    public static void main(String[] args) 
    {

//sets variables
        int size;
        int[] items1;
        int[] items2;
        long timeStart, timeStop, timeElapsed, total, total1, total2 = 0, total3 = 0;

//set array size
        size = 10;
        items1 = new int[size];
        items2 = new int[size];
        fillArrays(items1, items2, size);

//test interger set 10
        System.out.println("Size: " + size);
        total = 0;
        for (int i = 1; i <= 5; i++) 
        {
            timeStart = System.nanoTime();
            QuickSort(items1);
            timeStop = System.nanoTime();
            timeElapsed = timeStop - timeStart;
            total += timeElapsed;
        }
        System.out.println("Elapsed time for QuickSort after 5 runs in nanoseconds: " + total);
        total2 += total;
        total1 = 0;
        for (int i = 1; i <= 5; i++) 
        {
            timeStart = System.nanoTime();
            InsertionSort(items2);
            timeStop = System.nanoTime();
            timeElapsed = timeStop - timeStart;
            total1 += timeElapsed;
        }
        total3 += total1;
        System.out.println("Elapsed time for InsertionSort after 5 runs in nanoseconds: " + total1);
        if (total < total1) 
        {
            System.out.println("QuickSort is faster in this case.");
        } 
        else 
        {
            System.out.println("InsertionSort is faster in this case.");
        }//end test


        for (size = 25; size <= 800; size *= 2) 
        {
            System.out.println("\nSize: " + size);
            items1 = new int[size];
            items2 = new int[size];
            fillArrays(items1, items2, size);

            total = 0;
            for (int i = 1; i <= 5; i++) 
            {
                timeStart = System.nanoTime();
                QuickSort(items1);
                timeStop = System.nanoTime();
                timeElapsed = timeStop - timeStart;
                total += timeElapsed;
            }
            total2 += total;
            System.out.println("Elapsed time for QuickSort after 5 runs in nanoseconds: " + total);

            total1 = 0;
            for (int i = 1; i <= 5; i++) 
            {
                timeStart = System.nanoTime();
                InsertionSort(items2);
                timeStop = System.nanoTime();
                timeElapsed = timeStop - timeStart;
                total1 += timeElapsed;
            }
            total3 += total1;
            System.out.println("Elapsed time for InsertionSort after 5 runs in nanoseconds: " + total1);
            if (total < total1) 
            {
                System.out.println("QuickSort is faster in this case.");
            } 
            else 
            {
                System.out.println("InsertionSort is faster in this case.");
            }

        }//end test


        System.out.println();
        System.out.println("The total elapsed time for QuickSort for all cases: " + total2);
        System.out.println("The total elapsed time for InsertionSort for all cases: " + total3);
        if (total2 < total3) 
        {
            System.out.println("As the list size continues to grow QuickSort is shown to be faster with larger test cases.");
        } 
        else 
        {
            System.out.println("As the list size continues to grow InsertionSort is shown to be faster with larger test cases.");
        }
    }

    public static void fillArrays(int[] items1, int[] items2, int size) 
    {
        Random rand = new Random();

        for (int i = 0; i < size; i++) 
        {
            int number = rand.nextInt(size);
            items1[i] = number;
            items2[i] = number;
        }
    }

//QuickSort method implementation
    public static void QuickSort(int[] items) 
    {
        QuickSort(items, 0, items.length - 1);
    }//end QuickSort method 

//QuickSort method implementation
    private static void QuickSort(int[] items, int l, int r) 
    {
        int s = Partition(items, l, r);

        if (l < s - 1) {
            QuickSort(items, l, s - 1);
        }
        if (s < r) {
            QuickSort(items, s, r);
        }
    }//end QuickSort method

    //Partition method implementation
    private static int Partition(int[] items, int l, int r) 
    {
        int p = l;
        int q = r;
        int temp;
        int pivot;
        pivot = items[(l + r) / 2];

        while (p <= q) 
        {
            while (items[p] < pivot) 
            {
                p++;
            }
            while (items[q] > pivot) 
            {
                q--;
            }

            if (p <= q) {
                temp = items[p];
                items[p] = items[q];
                items[q] = temp;
                p++;
                q--;
            }
        }
        return p;
    }//end Partition method

    //InsertionSort method implementation
    public static void InsertionSort(int[] items) 
    {
        for (int i = 1; i < items.length; i++) 
        {
            int temp = items[i];
            int j = i;

            while (j > 0 && temp < items[j - 1]) 
            {
                items[j] = items[j - 1];
                j--;
            }

            items[j] = temp;
        }
    }//end InsertionSort 
} //end main program
