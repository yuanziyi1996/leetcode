//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 345 👎 0

class 验证回文串 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            int step = 'a' - 'A';
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                if ('A' <= a && a <= 'Z') {
                    stringBuilder.append((char) (a + step));
                } else if ('a' <= a && a <= 'z') {
                    stringBuilder.append(a);
                } else if ('0' <= a && a <= '9') {
                    stringBuilder.append(a);
                }
            }
            char[] arr = stringBuilder.toString().toCharArray();
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                if (arr[left++] != arr[right--]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 验证回文串().new Solution();
        String s = "0P";
        System.out.println(solution.isPalindrome(s));
        ;
    }
}