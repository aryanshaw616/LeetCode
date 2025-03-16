class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0,high = (long)1e14;
        while(low<high){
            long mid = low+(high-low)/2,rcars = 0;
            for(int r:ranks)
                rcars+=Math.sqrt(mid/r);
                if(rcars<cars) low = mid+1;
                else high = mid;
        }
        return low;
    }
}