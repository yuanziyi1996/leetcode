//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4768 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class 无重复字符的最长子串{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        int end = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
//                ans = Math.max(ans, j - i);
                if (ans < j - i) {
                    ans = j - i;
                    end = j - 1;
                }
            } else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println("结束下标为：" + end);
        System.out.println("最长字符串是：" + s.substring(end - ans + 1, end + 1));
        return ans;
    }

        public  int lengthOfLongestSubstring2(String s) {
            int length = s.length();
            int max = 0;

            Map<Character, Integer> map = new HashMap<>();
            for (int start = 0, end = 0; end < length; end++) {
                char element = s.charAt(end);
                if (map.containsKey(element)) {
                    start = Math.max(map.get(element) + 1, start); //map.get()的地方进行+1操作
                }
                max = Math.max(max, end - start + 1);
                map.put(element, end);
                System.out.print("start: " + start + "  end : " + end + "  max : " + max);
                System.out.println();
                map.forEach((key, value) -> {
                    System.out.print(" (key :" + key + " , value : " + value + " );");
                });
                System.out.println();
            }
            return max;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串().new Solution();
        String str = "sdfswgosdf";
        System.out.println(solution.lengthOfLongestSubstring2(str));
    }
}