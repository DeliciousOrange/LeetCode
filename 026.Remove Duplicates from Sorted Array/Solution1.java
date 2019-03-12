public class Solution1 {
    public int RemoveDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        // 下面使用下标进行索引循环for语句不够优雅，且多使用一个索引变量
        // 建议使用不使用索引的增强for循环
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                // i++; // 该条语句不够优雅，不如合并到数组下标里进行自增运算
                nums[i++] = nums[j];
            }
        }
        // 下面的i+1不够优雅
        return i + 1;
    }

    // 下面的这个版本通过使用不使用下标的增强for循环，达到少使用一个索引变量的效果
    // 显得更加简洁
    // public int removeDuplicates(int[] nums) {
    //     int i = 0;
    //     for (int n : nums)
    //         if (i == 0 || n > nums[i - 1])
    //             nums[i++] = n;
    //     return i;
    // }
    
    // 下面这个版本通过使用三目运算符消除了for循环里面的x==0的检测，更加优雅
    // And to not need the i == 0 check in the loop:

    // public int removeDuplicates(int[] nums) {
    //     int i = nums.length > 0 ? 1 : 0;
    //     for (int n : nums)
    //         if (n > nums[i - 1])
    //             nums[i++] = n;
    //     return i;
    // }
}
