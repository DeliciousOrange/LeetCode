public class Solution {
    public int SearchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.Length-1;        
        return BinarySearch(nums,low,high,target);
    }

    public static int BinarySearch(int[] nums, int low, int high, int target)
    {
        int mid = (low+high)/2;

        if(nums[mid]==target)
        {
            return mid;
        }
        else if(low>high)
        {
            return low;
        }
        else if(nums[mid]<target)
        {
            low=mid+1;
            return BinarySearch(nums,low,high,target);
        }
        else if(nums[mid]>target)
        {
            high=mid-1;
            return BinarySearch(nums,low,high,target);
        }
    }
}