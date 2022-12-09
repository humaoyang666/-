package 排序;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] a=new int[]{1,6,8,4,5,3,1,5,6,7};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
    private static void bubbleSort(int [] arr){
         int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j=1;j<n-i;j++){
                 if(arr[j]<arr[j-1]){
                     int temp=arr[j];
                     arr[j]=arr[j-1];
                     arr[j-1]=temp;
                 }
            }
        }
    }
}
