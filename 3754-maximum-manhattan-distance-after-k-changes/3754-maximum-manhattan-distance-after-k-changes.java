class Solution {
    public int maxDistance(String str, int k) {
        int max=0;
        List<List<Character>> lst= new ArrayList<>();
        lst.add(Arrays.asList('N', 'E'));
        lst.add(Arrays.asList('N','W'));
        lst.add(Arrays.asList('S','E'));
        lst.add(Arrays.asList('S','W'));
        for(int i=0;i<lst.size();i++){
            max=Math.max(max,dir(lst.get(i),str,k));

        }return max;


        
    }public static int dir(List<Character> lst,String str,int k){
            int sum=0;
            int changes=0;
            int max=0;
            char i=lst.get(1);
            char j=lst.get(0);
            for(char ch:str.toCharArray()){
                if(ch==i || ch==j) {
                    sum++;
                }else if(changes<k) {
                    sum++;
                    changes++;

                }else{
                    sum--;

                }max=Math.max(max,sum);
            }return max;

        }

}