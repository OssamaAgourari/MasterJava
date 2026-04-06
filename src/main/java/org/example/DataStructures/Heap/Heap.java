package org.example.DataStructures.Heap;

import java.util.*;

/**
 * ============================================================
 *                  HEAP — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A HEAP?
 * ----------------
 * A complete binary tree stored as an ARRAY where every parent
 * satisfies the heap property:
 *   MIN-HEAP: parent ≤ both children  → root = minimum
 *   MAX-HEAP: parent ≥ both children  → root = maximum
 *
 * ARRAY REPRESENTATION (1-indexed):
 *   Parent of i:      i / 2
 *   Left child of i:  2 * i
 *   Right child of i: 2 * i + 1
 *
 * 0-indexed (more common in code):
 *   Parent:      (i - 1) / 2
 *   Left child:  2*i + 1
 *   Right child: 2*i + 2
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation      | Time     | Notes
 *   ---------------|----------|----------------------------
 *   insert         | O(log n) | add at end, sift up
 *   extractMin/Max | O(log n) | swap root with last, sift down
 *   peek (min/max) | O(1)     | root is always min/max
 *   heapify array  | O(n)     | build heap from array
 *   search         | O(n)     | heap is NOT sorted
 *   delete at i    | O(log n) | decrease key then extract
 *
 * SPACE: O(n)
 *
 * KEY USE CASES:
 * ---------------
 *   ✔ Priority Queue (most common)
 *   ✔ Heap Sort — O(n log n)
 *   ✔ Kth Largest/Smallest element
 *   ✔ Merge K sorted lists
 *   ✔ Find median from data stream (two heaps)
 *   ✔ Dijkstra's shortest path
 *   ✔ Task scheduling
 *
 * JAVA BUILT-IN:
 * ---------------
 *   PriorityQueue<E> — min-heap by default
 *   new PriorityQueue<>(Collections.reverseOrder()) — max-heap
 *   offer(e) → insert O(log n)
 *   poll()   → extract min O(log n)
 *   peek()   → view min O(1)
 *
 * ============================================================
 */
public class Heap {

    // ─── Min-Heap implementation ──────────────────────────────
    static class MinHeap {
        private int[] data;
        private int   size;

        MinHeap(int capacity) { data = new int[capacity]; }

        // ── Insert O(log n)
        void insert(int val) {
            if (size == data.length) throw new RuntimeException("Heap full");
            data[size++] = val;
            siftUp(size - 1);
        }

        // ── Extract min O(log n)
        int extractMin() {
            if (size == 0) throw new RuntimeException("Heap empty");
            int min = data[0];
            data[0] = data[--size];
            siftDown(0);
            return min;
        }

        // ── Peek min O(1)
        int peek() { if (size==0) throw new RuntimeException(); return data[0]; }

        // ── Build heap from array — O(n)
        void heapify(int[] arr) {
            data = arr.clone();
            size = arr.length;
            // start from last non-leaf
            for (int i = size/2 - 1; i >= 0; i--) siftDown(i);
        }

        private void siftUp(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (data[parent] <= data[i]) break;
                swap(i, parent);
                i = parent;
            }
        }

        private void siftDown(int i) {
            while (true) {
                int left  = 2*i+1, right = 2*i+2, smallest = i;
                if (left  < size && data[left]  < data[smallest]) smallest = left;
                if (right < size && data[right] < data[smallest]) smallest = right;
                if (smallest == i) break;
                swap(i, smallest);
                i = smallest;
            }
        }

        private void swap(int a, int b) { int t=data[a]; data[a]=data[b]; data[b]=t; }

        boolean isEmpty() { return size == 0; }
        int     size()    { return size; }

