package com.teach.android.educationonline.http.func;

import com.teach.android.educationonline.http.common.ResponseHelper;
import com.teach.android.educationonline.http.mode.ApiResult;

import io.reactivex.functions.Function;

/**
 * ApiResult<T>转T
 * Created by zheng on 2017/11/3.
 */

public class ApiDataFunc<T> implements Function<ApiResult<T>, T> {
    public ApiDataFunc() {
    }

    @Override
    public T apply(ApiResult<T> response) throws Exception {
        if (ResponseHelper.isSuccess(response)) {
            return response.getData();
        }
        return null;
    }
}

