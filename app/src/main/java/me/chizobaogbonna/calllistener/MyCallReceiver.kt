package me.chizobaogbonna.calllistener

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast

class MyCallReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (
            // Build.VERSION.SDK_INT < Build.VERSION_CODES.Q &&
            intent.action == "android.intent.action.PHONE_STATE" &&
            intent.hasExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
        ) {
            val phoneNumber =
                intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER).toString()

            val message = context.getString(R.string.message, phoneNumber)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            Log.d("Phone number", phoneNumber)
        }
    }
}