class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        int ans[] = new int[2];
        Arrays.fill(ans, -1);
        
        // Finding prime numbers
        for(int i=left;i<=right;i++) {
            if(isPrime(i)) {
                list.add(i);
            }
        }

        // finding 2 prime numbers
        if(list.size() < 2) {
            return ans;
        }
        int diff = Integer.MAX_VALUE;

        for(int i=0;i<list.size()-1;i++) {
            if((list.get(i+1) - list.get(i)) < diff) {
                ans[0] = list.get(i);
                ans[1] = list.get(i+1);
                diff = (list.get(i+1) - list.get(i));
            }
        }

        // System.out.print(list);
        return ans;
    }

    public static boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }

        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}