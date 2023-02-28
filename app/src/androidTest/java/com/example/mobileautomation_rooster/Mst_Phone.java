    package com.example.mobileautomation_rooster;
    import androidx.test.ext.junit.runners.AndroidJUnit4;
    import androidx.test.platform.app.InstrumentationRegistry;
    import androidx.test.uiautomator.UiDevice;
    import androidx.test.uiautomator.UiObject;
    import androidx.test.uiautomator.UiSelector;

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
    public class Mst_Phone extends Utility_Functions{
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

            for(i=1; i<= openclose_PhoneApp_Loop; i++) {
                openClose_Apps("Phone");
                System.out.println(" **********************Open and close Phone App " + i);
            }}

        @Test
        public void Operation_Navigate_to_all_available_opt_in_Phone_App() throws Exception {
            // Context of the app under test.

            int i;

            for(i=1;i<=mst_Phone_loop;i++) {
                mst_Phone();
                System.out.println(" **********************Phone app Menu Structure Navigation and return to Home Screen  " + i);
            }
        }


        public void mst_Phone() throws Exception {

            try {

                //***********************************************************
                //Initializing Object Veriables
                //***********************************************************
                UiObject Phone_Opt = new UiObject(new UiSelector()
                        .description(Phone_opt_Resource_Id).description("More options"));
                UiObject Cal_Hstry = new UiObject(new UiSelector()
                        .text(Phone_opt_call_History_Text));
                UiObject Setngs = new UiObject(new UiSelector()
                        .text(Phone_opt_settings_Text));
                UiObject Hlp_n_Fdbk = new UiObject(new UiSelector()
                        .text(Phone_opt_help_Text));
                UiObject Phone_fvrts = new UiObject(new UiSelector()
                        .resourceId(Phone_Favorites_Resource_Id));
                UiObject Phone_Recent = new UiObject(new UiSelector()
                        .resourceId(Phone_Recent_Resource_Id));
                UiObject Phone_Cntacts  = new UiObject(new UiSelector()
                        .resourceId(Phone_Contacts_Resource_Id));
                UiObject Dail_Key_pad  = new UiObject(new UiSelector()
                        .resourceId(Phone_Dial_KeyPad_Resource_Id));



                //*********************************************************
                //Open Phone app and navigate to Options and return back to Home screen
                //************************************************************
                ufMenu_srch_App("Phone");

                Phone_Opt.click();//click on 3dot options element
                Cal_Hstry.click();
                device.pressBack();
                Phone_Opt.click();//click on 3dot options element
                Setngs.click();
                device.pressBack();
                Phone_Opt.click();//click on 3dot options element
                Hlp_n_Fdbk.click();
                device.pressBack();
                Phone_Cntacts.click();
                Phone_fvrts.click();
                Phone_Recent.click();
                Dail_Key_pad.click();
                device.pressBack();
                device.pressBack();
                device.pressHome();
                System.out.println("Returned To the Home Screen");

                Thread.sleep(3000);

                System.out.println("**********************Test Case - Navigate to all option in the Phone App - PASS ********************");
            } catch (Exception e) {

                //device.takeScreenshot( );
                e.printStackTrace();
                System.out.println("**********************Test Case - Navigate to all option in the Phone App - FAILED ********************");
                device.pressBack();
                device.pressHome();
            }

        }
    }
