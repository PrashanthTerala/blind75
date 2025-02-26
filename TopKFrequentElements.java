import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements top = new TopKFrequentElements();
        int[] numbers = {7,7,9,9,1,3,3};
        int frequency  = 3;
        int[] elements = top.topKFrequent(numbers, frequency);
        System.out.println(Arrays.toString(elements));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            queue.offer(new int[]{entry.getValue(), entry.getKey()});
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(queue.poll())[1];
        }
        return result;
    }
}
