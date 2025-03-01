public class MinimumWindowSubstring {

    public static void main(String[] args) {
        // s = YXZOUZODYXAZV, t=XYZ, output=YXAZ
        //  OUZODYXAZV
        //    ^
        //        ^
        String currentMin = minWindow("OUZODYXAZV", "XYZ");
        System.out.println(currentMin);
    }

    private static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] chars = new int[128];
        for(int i = 0; i < t.length(); i++) {
            chars[t.charAt(i)]++;
        }

        int count = t.length(), start = 0, end = 0, minLength = Integer.MAX_VALUE, startIndex = 0;
        String minString = "";

        while(end < s.length()) {
            if(chars[s.charAt(end)] > 0) {
                count--;
            }
            chars[s.charAt(end)]--;
            end++;
            while(count == 0) {
                if(end - start < minLength) {
                    minLength = Math.min(minLength, end - start);
                    startIndex = start;
                }

                chars[s.charAt(start)]++;
                if(chars[s.charAt(start)] > 0) {
                    count++;
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? minString : s.substring(startIndex, startIndex + minLength);
    }
}
