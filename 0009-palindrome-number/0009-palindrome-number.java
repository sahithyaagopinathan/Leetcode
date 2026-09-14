class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers cannot be palindromes.
        // Also, if the last digit is 0, the first digit must also be 0 (only true for 0 itself).
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // When length is odd, discard the middle digit via reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;    
    }
}