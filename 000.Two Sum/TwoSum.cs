public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        int[] indexs=new int[2];
        for(int i=0;i<nums.Length;i++)
        {
            for(int j=i+1;j<nums.Length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    indexs[0]=nums[i];
                    indexs[1]=nums[j];
                }
            }
        }
        return indexs;
    }
}