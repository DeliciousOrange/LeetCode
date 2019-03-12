class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int temp;
        int j = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=nums[j]){
                j++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                count = 0;
            }
            else{
                count++;
                if(count < 2){
                    j++;
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
         
            }           
        }
        // 关于下面这样返回一个变量加上一个常量尾巴的情形，要思考下是否可以消除掉常量尾巴
        // 毕竟不带尾巴更加简洁
        return j+1;
    }

    // 下面的代码更加简洁，关于in-place原地修改数组的实现确实应该像下面的代码这么优雅简洁

    // public int removeDuplicates(int[] nums) {
    //     int i = 0;
    //     for (int n : nums)
    //         if (i < 2 || n > nums[i-2])
    //             nums[i++] = n;
    //     return i;
    // }
}