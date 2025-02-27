public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
//        String s = "ABAB"; int k = 2;
        String s = "AABABBA"; int k = 1;
        int max = characterReplacement(s,k);
        System.out.println(max);
    }

    // AAABABB
    // ^
    //       ^
    private static int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int[] char_count = new int[26];
        int max_frequency = 0;
        int maxLength = 0;
        while(r < s.length()) {
            char_count[s.charAt(r) - 'A']++; // update count of each character
            max_frequency = Math.max(max_frequency, char_count[s.charAt(r) - 'A']); // update max_frequency if the current or existing
            while(r - l - max_frequency + 1 > k) { // Here we are shrinking a window when k is crossing because we are allowed to k replacements
                char_count[s.charAt(l) - 'A']--; // pop out first character which is from left
                l++; // then move pointer ahead
            }
            maxLength = Math.max(maxLength, r - l + 1); // Here calculation the length.
            r++; //  increment the right pointer on every iteration.
        }
        return maxLength;
    }
}
