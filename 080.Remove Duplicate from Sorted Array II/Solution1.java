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