//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
//和 "192.168@1.1" 是 无效 IP 地址。
//
//
//
// 示例 1：
//
//
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
//
//
// 示例 2：
//
//
//输入：s = "0000"
//输出：["0.0.0.0"]
//
//
// 示例 3：
//
//
//输入：s = "1111"
//输出：["1.1.1.1"]
//
//
// 示例 4：
//
//
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
//
//
// 示例 5：
//
//
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 3000
// s 仅由数字组成
//
// Related Topics 字符串 回溯算法
// 👍 516 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class 复原_IP_地址 {
    /**
     * 分析剪枝条件（下面只写出一些我想到的要点，有些点能想到，但是编码很复杂，我就没有写了）：
     * <p>
     * 1、一开始，字符串的长度小于 4 或者大于 12 ，一定不能拼凑出合法的 ip 地址（这一点可以一般化到中间结点的判断中，以产生剪枝行为）；
     * <p>
     * 2、每一个结点可以选择截取的方法只有 3 种：截 1 位、截 2 位、截 3 位，因此每一个结点可以生长出的分支最多只有 3 条分支；
     * <p>
     * 根据截取出来的字符串判断是否是合理的 ip 段，这里写法比较多，可以先截取，再转换成 int ，再判断。我采用的做法是先转成 int，是合法的 ip 段数值以后，再截取。
     * <p>
     * 3、由于 ip 段最多就 4 个段，因此这棵三叉树最多 4 层，这个条件作为递归终止条件之一；
     * <p>
     * 4、每一个结点表示了求解这个问题的不同阶段，需要的状态变量有：
     * <p>
     * splitTimes：已经分割出多少个 ip 段；
     * begin：截取 ip 段的起始位置；
     * path：记录从根结点到叶子结点的一个路径（回溯算法常规变量，是一个栈）；
     * res：记录结果集的变量，常规变量。
     * 总结：这个问题思想不难，但是细节比较繁琐，什么时候递归终止，如何手动截取字符串，再转换成 int 类型，还有如何在中间结点发现可以剪枝，这些细节需要在编码的时候考虑清楚。
     * <p>
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        List<String> list = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            int length = s.length();
            List<String> res = new ArrayList<>();

            if (length > 12 || length < 4) {
                return res;
            }
            Deque<String> path = new ArrayDeque<>(4);
            dfs(s, s.length(), 0, 4, path, res);
            return res;

        }

        public boolean isvalidIp(String s) {
            char[] a = s.toCharArray();
            if (a.length > 1 && a[0] == '0') {
                return false;
            }
            int value = Integer.parseInt(s);
            return value == 0 || (value > 0 && value <= 255);
        }

        private void dfs(String s, int len, int begin, int remainSegment, Deque<String> path, List<String> res) {
            // 当开始节点到达最后，并且 剩余的段数为0的时候 就加入到结果集
            if (begin == len) {
                if (remainSegment == 0) {
                    res.add(String.join(".", path));
                }
            }

            for (int i = begin + 1; i < begin + 4; i++) {

                if (i > len) {
                    break;
                }

                if ((len - begin) > (remainSegment * 3)) {
                    continue;
                }
                String number = s.substring(begin, i);
                if (isvalidIp(number)) {
                    //记录从根结点到叶子结点的一个路径（回溯算法常规变量，是一个栈）；
                    path.addLast(number);
                    dfs(s, len, i, remainSegment - 1, path, res);
                    path.removeLast();
                }
            }

        }


        public boolean find(int left, int right, String s, StringBuilder res, int numberCount) {
            if ((s.length() - (res.length() - numberCount)) > (4 - numberCount) * 3) {
                return false;
            }

            if (left == right || left > right || left > s.length() || right > s.length()) {
                return false;
            }
            //right 是开区间
            String num = s.substring(left, right);
            if (!isvalidIp(num)) {
                return false;
            }
            numberCount++;
            if (numberCount != 4) {
                res.append(num).append(".");
            } else {
                res.append(num);
                list.add(res.toString());
                res = new StringBuilder();
                numberCount = 0;
            }


            return find(right, right + 1, s, res, numberCount) ||
                    find(right, right + 2, s, res, numberCount) ||
                    find(right, right + 3, s, res, numberCount);


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 复原_IP_地址().new Solution();
        String strings[] = {"25525511135", "0000", "1111", "101023", "010010" };
        for (String s : strings) {
            System.out.println(solution.restoreIpAddresses(s));
        }
    }
}