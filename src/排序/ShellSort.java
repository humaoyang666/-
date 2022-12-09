package 排序;

import java.util.Random;

public class ShellSort implements test{
    public static void main(String[] args) {
        test proxy = (test) new ProxyTest(new ShellSort()).getProxy();
        Random random=new Random();
        int max=100000;
        int [] a=new int[max];
        for (int i = 0; i < max; i++) {
            a[i]= random.nextInt(1000);
        }
        proxy.test(a);
        //System.out.println(Arrays.toString(a));
    }
    private static void shellSort(int [] arr){
        int n= arr.length;
        for(int grap=n>>1;grap>0;grap>>=1){
            for (int i = grap; i < n; i++) {
                int val=arr[i];
                int j=i-grap;
                while (j>=0&&val<arr[j]){
                    arr[j+grap]=arr[j];
                    j-=grap;
                }
                arr[j+grap]=val;
            }

        }

    }

    @Override
    public void test(int []arr) {
        shellSort(arr);
    }
}
