package com.x2mobile.wodjar.activity.base

import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import com.x2mobile.wodjar.R
import org.greenrobot.eventbus.EventBus

open class BaseFormActivity : BaseToolbarActivity() {

    protected val username: EditText by lazy {
        findViewById(R.id.username) as EditText
    }

    protected val password: EditText by lazy {
        findViewById(R.id.password) as EditText
    }

    override fun onStart() {
        super.onStart()

        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()

        EventBus.getDefault().unregister(this)
    }

    protected fun isInputValid(): Boolean {
        if (!isInputValid(username)) {
            return false
        }
        if (!isInputValid(password)) {
            return false
        }
        return true
    }

    protected fun isInputValid(textView: TextView): Boolean {
        if (TextUtils.isEmpty(textView.text)) {
            textView.error = getString(R.string.field_mandatory)
            return false
        }
        return true
    }
}