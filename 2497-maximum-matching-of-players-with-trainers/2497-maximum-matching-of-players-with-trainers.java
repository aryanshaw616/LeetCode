class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int ptr = 0;
        for(int i = 0;i<players.length; i++){
           for(int j = ptr;j<trainers.length; j++){
                if(players[i]<=trainers[j])
                {
                    count++;
                    ptr = j+1;
                    break;
                }
           }
        }
        return count;
        
    }
}
