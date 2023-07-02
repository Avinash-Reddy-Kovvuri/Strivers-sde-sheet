class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int c1=0,c2=0,ele1=-10000,ele2=-10000;

        for(int i=0;i<nums.length;i++){

            int ele = nums[i];
            if(c1==0 && ele!=ele2){
                ele1 = ele;
                c1+=1;
            }
            else if(c2==0 && ele!=ele1){
                ele2 = ele;
                c2+=1;
            }
            else if(ele==ele1) c1+=1;
            else if(ele==ele2) c2+=1;
            else{
                c1-=1;
                c2-=1;
            }
        }
        int cc1=0,cc2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1) cc1+=1;
            else if(nums[i]==ele2) cc2+=1;
        }
        List<Integer> li = new ArrayList<Integer>();
        if(cc1>(nums.length/3)) li.add(ele1);
        if(cc2>(nums.length/3)) li.add(ele2);
        return li;
        
    }
}
