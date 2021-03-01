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

class 无重复字符的最长子串 {
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

        public int lengthOfLongestSubstring2(String s) {
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

        /**
         * 这道题主要用到思路是：滑动窗口
         *
         * 什么是滑动窗口？
         *
         * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
         *
         * 如何移动？
         *
         * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
         *
         * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
         *
         * 时间复杂度：O(n)O(n)
         *
         * 作者：powcai
         * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring3(String s) {
            if (s.length() == 0) {
                return 0;
            }
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
                if(max < i - left + 1){
                    max = i - left + 1;
                    end = i;
                }
            }
            System.out.println("left : " + left);
            System.out.println("end "+ end);
            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串().new Solution();
        String str = "sdfswgosdf";
        System.out.println(solution.lengthOfLongestSubstring2(str));
        System.out.println("==========");
        System.out.println(solution.lengthOfLongestSubstring3(str));
    }
}