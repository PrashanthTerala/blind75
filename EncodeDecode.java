import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {
        List<String> ss = Arrays.asList("neet","code","love","you");
//        System.out.println(encode(ss));
        System.out.println(decode(encode(ss)));
    }

    public static String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        for (int size : sizes) {
            res.append(size).append(',');
        }
        res.append('#');
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static List<String> decode(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            String cur = null;
            while (str.charAt(i) != ',') {
                cur = String.valueOf(str.charAt(i));
                i++;
            }
            assert cur != null;
            sizes.add(Integer.parseInt(cur));
            i++;
        }
        i++;
        for (int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;
    }
}
