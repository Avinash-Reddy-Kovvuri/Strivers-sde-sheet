import java.util.*;;

class Sample implements Comparable<Sample>{

    int s,l,po;
    Sample(int s,int l,int po){
        this.s=s;
        this.l=l;
        this.po=po;
    }
    public int compareTo(Sample that){

        if(this.l<that.l) return -1;
        else if(this.l>that.l) return 1;
        else{
            if(this.po<that.po) return -1;
            else return 1;
        }

    }
    public String toString(){

        return Integer.toString(s)+" "+Integer.toString(l);
    }

}

public class Solution {
    public static int maximumMeetings(int []start, int []end) {
        // Write your code here.
        ArrayList<Sample> li = new ArrayList<>();
        int n = start.length;
        for(int i=0;i<n;i++){
            li.add(new Sample(start[i],end[i],i));
        }

        Collections.sort(li);
        int e = li.get(0).l;
        int c=1;
        for(int i=1;i<n;i++){
            if(li.get(i).s>e){
                c+=1;
                e = li.get(i).l;
            }

        }

        return c;

    }
}
