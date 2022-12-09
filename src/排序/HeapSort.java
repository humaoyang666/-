package 排序;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int [] arr=new int[]{1,7,3,5,6,12,-7,9,0,4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int []arr){
        buildLargeHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            int temp=arr[0];
            arr[0]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
            adjustHeap(arr,0,arr.length-i-1);
        }

    }
    //构建大顶堆
    private static void buildLargeHeap(int []arr){
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
    }
    private static void adjustHeap(int []arr,int l,int r){
        int temp=arr[l];
        while (l<r){
            int child=2*l+1;
            if(child+1<r&&arr[child]<arr[child+1]){
                child++;
            }
            if(child<r&&temp<arr[child]){
                arr[l]=arr[child];
                l=child;
            }else {
                break;
            }
        }
        arr[l]=temp;
    }

}
