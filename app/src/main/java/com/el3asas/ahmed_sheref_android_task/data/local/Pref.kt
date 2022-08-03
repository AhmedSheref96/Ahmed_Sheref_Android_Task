package com.el3asas.ahmed_sheref_android_task.data.local

import android.app.Application
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Pref @Inject constructor(context: Application) {

    val userToken: String = "Ahmed Sheref Token"
    private val pref by lazy { context.getSharedPreferences("MedicalApp", 0) }

    private val LOGIN_KEY = "isLogin"
    private val USER_NAME_KEY = "userNameKey"
    private val TOKEN_KEY = "tokenKey"


    var isUserLogin: Boolean = false
        get() = pref.getBoolean(LOGIN_KEY, false)
        set(value) {
            field = value
            pref.edit().putBoolean(LOGIN_KEY, value).apply()
        }

    var userName: String = ""
        get() = pref.getString(USER_NAME_KEY, "") ?: ""
        set(value) {
            field = value
            pref.edit().putString(USER_NAME_KEY, value).apply()
        }


    var token: String = ""
        get() = pref.getString(TOKEN_KEY, "") ?: ""
        set(value) {
            field = value
            pref.edit().putString(TOKEN_KEY, value).apply()
        }

    fun clearAll() {
        token = ""
        userName = ""
        isUserLogin = false
    }

}