package org.example.DataStructures.Arrays;

public class Main {
    public static void main(String[] args){

        int[] a = new int[5];
        int[] b = {1,2,3,4,5};

        int result = binarySearch(b, 5);
        if(result != -1 ){
            System.out.println("Found at index: " + result);
        }else{
            System.out.println("Not found");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int fi = 0, li = arr.length - 1;
        while (fi <= li) {
            int mid = (fi + li) / 2;
            System.out.println("Mid: " + mid);
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                fi = mid + 1;
            }else{
                li = mid - 1;
            }
        }
        return -1;
    }

    public static int linear(int[] arr, int target) {
        int j = - 1;
        for (int i = 1; i < arr.length; i++){
            j = i - 1 ;
            int current = arr[i];
            while(arr[j] > current){
               arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        return -1 ;
    }

}
