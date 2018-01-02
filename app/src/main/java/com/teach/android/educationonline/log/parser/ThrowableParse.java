package com.teach.android.educationonline.log.parser;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Throwable解析器
 * Created by zheng on 2017/11/1.
 */

public class ThrowableParse implements Parser<Throwable>{
    @Override
    public Class<Throwable> parseClassType() {
        return Throwable.class;
    }

    @Override
    public String parseString(Throwable throwable) {
        return getStackTraceString(throwable);
    }

    private String getStackTraceString(Throwable t) {
        StringWriter sw = new StringWriter(256);
        PrintWriter pw = new PrintWriter(sw, false);
        t.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }
}
