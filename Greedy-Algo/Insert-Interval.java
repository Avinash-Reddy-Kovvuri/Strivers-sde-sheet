import java.util.*;

class Sample implements Comparable<Sample>{

    int start,end;
    Sample(int start,int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(Sample o){

        if(this.start>o.start) return 1;
        else if(this.start<o.start) return -1;
        else return this.end - o.end;
    }
}


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<Sample> li = new ArrayList<>();
        int n=intervals.length;
        for(int i=0;i<n;i++){
            li.add(new Sample(intervals[i][0],intervals[i][1]));
        }
        li.add(new Sample(newInterval[0],newInterval[1]));
        Collections.sort(li);


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int open = -1;
        int close = -1;
        for(int i=0;i<=n;i++){
            int curopen = li.get(i).start;
            int curclose = li.get(i).end;
            if(open==-1 && close==-1){
                open = curopen;
                close = curclose;
            }
            else if(close>=curopen){
                close = Math.max(close,curclose);
            }
            else{
                ArrayList<Integer> pres = new ArrayList<>();
                System.out.println(open+" , "+close);
                pres.add(open);
                pres.add(close);
                res.add(pres);
                open = curopen;
                close = curclose;
            }

        }
        ArrayList<Integer> p = new ArrayList<>();
                
                p.add(open);
                p.add(close);
                res.add(p);
        int[][] a = new int[res.size()][2];

        for(int i=0;i<res.size();i++){
            int[] b = new int[2];
            b[0] = res.get(i).get(0);
            b[1] = res.get(i).get(1);
            a[i] = b;
        }
        return a;
        
    }
}
