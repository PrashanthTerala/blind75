import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaoooaa";
        boolean isPermutationExist = checkInclusion(s1, s2);
        System.out.println(isPermutationExist);
    }

    private static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1_arr = new int[26];
        int[] s2_arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1_arr[s1.charAt(i) - 'a']++;
            s2_arr[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1_arr, s2_arr)) return true;

        int i = s1.length();
        while(i < s2.length()) {
            s2_arr[s2.charAt(i)-'a']++;
            s2_arr[s2.charAt(i - s1.length())-'a']--;
            i++;
            if (Arrays.equals(s1_arr, s2_arr)) return true;
        }
        return  false;
    }
}
