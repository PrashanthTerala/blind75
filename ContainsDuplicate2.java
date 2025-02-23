import java.util.HashSet;

public class ContainsDuplicate2 {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,1};
        boolean anyDuplicate = containsNearbyDuplicate(numbers, 3);
        System.out.println(anyDuplicate);
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
