package 稀疏数组;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 胡茂洋
 */
public class SparseArray {
    public static int [][] arrayToSparse(int [][] array){
        List<int []> sparse=new ArrayList<>();
        int count=0;
        int m= array.length;
        int n= m>0? array[0].length:0;
        sparse.add(new int[]{m,n,count});
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(array[i][j]!=0){
                    sparse.get(0)[2]++;
                    sparse.add(new int[]{i,j,array[i][j]});
                }
            }
        }
        return sparse.toArray(new int[sparse.size()][3]);
    }
    public static int [][] sparseToArray(int [][] sparse){
        int m=sparse[0][0];
        int n=sparse[0][1];
        int [][]array=new int[m][n];
        for (int i = 1; i <= sparse[0][2]; i++) {
            array[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        return  array;
    }
    public static void saveToFile(int [][] sparse){
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream oos=null;
        try {
            fileOutputStream = new FileOutputStream("sparse.data");
            oos= new ObjectOutputStream(fileOutputStream);
            oos.writeObject(sparse);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(oos!=null){
                    oos.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static int [][] loadSparse(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        int [][] sparse=null;
        try {
            fis=new FileInputStream("sparse.data");
            ois=new ObjectInputStream(fis);
            sparse= (int[][]) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ois!=null){
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sparse;
    }
}
class Main{
    public static void main(String[] args) {
        int [][] array=new int[][]{{0,1,0},{0,0,2},{0,0,3}};
        int[][] sparse = SparseArray.arrayToSparse(array);
        System.out.println(Arrays.deepToString(sparse));
        System.out.println(Arrays.deepToString(SparseArray.sparseToArray(sparse)));
        SparseArray.saveToFile(sparse);
        int[][] sparse1 = SparseArray.loadSparse();
        System.out.println(Arrays.deepToString(sparse1));
    }
}
