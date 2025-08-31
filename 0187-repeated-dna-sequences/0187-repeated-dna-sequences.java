class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer>map=new TreeMap<>();
        List<String>list=new ArrayList<>();
        String st="";
        if(s.length()<10)
        return list;
        for(int i=0;i<=s.length()-10;i++)
         {
            st=s.substring(i,i+10);
            map.put(st,map.getOrDefault(st,0)+1);
         }
         for(String f : map.keySet())
         if(map.get(f)>1)
         list.add(f);
         return list;

    }
}