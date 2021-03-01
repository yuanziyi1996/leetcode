package tree;

import java.util.*;

/**
 * Author:liuyu
 * Date:2019-02-21
 */
public class TreeUtils {

    //打印树的时候依据每行来打印，每行初始2048个字符
    private static char[] line = new char[2048];

    //判断二叉树是否为平衡二叉树的参数，min为二叉树最低高度，max为最高
    private static int min;
    private static int max;

    static {
        for (int i = 0; i < line.length; i++) {
            line[i] = ' ';
        }
    }

    //将结构化的数组，转变为二叉树
    public static Node transfer(Integer[] arr) {
        if (arr[0] == null) {
            throw new RuntimeException("first element can't be null!");
        }
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            nodes[i] = new Node(arr[i]);
            if (i != 0) {
                int parent = i - 1 >>> 1;
                if (nodes[parent] == null) {
                    throw new RuntimeException("can't transfer!");
                }
                nodes[i].parent = nodes[parent];
                if (i % 2 == 0) {
                    nodes[parent].right = nodes[i];
                } else {
                    nodes[parent].left = nodes[i];
                }
            }
        }
        return nodes[0];
    }

    public static void printTree(Node root) {
        printTree(root, false);
    }

    public static void printTree(Integer[] arr) {
        if (Objects.isNull(arr) || arr.length < 0) {
            throw new RuntimeException("数组长度为0");
        }
        System.out.println("原始层次遍历：" + Arrays.toString(Arrays.stream(arr).toArray()));
        Node node = transfer(arr);
        printTree(node);
    }

    //打印二叉树
    public static void printTree(Node root, boolean hasNum) {
        if (root == null) {
            System.out.println("tree is null");
        }

        //如果没有节点值，添加
        if (!hasNum) {
            add_num(root);
        }
        System.out.println("----------------------------------------------------------------------------------");

        //探测树转变为数组后需要的长度
        int length = length(root, 0);
        //根据长度计算树的高度
        int height = 0;
        while ((length + 1 >>> height + 1) > 0) {
            height++;
        }
        Node[] nodes = new Node[(1 << height + 1) - 1];

        //遍历，将树放入数组,并返回树中最长的节点，方便计算格式
        int len = insert_tree(root, nodes) + 1;
        //判断底层长度是否超出范围
        if ((1 << height + 1) * len > line.length) {
            throw new RuntimeException("the height of tree is too large!");
        }

        //为了观看方便，将空节点塞满 '*'
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node(1, '*');
            }
        }

        //根据数组逐层打印树结构
        int point = 0;
        for (int i = 0; i <= height; i++) {
            char[] value = line.clone();

            //计算每行第一个元素的缩进距离
            int cursor = len * ((1 << height - i) - 1);
            int pre_long = 0;
            if (i < height) {
                pre_long = 3 * (1 << (height - 1 - i));
                for (int j = cursor; j > cursor - pre_long; j--) {
                    value[j] = '-';
                }
                value[cursor - pre_long] = '.';
                for (int j = cursor; j < cursor + pre_long; j++) {
                    value[j] = '-';
                }
                value[cursor + pre_long] = '.';
            }

            char[] node = nodes[point].value.toCharArray();
            for (char aNode : node) {
                value[cursor++] = aNode;
            }
            point++;
            //遍历元素，将每层剩下的元素加入行中
            while (point < (1 << i + 1) - 1 && point < nodes.length) {
                char[] no = nodes[point].value.toCharArray();
                cursor = cursor + ((1 << height - i + 1) - 1) * len + len - nodes[point - 1].value.length();
                //打印左边的 -
                for (int j = cursor; j > cursor - pre_long; j--) {
                    value[j] = '-';
                }
                value[cursor - pre_long] = '.';
                //打印右边的 -
                for (int j = cursor; j < cursor + pre_long; j++) {
                    value[j] = '-';
                }
                value[cursor + pre_long] = '.';
                for (char aNo : no) {
                    value[cursor++] = aNo;
                }
                point++;
            }
            System.out.println(String.valueOf(value));
            if (point >= nodes.length) {
                break;
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    //判断二叉树是否为平衡二叉树
    public static boolean isbalance(Node root) {
        min = Integer.MAX_VALUE;
        max = 0;
        return isbalance(root, 0);
    }

    private static boolean isbalance(Node root, int height) {
        if (root == null) {
            if (height < min) {
                min = height;
            }
            if (height > max) {
                max = height;
            }
            return !(max - min > 1);
        }
        height++;
        return isbalance(root.left, height) && isbalance(root.right, height);
    }

    //查找树结构需要多大的数组
    private static int length(Node root, int length) {
        if (root == null) {
            return length;
        }
        int left = length(root.left, root.num);
        int right = length(root.right, root.num);
        return left > right ? left : right;
    }

    //将树结构塞入数组
    private static int insert_tree(Node root, Node[] arr) {
        if (root == null) {
            return 0;
        }
        arr[root.num] = root;
        int left = insert_tree(root.left, arr);
        int right = insert_tree(root.right, arr);
        return Math.max(root.value.length(), Math.max(left, right));
    }

    //为树中的每个元素添加数组节点
    private static void add_num(Node root) {
        if (root == null) {
            return;
        }
        if (root.parent == null) {
            root.num = 0;
        } else if (root == root.parent.left) {
            root.num = ((root.parent.num + 1) << 1) - 1;
        } else if (root == root.parent.right) {
            root.num = ((root.parent.num + 1) << 1);
        }
        add_num(root.left);
        add_num(root.right);
    }

    public static void main(String[] args) {

        Integer[] res = randomBuildTree(4);
        Node node = transfer(res);
        printTree(node);
    }

    /**
     * 随机生成一棵树的 层次序列
     *
     * @param level
     * @return
     */
    public static Integer[] randomBuildTree(int level) {
        if (level > 20) {
            return new Integer[]{1};
        }
        int max = (1 << level) - 1;
        List<Integer> mylist = new ArrayList(); //生成数据集，用来保存随即生成数，并用于判断
        Random rd = new Random();
        while (mylist.size() < max) {
            int num = rd.nextInt(max + 1);
            if (num <= 0) {
                continue;
            }
            if (!mylist.contains(num)) {
                mylist.add(num); //往集合里面添加数据。
            }
        }
        Integer[] arr = mylist.toArray(new Integer[max]);
        // 设置几个空的子节点
        List<Integer> nullNode = new ArrayList<>();
        while (nullNode.size() < level) {
            int num = rd.nextInt(max + 1);
            if (num <= 0) {
                continue;
            }
            nullNode.add(num);
        }
        for (int i = 0; i < nullNode.size(); i++) {
            calculateNull(arr, nullNode.get(i), arr.length);
        }
        return arr;
    }

    public static void calculateNull(Integer[] arr, int index, int length) {
        if (index >= length) {
            return;
        }
        arr[index] = null;
        calculateNull(arr, index * 2 + 1, length);
        calculateNull(arr, index * 2 + 2, length);
    }

}