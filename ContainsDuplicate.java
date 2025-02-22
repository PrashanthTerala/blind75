import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
    * Input: nums = [1,2,3,1]
    * Output: true
    * Explanation:
    * The element 1 occurs at the indices 0 and 3.
    * */
    public static void main(String[] args) {
        int[] numbers = {1,2,3,1};
        boolean isContainsDuplicate = containsDuplicate(numbers);
        System.out.println(isContainsDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numbersSet = new HashSet<>();
        for (int num : nums) {
            if (!numbersSet.add(num))
                return true;
        }
        return false;
    }
}
