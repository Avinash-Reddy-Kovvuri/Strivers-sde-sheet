import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.

			Comparator<Pair> co = new Comparator<Pair>() {

				public int compare(Pair a,Pair b){

					double one = (double)a.value / (double)a.weight;
					double two = (double)b.value / (double)b.weight;

					if(one>two) return -1;
					return 1;
				}
	
			};

			Arrays.sort(items,co);
			double finwe=0,finval=0;
			for(int i=0;i<n;i++){
				double curwe = (double)items[i].weight;
				double curva = (double)items[i].value;

				if(finwe<w){

					if((finwe+curwe)<=w){
						finwe += (double)curwe;
						finval += (double)curva;
					}
					else{
						double rem = (double)w - finwe;
						finval += (double)((double)curva /(double)curwe) * rem;
						finwe += rem;

					}
				}



			}

			return finval;
			
    }
}
