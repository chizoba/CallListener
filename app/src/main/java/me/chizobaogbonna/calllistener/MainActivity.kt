package me.chizobaogbonna.calllistener

import android.app.Activity
import android.app.role.RoleManager
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val REQUEST_CODE = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestRole()
    }

    private fun requestRole() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val roleManager = getSystemService(ROLE_SERVICE) as RoleManager
            val intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_CALL_SCREENING)
            startActivityForResult(intent, REQUEST_CODE)
        } else {
            // if (
            //     applicationContext.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) !=
            //     PackageManager.PERMISSION_GRANTED
            // ) {
            //     ActivityCompat.requestPermissions(
            //         this,
            //         arrayOf(Manifest.permission.READ_PHONE_STATE),
            //         REQUEST_CODE,
            //     )
            // }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                // Your app is now the call screening app
                Log.d("TEST", "Role attained")
            } else {
                // Your app is not the call screening app
                Log.d("TEST", "failed to attain role")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
