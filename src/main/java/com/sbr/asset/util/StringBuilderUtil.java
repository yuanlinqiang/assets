package com.sbr.asset.util;

import com.sbr.common.util.StringUtil;
import org.assertj.core.util.Strings;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>字符串拼接工具类</p>
 * @author yuan
 * @date 2019/7/26
 */
public class StringBuilderUtil {

    //建立层级关系
    public static String  stringBuilder(String levelCode, String id){
        StringBuilder str=new StringBuilder();
        if(!StringUtil.isEmpty(levelCode))str.append(levelCode);
        str.append("/").append(id);
        return String.valueOf(str);
    }

    //同步到盛华安数据库   将层级关系做成ID
    public static String  levelCodeTrans(String levelCode){
        StringBuilder newLevelCode=new StringBuilder();
        String[] split = levelCode.split("/");
        for (int i = 1; i < split.length; i++) {
            newLevelCode.append("/").append(DataTypeConversionUtil.UUIDTransID(split[i]));
        }
          return  String.valueOf(newLevelCode);
    }

    public static void main(String[] args) {

    }



}
