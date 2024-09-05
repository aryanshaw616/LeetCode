class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int target = mean * (n + rolls.length); 
        
        int sumOfRolls = 0;
        for (int i = 0; i < rolls.length; i++){
            sumOfRolls += rolls[i];
        }
        
        int diff = target - sumOfRolls;
        int divisor = diff / n;
        int leftOver = diff % n;
        
        if (divisor == 0 || diff < 0 || n * 6 < target - sumOfRolls){
            return new int[] {};
        }
        
        int[] res = new int[n];
        
        for (int i = 0; i < res.length; i++){
            res[i] = divisor;
			if (leftOver > 0){
				res[i]++;
				leftOver--;
			}
        }
    
        return res;
    }
}