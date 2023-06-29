class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void swap(int arr[],int i,int j){
        
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(high>low){
        int p = partition(arr,low,high);
        // System.out.println(p);
        // return;
        quickSort(arr,low,p-1);
        quickSort(arr,p+1,high);}
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
    
        int i=low-1,pivo=arr[high];
        for(int j=low;j<high;j++){
            
            if(arr[j]<pivo){
                i+=1;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    } 
}
