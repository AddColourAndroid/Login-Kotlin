package addcolour.co.za.loginkotlin.helper

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class PreferencesHelper {

    companion object {

        val TAG = PreferencesHelper::class.java.simpleName
        private val PREFERENCES = "LOGIN_KOTLIN_PREFS"

        private val PREFS_KEY_USERNAME = "KEY_USERNAME"
        private val PREFS_KEY_PASSWORD = "KEY_PASSORD"

        private fun getSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        }

        private fun getStringPreference(context: Context, key: String): String? {
            return getSharedPreferences(context).getString(key, null)
        }

        private fun setStringPreference(context: Context, key: String, value: String) {
            val sharedPreferences = getSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putString(key, value)
            if (!editor.commit()) {
                Log.e(TAG, "FAILED to store preference!")
            }
        }

        fun getUsername(context: Context): String? {
            return getStringPreference(context, PREFS_KEY_USERNAME)
        }

        fun setUsername(context: Context, username: String?) {
            if (username != null) {
                setStringPreference(context, PREFS_KEY_USERNAME, username)
            }
        }

        fun getPassword(context: Context): String? {
            return getStringPreference(context, PREFS_KEY_PASSWORD)
        }

        fun setPassword(context: Context, password: String?) {
            if (password != null) {
                setStringPreference(context, PREFS_KEY_PASSWORD, password)
            }
        }
    }
}