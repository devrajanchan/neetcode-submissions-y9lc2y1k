class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> res, StringBuilder current, int openN, int closedN, int max) {
        if (current.length() == max * 2) {
            res.add(current.toString());
            return;
        }

        if (openN < max) {
            current.append("(");
            backtrack(res, current, openN + 1, closedN, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        if (closedN < openN) {
            current.append(")");
            backtrack(res, current, openN, closedN + 1, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}