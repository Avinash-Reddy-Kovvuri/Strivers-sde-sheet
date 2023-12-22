class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int n=matrix.length,m=matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int top=0,left=0,right=m-1,bottom=n-1;

        while(bottom>=top && right>=left){

        for(int i=left;i<=right;i++){

            res.add(matrix[top][i]);

        }
        top+=1;

        for(int i=top;i<=bottom;i++){
            res.add(matrix[i][right]);
        }
        right-=1;

        if(bottom>=top){
        for(int i=right;i>=left;i--){
            res.add(matrix[bottom][i]);
        }


        bottom-=1;}

        if(right>=left){

        for(int i=bottom;i>=top;i--){
            res.add(matrix[i][left]);
        }

        left+=1;
        }

        }

        return res;
        
    }
}
