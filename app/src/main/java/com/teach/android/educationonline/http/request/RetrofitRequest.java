package com.teach.android.educationonline.http.request;

/**
 * 传入自定义Retrofit接口的请求类型
 * Created by zheng on 2017/11/3.
 */

public class RetrofitRequest extends BaseRequest<RetrofitRequest>{
    public RetrofitRequest(){

    }

    public <T> T create(Class<T> cls){
        generateGlobalConfig();
        generateLocalConfig();
        return retrofit.create(cls);
    }
}
