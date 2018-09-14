package cn.wmyskxz.springboot.util;


import java.io.PrintWriter;
import java.io.StringWriter;

public class Exceptions {
    public Exceptions() {
    }

    public static RuntimeException unchecked(Exception e) {
        return e instanceof RuntimeException ? (RuntimeException)e : new RuntimeException(e);
    }

    public static String getStackTraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean isCausedBy(Exception ex, Class... causeExceptionClasses) {
        for(Throwable cause = ex.getCause(); cause != null; cause = cause.getCause()) {
            Class[] arr$ = causeExceptionClasses;
            int len$ = causeExceptionClasses.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Class<? extends Exception> causeClass = arr$[i$];
                if (causeClass.isInstance(cause)) {
                    return true;
                }
            }
        }

        return false;
    }
}
