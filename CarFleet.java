import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public static void main(String[] args) {
       int[] position = {10,8,0,5,3}, speed = {2,4,1,1,3}; int target = 12;
        carFleet(target, position, speed);
    }
    // -- After sorting based on car positions --
    //  time to reach- (t-p)/s     (t-p)/s
    // -destination:   10-1/3=3    10-4/2=3     | Both are reaching at same time. still consider as fleet as per problem description.
    //  speed      :   2(speed)    3(speed)
    //  position   :   1(car)->    4(car)->     |10 <-- target
    //             :   _________________________|
    private static int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1) return 1;
        Stack<Double> stack = new Stack<>();
        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            int j = 0;
            while( j < 1) {
                cars[i][j] = position[i];
                cars[i][++j] = speed[i];
            }
        }
        // Sort on positions
        Arrays.sort(cars, (o1, o2) -> o2[0]-o1[0]);
//        System.out.println(Arrays.toString(cars[0]));
        for(int i = 0; i < cars.length; i++) { // traverse from nearest car to destination and add currentSpeeds to stack if currentSpeed to greater than top element in the stack.
            double currentSpeed = (double) (target - cars[i][0]) /cars[i][1];
            if (stack.isEmpty() || currentSpeed > stack.peek()) {
                stack.push(currentSpeed);
            }
        }
        System.out.println(stack.size());
        return stack.size();
    }
}
