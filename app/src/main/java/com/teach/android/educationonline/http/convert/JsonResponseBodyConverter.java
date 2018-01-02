package com.teach.android.educationonline.http.convert;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * responseBody to T
 * Created by zheng on 2017/11/3.
 */

final class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    JsonResponseBodyConverter() {
    }

    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        return (T) value.string();
    }
}

