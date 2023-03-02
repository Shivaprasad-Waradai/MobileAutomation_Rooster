package com.example.mobileautomation_rooster;

import android.util.Log;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

public class Camera {
    private static final String TAG = "camera";
    private UiDevice mUiDevice;
    private static final String CAMERA_PACKAGE_NAME = "com.hmdglobal.camera2";
    private static final String VIDEO_BUTTON_TEXT = "Video";
    private static final String RECORD_VIDEO_BUTTON_ID = "com.hmdglobal.camera2:id/shutter_button";
    private static final String VIDEO_CONTENT_BUTTON_ID = "com.hmdglobal.camera2:id/rounded_thumbnail_container";
    private static final String VIDEO_PLAY_BUTTON_ID = "com.google.android.apps.photos:id/photos_videoplayer_play_button";

    public Camera(UiDevice uiDevice) {
        this.mUiDevice = uiDevice;
    }

    public boolean recordVideo(int recordDuration) throws Exception {
        Log.i(TAG, "started:  record "+ recordDuration/1000 +" seconds video");
        mUiDevice.pressBack();
        mUiDevice.pressHome();
        boolean result = true;

        if (Util.clickByDesc(mUiDevice, "Apps list") &&
                Util.clickByText(mUiDevice, "Camera"))
        {

            //Switch to Video recorder
            Util.clickByText(mUiDevice, VIDEO_BUTTON_TEXT);

            //start record video
            //Util.waitForWindowUpdate(mUiDevice, CAMERA_PACKAGE_NAME);
            Util.clickByID(mUiDevice, RECORD_VIDEO_BUTTON_ID);

            //record 30 seconds
            Thread.sleep(recordDuration);

            //stop record video
            Util.clickByID(mUiDevice, RECORD_VIDEO_BUTTON_ID);
            Util.waitForWindowUpdate(mUiDevice, CAMERA_PACKAGE_NAME);

            Log.i(TAG, "finished: record "+ recordDuration/1000 +" seconds video successfully");
        } else {
            Log.i(TAG, "finished: record "+ recordDuration/1000 +" seconds video failed");
            result = false;
        }

        mUiDevice.pressBack();
        mUiDevice.pressHome();
        return result;
    }

    public boolean playVideo(int playDuration) throws Exception {
        Log.i(TAG, "started:  play "+ playDuration/1000 +" seconds video");
        mUiDevice.pressBack();
        mUiDevice.pressHome();
        boolean result = true;


        if (Util.clickByDesc(mUiDevice, "Apps list") &&
                Util.clickByText(mUiDevice, "Camera")
        ) {
            //Click play button
            Util.waitForWindowUpdate(mUiDevice, CAMERA_PACKAGE_NAME);
            Util.clickByID(mUiDevice, VIDEO_CONTENT_BUTTON_ID);
            Util.clickByID(mUiDevice, VIDEO_PLAY_BUTTON_ID);

            //Check the player select option
            Util.waitForWindowUpdate(mUiDevice, CAMERA_PACKAGE_NAME);
            UiObject2 photos = null;
            photos = mUiDevice.findObject(By.text("Photos"));
            if (null != photos) {
                photos.click();
            }

            //Select JUST ONCE option.
            Util.waitForWindowUpdate(mUiDevice, CAMERA_PACKAGE_NAME);
            Util.clickByText(mUiDevice, "JUST ONCE");

            //Wait 30 seconds
            Thread.sleep(playDuration);
            Log.i(TAG, "finished: play "+ playDuration/1000 +" seconds video successfully");
        } else {
            Log.i(TAG, "finished: play "+ playDuration/1000 +" seconds video failed");
            result = false;
        }

        //Back to the idle from the video playback interface, need 3 pressback.
        mUiDevice.pressBack();
        mUiDevice.pressBack();
        mUiDevice.pressBack();
        mUiDevice.pressHome();
        return result;
    }

    public boolean deleteVideos(int deleteNumber) throws Exception {
        Log.i(TAG, "started:  delete "+ deleteNumber +" videos");
        mUiDevice.pressBack();
        mUiDevice.pressHome();
        boolean result = true;

        if (Util.clickByDesc(mUiDevice, "Apps list") &&
                Util.clickByText(mUiDevice, "Camera") &&
                Util.clickByID(mUiDevice, VIDEO_CONTENT_BUTTON_ID)) {

            for (int i = 0; i < deleteNumber;) {
                i++;

                //Click the delete button
                Util.waitForWindowUpdate(mUiDevice, CAMERA_PACKAGE_NAME);
                UiObject2 delete = null;
                delete = mUiDevice.findObject(By.desc("Bin"));

                if (null != delete)
                {
                    delete.click();
                    Util.clickByText(mUiDevice, "Move to Bin");
                    Log.i(TAG, "deleted "+ i +" videos");
                } else {
                    //There are no more videos to delete
                    Log.i(TAG, "finished: there are no more videos to delete");
                    Util.waitForWindowUpdate(mUiDevice, CAMERA_PACKAGE_NAME);
                    mUiDevice.pressBack();
                    mUiDevice.pressHome();
                    return true;
                }
            }

            Util.waitForWindowUpdate(mUiDevice, CAMERA_PACKAGE_NAME);
            Log.i(TAG, "finished: delete "+ deleteNumber +" videos successfully");
        } else {
            Log.i(TAG, "finished: delete "+ deleteNumber +" videos failed");
            result = false;
        }

        mUiDevice.pressBack();
        mUiDevice.pressHome();
        return result;
    }
}