/**
 * @author ziyi.yuan
 * @date 2022/3/25 4:34 下午
 */
public class TextUtils {
    public static String format(String msg, Object... args) {
        String s = msg.replace("{}", "%s");
        return String.format(s, args);
    }
}
