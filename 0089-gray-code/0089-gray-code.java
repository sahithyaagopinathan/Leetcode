import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int totalElements = 1 << n; // 2^n
        
        for (int i = 0; i < totalElements; i++) {
            // Formula to convert binary integer i to its Gray code equivalent: i ^ (i >> 1)
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}