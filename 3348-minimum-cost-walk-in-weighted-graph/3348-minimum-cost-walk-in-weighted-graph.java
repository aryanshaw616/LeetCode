class Solution {
    static int[] parent;
    static int[] cost;
   // static int[] rank'
    public static int find(int i){
       if(i==parent[i]){
          return i;
       }
       return parent[i]=find(parent[i]);
    }
    public static void Union(int x,int y){
        parent[find(y)]=find(x);
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent=new int[n];
        cost=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            cost[i]=-1;
        }
        for(int[] e:edges){
            if(find(e[0])!=find(e[1])){
                 cost[find(e[0])]=cost[find(e[0]) ]& cost[find(e[1])];

                Union(e[0],e[1]);
            }
            cost[find(e[0])]=cost[find(e[0])] & e[2];
        }

        int[] res=new int[query.length];
        int i=0;
        for(int[] l:query){
            if(l[0]==l[1]){
                res[i]=0;
            }
            else if(find(l[0])!=find(l[1])){
                res[i]=-1;
            }
            else{
                res[i]=cost[find(l[1])];
            }
            i++;
        }
        return res;
    }
}