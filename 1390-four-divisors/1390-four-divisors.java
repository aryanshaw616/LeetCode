class Solution {
    public int countDivisors(int num){
        int count = 0;
        int sum = 0;
        for(int i = 1;i*i<=num;i++){
            if(num%i == 0){
                if(i!=num/i){
                count+=2;
                sum+=i + num/i;
                }else{
                    count++;
                    sum+=i;
                }
            }
        }

        if(count == 4){
            return sum;
        }
        return 0;
    }

    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for(int num:nums){
            result+=countDivisors(num);
        }
        return result;
    }
}