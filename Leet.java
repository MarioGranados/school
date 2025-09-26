import java.util.HashMap;

public class Leet {

    public static void main(String[] args) {

        int testCase[] = { 2, 5, 5, 11 };
        int[] num = twoSum(testCase, 16);

        System.out.println(num[0] + " " + num[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if (map.containsKey(difference)) {
                return new int[] { map.get(difference), i };
            }
            map.put(nums[i], i);
        }
        return null;

    }

}
