package com.teach.android.educationonline.log.parser;

import android.os.Bundle;

import com.teach.android.educationonline.log.common.LogConvert;

/**
 * Bundle解析器
 * Created by zheng on 2017/11/1.
 */

public class BundleParse implements Parser<Bundle>{
    @Override
    public Class<Bundle> parseClassType() {
        return Bundle.class;
    }

    @Override
    public String parseString(Bundle bundle) {
        if (bundle != null) {
            StringBuilder builder = new StringBuilder(bundle.getClass().getName() + " [" +
                    LINE_SEPARATOR);
            for (String key : bundle.keySet()) {
                builder.append(String.format("'%s' => %s " + LINE_SEPARATOR,
                        key, LogConvert.objectToString(bundle.get(key))));
            }
            builder.append("]");
            return builder.toString();
        }
        return null;
    }
}
