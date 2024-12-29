class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z\\s+]"," ");
        String str [] = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        String ans = "";;
        for(String  s : str){
            if(Arrays.asList(banned).contains(s.toUpperCase()) || Arrays.asList(banned).contains(s.toLowerCase())){
                continue;
            }else{
                map.put(s.toLowerCase(), map.getOrDefault(s.toLowerCase(),0)+1);
            }
        }
        int temp = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(temp < entry.getValue()){
                temp = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}