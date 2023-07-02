class Solution {

    public int ncr(int n,int r){

        long res=1;
        for(int i=0;i<r;i++){
            res *= (n-i);
            res /= (i+1);
        }
        return (int) res;
    }
    public List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> li = new ArrayList<List<Integer>>();

        for(int i=0;i<numRows;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<=i;j++){

                l.add(ncr(i,j));

            }
            // System.out.println(l.get(0));
            // break;
            li.add(l);
        }
       
        return li;     
    }
}
