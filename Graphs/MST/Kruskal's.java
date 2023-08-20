class Dijoin{
    
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> par = new ArrayList<>();
    public Dijoin(int V){
        
        for(int i=0;i<V;i++){
            rank.add(0);
            size.add(1);
            par.add(i);
        }
        
    }
    
    public int finupar(int node){
        
        if(node == par.get(node)) return node;
        
        int lv = finupar(par.get(node));
        par.set(node,lv);
        return par.get(node);
    }
    
    public boolean unionByRank(int u,int v){
        
        int upu = finupar(u);
        int upv = finupar(v);
        
        if(upu==upv) return false;
        
        if(rank.get(upu)>rank.get(upv)){
            par.set(upv,upu);
        }
        else if(rank.get(upu)<rank.get(upv)){
            par.set(upu,upv);
        }
        else{
            
            par.set(upu,upv);
            int rr = rank.get(upu);
            rank.set(upv,rr+1);
        }
        
        return true;
            
        }
        
    public boolean unionBySize(int u,int v){
        
        int upu = finupar(u);
        int upv = finupar(v);
        
        if(upu==upv) return false;
        if(size.get(upu)>size.get(upv)){
            par.set(upv,upu);
            size.set(upu,size.get(upu)+size.get(upv));
        }
        else{
            par.set(upu,upv);
            size.set(upv,size.get(upu)+size.get(upv));
        }
        
        return true;
        
        
    }
        
    
        
    
}

class Sample implements Comparable<Sample>{
    
    int u,v,dis;
    Sample(int u,int v,int dis){
        this.u = u;
        this.v = v;
        this.dis = dis;
    }
    
    public int compareTo(Sample that){
        return this.dis-that.dis;
    }
    
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    // Code Here. 
	    
	    ArrayList<Sample> add = new ArrayList<>();
	    for(int i=0;i<E;i++){
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        add.add(new Sample(u,v,wt));
	    }
	    
	    Collections.sort(add);
	    int kd = 0;
	    
	    Dijoin d = new Dijoin(V);
	    
	    for(int i=0;i<add.size();i++){
	        
	        int au = add.get(i).u;
	        int av = add.get(i).v;
	        int awt = add.get(i).dis;
	        if(d.unionBySize(au,av)){
	            kd+=awt;
	        }
	    }
	    
	    return kd;
	    
	}
}
