package com.example.mobileautomation_rooster;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/* ******************TEST Scenario *******************
    Navigate to all available options in the FM Radio

    //******Test Case 1 : Open and close the FM Radio
    1. Open All apps menu
    2. Search FM Radio in apps list
    3. Return back to Home screen


 */
@RunWith(AndroidJUnit4.class)
public class Mst_FM_Radio extends Utility_Functions{
    private UiDevice device;
    @Before
    public void setUp() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

    }
    @Test
    public void Operation_Open_and_close_Phone_App() throws Exception {
        // Context of the app under test.

        int i;

        for(i=1;i<=openclose_FMRadioApp_Loop;i++) {
            openClose_Apps("FM Radio");
            System.out.println(" **********************Open and close FM Radio App " + i);
        }}


}
