package common;

/**
 * @author ziyi.yuan
 * @date 2021/2/23 10:33 上午
 */
public class 单例模式 {
    public static class Instance {
        public Instance() {

        }
        private static volatile Instance instance = null;

        public static Instance getInstance() {
            if (instance == null) {
                synchronized (Instance.class) {
                    if (instance == null) {
                        return new Instance();
                    }
                }
            }
            return instance;
        }
    }


    public static int binaryFind(int arr[], int target) {
        int length = arr.length;
        if (length <= 0) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        int mid = (left + right) / 2;
        while (left < right) {

            //在左边部分
            if (target < arr[mid]) {
                right = mid -1;
                mid = (left + right) / 2;
            }else if (arr[mid] < target ) {
                left = mid +1;
                mid = (left + right) / 2;
            }else {
                return mid;
            }
            System.out.println("left :"+ left + " mid : " + mid + "  right :"+ right);
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "123456";
        String b = "7654321";
        int [] arr = {1,2,3,4,5,6,7,8,10,11};
        System.out.println(binaryFind(arr,17));
        System.out.println(Integer.valueOf(a) + Integer.valueOf(b));
        System.out.println(towStringAdd(a, b));
    }


    // 字符串，数字，123456，全是正数，第一位没有0；字符串相加，返回一个字符串。
    public static String towStringAdd(String stringa, String stringb) {
        int lengtha = stringa.length();
        int lengthb = stringb.length();
        StringBuilder stringBuilder = new StringBuilder();
        int added = 0;
        while (lengtha > 0 && lengthb > 0) {
            int one = Integer.valueOf(stringa.charAt(lengtha - 1) - 48);
            int tow = Integer.valueOf(stringb.charAt(lengthb - 1) - 48);
            added = (one + tow + added) > 10 ? 1 : 0;
            int res = (one + tow + added) % 10;
            lengtha--;
            lengthb--;
            stringBuilder.append(String.valueOf(res));
            if (lengtha == 0 && lengthb > 0) {
                while (lengthb > 0) {
                    stringBuilder.append(Integer.valueOf(stringb.charAt(lengthb - 1)- 48) + added);
                    lengthb --;
                    added = 0;
                }
            }
            if (lengthb == 0 && lengtha > 0) {
                while (lengtha > 0) {
                    stringBuilder.append(Integer.valueOf(stringa.charAt(lengtha - 1)- 48) + added);
                    lengtha --;
                    added = 0;
                }
            }
        }

        //
        return stringBuilder.reverse().toString();
    }


}
