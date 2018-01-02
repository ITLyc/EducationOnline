package com.teach.android.educationonline.log.inner;

/**
 * 系统打印树- 输出日志信息到控制台
 * Created by zheng on 2017/11/1.
 */

public class ConsoleTree extends Tree{
    @Override
    protected void log(int type, String tag, String message) {
        System.out.println(tag + "\t" + message);
    }
}
