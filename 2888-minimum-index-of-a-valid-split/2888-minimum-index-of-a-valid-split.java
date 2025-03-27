
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        int candidate = -1, count = 0;
        for(int num : nums){
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        int totalOccurrences = 0;
        for (int num : nums){
            if(num == candidate){
                totalOccurrences++;
            }
        } 
        int leftCount = 0;
        for (int i = 0; i < n -1; i++){
            if (nums.get(i) == candidate){
                leftCount++;
            }
            int leftSize = i + 1;
            int rightSize = n - leftSize;
            int rightCount = totalOccurrences - leftCount;
            if(leftCount * 2 > leftSize && rightCount * 2 > rightSize){
                return i;
            }
        }
        return -1;
    }
}