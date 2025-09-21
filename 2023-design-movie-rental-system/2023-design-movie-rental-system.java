class MovieRentingSystem {
    Map<Integer, Set<Pair<Integer, Integer>>> map;
    Map<Pair<Integer, Integer>, Integer> renting; 
    Set<List<Integer>> rented; 

    public MovieRentingSystem(int n, int[][] entries) {
        renting = new HashMap<>(); 
        map = new HashMap<>(); 
        rented = new TreeSet<>((a, b) -> {
            if (a.get(0).equals(b.get(0)) && a.get(1).equals(b.get(1))){
                return a.get(2) - b.get(2); 
            } else if (a.get(0).equals(b.get(0))){
                return a.get(1) - b.get(1); 
            } else{
                return a.get(0) - b.get(0); 
            }
        }); 
        for (int[] entry : entries){
            renting.put(new Pair(entry[0], entry[1]), entry[2]); 
            if (!map.containsKey(entry[1])){
                map.put(entry[1], new TreeSet<>((a, b) -> {
                    if (a.getKey().equals(b.getKey())){
                        return a.getValue() - b.getValue(); 
                    } else {
                        return a.getKey() - b.getKey(); 
                    }
                }));
            }
            map.get(entry[1]).add(new Pair(entry[2], entry[0])); 
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!map.containsKey(movie) || map.get(movie).size() == 0){
            return res; 
        }
        for (Pair<Integer, Integer> pair : map.get(movie)){
            res.add(pair.getValue()); 
            if (res.size() == 5){
                break; 
            }
        } 
        return res; 
    }
    
    public void rent(int shop, int movie) {
        int price = renting.get(new Pair(shop, movie));
        Pair<Integer, Integer> toFind = new Pair(price, shop);
        List<Integer> toAdd = new ArrayList<>();
        toAdd.add(price); 
        toAdd.add(shop);
        toAdd.add(movie);  
        rented.add(toAdd); 
        map.get(movie).remove(toFind);   
    }
    
    public void drop(int shop, int movie) {
        int price = renting.get(new Pair(shop, movie));
        Pair<Integer, Integer> toAdd = new Pair(price, shop); 
        List<Integer> toRem = new ArrayList<>();
        toRem.add(price); 
        toRem.add(shop);
        toRem.add(movie);
        rented.remove(toRem); 
        map.get(movie).add(toAdd);  
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>(); 
        for (List<Integer> movies : rented){
            List<Integer> toAdd = new ArrayList<>();
            toAdd.add(movies.get(1)); 
            toAdd.add(movies.get(2));  
            res.add(toAdd);
            if (res.size() == 5){
                break; 
            } 
        }
        return res; 
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */