class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<Integer>();
        for(int i =0; i<expression.length(); i++){
            if(expression.charAt(i)=='-' ||
               expression.charAt(i)=='+' ||
               expression.charAt(i)=='*' ){  

                String right = expression.substring(0,i);
                String left = expression.substring(i+1);

                List<Integer> rightres = diffWaysToCompute(right);
                List<Integer> leftres = diffWaysToCompute(left);

                for(Integer val1 : rightres){
                    for(Integer val2 : leftres){
                        int c = 0;
                        switch(expression.charAt(i)){
                            case '+' : c = val1 + val2;
                                break;

                            case '-' : c = val1 - val2;
                                break;
                        
                            case '*': c = val1 * val2;
                                break;
                        }
                        res.add(c);
                    }
                }
               }
        }
        if(res.size() == 0) res.add(Integer.valueOf(expression));
        return res;
    }
}