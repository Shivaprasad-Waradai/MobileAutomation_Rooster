package com.example.mobileautomation_rooster;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/* ******************TEST Scenario *******************
    Navigate to all available options in the Phone App

    //******Test Case 1 : Open and close the Phone App
    1. Open All apps menu
    2. Search Phone App in apps list
    3. Return back to Home screen
    //*******Test Case 2 : Open the Phone App and Navigate to all the options in the Phone App
    1. Open All apps menu
    2. Search Phone App in apps list
    3. Click on Phone App
    4. Navigate to Options > tap on Call History and return back to Phone app
    5. Navigate to Options > tap on Settings and return back to Phone App
    6. Navigate to Options > tap on Help and Feedback option then return back to Phone App
    7. Navigate to Contacts Tab
    8. Navigate to Favorites Tab
    9. Navigate to Recent Tab
    10. Return back to Home screen
 */
@RunWith(AndroidJUnit4.class)
public class Mst_Clock extends Utility_Functions{
    private UiDevice device;
    @Before
    public void setUp() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

    }
    @Test
    public void Operation_Open_and_close_Clock_App() throws Exception {
        // Context of the app under test.

        int i;

        for(i=1; i<= openclose_ClockApp_Loop; i++) {
            openClose_Apps("Clock");
            System.out.println(" **********************Open and close Clock App " + i);
        }}


}
