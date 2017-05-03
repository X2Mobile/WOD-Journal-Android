package com.x2mobile.wodjar.data.callback

import com.x2mobile.wodjar.data.event.SignUpRequestEvent
import com.x2mobile.wodjar.data.event.SignUpRequestFailureEvent
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpCallback : Callback<Void> {

    override fun onFailure(call: Call<Void>?, throwable: Throwable?) {
        EventBus.getDefault().post(SignUpRequestFailureEvent(call, throwable))
    }

    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
        EventBus.getDefault().post(SignUpRequestEvent(call, response))
    }

}