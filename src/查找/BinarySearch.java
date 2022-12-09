package 查找;

public class BinarySearch {
    public static void main(String[] args) {
        int []arr={1,3,5,7,9,11};
        System.out.println(binarySearch(arr,-1));
    }
    private static int binarySearch(int []arr,int val){
        int l=0;
        int r=arr.length-1;

        while (l<=r){
            int m=(l+r)>>1;
            if(arr[m]==val){
                return m;
            }else if(arr[m]>val){
                r=m-1;
            }else {
                l=m+1;
            }
        }
        return -1;
    }
}
