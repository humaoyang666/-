package 排序;

import java.util.Arrays;

public class QuickSort{
    public static void main(String[] args) {
        int []arr=new int[]{2,1,1,3,5,9,7,6};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    private static void quickSort(int []arr,int l,int r){
        if(l>=r){
            return;
        }
        int fundament=arr[l];
        int left=l;
        int right=r;
        while (left<right){
            while (left<right&&arr[right]>=fundament){
                right--;
            }
            arr[left]=arr[right];
            while (left<right&&arr[left]<=fundament){
                left++;
            }
            arr[right]=arr[left];
        }
        System.out.println(Arrays.toString(arr));
        arr[left]=fundament;
        quickSort(arr,l,l-1);
        quickSort(arr,l+1,r);

    }

}
