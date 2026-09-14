class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If exact target sum is found, return immediately
                if (currentSum == target) {
                    return currentSum;
                }

                // Update closestSum if current sum is closer to target
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }

        return closestSum;
        
    }
}