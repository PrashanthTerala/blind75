import java.util.HashSet;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] numbers = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}; // 9
        int longest = longestConsecutive(numbers);
        System.out.println(longest);
    }

    private static int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            hs.add(num);
        }
        for (int num : nums) {
            if (!hs.contains(num - 1)) {
                int counter = 1;
                while (hs.contains(num + counter)) {
                    counter++;
                }
                max = Math.max(max, counter);
            }
        }
        return max;
    }
}
