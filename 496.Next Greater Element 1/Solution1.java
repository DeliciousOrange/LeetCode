import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length];
        for (int v = 0; v < results.length; v++) {
            results[v] = -1;
        }
        boolean[] flags = new boolean[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            stack.push(nums2[i]);
        }
        while (stack.size() != 0) {
            int data = stack.pop();
            for (int k = 0; k < nums1.length; k++) {
                if (flags[k]) {
                    continue;
                } else {
                    if (data > nums1[k]) {
                        results[k] = data;
                    }
                    if (data == nums1[k]) {
                        flags[k] = true;
                    }
                }
//                if (!flags[k] && data > nums1[k]) {
//                    results[k] = data;
//                }
//                if (data == nums1[k]) {
//                    flags[k] = true;
//                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] results = nextGreaterElement(nums1, nums2);
        for (int result : results) {
            System.out.println(result);
        }
    }
}
