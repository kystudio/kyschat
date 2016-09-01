package cn.kystudio.chat.utils;

/**
 * Created by kystudio on 2016/9/1.
 */
public class CharacterUtil {

    /**
     * 判定给定的字符串是否为空，为空返回true，否则返回false
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if("".equals(str)){
            return true;
        }

        return false;
    }

    /**
     * 判定给定的字符串是否是数字，是数字返回true，否则返回false
     * @param str
     * @return
     */
    public static boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }

        return true;
    }

    /**
     * 判断服务器端口号是否在正确的范围内
     * @param port
     * @return
     */
    public static boolean isPortCorrect(String port){
        int temp = Integer.parseInt(port);

        if (temp<=1024 || temp>=65535){
            return false;
        }

        return true;
    }
}
