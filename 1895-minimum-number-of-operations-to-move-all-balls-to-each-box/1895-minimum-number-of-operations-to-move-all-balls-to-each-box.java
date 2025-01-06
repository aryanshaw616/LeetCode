class Solution {
    public int[] minOperations(String boxes) {
        
        int n = boxes.length();
        
        int leftCount = 0, rightCount = 0;
        int leftOp    = 0, rightOp    = 0;

        for(int i = 1; i < n; i++) {

            if(boxes.charAt(i) == '1') {
                rightOp += i;
                rightCount++;
            }
        }

        int answer[] = new int[n];
        for(int i = 0; i < n; i++) {

            answer[i] = leftOp + rightOp;

            if(boxes.charAt(i) == '1') 
                leftCount++;

            leftOp += leftCount;
            rightOp -= rightCount;

            if(i+1 < n && boxes.charAt(i+1) == '1') 
                rightCount--;
            
        }

        return answer;
    }   
}