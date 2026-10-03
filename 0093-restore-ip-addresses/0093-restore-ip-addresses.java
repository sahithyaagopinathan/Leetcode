import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }
    private void backtrack(String s, int index, int dots, StringBuilder current, List<String> result) {
        if (dots == 4) {
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) {
                break;
            }
            String segment = s.substring(index, index + len);
            if ((segment.startsWith("0") && len > 1) || (len == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            int prevLen = current.length();
            current.append(segment).append(".");
            backtrack(s, index + len, dots + 1, current, result);
            current.setLength(prevLen);
        }
    }
}