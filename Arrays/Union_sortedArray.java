class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> li = new ArrayList<>();
        int i=0,j=0;
        while(i<n && j<m){
            if(i!=n-1 && arr1[i]==arr1[i+1]){i+=1;continue;}
            if(j!=m-1 && arr2[j]==arr2[j+1]){j+=1;continue;}
            if(arr1[i]==arr2[j]){li.add(arr1[i]);i+=1;j+=1;}
            else{
                if(arr1[i]>arr2[j]){li.add(arr2[j]);j+=1;}
                else{li.add(arr1[i]);i+=1;}
            }
        }
        while(i<n){
            if(i!=n-1 && arr1[i]==arr1[i+1]){i+=1;continue;}
           
            
                li.add(arr1[i]);
                i+=1;
            
        }
        while(j<m){
             if(j!=m-1 && arr2[j]==arr2[j+1]){j+=1;continue;}
                li.add(arr2[j]);
                j+=1;
            
        }
        return li;
    }
}
