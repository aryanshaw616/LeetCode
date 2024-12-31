class Solution {
    private int[] year = new int[366];
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(year,-1);
        return dfs(0,days,costs);
    }

    public int dfs(int date,int[] days,int[] costs){
        if(date>=days.length){
            return 0;
        }
        if(year[date]!=-1){
            return year[date];
        }
        int oneDay = costs[0]+dfs(date+1,days,costs);

        int day = getTheDateFromDays(days,days[date]+7);

        int sevenDay = costs[1]+dfs(day,days,costs);

        day = getTheDateFromDays(days,days[date]+30);

        int thrityDay = costs[2]+dfs(day,days,costs);

        year[date] = Math.min(oneDay,Math.min(sevenDay,thrityDay));

        return year[date];
    }

    public int getTheDateFromDays(int[] days,int target){
        int low=0;
        int high = days.length;
        while(low<high){
            int mid = low+(high-low)/2;
            if(days[mid]>=target) high = mid;
            else low= mid+1;
        }
        return low;
    }
}