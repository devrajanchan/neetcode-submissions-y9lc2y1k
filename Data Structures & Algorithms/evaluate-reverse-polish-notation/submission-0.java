class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String t:tokens)
        {
            if(!s.isEmpty() && "+-*/".contains(t))
            {
                switch(t){
                    case "+":
                        int b = s.pop();
                        int a = s.pop();
                        s.push(a+b);
                        break;
                    case "-":
                        int d = s.pop();
                        int c = s.pop();
                        s.push(c-d);
                        break;
                    case "*":
                        int f = s.pop();
                        int e = s.pop();
                        s.push(e*f);
                        break;
                    case "/":
                        int h = s.pop();
                        int g = s.pop();
                        s.push(g/h);
                        break;
                }
            }
            else s.push(Integer.parseInt(t));
        }
        return s.pop();
    }
}
