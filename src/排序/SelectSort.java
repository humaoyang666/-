package 排序;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int [] a=new int[]{1,6,8,4,5,3,1,5,6,7};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
    private static void selectSort(int [] arr){
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx=i;
            for (int j=i+1;j<n;j++){
                if(arr[j]<arr[minIdx]){
                    minIdx=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=temp;
        }
    }
}
