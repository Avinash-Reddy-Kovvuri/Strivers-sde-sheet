class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   // add your code here
	   
	   Set<Integer> hashset = new HashSet<>();
	   
	   for(int n : arr){
	       hashset.add(n);
	       
	   }
	   
	   int lonlen = 0;
	   
	   for(int i=0;i<N;i++){
	       
	       if(!hashset.contains(arr[i]-1)){
	           
	           int curnum = arr[i];
	           int currlen = 1;
	           
	           while(hashset.contains(curnum+1)){
	               curnum+=1;
	               currlen+=1;
	           }
	           lonlen = Math.max(lonlen,currlen);
	       }
	       
	       
	   }
	   return lonlen;
	}
}
