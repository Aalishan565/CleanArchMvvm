package com.example.cleanarchmvvm.utils

import android.text.TextUtils

/**
 * Created by Aalishan Ansari on 29/03/23.
 */
object ValidationUtil {

    fun isValidInput(input: String): Boolean {
        return if (!TextUtils.isEmpty(input)) return true else false
    }
}