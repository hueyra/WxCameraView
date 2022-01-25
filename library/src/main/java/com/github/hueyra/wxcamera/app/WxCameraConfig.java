package com.github.hueyra.wxcamera.app;

public class WxCameraConfig {

    public static final int REQUEST_CAMERA = 101;
    public static final int REQUEST_CROP = 102;

    public static final int BUTTON_STATE_BOTH = 0;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 1;
    public static final int BUTTON_STATE_ONLY_RECORDER = 2;

    public static final int CHECK_PERMISSION_STATE_RECORDING = -1;
    public static final int CHECK_PERMISSION_STATE_NO_PERMISSION = -2;
    public static final int CHECK_PERMISSION_STATE_SUCCESS = 1;

    public static final String EXTERNAL_FILES_DIR_NAME = "Camera";
    public final static String FILE_NAME_IMAGE_PREFIX = "IMG_";
    public final static String FILE_NAME_VIDEO_PREFIX = "VID_";

    public final static String FILE_SAVE_TYPE_IMAGE = ".jpg";
    public final static String FILE_SAVE_TYPE_VIDEO = ".mp4";

    public final static String MIME_TYPE_JPG = "image/jpg";
    public final static String MIME_TYPE_MP4 = "video/mp4";


}
