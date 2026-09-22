import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people:
        // 1. Descending order by height h
        // 2. Ascending order by k-value if heights are equal
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        // Insert each person at the index equal to their k-value
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][]);
    }
}