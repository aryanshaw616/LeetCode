class Solution {
    //3
    //0 1 2 3 4
    //1 3 1 2 2
    //i     j   -> 4-3+1 = 2
    //  i   j   -> 4-3+1 = 2
    //    i j
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> distinct = new HashSet<>();
        for(int n:nums)
            distinct.add(n);
        int distinctCount = distinct.size();
        HashMap<Integer,Integer> countMap = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int j = -1;

        int res = 0;

        while(j<n){
            
            while(countMap.size() < distinctCount && j+1<n){
                j++;
                int num = nums[j];
                if(!countMap.containsKey(num))
                    countMap.put(num,1);
                else
                    countMap.put(num,countMap.get(num)+1);        
            }

            if(countMap.size() < distinctCount)
                break;
                
            res = res + (n - j);

            int removeNum = nums[i];
            int currentCount = countMap.get(removeNum);
            if(currentCount == 1)
                countMap.remove(removeNum);
            else
                countMap.put(removeNum,currentCount-1);
            
            i++;
        }

        return res;

    }
}