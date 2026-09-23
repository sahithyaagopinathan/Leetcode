import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n];
        
        // Compute factorials and populate the list of available numbers [1, 2, ..., n]
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }
        numbers.add(n);
        
        // Convert k to 0-based index
        k--;
        
        StringBuilder result = new StringBuilder();
        
        // Determine digits one by one
        for (int i = n; i >= 1; i--) {
            int fact = factorial[i - 1]; // Number of permutations per block
            int index = k / fact;        // Find which block k falls into
            
            result.append(numbers.get(index));
            numbers.remove(index);       // Remove chosen digit from available list
            
            k %= fact;                   // Update k for the remaining digits
        }
        
        return result.toString();
    }
}