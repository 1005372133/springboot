package cn.wmyskxz.springboot.util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public StringUtil() {
    }

    public static String FilterNull(Object o) {
        return o != null && !"null".equals(o.toString()) ? o.toString().trim() : "";
    }

    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        } else {
            return "".equals(FilterNull(o.toString()));
        }
    }

    public static boolean isNotEmpty(Object o) {
        if (o == null) {
            return false;
        } else {
            return !"".equals(FilterNull(o.toString()));
        }
    }

    public static boolean isNum(Object o) {
        try {
            new BigDecimal(o.toString());
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean isLong(Object o) {
        try {
            new Long(o.toString());
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static Long toLong(Object o) {
        return isLong(o) ? new Long(o.toString()) : 0L;
    }

    public static int toInt(Object o) {
        return isNum(o) ? new Integer(o.toString()) : 0;
    }

    public static String holdmaxlength(Object o) {
        int maxlength = 50;
        return o == null ? "" : subStringByByte(o, maxlength);
    }

    public static String holdmaxlength(Object o, int maxlength) {
        maxlength = maxlength <= 0 ? 50 : maxlength;
        return o == null ? "" : subStringByByte(o, maxlength);
    }

    private static String subStringByByte(Object o, int len) {
        if (o == null) {
            return "";
        } else {
            String str = o.toString();
            String result = null;
            if (str != null) {
                byte[] a = str.getBytes();
                if (a.length <= len) {
                    result = str;
                } else if (len > 0) {
                    result = new String(a, 0, len);
                    int length = result.length();
                    if (str.charAt(length - 1) != result.charAt(length - 1)) {
                        if (length < 2) {
                            result = null;
                        } else {
                            result = result.substring(0, length - 1);
                        }
                    }
                }
            }

            return result;
        }
    }

    public static String comma_add(String commaexpress, String newelement) {
        return comma_rect(FilterNull(commaexpress) + "," + FilterNull(newelement));
    }

    public static String comma_del(String commaexpress, String delelement) {
        if (commaexpress != null && delelement != null && !commaexpress.trim().equals(delelement.trim())) {
            String[] deletelist = delelement.split(",");
            String result = commaexpress;
            String[] arr$ = deletelist;
            int len$ = deletelist.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String delstr = arr$[i$];
                result = comma_delone(result, delstr);
            }

            return result;
        } else {
            return "";
        }
    }

    public static String comma_delone(String commaexpress, String delelement) {
        if (commaexpress != null && delelement != null && !commaexpress.trim().equals(delelement.trim())) {
            String[] strlist = commaexpress.split(",");
            StringBuffer result = new StringBuffer();
            String[] arr$ = strlist;
            int len$ = strlist.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String str = arr$[i$];
                if (!str.trim().equals(delelement.trim()) && !"".equals(str.trim())) {
                    result.append(str.trim() + ",");
                }
            }

            return result.toString().substring(0, result.length() - 1 > 0 ? result.length() - 1 : 0);
        } else {
            return "";
        }
    }

    public static boolean comma_contains(String commaexpress, String element) {
        boolean flag = false;
        commaexpress = FilterNull(commaexpress);
        element = FilterNull(element);
        if (!"".equals(commaexpress) && !"".equals(element)) {
            String[] strlist = commaexpress.split(",");
            String[] arr$ = strlist;
            int len$ = strlist.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String str = arr$[i$];
                if (str.trim().equals(element.trim())) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }

   /* public static String comma_intersect(String commaexpressA, String commaexpressB) {
        commaexpressA = FilterNull(commaexpressA);
        commaexpressB = FilterNull(commaexpressB);
        StringBuffer result = new StringBuffer();
        String[] strlistA = commaexpressA.split(",");
        String[] strlistB = commaexpressB.split(",");
        String[] arr$ = strlistA;
        int len$ = strlistA.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String boA = arr$[i$];
            String[] arr$ = strlistB;
            int len$ = strlistB.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String boB = arr$[i$];
                if (boA.trim().equals(boB.trim())) {
                    result.append(boA.trim() + ",");
                }
            }
        }

        return comma_rect(result.toString());
    }*/

    public static String comma_rect(String commaexpress) {
        commaexpress = FilterNull(commaexpress);
        String[] strlist = commaexpress.split(",");
        StringBuffer result = new StringBuffer();
        String[] arr$ = strlist;
        int len$ = strlist.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String str = arr$[i$];
            if (!"".equals(str.trim()) && !("," + result.toString() + ",").contains("," + str + ",") && !"null".equals(str)) {
                result.append(str.trim() + ",");
            }
        }

        return result.toString().substring(0, result.length() - 1 > 0 ? result.length() - 1 : 0);
    }

    public static String comma_reverse(String commaexpress) {
        commaexpress = FilterNull(commaexpress);
        String[] ids = commaexpress.split(",");
        StringBuffer str = new StringBuffer();

        for(int i = ids.length - 1; i >= 0; --i) {
            str.append(ids[i] + ",");
        }

        return comma_rect(str.toString());
    }

    public static String comma_first(String commaexpress) {
        commaexpress = FilterNull(commaexpress);
        String[] ids = commaexpress.split(",");
        System.out.println("length:" + ids.length);
        return ids != null && ids.length > 0 ? ids[0] : null;
    }

    public static String comma_last(String commaexpress) {
        commaexpress = FilterNull(commaexpress);
        String[] ids = commaexpress.split(",");
        return ids != null && ids.length > 0 ? ids[ids.length - 1] : null;
    }

    public static String replace(String strData, String regex, String replacement) {
        return strData == null ? "" : strData.replaceAll(regex, replacement);
    }

    public static String String2HTML(String strData) {
        if (strData != null && !"".equals(strData)) {
            strData = replace(strData, "&", "&amp;");
            strData = replace(strData, "<", "&lt;");
            strData = replace(strData, ">", "&gt;");
            strData = replace(strData, "\"", "&quot;");
            return strData;
        } else {
            return "";
        }
    }

    public static String getexceptionInfo(Exception e) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            e.printStackTrace(new PrintStream(baos));
        } finally {
            try {
                baos.close();
            } catch (IOException var8) {
                var8.printStackTrace();
            }

        }

        return baos.toString();
    }

    public static String regex(String str) {
        Pattern pattern = Pattern.compile("[0-9-:/ ]");
        char[] array = str.toCharArray();

        for(int i = 0; i < array.length; ++i) {
            Matcher matcher = pattern.matcher(String.valueOf(array[i]));
            if (!matcher.matches()) {
                str = str.replace(String.valueOf(array[i]), "");
            }
        }

        return str;
    }

    public static String comma_insert(String commaexpress, String newelement, int index) {
        int length = commaexpress.length();
        if (index > length) {
            index = length;
        } else if (index < 0) {
            index = 0;
        }

        String result = commaexpress.substring(0, index) + newelement + commaexpress.substring(index, commaexpress.length());
        return result;
    }

    public static String changeDirection(String strDir) {
        String s = "/";
        String a = "\\";
        if (strDir != null && !" ".equals(strDir) && strDir.contains(s)) {
            strDir = strDir.replace(s, a);
        }

        return strDir;
    }

    public static String trim(String s) {
        int i = s.length();
        int j = 0;
        int k = 0;

        char[] arrayOfChar;
        for(arrayOfChar = s.toCharArray(); j < i && arrayOfChar[k + j] <= ' '; ++j) {
            ;
        }

        while(j < i && arrayOfChar[k + i - 1] <= ' ') {
            --i;
        }

        return j <= 0 && i >= s.length() ? s : s.substring(j, i);
    }

    public static String getBrackets(String str) {
        int a = str.indexOf("{");
        int c = str.indexOf("}");
        return a >= 0 && c >= 0 & c > a ? str.substring(a + 1, c) : str;
    }

    public static String commaToVerti(String str) {
        return str != null && !"".equals(str) && str.contains(",") ? str.replaceAll(",", "|") : str;
    }

    public static String extractBlank(String name) {
        return name != null && !"".equals(name) ? name.replaceAll(" +", "") : name;
    }

    public static String ConvertStr(String str) {
        return str != null && !"null".equals(str) ? str.trim() : "";
    }

    public static void main(String[] args) {
        System.out.println(isNum("a"));
        System.out.println(isNum("-1"));
        System.out.println(isNum("01"));
        System.out.println(isNum("1E3"));
        System.out.println(isNum("1.a"));
        System.out.println(isLong("014650"));
        System.out.println(Long.parseLong("014650"));
    }
}
