package com.teach.android.educationonline.api;

import com.teach.android.educationonline.ui.entity.LiveUserModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author 作者:Lyc
 *         Created by Administrator on 2017/12/6 0006.
 *         com.teach.android.educationonline.api
 *         EducationOnline
 */

public interface LiveUserService {
    @GET("LiveUser/register")
    Observable<LiveUserModel> getLiveuser();
}
