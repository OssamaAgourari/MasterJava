package org.example.Algorithms.Sorting;

import java.util.Arrays;

/**
 * ============================================================
 *           SORTING ALGORITHMS — COMPARISON GUIDE
 * ============================================================
 *
 * ALL SORTING ALGORITHMS AT A GLANCE:
 * ─────────────────────────────────────────────────────────────────────────────
 *  Algorithm     | Best     | Average  | Worst    | Space  | Stable | Notes
 * ─────────────────────────────────────────────────────────────────────────────
 *  Bubble Sort   | O(n)     | O(n²)    | O(n²)    | O(1)   | YES    | educational only
 *  Selection Sort| O(n²)    | O(n²)    | O(n²)    | O(1)   | NO*    | min swaps
 *  Insertion Sort| O(n)     | O(n²)    | O(n²)    | O(1)   | YES    | best for nearly sorted
 *  Merge Sort    | O(n logn)| O(n logn)| O(n logn)| O(n)   | YES    | best for linked lists
 *  Quick Sort    | O(n logn)| O(n logn)| O(n²)    | O(logn)| NO     | fastest in practice
 *  Heap Sort     | O(n logn)| O(n logn)| O(n logn)| O(1)   | NO     | guaranteed O(n logn)
 *  Counting Sort | O(n+k)   | O(n+k)   | O(n+k)   | O(k)   | YES    | integers in range [0,k]
 *  Radix Sort    | O(nk)    | O(nk)    | O(nk)    | O(n+k) | YES    | fixed-width integers
 *  Tim Sort      | O(n)     | O(n logn)| O(n logn)| O(n)   | YES    | Java's Arrays.sort()
 * ─────────────────────────────────────────────────────────────────────────────
 *  * Selection sort can be made stable but typically isn't
 *  k = range of input values, n = number of elements
 *
 * DECISION GUIDE — WHICH TO USE?
 * ────────────────────────────────────────────────────────────
 *  Situation                          → Best Choice
 * ────────────────────────────────────────────────────────────
 *  General purpose, production        → Tim Sort (Java's Arrays.sort)
 *  Small array (n < 20)               → Insertion Sort
 *  Nearly sorted data                 → Insertion Sort
 *  Guaranteed O(n logn), no extra mem → Heap Sort
 *  Stable sort needed, extra mem OK   → Merge Sort
 *  Average best performance, in-place → Quick Sort (with good pivot)
 *  Integers in small range            → Counting Sort
 *  Large integers, many digits        → Radix Sort
 *  Interview (simplest to explain)    → Merge Sort or Quick Sort
 * ────────────────────────────────────────────────────────────
 *
 * STABILITY:
 * -----------
 *   A sort is STABLE if equal elements keep their original order.
 *   Matters when sorting objects by one field when already sorted by another.
 *   Stable: Bubble, Insertion, Merge, Counting, Radix, Tim Sort
 *   NOT stable: Selection, Quick (typically), Heap Sort
 *
 * ============================================================
 */
public class SortingComparison {

