package com.example.mobileautomation_rooster;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
public class Mst_Camera extends Utility_Functions{
    private UiDevice device;
    @Before
    public void setUp() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

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


}
