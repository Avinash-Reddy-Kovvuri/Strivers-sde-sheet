import java.util.*;
public class Solution {
    public static int team(int []skill, int n){
        // Write your code here.

        return mergeSort(skill, 0, n-1);
    }

    public static int count(int[] arr,int l,int m,int r){

        int c=0;
        int rig=m+1;
        for(int i=l;i<=m;i++){
            while(rig<=r && arr[i]> 2*arr[rig]) rig+=1;
            c += (rig - (m+1));
        }
        return c;
    }

    public static int mergeSort(int[] arr,int l,int r){

        int c=0;
        if(l>=r) return c;

        int m = (l+r)/2;

        c+=mergeSort(arr,l,m);
        c+=mergeSort(arr,m+1,r);
        c+= count(arr,l,m,r);
        merge(arr,l,m,r);

        return c;
    }

    public static void merge(int[] arr,int l,int m,int r){

        int lef=l,rig=m+1;
        ArrayList<Integer> li = new ArrayList<>();

        while(lef<=m && rig<=r){

            if(arr[lef]>arr[rig]){
                li.add(arr[rig]);
                rig+=1;
            }
            else{
                li.add(arr[lef]);
                lef+=1;
            }
        }
        while(lef<=m){
            li.add(arr[lef]);
            lef+=1;
        }
        while(rig<=r){
            li.add(arr[rig]);
            rig+=1;
        }

        for(int i=l;i<=r;i++){
            arr[i] = li.get(i-l);
        }

        return;
    }
}
