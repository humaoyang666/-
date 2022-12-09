package 递归;

import java.util.Arrays;

/**
 * 八皇后问题
 * @author humaoyang
 */
public class EightEmpresses {
    private static int ans=0;
    public static void main(String[] args) {
        int []board = new int[8];
        setEmpresses(board,0);
        System.out.println(ans);
    }

    /**
     *
     * @param board 皇后的棋盘
     * @param i 第i+1个皇后
     */
    private static void setEmpresses(int []board,int i){
        if(i==8){
            ans++;
            System.out.println(Arrays.toString(board));
            return;
        }
        for (int k=0;k<8;k++){
            if(isSafe(board,i,k)){
                board[i]=k;
                setEmpresses(board,i+1);
            }
        }
    }
    private static  boolean  isSafe(int []board,int i,int j){
        for (int n = 0; n < i; n++) {
            if(board[n] == j || Math.abs(n - i) == Math.abs(board[n] - j)){
                return false;
            }
        }
        return true;
    }
}
