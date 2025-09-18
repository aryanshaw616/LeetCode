class TaskManager {
    PriorityQueue<List<Integer>> pq;
    HashMap<Integer, Integer> map, updatedTask;
    HashSet<Integer> expireTask;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (b.get(1).equals(a.get(1)))
                return b.get(0) - a.get(0);
            return b.get(1) - a.get(1);
        });

        map = new HashMap<>();
        // taskId ,userId

        updatedTask = new HashMap<>();
        expireTask = new HashSet<>();

        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {

        if (expireTask.contains(taskId)) {
            edit(taskId, priority);
            expireTask.remove(taskId);
            map.put(taskId, userId);
        } else {
            pq.add(Arrays.asList(new Integer[] { taskId, priority }));
            map.put(taskId, userId);
        }
        // System.out.println(pq);
    }

    public void edit(int taskId, int newPriority) {
        pq.add(Arrays.asList(new Integer[] { taskId, newPriority }));
        updatedTask.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        expireTask.add(taskId);
        // remove taskId
        // map.remove(taskId);

    }

    public int execTop() {
        // System.out.println(pq);
        while (!pq.isEmpty()) {
            List<Integer> temp = pq.poll();
            int taskId = temp.get(0);
            // System.out.println(temp);
            if (!expireTask.contains(taskId)
                    && (!updatedTask.containsKey(taskId) || updatedTask.get(taskId).equals(temp.get(1)))) {
                        //taskId has to be removed from the system
                if (updatedTask.containsKey(taskId)) {
                    //if taskId is present in updated list remove that also
                    updatedTask.remove(taskId);
                    rmv(taskId);
                }
                return map.get(taskId);
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */


/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */


//  [[[[21,51,329],[41,70,576],[43,47,765],[35,49,316],[9,27,316],[37,76,156],[7,26,383],[41,52,458],[34,99,351],[33,57,657],[5,83,545],[46,54,252],[41,65,360],[19,36,937],[46,75,159],[31,38,989],[16,1,801],[16,62,306],[26,41,692],[14,79,233],[35,48,284],[44,30,927],[0,13,886],[31,28,664],[46,24,847],[50,16,295],[23,74,479],[46,71,316],[44,60,827],[40,66,594],[26,100,86],[35,43,989],[36,88,328],[43,55,333],[25,0,431],[9,8,83],[7,96,68],[7,12,137],[44,21,826],[42,20,940],[30,84,196],[8,11,819],[31,95,331],[43,82,508],[8,14,285],[11,72,710],[1,18,453],[22,59,174],[33,23,123],[24,22,18],[50,68,882],[17,98,701],[17,58,115],[6,97,379],[6,67,12],[31,2,249],[50,53,76],[0,93,562],[43,78,914],[2,17,390],[24,35,354],[12,15,364],[33,42,672],[44,81,489],[4,45,300],[16,37,435],[37,85,350],[14,31,783],[13,50,726],[43,80,597],[40,89,151],[17,63,215],[23,86,404],[38,69,660],[28,87,17],[15,32,656],[21,34,447],[42,64,719],[4,40,585],[50,4,837],[29,6,437],[2,25,856],[26,5,153]]]
 
//  ,[35,304],[1,9,473],[100,928],[]]