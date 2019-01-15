# 思路（C#）
这是LeetCode上遇到的第一道题目，由于之前没有学过数据结构的知识，所以每次遇到这种需要遍历数组元素的题目，总是选择使用暴力解法。这次，在暴力解法之外考虑用更优的解法来解决这个问题。

在使用c#的dictionary解决问题的时候，要注意不像java中的hashmap，dictionary的key一定不能重复，所以Solution2在往dictionary中添加键值对时需要判断是否已经存在该键。  

在第二个解决方案的第一版中，使用了临时数组作为中间工作变量，并将数组元素初始化为0，代码如下： 
```c#
public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        int[] indexs=new int[2];
        Dictionary<int,int> dict=new Dictionary<int,int>();
        for(int i=0;i<nums.Length;i++)
        {
            if(dict.ContainsKey(target-nums[i]))
            {
                indexs[0]=dict[target-nums[i]];
                indexs[1]=i;
                return indexs;
            }
            if(!dict.ContainsKey(nums[i]))
            {
                dict.Add(nums[i],i);
            }            
        }
        return indexs;
    }
}
```
我们知道对于从一个文件中读取信息的方法来说，返回值通常不是一个标准字符，而是一个-1，表示文件结束。这种处理方式对于很多异常情况都是可行的。还有一种表示错误情况的常用返回值是`null`引用。

但并不是在任何情况下都能够返回一个错误码。拿上面的代码来说，当给定的nums数组中不存在和等于target的两个数字时，TwoSum方法返回的却是\[0,0]，这种方法无法将有效数据和无效数据区分开，因为\[0,0]很有可能就是一个合法值。对于这种方法无法从正常执行路径返回一个值或完成它的任务的情况，应通过另一个路径退出方法，此时，方法并不返回一个值，而是抛出一个封装了错误信息的异常对象。

Solution2的抛出异常版本已更新到TwoSum_Solution2.cs文件中。
