package com.daman.starter.data.prefs

interface AppSettings {
    fun getString(key: String): String
    fun set(key: String, value: String)
    fun getBoolean(key: String): Boolean
    fun set(key: String, value: Boolean)
}
