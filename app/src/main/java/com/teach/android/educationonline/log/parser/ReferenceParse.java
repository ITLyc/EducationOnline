package com.teach.android.educationonline.log.parser;

import com.teach.android.educationonline.log.common.LogConvert;

import java.lang.ref.Reference;

/**
 * Reference解析器
 * Created by zheng on 2017/11/1.
 */

public class ReferenceParse implements Parser<Reference>{
    @Override
    public Class<Reference> parseClassType() {
        return Reference.class;
    }

    @Override
    public String parseString(Reference reference) {
        Object actual = reference.get();
        StringBuilder builder = new StringBuilder(reference.getClass().getSimpleName() + "<"
                + actual.getClass().getSimpleName() + "> {");
        builder.append("→").append(LogConvert.objectToString(actual));
        return builder.toString() + "}";
    }
}
