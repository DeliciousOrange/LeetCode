# 思路（C#）
这道题目的级别是easy。但是在做的时候居然卡脑壳了，到最后也没想出来，说明自己掉到思维的误区绕不出来了。  
题目本身说的是不能额外开辟空间，需要在数组本身上面动手脚，同时还说了这句话：`It doesn't matter what you leave beyond the returned length.` 这表示我们可以在返回的length索引范围内将不重复的元素进行排列。  
除了RemoveDuplicates.cs文件中的方法之外，还有一种方法，但两种方法的思想是一样的，都是利用双指针的思想。但是该方法通过三目运算符实现了函数仅有一条返回路径。代码如下：

```c#
public class Solution {
    public int RemoveDuplicates(int[] nums) {
            int i = nums.Length > 0 ? 1 : 0;
            for (int j = 1; j < nums.Length; j++) {
                if (nums[j] != nums[i]) {
                    nums[i++] = nums[j];
                }
            }
            return i;   
        }
}
```
这样看起来是不是更加简洁？哈哈😄。