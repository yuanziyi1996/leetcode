package a排序算法;

/**
 * @author ziyi.yuan
 * @date 2021/1/23 7:33 下午
 */
public class 归并排序 {

    public static void mergeSort(int[] nums) {

    }

    public static void merge(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }


    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        //这一次合并是 从left 开始的，则临时数组的第一个值要给到 left的起始位
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static int[] mergeTow(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int res[] = new int[len1 + len2];
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 || index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                res[index1 + index2] = nums1[index1];
                index1++;
            } else {
                res[index1 + index2] = nums2[index2];
                index2++;
            }

            if (index1 == len1) {
                while (index2 < len2) {
                    res[index1 + index2] = nums2[index2];
                    index2++;
                }
                break;
            }
            if (index2 == len2) {
                while (index1 < len1) {
                    res[index1 + index2] = nums1[index1];
                    index1++;
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 3, 9, 7,11,9,20,18,4,8};
        int b[] = {2, 4, 6, 8, 10};
//        int c[] = mergeTow(a, b);
//        for (int i = 0; i < c.length; i++) {
//            System.out.printf(c[i] + " ");
//            System.out.println();
//        }

        merge(a);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i] + " ");
        }
    }
}
