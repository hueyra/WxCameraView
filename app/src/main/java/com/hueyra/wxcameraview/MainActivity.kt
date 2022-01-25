package com.hueyra.wxcameraview

import android.Manifest
import android.widget.TextView
import android.os.Bundle
import com.permissionx.guolindev.PermissionX
import android.widget.Toast
import android.app.Activity
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.github.hueyra.wxcamera.WxCamera
import com.github.hueyra.wxcamera.entity.LocalMedia

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mResult: TextView

    //选择学员
    private val mCameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            val media: LocalMedia? =
                WxCamera.obtainResult(activityResult.resultCode, activityResult.data)
            if (media != null) {
                mResult.text = media.realPath
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_both).setOnClickListener(this)
        findViewById<View>(R.id.btn_img).setOnClickListener(this)
        findViewById<View>(R.id.btn_vid).setOnClickListener(this)
        mResult = findViewById(R.id.result)
    }

    override fun onClick(v: View) {

        val cameraBuilder = WxCamera.Builder()

        when (v.id) {
            R.id.btn_both -> cameraBuilder.cameraBoth()
            R.id.btn_img -> cameraBuilder.cameraOnlyIMG()
            R.id.btn_vid -> cameraBuilder.cameraOnlyVID()
        }
        PermissionX.init(this).permissions(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA
        )
            .request { allGranted: Boolean, _: List<String?>?, _: List<String?>? ->
                if (allGranted) {

                    mCameraLauncher.launch(cameraBuilder.build().newIntent(this))
                    overridePendingTransition(
                        R.anim.wxc_anim_up_in,
                        R.anim.wxc_anim_fade_out
                    )
                } else {
                    Toast.makeText(this, "请授权", Toast.LENGTH_SHORT).show()
                }
            }
    }
}