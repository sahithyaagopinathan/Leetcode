import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] memo;
    private int n;

    public int specialPerm(int[] nums) {
        n = nums.length;
        // memo[mask][last_idx] stores the number of special permutations
        // mask: bitmask representing the set of used numbers
        // last_idx: index of the last placed number
        memo = new int[1 << n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int totalPermutations = 0;
        // Try placing each number as the first element
        for (int i = 0; i < n; i++) {
            totalPermutations = (totalPermutations + solve(1 << i, i, nums)) % MOD;
        }

        return totalPermutations;
    }

    private int solve(int mask, int lastIdx, int[] nums) {
        // Base case: all numbers have been used
        if (mask == (1 << n) - 1) {
            return 1;
        }

        if (memo[mask][lastIdx] != -1) {
            return memo[mask][lastIdx];
        }

        int count = 0;
        for (int nextIdx = 0; nextIdx < n; nextIdx++) {
            // Check if nextIdx is not yet used in mask
            if ((mask & (1 << nextIdx)) == 0) {
                // Check div condition: nums[lastIdx] % nums[nextIdx] == 0 or vice versa
                if (nums[lastIdx] % nums[nextIdx] == 0 || nums[nextIdx] % nums[lastIdx] == 0) {
                    count = (count + solve(mask | (1 << nextIdx), nextIdx, nums)) % MOD;
                }
            }
        }

        return memo[mask][lastIdx] = count;
    }
}