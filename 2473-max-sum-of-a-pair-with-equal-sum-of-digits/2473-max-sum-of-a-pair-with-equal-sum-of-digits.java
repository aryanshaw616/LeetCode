class Solution {
    public int maximumSum(int[] nums) {
        // This variable will hold the answer, initialized to -1 as per the problem statement.
        int maxPairSum = -1;
        // This array will store the maximum number encountered for each digit sum.
        int[] maxNumWithDigitSum = new int[100];
      
        // Iterate through all the numbers in the input array.
        for (int number : nums) {
            int sumOfDigits = 0;
            // Calculate the sum of digits of the current number.
            for (int tempNumber = number; tempNumber > 0; tempNumber /= 10) {
                sumOfDigits += tempNumber % 10;
            }
            // If there's already a number with the same digit sum encountered,
            // check if the two numbers form a larger pair sum.
            if (maxNumWithDigitSum[sumOfDigits] > 0) {
                maxPairSum = Math.max(maxPairSum, maxNumWithDigitSum[sumOfDigits] + number);
            }
            // Update the array with the maximum number for the current digit sum.
            maxNumWithDigitSum[sumOfDigits] = Math.max(maxNumWithDigitSum[sumOfDigits], number);
        }
        // Return the maximum pair sum of numbers with the same digit sum, else -1.
        return maxPairSum;
    }
}