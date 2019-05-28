package com.daman.starter.core.storage

import android.content.Context
import android.content.SharedPreferences
import com.daman.starter.utils.PREF_NAME
import com.daman.starter.utils.PREF_SHARED_PREFS_NAME
import com.daman.starter.utils.PREF_USER_ID

object AppPreferences {
    private const val NAME = PREF_SHARED_PREFS_NAME
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val USER_ID = Pair(PREF_USER_ID, "")
    private val USER_NAME = Pair(PREF_NAME, "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(
            NAME,
            MODE
        )
    }

    /**
     * SharedPreferences extension function, so we won't need to call edit() and apply()
     * ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var userId: String
        // custom getter to get a preference of a desired type, with a predefined default value
        get() = preferences.getString(USER_ID.first, USER_ID.second) ?: ""

        // custom setter to save a preference back to preferences file
        set(value) = preferences.edit {
            it.putString(USER_ID.first, value)
        }

    var userName: String
        get() = preferences.getString(USER_NAME.first, USER_NAME.second) ?: ""

        set(value) = preferences.edit {
            it.putString(USER_NAME.first, value)
        }
}