package com.example.mobileautomation_rooster;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/* ******************TEST Scenario *******************
    Navigate to all available options in the Wallpapers App

    //******Test Case 1 : Open and close the Phone App
    1. Open All apps menu
    2. Search Wallpapers App in apps list
    3. Return back to Home screen
*/
@RunWith(AndroidJUnit4.class)
public class Mst_Wallpapers extends Utility_Functions{
    private UiDevice device;
    @Before
    public void setUp() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

    }
    @Test
    public void Operation_Open_and_close_Wallpapers_App() throws Exception {
        // Context of the app under test.

        int i;

        for(i=1; i<= openclose_MessagesApp_Loop; i++) {
            openClose_Apps("Wallpapers");
            System.out.println(" **********************Open and close Wallpapers App " + i);
        }}
}
