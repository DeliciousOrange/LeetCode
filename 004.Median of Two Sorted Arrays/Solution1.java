public class MedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 该题目不考虑数组为null的情况，edge case仅考虑length等于0的情况
        // 下面的代码多重嵌套if...else，太过丑陋，本题的一个技巧点就是，我们
        // 要保证始终对长度最小的数组进行二分查找，解决方法有两个，分别如下：

//        一、原始方法
//        if (nums1 == null || nums1.length == 0) {
//            if (nums2.length % 2 == 0) {
//                return (double) (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2;
//            } else {
//                return nums2[nums2.length / 2];
//            }
//        } else if (nums2 == null || nums2.length == 0) {
//            if (nums1.length % 2 == 0) {
//                return (double) (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2;
//            } else {
//                return nums1[nums1.length / 2];
//            }
//        }

//        二、改进方法1
//        int m = nums1.length;
//        int n = nums2.length;
//        if (m > n) { // to ensure m<=n
//            int[] temp = nums1; nums1 = nums2; nums2 = temp;
//            int tmp = m; m = n; n = tmp;
//        }


//        三、改进方法2，此方法最简洁优雅
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

//        int[] nums3 = nums1.length <= nums2.length ? nums1 : nums2;
//        int[] nums4 = nums3 == nums1 ? nums2 : nums1;


        // 这里其实不必定义一个totalLen的概念，我们只需要定义两个变量分别持有nums1和nums2的length即可，
        // 当在while循环中需要用到两个数组的长度和时，尽管计算就行了，加减乘除基本不影响效率。之所以这样做
        // 是为了代码的优雅性，尽量不多定义概念或者自造概念。我们可以认为定义两个变量持有nums1和nums2的长度
        // 比定义一个totalLen的概念要优雅，因为数组的长度是一个更加通用的概念
//        int totalLen = nums1.length + nums2.length;

        int len1 = nums1.length;
        int len2 = nums2.length;

        int low = 0;
        int high = len1;

        // 不要像下面这样提前定义变量，最好把他们的定义放在while循环中，这样做的目的也是为了代码的整洁优雅
        // 牺牲了小小的微效率，忽略了在while循环中给变量分配内存的时间开销
//        int maxLeft1;
//        int minRight1;
//        int maxLeft2;
//        int minRight2;
        while (low <= high) {
            // 不要像下面这样写代码，下面的mid纯属多余
//            int mid = (start + end) / 2;
//            int partition1 = mid;
            int partition1 = (low + high) / 2;
            int partition2 = (len1 + len2 + 1) / 2 - partition1;

            // 下面这段if...else...逻辑太过丑陋，而且会忽略edge case，当nums1=[],nums2=[1]时报数组越界异常
//            if (partition1 == 0) {
//                maxLeft1 = Integer.MIN_VALUE;
//                minRight1 = nums3[partition1];
//            } else if (partition1 == nums3.length) {
//                maxLeft1 = nums3[partition1 - 1];
//                minRight1 = Integer.MAX_VALUE;
//            } else {
//                maxLeft1 = nums3[partition1 - 1];
//                minRight1 = nums3[partition1];
//            }
//            if (partition2 == 0) {
//                maxLeft2 = Integer.MIN_VALUE;
//                minRight2 = nums4[partition2];
//            } else if (partition2 == nums4.length) {
//                maxLeft2 = nums4[partition2 - 1];
//                minRight2 = Integer.MAX_VALUE;
//            } else {
//                maxLeft2 = nums4[partition2 - 1];
//                minRight2 = nums4[partition2];
//            }

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == len2) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2
                    && maxLeft2 <= minRight1) {
                if ((len1 + len2) % 2 == 0) {
                    return (double) (Math.max(maxLeft1, maxLeft2) + Math
                            .min(minRight1, minRight2)) / 2;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            } else if (maxLeft2 > minRight1) {
                low = partition1 + 1;
            }
        }
        // 下面写成return 0.0 不如写成抛出异常优雅
//        return 0.0;

        // 如果程序运行到这里，说明输入数组不是有序的，故抛出异常
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
