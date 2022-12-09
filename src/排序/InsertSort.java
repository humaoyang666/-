package 排序;

import java.time.LocalDateTime;
import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int [] a=new int[]{1,6,8,4,5,3,1,5,6,7};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
    private static void insertSort(int [] arr){
        int n= arr.length;
        for (int i = 1; i < n; i++) {
            int val=arr[i];
            int j=i-1;
            while (j>=0&&val<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=val;
        }
    }
}
