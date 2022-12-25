package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int []weight=new int[]{1,4,3};
        int []value=new int[]{1500,3000,2000};
        int w=4;
        int []bp=new int[w+1];

        int n=weight.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w-weight[i]; j++) {
                bp[j]=Math.max(bp[j],bp[j+weight[i]]+value[i]);
            }
        }
        System.out.println(Arrays.toString(bp));
    }
}
