package com.example.mobileautomation_rooster;

import androidx.annotation.RequiresPermission;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/* ******************TEST Scenario *******************
    Navigate to all available options in the Settings

    //******Test Case 1 : Open and close the Settings App
    1. Open All apps menu
    2. Search Settings in apps list
    3. Return back to Home screen
    4. adding comment to check git commit
 */
/*

    //*******Test Case 2 : Open the Settings and Navigate to all the options in the Phone App
        1.
        2.
 */

@RunWith(AndroidJUnit4.class)
public class Mst_Settings extends Utility_Functions {
    private UiDevice device;

    @Before
    public void setUp() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

    }

    @Test
    public void Operation_Open_and_close_Settings() throws Exception {
        // Context of the app under test.

        int i;
        for (i = 1; i <= openClose_Settings_Loop; i++) {
            openClose_Apps("Settings");
            System.out.println(" **********************Open and close Settings App " + i);
        }
    }

    @Test
    public void Operation_Naviagate_Settings_menu_list() throws Exception {
        // Context of the app under test.

        int i;
        for (i = 1; i <=mst_settings_loop; i++) {
            mst_Settings();
            System.out.println(" **********************Open and close Settings App " + i);
        }
    }



    public void mst_Settings() throws Exception {
        try {

            //***********************************************************
            //Object initialization
            //***********************************************************
            UiObject Settings_drag = new UiObject(new UiSelector()
                    .resourceId(Setting_Dashboard_container_Resource_Id));
            UiObject Network_Internet = new UiObject(new UiSelector()
                    .text(Settings_Ntwrk_n_Internet_Text));
            UiObject Connected_Dev = new UiObject(new UiSelector()
                    .text(Settings_Connected_Devices_Text));
            UiObject Apps_Notifi = new UiObject(new UiSelector()
                    .text(Settings_App_Notification_Text));
            UiObject Battery = new UiObject(new UiSelector()
                    .text(Settings_Battery_Text));
            UiObject Display = new UiObject(new UiSelector()
                    .text(Settings_Display_Text));
            UiObject Sound  = new UiObject(new UiSelector()
                    .text(Settings_Sound_Text));

            UiObject Security_Location  = new UiObject(new UiSelector()
                    .resourceId(Settings_Security_Location_Text));
            UiObject User_Acc  = new UiObject(new UiSelector()
                    .resourceId(Settings_User_Acc_Text));
            UiObject Accessibility  = new UiObject(new UiSelector()
                    .resourceId(Settings_Accessibility_Text));
            UiObject Google  = new UiObject(new UiSelector()
                    .resourceId(Settings_Google_Text));
            UiObject Dev_System  = new UiObject(new UiSelector()
                    .resourceId(Settings_System_Text));
            UiObject Storage  = new UiObject(new UiSelector()
                    .resourceId(Settings_Storage_Text));



            //***********************************************************
            //Open Settings and return to the Home Screen
            //************************************************************

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Settings");
            Settings_drag.swipeDown(2);
            Network_Internet.click();
            device.pressBack();
            Connected_Dev.waitForExists(1000);
            Connected_Dev.click();
            device.pressBack();
            Apps_Notifi.waitForExists(1000);
            Apps_Notifi.click();
            device.pressBack();
            Battery.waitForExists(1000);
            Battery.click();
            device.pressBack();
            Display.waitForExists(1000);
            Display.click();
            device.pressBack();
            Sound.waitForExists(1000);
            Sound.click();
            device.pressBack();
            Storage.waitForExists(1000);
            Storage.click();
            device.pressBack();
            Security_Location.waitForExists(1000);
            Security_Location.click();
            device.pressBack();
            User_Acc.waitForExists(1000);
            User_Acc.click();
            device.pressBack();
            Accessibility.waitForExists(1000);
            Accessibility.click();
            device.pressBack();
            Google.waitForExists(1000);
            Google.click();
            device.pressBack();
            Dev_System.waitForExists(1000);
            Dev_System.click();
            device.pressBack(); Thread.sleep(1000);

            Thread.sleep(3000);
            System.out.println("**********************Open and close Phone app - PASS ********************");




        } catch (Exception e) {

            //device.takeScreenshot( );
            e.printStackTrace();
            System.out.println("**********************Open and close Phone app - FAILED********************");
            device.pressBack();
            device.pressHome();
        }
    }
}
