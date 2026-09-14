import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

       for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

           // If character was seen and is inside the current window, move the left pointer
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
                                                                             }

            // Store / update the character's latest index
             map.put(currentChar, right);

            // Calculate max window length
            maxLength = Math.max(maxLength, right - left + 1);
                                                                          }
        return maxLength;                                               
    }
                                                                
}
                    