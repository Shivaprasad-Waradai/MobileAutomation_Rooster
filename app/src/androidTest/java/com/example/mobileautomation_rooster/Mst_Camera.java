package com.example.mobileautomation_rooster;
import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SdkSuppress;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;


import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 21)
public class Mst_Camera extends Utility_Functions{
    private UiDevice device;
    private Camera mCamera;
    @Before
    public void setUp() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();
        //Newly Updated 02.03.2023
        if (null == device) {
            Log.e(TAG, "can't find the UiDevice");
            return;
        }
        mCamera = new Camera(device);

    }
    @Test
    public void Operation_Open_and_close_Camera() throws Exception {
        // Context of the app under test.

        int i;

        for(i=1;i<=openclose_Camera_Loop;i++) {
            openClose_Apps("Camera");

            System.out.println(" **********************Open and close Camera " + i);
        }
    }

    //Newly added code to record Video for 30 seconds...... 02.03.2023
    @Test
    public void record_video_for_30_seconds() {
        int i;
        for (i=1;i<=1;i++)
        {
            try {
                //Record a 30 seconds video
                mCamera.recordVideo(30000);
            } catch (Exception e) {
                throw new AssertionFailedError();
            }

        }

    }
    //Newly added code to play recorded Video for 30 seconds...... 02.03.2023
    @Test
    public void play_recorded_video_for_30_seconds() {
        int i;
        for(i=1;i<=1;i++) {
            try {
                //Play a 30 seconds video
                mCamera.playVideo(30000);
            } catch (Exception e) {
                throw new AssertionFailedError();
            }
        }
    }

    @Test
    public void test() {
        int i;
        for(i=1;i<=1;i++) {
            try {
                //Delete a video
                mCamera.deleteVideos(1);
            } catch (Exception e) {
                throw new AssertionFailedError();
            }
        }
    }


}
