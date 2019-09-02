package com.sbr.asset.util;

import com.sbr.common.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * <p>字符串拼接工具类</p>
 * @author YLQ
 * @date 2019/7/26
 */
public class DataTypeConversionUtil {

    /**
     * <p>UUID转换成int类型   转类型的标砖一定要一致</p>
     *
     * @param uuids
     * @return UUID  对应的ID
     * @author YLQ 2019-05-15 14:23:01
     */
    public static Integer UUIDTransID(List<String> uuids) throws Exception {
        String id = "";
        Integer num = 0;
        for (String UUID : uuids) {
            id = UUID.replace("-", "");//去掉随机ID的短横线
            num = id.hashCode(); //将随机ID换成数字
            num = num < 0 ? -num : num; //去绝对值
        }
        return num;
    }


    /**
     * <p>UUID转换成int类型   转类型的标砖一定要一致</p>
     * @param  uuid
     * @return UUID  对应的ID
     * @author YLQ 2019-05-15 14:23:01
     */
    public static Integer UUIDTransID(String uuid)  {
        Integer num = 0;
        try {
            uuid = uuid.replace("-", "");//去掉随机ID的短横线
            num = uuid.hashCode(); //将随机ID换成数字
            num = num < 0 ? -num : num; //去绝对值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * <p>标准转化为毫秒数</p>
     * @param     dateTimes
     * @return  毫秒值
     * @author YLQ 2019-05-15 14:23:01
     */
    public static Date StringFormatDate(String dateTimes) throws Exception {
        if(dateTimes.equals("null"))return  null;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(dateTimes);
        return date;
    }

    /**
     * <p>标准转化为毫秒数</p>
     * @param     dateTimes
     * @return  毫秒值
     * @author YLQ 2019-05-15 14:23:01
     */
    public static Long DataFormatMillises(Date dateTimes)   {
        if(dateTimes == null) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        Long time2 = null;
        try {
             time2 = simpleDateFormat.parse(simpleDateFormat.format(dateTimes)).getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return time2;
    }



    public static void main(String[] args) throws Exception {
        String time="2019-08-20 23:52:19.0";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(time);
        Long timestamp=date.getTime();
        System.out.println("最后的数据是========"+ date);

    }


}
