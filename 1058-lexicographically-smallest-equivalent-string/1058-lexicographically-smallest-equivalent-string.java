class Solution {
     int[] parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[27];
        int n = s1.length();

        for(int i=0;i<26;i++){
            parent[i] = i;
        }

        for(int i=0;i<n;i++){
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            if(a == b)
                continue;
            union(a,b);
        }

        StringBuilder res = new StringBuilder();

        for(int i=0;i<baseStr.length();i++){
            res.append((char)('a'+find(baseStr.charAt(i)-'a')));
        }

        return res.toString();
    }

    public void union(int a,int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA < parentB)
            parent[parentB] = parentA;
        else
            parent[parentA] = parentB;
    }

    public int find(int a){
        int parentA = parent[a];
        if(parentA == a)
            return a;
        return find(parentA);        
    }
}