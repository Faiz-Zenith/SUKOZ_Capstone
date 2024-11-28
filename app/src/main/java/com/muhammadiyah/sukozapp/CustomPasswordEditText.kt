package com.muhammadiyah.sukozapp

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged

@SuppressLint("AppCompatCustomView")
class CustomPasswordEditText : EditText {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        this.doAfterTextChanged { text ->
            if (text != null && text.length < 5) {
                error = context.getString(R.string.password_error)
            }
        }
    }
}
