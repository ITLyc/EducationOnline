package com.teach.android.educationonline.http.cache;

import android.content.Context;
import android.content.SharedPreferences;

import com.teach.android.educationonline.http.common.ViseConfig;
import com.teach.android.educationonline.log.MyLog;
import com.teach.android.educationonline.util.cipher.BASE64;
import com.teach.android.educationonline.util.convert.ByteUtil;
import com.teach.android.educationonline.util.convert.HexUtil;

/**
 * 存储，支持对象加密存储
 * Created by zheng on 2017/11/2.
 */

public class SpCache implements ICache{

    private SharedPreferences sp;

    public SpCache(Context context){
        this(context, ViseConfig.CACHE_SP_NAME);
    }

    public SpCache(Context context,String fileName){
        sp = context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
    }

    public SharedPreferences getSp(){
        return sp;
    }
    @Override
    public void put(String key, Object ser) {
        try {
            MyLog.i(key+"put:" + ser);
            if (ser == null){
                sp.edit().remove(key).apply();
            }else {
                byte[] bytes = ByteUtil.objectToByte(ser);
                bytes = BASE64.encode(bytes);
                put(key, HexUtil.encodeHexStr(bytes));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object get(String key) {
        try {
            String hex = get(key,null);
            if (hex == null) return null;
            byte[] bytes = HexUtil.decodeHex(hex.toCharArray());
            bytes = BASE64.decode(bytes);
            Object obj = ByteUtil.byteToObject(bytes);
            MyLog.i(key + "get:" + obj);
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean contains(String key) {
        return sp.contains(key);
    }

    @Override
    public void remove(String key) {
        sp.edit().remove(key).apply();
    }

    @Override
    public void clear() {
        sp.edit().clear().apply();
    }

    public void put(String key, String value){
        if (value == null){
            sp.edit().remove(key).apply();
        }else {
            sp.edit().putString(key,value).apply();
        }
    }

    public void put(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    public void put(String key, float value) {
        sp.edit().putFloat(key, value).apply();
    }

    public void put(String key, long value) {
        sp.edit().putLong(key, value).apply();
    }

    public void putInt(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    public String get(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public boolean get(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public float get(String key, float defValue) {
        return sp.getFloat(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public long get(String key, long defValue) {
        return sp.getLong(key, defValue);
    }
}
