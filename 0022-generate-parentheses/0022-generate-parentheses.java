class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int openN, int closeN, int n) {
        // Base case: combination is valid and has max length (2 * n)
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add open parenthesis if we haven't reached n yet
        if (openN < n) {
            current.append('(');
            backtrack(result, current, openN + 1, closeN, n);
            current.deleteCharAt(current.length() - 1);
        }

        // Add close parenthesis if it won't exceed open ones
        if (closeN < openN) {
            current.append(')');
            backtrack(result, current, openN, closeN + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
        
    }
}