package com.lmy.util.consts;

/**
 * @Description 数字类型 和 中文名称互转
 * @Date 2022/11/25 10:45
 * @Author by Soleil
 */
public class ConvertUtil {

    /**
     * 获取身份信息
     * @param type 身份类型
     * @return
     */
    public static String identStr(int type) {
        String result = null;
        if(type ==  Constants.ADMIN) {
            result = Constants.ADMIN_STR;
        }
        else {
            result = Constants.USER_STR;
        }

        return result;
    }
    
    /**
     * 获取图书分类
     */
    public static String typeStr(String type) {
        String result = null;
        if(type.equals(Constants.TYPE1)) {
            result = Constants.TYPE1_STR;
        }
        else if(type.equals(Constants.TYPE2)) {
            result = Constants.TYPE2_STR;
        }
        else if(type.equals(Constants.TYPE3)) {
            result = Constants.TYPE3_STR;
        }

        return result;
    }
}
