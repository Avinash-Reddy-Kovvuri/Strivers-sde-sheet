class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         int[] li = new int[r-l+1];
        //  ArrayList<Integer> li = new ArrayList<>();
         int lef=l,rig=m+1,t=0;
         while(lef<=m && rig<=r){
             if(arr[lef]>=arr[rig]){
                 li[t++] = arr[rig];
                 rig+=1;
             }
             else{
                 li[t++] = arr[lef];
                 lef+=1;
             }
         }
         while(lef<=m){
             li[t++] = arr[lef];
             lef+=1;
         }
         while(rig<=r){
             li[t++] = arr[rig];
             rig+=1;
         }
         for(int i=l;i<=r;i++){
             arr[i] = li[i-l];
         }
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l>=r) return;
        int mid = l+((r-l)/2);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}
