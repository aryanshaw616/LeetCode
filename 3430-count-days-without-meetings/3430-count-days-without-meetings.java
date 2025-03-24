class Solution {
    public int countDays(int days, int[][] meetings) {
        Stack<int[]> stk = new Stack<>();
        int meetingDays = 0;

        Arrays.sort(meetings,(a,b)->a[0]-b[0]);

        for(int i=0;i<meetings.length;i++){
            if(stk.isEmpty()){
                stk.push(meetings[i]);
            } else {
                int[] peek = stk.peek();

                if(meetings[i][0]<=peek[1]){
                    peek[1] = Math.max(peek[1], meetings[i][1]);
                } else {
                    stk.pop();
                    meetingDays += (peek[1]-peek[0]+1);

                    stk.push(meetings[i]);

                }
            }
        }

        if(!stk.isEmpty()){
            int[] peek = stk.pop();
            meetingDays += (peek[1]-peek[0]+1);
        }

        int count = days - meetingDays;


        return count;


    }
}