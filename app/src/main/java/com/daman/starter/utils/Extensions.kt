package com.daman.starter.utils

import android.content.Context
import android.content.res.Resources
import android.widget.Toast

fun String.Companion.empty(): String = ""

fun String.toast(context: Context) = Toast.makeText(context, this, Toast.LENGTH_LONG).show()

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()