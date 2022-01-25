package com.github.hueyra.wxcamera;

import static android.app.Activity.RESULT_OK;
import static com.github.hueyra.wxcamera.app.WxCameraConfig.REQUEST_CAMERA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.github.hueyra.wxcamera.app.WxCameraConfig;
import com.github.hueyra.wxcamera.entity.LocalMedia;
import com.github.hueyra.wxcamera.ui.WxCameraActivity;

public class WxCamera {
    private int mType;
    private boolean mCrop;

    private WxCamera() {
    }

    private WxCamera(Builder builder) {
        mType = builder.type;
        mCrop = builder.crop;
    }

    public static final class Builder {
        private int type;
        private boolean crop;

        public Builder() {
            type = WxCameraConfig.BUTTON_STATE_BOTH;
            crop = false;
        }

        public Builder cameraBoth() {
            type = WxCameraConfig.BUTTON_STATE_BOTH;
            return this;
        }

        public Builder cameraOnlyIMG() {
            type = WxCameraConfig.BUTTON_STATE_ONLY_CAPTURE;
            return this;
        }

        public Builder cameraOnlyVID() {
            type = WxCameraConfig.BUTTON_STATE_ONLY_RECORDER;
            return this;
        }

//        public Builder cropIMG() {
//            crop = true;
//            return this;
//        }

        public WxCamera build() {
            return new WxCamera(this);
        }
    }

    public void openCamera(Activity activity) {
        activity.startActivityForResult(newIntent(activity), REQUEST_CAMERA);
        activity.overridePendingTransition(R.anim.wxc_anim_up_in, R.anim.wxc_anim_fade_out);
    }

    public Intent newIntent(Context context) {
        Intent intent = new Intent(context, WxCameraActivity.class);
        intent.putExtra("type", mType);
        intent.putExtra("crop", mCrop);
        return intent;
    }

    public static LocalMedia obtainResult(Intent data) {
        if (data != null && data.hasExtra("result")) {
            return data.getParcelableExtra("result");
        } else {
            return null;
        }
    }

    public static LocalMedia obtainResult(int resultCode, Intent data) {
        if (resultCode == RESULT_OK && data != null && data.hasExtra("result")) {
            return data.getParcelableExtra("result");
        } else {
            return null;
        }
    }

    public static LocalMedia obtainResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK
                && data != null && data.hasExtra("result")) {
            return data.getParcelableExtra("result");
        } else {
            return null;
        }
    }

}
