public class BinarySearch {

    public static void main(String[] args) {
                             //0   1   2   3   4   5   6   7  8
        int[] sortedNumbers = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int found = binarySearch(sortedNumbers, 90);
//        int found = binarySearch(sortedNumbers, 0, sortedNumbers.length, 40);
        System.out.println(found);
    }

    /* Regular approach */
    public static int binarySearch(int[] sortedNumbers, int target) {
        int head = 0, tail = sortedNumbers.length;
        while(head < tail ) {
            int mid = head + (tail - head)/2;
            if(sortedNumbers[mid] == target)
                return mid;
            else if(sortedNumbers[mid] < target)
                head = mid + 1;
            else if(sortedNumbers[mid] > target)
                tail = mid;
        }
        return -1;
    }

    /* Recursive approach */
    public static int binarySearch(int[] sortedNumbers, int head, int tail, int target) {
        int mid = head + (tail - head) / 2;
        if(sortedNumbers[mid] == target)
            return mid;
        else if (sortedNumbers[mid] < target)
            return binarySearch(sortedNumbers, mid+1, tail, target);
        else
            return binarySearch(sortedNumbers, head, mid, target);

    }
}