    // ── All sorting algorithms side by side ──────────────────

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) { int t=arr[j];arr[j]=arr[j+1];arr[j+1]=t; swapped=true; }
            }
            if (!swapped) break; // already sorted — O(n) best case
        }
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) if (arr[j] < arr[min]) min = j;
            if (min != i) { int t=arr[i];arr[i]=arr[min];arr[min]=t; }
        }
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i-1;
            while (j >= 0 && arr[j] > key) { arr[j+1]=arr[j]; j--; }
            arr[j+1] = key;
        }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid); mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r-l+1];
        int i=l, j=mid+1, k=0;
        while (i<=mid && j<=r) tmp[k++] = arr[i]<=arr[j] ? arr[i++] : arr[j++];
        while (i<=mid) tmp[k++]=arr[i++];
        while (j<=r)   tmp[k++]=arr[j++];
        System.arraycopy(tmp,0,arr,l,tmp.length);
    }

    static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p-1); quickSort(arr, p+1, hi);
    }
    static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi], i = lo-1;
        for (int j=lo; j<hi; j++) if (arr[j]<=pivot) { int t=arr[++i];arr[i]=arr[j];arr[j]=t; }
        int t=arr[i+1];arr[i+1]=arr[hi];arr[hi]=t;
        return i+1;
    }

    static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i=n/2-1;i>=0;i--) sift(arr,n,i);
        for (int i=n-1;i>0;i--) { int t=arr[0];arr[0]=arr[i];arr[i]=t; sift(arr,i,0); }
    }
    static void sift(int[] arr, int n, int i) {
        while (true) { int l=2*i+1,r=2*i+2,big=i;
            if (l<n&&arr[l]>arr[big])big=l; if (r<n&&arr[r]>arr[big])big=r;
            if (big==i)break; int t=arr[i];arr[i]=arr[big];arr[big]=t;i=big; }
    }

    static void countingSort(int[] arr) {
        if (arr.length==0) return;
        int max=arr[0]; for (int v:arr) max=Math.max(max,v);
        int[] count = new int[max+1];
        for (int v:arr) count[v]++;
        int idx=0;
        for (int v=0;v<=max;v++) while (count[v]-->0) arr[idx++]=v;
    }

    public static void main(String[] args) {

        int[] original = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original: " + Arrays.toString(original));

        int[] arr; // test each

        arr = original.clone(); bubbleSort(arr);
        System.out.println("Bubble:    " + Arrays.toString(arr));

        arr = original.clone(); selectionSort(arr);
        System.out.println("Selection: " + Arrays.toString(arr));

        arr = original.clone(); insertionSort(arr);
        System.out.println("Insertion: " + Arrays.toString(arr));

        arr = original.clone(); mergeSort(arr, 0, arr.length-1);
        System.out.println("Merge:     " + Arrays.toString(arr));

        arr = original.clone(); quickSort(arr, 0, arr.length-1);
        System.out.println("Quick:     " + Arrays.toString(arr));

        arr = original.clone(); heapSort(arr);
        System.out.println("Heap:      " + Arrays.toString(arr));

        arr = original.clone(); countingSort(arr);
        System.out.println("Counting:  " + Arrays.toString(arr));

        arr = original.clone(); Arrays.sort(arr); // Tim Sort
        System.out.println("Tim Sort:  " + Arrays.toString(arr));

        // ── Performance benchmark (rough) ──────────────────────
        System.out.println("\n=== Benchmark: n=10000 random array ===");
        int N = 10000;
        int[] data = new int[N]; java.util.Random rng = new java.util.Random(42);
        for (int i=0;i<N;i++) data[i]=rng.nextInt(10000);

        long t; int[] copy;

        copy=data.clone(); t=System.nanoTime(); insertionSort(copy); System.out.printf("Insertion  %8.2f ms%n",(System.nanoTime()-t)/1e6);
        copy=data.clone(); t=System.nanoTime(); mergeSort(copy,0,copy.length-1); System.out.printf("Merge      %8.2f ms%n",(System.nanoTime()-t)/1e6);
        copy=data.clone(); t=System.nanoTime(); quickSort(copy,0,copy.length-1); System.out.printf("Quick      %8.2f ms%n",(System.nanoTime()-t)/1e6);
        copy=data.clone(); t=System.nanoTime(); heapSort(copy); System.out.printf("Heap       %8.2f ms%n",(System.nanoTime()-t)/1e6);
        copy=data.clone(); t=System.nanoTime(); Arrays.sort(copy); System.out.printf("Tim Sort   %8.2f ms%n",(System.nanoTime()-t)/1e6);

        // ── Summary table ──────────────────────────────────────
        System.out.println("\n════════════════════════════════════════════════════════════════");
        System.out.printf("%-16s %-11s %-11s %-11s %-7s %-7s%n","Algorithm","Best","Average","Worst","Space","Stable");
        System.out.println("────────────────────────────────────────────────────────────────");
        row("Bubble",    "O(n)",     "O(n²)",    "O(n²)",    "O(1)",   "YES");
        row("Selection", "O(n²)",    "O(n²)",    "O(n²)",    "O(1)",   "NO");
        row("Insertion", "O(n)",     "O(n²)",    "O(n²)",    "O(1)",   "YES");
        row("Merge",     "O(nlogn)", "O(nlogn)", "O(nlogn)", "O(n)",   "YES");
        row("Quick",     "O(nlogn)", "O(nlogn)", "O(n²)",    "O(logn)","NO");
        row("Heap",      "O(nlogn)", "O(nlogn)", "O(nlogn)", "O(1)",   "NO");
        row("Counting",  "O(n+k)",   "O(n+k)",   "O(n+k)",   "O(k)",   "YES");
        row("Tim Sort",  "O(n)",     "O(nlogn)", "O(nlogn)", "O(n)",   "YES");
        System.out.println("════════════════════════════════════════════════════════════════");
    }

    static void row(String a, String b, String avg, String w, String sp, String st) {
        System.out.printf("%-16s %-11s %-11s %-11s %-7s %-7s%n",a,b,avg,w,sp,st);
    }
}
