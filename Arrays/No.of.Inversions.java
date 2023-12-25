import java.util.ArrayList;

public class Solution {



    public static int numberOfInversions(int []a, int n) {
        // Write your code here.

        return mergeSort(a, 0, n-1);
    }

    public static int merge(int[] arr,int l,int m,int r){

        int lef=l,rig=m+1;
        int c=0;

        ArrayList<Integer> tt = new ArrayList<>();

        while(lef<=m && rig<=r){

            if(arr[lef]<=arr[rig]){

                tt.add(arr[lef]);
                lef+=1;
                
            }
            else{
                c += (m-lef+1);
                tt.add(arr[rig]);
                rig+=1;
            }
        }

        while(lef<=m){
            tt.add(arr[lef]);
            lef+=1;
        }
        while(rig<=r){
            tt.add(arr[rig]);
            rig+=1;
        }

        for(int i=l;i<=r;i++){
            arr[i] = tt.get(i-l);
        }

        return c;
    }
    public static int mergeSort(int[] arr,int l,int r){

        int c=0;

        if(l>=r) return c;

        int m = (r+l)/2;

        c += mergeSort(arr,l,m);
        c += mergeSort(arr, m+1, r);
        c += merge(arr,l,m,r);

        return c;


    }
}
