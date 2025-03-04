import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] bananasPiles = {805306368,805306368,805306368};
        int hours = 1000000000;
        int minimumTime = minEatingSpeed(bananasPiles, hours);
        System.out.println(minimumTime);

    }

    //     3,6,7,11
    // [1 2 3 4 5 6 7 8 9 10 11]
    //          ^
    private static int minEatingSpeed(int[] piles, int h) {
        int head = 1, tail = Arrays.stream(piles).max().orElse(1);
        int min = Integer.MAX_VALUE;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            int eatingSpeed = 0;
            for (int pile : piles) {
                eatingSpeed += Math.ceil(pile*1.0/mid);
            }
            if (eatingSpeed > h)
                head = mid + 1;
            else {
                min = Math.min(min, mid);
                tail = mid - 1;
            }
        }
        return min;
    }
}
