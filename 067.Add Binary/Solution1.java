class Solution {
    public String addBinary(String a, String b) {
    	// 一般字符串表示的数字的计算问题都可以用类似下面的方法解决，首先，
    	// 一个技巧点就是减去‘0’，另外一个技巧点就是像下面那样使用carry
    	// 进位。
    	// 此题目还可以额外使用一个stack来避免最后的反转。
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}