
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        Comparator<int[]> com = new Comparator<int[]>(){

            public int compare(int[] a,int[] b){

                if(a[0]>b[0]) return 1;

                

                return -1;
            }
        };

        Arrays.sort(items1,com);
        Arrays.sort(items2,com);

        List<List<Integer>> li = new ArrayList<>();

        int siz1 = items1.length,siz2=items2.length,i=0,j=0;

        while(i<siz1 && j<siz2){

            List<Integer> ll = new ArrayList<>();

            if(items1[i][0]==items2[j][0]){

                ll.add(items1[i][0]);
                ll.add(items1[i][1]+items2[j][1]);
                i+=1;
                j+=1;

            }
            else if(items1[i][0]>items2[j][0]){

                ll.add(items2[j][0]);
                ll.add(items2[j][1]);
                j+=1;

            }
            else{

                ll.add(items1[i][0]);
                ll.add(items1[i][1]);
                i+=1;

            }

            li.add(ll);

        }
        while(i<siz1){

            List<Integer> ll = new ArrayList<>();

            ll.add(items1[i][0]);
            ll.add(items1[i][1]);
            i+=1;
            li.add(ll);

        }
        while(j<siz2){
            List<Integer> ll = new ArrayList<>();
            ll.add(items2[j][0]);
            ll.add(items2[j][1]);
                j+=1;
                li.add(ll);
        } 

        return li;
        
    }
}
