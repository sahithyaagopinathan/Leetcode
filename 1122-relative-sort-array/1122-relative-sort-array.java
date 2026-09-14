class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        // Step 1: Count occurrences of each number in arr1
        for (int num : arr1) {
            count[num]++;
        }

        int index = 0;

        // Step 2: Fill result array with elements of arr2 in order
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }

        // Step 3: Fill remaining elements not in arr2 in ascending order
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }

        return arr1;
        
    }
}