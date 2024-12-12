class Solution {
    public List<String> stringMatching(String[] words) {
        Set set=new HashSet<String>();
        for(int i=0;i<words.length;i++)
        for(int j=0;j<words.length;j++)
        if(words[j].contains(words[i] ) && i!=j)
        set.add(words[i]);
        List<String>list= new ArrayList<>(set);
        return list;
    }
}