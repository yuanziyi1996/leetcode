//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 68 👎 0

import java.util.LinkedHashMap;
import java.util.Map;

class 第一个只出现一次的字符 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            int len = s.length();
            if (len == 0) {
                return ' ';
            }
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c,map.get(c)+1);
                } else {
                    map.put(c,1);
                }
            }
           return map.keySet()
                    .stream()
                    .filter(key -> map.get(key)==1)
                    .findFirst().orElse(' ');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 第一个只出现一次的字符().new Solution();
    }
}