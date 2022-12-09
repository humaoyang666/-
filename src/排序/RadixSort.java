package 排序;

import java.util.Arrays;

/**
 * @author 胡茂洋
 * 基数排序（桶排序）
 * todo 目前不支持负数
 */
public class RadixSort {
    public static void main(String[] args) {
        int [] arr=new int[]{8,6,12,36,2,1,98,45,109};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void radixSort(int []arr){
        int n=arr.length;
        int [][]bucket=new int[10][n+1];
        int fundamentNum=10;
        int divisor=1;
        while (true){
            for (int i = 0; i < n; i++) {
                int idx=arr[i]/divisor%fundamentNum;
                bucket[idx][++bucket[idx][0]]=arr[i];
            }
            if(bucket[0][0]==n){
                break;
            }

            for (int idx=0, i = 0; i < bucket.length; i++) {
                for (int j = 0; j < bucket[i][0]; j++) {
                    arr[idx++]=bucket[i][j+1];
                }
            }
            //重置桶子
            for (int i = 0; i < bucket.length; i++) {
                bucket[i][0]=0;
            }
            divisor*=10;
        }
        arr=bucket[0];
    }
}
