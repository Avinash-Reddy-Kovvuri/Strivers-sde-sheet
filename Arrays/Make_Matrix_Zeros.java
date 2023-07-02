class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        // code here
        int l = matrix.length;
        int r = matrix[0].length;
        
        int[][] li = new int[l][r];
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++){


                    li[i][j]=matrix[i][j];
    
                
            }
        }
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++){
          
                if(li[i][j]==0){
                
                int s=0;
                    if(j+1<r){s+=li[i][j+1];matrix[i][j+1]=0;}
                    if(j-1>=0){s+=li[i][j-1];matrix[i][j-1]=0;}
                    if(i+1<l){s+=li[i+1][j];matrix[i+1][j]=0;}
                    if(i-1>=0){s+=li[i-1][j];matrix[i-1][j]=0;}
                
                matrix[i][j] = s;
                }
            
            }
        }
                
        
        
        return;
    }
}
