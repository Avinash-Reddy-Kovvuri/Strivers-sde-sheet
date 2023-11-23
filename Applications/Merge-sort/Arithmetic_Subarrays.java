class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> li = new ArrayList<>();
        for(int i=0;i<l.length;i++){
            boolean tt = check(nums,l[i],r[i]);
            li.add(tt);
        }

        return li;
        
    }

    public boolean check(int[] nums,int lef,int rig){

        int len = rig-lef+1;
        int[] arr = new int[len];
        for(int j=0;j<len;j++){
            arr[j] = nums[lef+j];
        }

        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        
        return true;
        

    }
}
