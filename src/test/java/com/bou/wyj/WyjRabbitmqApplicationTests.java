package com.bou.wyj;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.bou.wyj.entity.DeviceEntity;
import com.bou.wyj.entity.TransPojo;
import com.bou.wyj.redis.RedisCache;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class WyjRabbitmqApplicationTests {
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {

        String hump = "firstNameAndSchool";
        String toLine = humpToLine(hump);
        System.out.println( hump +"=====>" + toLine);


        String line = "get_one_name_ok";
        String toHump = lineToHump(line);
        System.out.println( line +"=====>" + toHump);

    }


    /**
     * 驼峰转下划线
     *
     * @Param: [str]
     * @return: java.lang.String
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     *
     * @Param: [str]
     * @return: java.lang.String
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @Resource
    private RedisCache redisCache;

    @Test
    void test1() throws JsonProcessingException {
        // new DeviceEntity().getTransMap();

        String deviceStr = "{\"id\":\"56\",\"createUser\":null,\"updateUser\":\"10017\"" +
                ",\"isDelete\":false,\"name\":\"三号厂双鱼座边缘计算\",\"deviceSn\":\"02700123072400010090\",\"deviceCode\":\"21tbOvo9BEespa0mswQBpnY0a6xiA1Vg\"" +
                ",\"deviceCodeUrl\":null,\"cameraCode\":\"a885d575-753aee02\",\"timePayment\":1,\"status\":true,\"deviceModeType\":1,\"storeId\":\"10001\",\"shopId\":\"10017\",\"siteId\":\"11\"" +
                ",\"runStatus\":6,\"minprogramCodeUrl\":\"/uploads/minprogram/20231213/SJDg43Hr6YtNalHN_share_image.jpg\",\"minprogramCode\":\"giahh7z3TzPnKQ3h\",\"paymentCode\":\"ceYwj0nU9ZJDuzDv\"" +
                ",\"paymentCodeUrl\":\"/device/payment/17024307095219554.png\",\"isReset\":true,\"valVer\":\"20231025\",\"shareProportion\":10,\"isRun\":true,\"payTypes\":\"[1]\",\"isCarStop\":false" +
                ",\"isQueue\":0 }\n";


        ObjectMapper objectMapper = new ObjectMapper();
        DeviceEntity deviceEntity = objectMapper.readValue(deviceStr, DeviceEntity.class);
        deviceEntity.setCreateTime(LocalDateTime.now());
        deviceEntity.setUpdateTime(LocalDateTime.now());


        // redisCache.set("test" , deviceEntity);
        // DeviceEntity testDevice = (DeviceEntity) redisCache.get("test");
        DeviceEntity testDevice = redisCache.getCacheObject("test");
        System.out.println("testDevice = " + testDevice);
        System.out.println("testDevice = " + testDevice.getCreateTime());
    }
}
