package com.teach.android.educationonline.http.event;

/**
 * 事件管理，可定制事件发送方式，可替换成EventBus
 * Created by zheng on 2017/11/2.
 */

public class BusManager {
    private static IBus innerBus;
    private static IBus externalBus;

    public static void setBus(IBus bus){
        if (externalBus == null && bus != null){
            externalBus = bus;
        }
    }

    public static IBus getBus(){
        if (innerBus == null){
            synchronized (BusManager.class){
                if (innerBus == null){
                    if (externalBus != null){
                       innerBus = externalBus;
                    }else {
                        innerBus = new RxBusImpl();
                    }
                }
            }
        }
        return innerBus;
    }
}
