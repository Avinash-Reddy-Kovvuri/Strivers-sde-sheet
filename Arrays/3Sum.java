class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ll = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

            if(i==0 ||(i>0 && nums[i]!=nums[i-1])){

            int lo=i+1,hi=nums.length-1,sum=0-nums[i];


            while(hi>lo){



                if(nums[lo]+nums[hi]==sum){

                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[lo]);
                    li.add(nums[hi]);


                    ll.add(li);
                    while(hi>lo && nums[lo]==nums[lo+1]) lo+=1;
                    while(hi>lo && nums[hi]==nums[hi-1]) hi-=1;

                    lo+=1;
                    hi-=1;

                }
                else if(nums[lo]+nums[hi]<sum) lo+=1;
                else if(nums[lo]+nums[hi]>sum) hi-=1;

           }

        }
        }

        return ll;
        
    }
}
