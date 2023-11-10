package com.bou.wyj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
}