        @Override public String toString() {
            return Arrays.toString(Arrays.copyOf(data, size));
        }
    }

    // ─── Max-Heap (invert comparisons) ────────────────────────
    static class MaxHeap {
        private int[] data; private int size;
        MaxHeap(int cap) { data = new int[cap]; }

        void insert(int val) {
            data[size++] = val;
            int i = size-1;
            while (i > 0) {
                int p = (i-1)/2;
                if (data[p] >= data[i]) break;
                int t=data[p]; data[p]=data[i]; data[i]=t;
                i = p;
            }
        }

        int extractMax() {
            int max = data[0]; data[0] = data[--size];
            int i = 0;
            while (true) {
                int l=2*i+1, r=2*i+2, big=i;
                if (l<size && data[l]>data[big]) big=l;
                if (r<size && data[r]>data[big]) big=r;
                if (big==i) break;
                int t=data[i]; data[i]=data[big]; data[big]=t; i=big;
            }
            return max;
        }

        int peek() { return data[0]; }
        boolean isEmpty() { return size==0; }
    }

    public static void main(String[] args) {

        // EXERCISE 1: MinHeap operations
        MinHeap minHeap = new MinHeap(10);
        for (int v : new int[]{5, 3, 8, 1, 9, 2}) minHeap.insert(v);
        System.out.println("MinHeap: " + minHeap);
        System.out.println("peek: " + minHeap.peek());           // 1
        System.out.println("extractMin: " + minHeap.extractMin()); // 1
        System.out.println("extractMin: " + minHeap.extractMin()); // 2
        System.out.println("After: " + minHeap);

        // EXERCISE 2: MaxHeap operations
        MaxHeap maxHeap = new MaxHeap(10);
        for (int v : new int[]{5, 3, 8, 1, 9, 2}) maxHeap.insert(v);
        System.out.println("MaxHeap peek: " + maxHeap.peek());            // 9
        System.out.println("extractMax: " + maxHeap.extractMax());        // 9
        System.out.println("extractMax: " + maxHeap.extractMax());        // 8

        // EXERCISE 3: Build heap from array — O(n)
        MinHeap built = new MinHeap(10);
        built.heapify(new int[]{9, 5, 1, 3, 8, 2});
        System.out.println("Heapified: " + built);
        System.out.print("Extract all (sorted): ");
        while (!built.isEmpty()) System.out.print(built.extractMin() + " ");
        System.out.println();

        // EXERCISE 4: Heap Sort using MaxHeap — O(n log n)
        int[] arr = {4, 10, 3, 5, 1};
        heapSort(arr);
        System.out.println("Heap sorted: " + Arrays.toString(arr));
        // [1, 3, 4, 5, 10]

        // EXERCISE 5: Java PriorityQueue (min-heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int v : new int[]{5, 1, 3, 2, 4}) pq.offer(v);
        System.out.print("PQ poll order: ");
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println();

        // EXERCISE 6: Kth largest element using min-heap of size k
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println("3rd largest: " + kthLargest(nums, 3)); // 4

        // EXERCISE 7: Kth smallest using max-heap of size k
        int[] nums2 = {7, 10, 4, 3, 20, 15};
        System.out.println("4th smallest: " + kthSmallest(nums2, 4)); // 10

        // EXERCISE 8: Merge K sorted arrays using min-heap
        int[][] arrays = {{1,4,7}, {2,5,8}, {3,6,9}};
        int[] merged = mergeKSorted(arrays);
        System.out.println("Merged K sorted: " + Arrays.toString(merged));

        // EXERCISE 9: Two heaps — running median
        MedianFinder mf = new MedianFinder();
        for (int v : new int[]{1, 2, 3, 4, 5}) {
            mf.addNum(v);
            System.out.println("Added " + v + ", median: " + mf.findMedian());
        }

        // EXERCISE 10: Top K frequent elements
        int[] freq = {1,1,1,2,2,3};
        System.out.println("Top 2 frequent: " + Arrays.toString(topKFrequent(freq, 2)));

        // SUMMARY
        System.out.println("\n=== Heap Complexity ===");
        System.out.println("insert      O(log n)");
        System.out.println("extractMin  O(log n)");
        System.out.println("peek        O(1)");
        System.out.println("heapify     O(n)");
        System.out.println("heap sort   O(n log n)");
    }

    static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n/2-1; i >= 0; i--) siftDown(arr, n, i); // build max-heap
        for (int i = n-1; i > 0; i--) {
            int t=arr[0]; arr[0]=arr[i]; arr[i]=t;
            siftDown(arr, i, 0);
        }
    }
    static void siftDown(int[] arr, int n, int i) {
        while (true) {
            int l=2*i+1, r=2*i+2, big=i;
            if (l<n && arr[l]>arr[big]) big=l;
            if (r<n && arr[r]>arr[big]) big=r;
            if (big==i) break;
            int t=arr[i]; arr[i]=arr[big]; arr[big]=t; i=big;
        }
    }

    static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) { pq.offer(n); if (pq.size()>k) pq.poll(); }
        return pq.peek();
    }

    static int kthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) { pq.offer(n); if (pq.size()>k) pq.poll(); }
        return pq.peek();
    }

    static int[] mergeKSorted(int[][] arrays) {
        // [value, arrayIndex, elementIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int total = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) { pq.offer(new int[]{arrays[i][0],i,0}); total+=arrays[i].length; }
        }
        int[] result = new int[total]; int idx = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); result[idx++] = cur[0];
            if (cur[2]+1 < arrays[cur[1]].length) pq.offer(new int[]{arrays[cur[1]][cur[2]+1], cur[1], cur[2]+1});
        }
        return result;
    }

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);
        PriorityQueue<Map.Entry<Integer,Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (var e : freq.entrySet()) { pq.offer(e); if (pq.size()>k) pq.poll(); }
        return pq.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    static class MedianFinder {
        PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // max-heap lower half
        PriorityQueue<Integer> hi = new PriorityQueue<>();                            // min-heap upper half
        void addNum(int n) {
            lo.offer(n);
            hi.offer(lo.poll());
            if (hi.size() > lo.size()) lo.offer(hi.poll());
        }
        double findMedian() {
            return lo.size() > hi.size() ? lo.peek() : (lo.peek()+hi.peek())/2.0;
        }
    }
}
