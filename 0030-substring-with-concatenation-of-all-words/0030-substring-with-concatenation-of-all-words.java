import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wLen = words[0].length(), k = words.length, totalLen = wLen * k, sLen = s.length();
        if (sLen < totalLen) return res;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);

        for (int i = 0; i < wLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int left = i, count = 0;

            for (int right = i; right <= sLen - wLen; right += wLen) {
                String word = s.substring(right, right + wLen);

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wLen;
                    }

                    if (count == k) res.add(left);
                } else {
                    seen.clear();
                    count = 0;
                    left = right + wLen;
                }
            }
        }
        return res;
    }
}