package me.chizobaogbonna.calllistener

import android.os.Build
import android.telecom.Call
import android.telecom.CallScreeningService
import android.util.Log

class MyCallScreeningService : CallScreeningService() {
    override fun onScreenCall(callDetails: Call.Details) {
        Log.d("TEST", "onScreenCall")
        if (
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
            callDetails.callDirection == Call.Details.DIRECTION_INCOMING
        ) {
            Log.d("Phone number", callDetails.handle.toString())
            respondToCall(callDetails, CallResponse.Builder().build())
        }
    }
}