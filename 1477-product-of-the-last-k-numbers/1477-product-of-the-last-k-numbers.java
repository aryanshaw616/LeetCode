class ProductOfNumbers {
    ArrayList<Integer> list;

    public ProductOfNumbers() {
        list= new ArrayList<>();
    }
    
 public void add(int num) {
         list.add(num); 
    }
    
    public int getProduct(int k) {
        int pro=1;
       for(int i=list.size()-k;i<list.size();i++){
          pro=list.get(i)*pro;
       } 
       return pro; 
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */