class Solution {
    public int evalRPN(String[] t) {
        Stack<Integer> s = new Stack<>();
        for (String x : t) {
            if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
                int b = s.pop(), a = s.pop();
                if (x.equals("+")) s.push(a + b);
                else if (x.equals("-")) s.push(a - b);
                else if (x.equals("*")) s.push(a * b);
                else s.push(a / b);
            } else s.push(Integer.parseInt(x));
        }
        return s.pop();
    }
}