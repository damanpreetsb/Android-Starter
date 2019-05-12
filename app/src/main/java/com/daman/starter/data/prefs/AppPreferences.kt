package com.daman.starter.data.prefs

import android.content.SharedPreferences
import com.daman.starter.utils.PREF_NAME
import com.daman.starter.utils.PREF_USER_ID
import com.daman.starter.utils.empty

class AppPreferences(private val preferences: SharedPreferences) : AppSettings {
    override fun getString(key: String): String =
        preferences.getString(key, String.empty()) ?: String.empty()

    override fun set(key: String, value: String) {
        preferences.edit { it.putString(key, value) }
    }

    override fun getBoolean(key: String): Boolean =
        preferences.getBoolean(key, false)

    override fun set(key: String, value: Boolean) {
        preferences.edit { it.putBoolean(key, value) }
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
}
