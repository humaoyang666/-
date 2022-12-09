package 排序;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr=new int[]{1,7,8,6,4,5,3};
        int []temp=new int[arr.length];
        mergeSort(0,arr.length-1,arr,temp);
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSort(int l,int r,int []arr,int [] temp){
        if(l<r){
            int m=(l+r)>>1;
            mergeSort(l,m,arr,temp);
            mergeSort(m+1,r,arr,temp);
            merge(l,m,r,arr,temp);
        }
    }
    private static void merge(int l,int m,int r,int []arr,int []temp){
        int left=l;
        int mid=m+1;
        int i=0;
        while (left<=m&&mid<=r){
            temp[i++]= arr[left]<arr[mid] ? arr[left++]:arr[mid++];
        }
        while (left<=m){
            temp[i++]=arr[left++];
        }
        while (mid<=r){
            temp[i++]=arr[mid++];
        }
        i=0;
        while (l<=r){
            arr[l++]=temp[i++];
        }
    }
}
