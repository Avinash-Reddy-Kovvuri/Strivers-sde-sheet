class Solution {
    public void swap(int[] nums, int a,int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    public void sortColors(int[] nums) {

        int s=0,m=0,l=nums.length-1;
        while(l>=m){
            if(nums[m]==0){
                swap(nums,s,m);
                s+=1;
                m+=1;
            }
            else if(nums[m]==2){
                swap(nums,m,l);
                l-=1;
            }
            else{ m+=1;}
        }
        
    }
}
