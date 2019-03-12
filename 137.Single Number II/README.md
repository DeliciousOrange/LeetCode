# 思路（C#）
从这个问题的简单版本，也就是使用XOR运算的版本，我们可以得到这样一个启示：对于Single Number II
(数组中每个数出现K=3次，除了一个数字之外，该数字出现次数M不是K的倍数，**注意：只要M不是K的倍数就行，并不要求一定小于K**)，我们需要一个类似于XOR的操作符号，我们把它表示为@，那么@必须满足：  
Commutative: A@B == B@A.
Circular: A@B@...@B == A where the count of B's is a multiple of K.

我们需要创造出这个@操作。此类问题的精髓就在于：**我们需要为每一个bit位维护一个state状态，此处，状态对应于该bit位出现多少次1**。因此，对于本题目，一个很自然的想法就是创建一个int[32]数组来统计32位整数的每个bit位出现1的次数。  

bitCount = [];
for (i = 0; i < 32; i++) {
  bitCount[i] = 0;
}
The state transits like this:

for (j = 0; j < nums.length; j++) {
    n = nums[j];
    for (i = 0; i < 32; i++) {
        hasBit = (n & (1 << i)) != 0;
        if (hasBit) {
            bitCount[i] = (bitCount[i] + 1) % K;
        }
    }
}
I use '!=' instead of '>' in 'hasBit = (n & (1 << i)) != 0;' because 1<<31 is considered negative. After this, bitCount will store the module count of appearance of '1' by K in every bit. We can then find the wanted number by inspecting bitCount.

exept = 0;
for (i = 0; i < 32; i++) {
  if (bitCount[i] > 0) {
    exept |= (1 << i);
  }
}
return exept;
We use bitCount[i] > 0 as condition because there is no tell how many times that exceptional number appears.

Now let's talk about ziyihao's solution. His solution looks much magical than mine because given a fixed K, we can encode the state into a few bits. In my bitCount version, we have a int[32] array to store the count of each bit but a 32-bit integer is way more than what we need to store just 3 states. So ideally we can have a bit[32][2] structure to store the counts. We name bit[...][0] as 'a' and bit[...][1] as 'b' and the bits of n as 'c' and we have ziyihao's post.