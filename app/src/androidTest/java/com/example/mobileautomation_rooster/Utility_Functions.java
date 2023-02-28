    package com.example.mobileautomation_rooster;

    import androidx.test.platform.app.InstrumentationRegistry;
    import androidx.test.uiautomator.UiDevice;
    import androidx.test.uiautomator.UiObject;
    import androidx.test.uiautomator.UiSelector;

    public class Utility_Functions extends Device_Variables{
        private UiDevice device;
        // UiDevice device1;
        public void DeviceInit() throws Exception {

            device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
            device.pressHome();

        }
        public void ufMenu_srch_App(String AppName) throws Exception {
            try {

                UiObject device_main_menu_Key = new UiObject(new UiSelector()
                        .resourceId(all_Apps_Menu_Resource_Id));//Frontier Veriable Values are present in Device_Veriable Class

                UiObject search_App = new UiObject(new UiSelector()
                        .resourceId(Search_Apps_Resource_Id));//Frontier


                UiObject click_on_App = new UiObject(new UiSelector()
                        .className("android.widget.TextView").index(0));//Frontier
                UiObject click_on_App1 = new UiObject(new UiSelector()
                        .className("android.widget.TextView").text("Settings"));//Frontier


                Thread.sleep(2000);
                device_main_menu_Key.click();
                Thread.sleep(2000);
                search_App.setText(AppName);
                Thread.sleep(2000);

                if (click_on_App1.exists()) {
                    click_on_App1.click();
                    Thread.sleep(2000);
                } else {
                    click_on_App.click();
                    Thread.sleep(2000);
                }

                System.out.println("*************************" + AppName + " Application found **************************");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("*************************" + AppName + " Application not found ****************************");


            }
        }

            public void clear_Recent_Apps() {
                try {

                    UiObject clr_all_rcnt_apps = new UiObject(new UiSelector()
                            .resourceId(clr_All_rcnt_Apps_resource_Id).text("CLEAR ALL"));
                    UiObject scroll_down_to_get_Clear_all = new UiObject(new UiSelector()
                            .className(recent_App_scroll_View_Class));

                    scroll_down_to_get_Clear_all.swipeDown(3);
                    Thread.sleep(1000);

                     if (clr_all_rcnt_apps.exists()) {
                         clr_all_rcnt_apps.click();
                        Thread.sleep(2000);
                    } else {
                        device.pressBack();
                        Thread.sleep(2000);
                    }

                    //System.out.println("*************************" + AppName + " Application found **************************");

                } catch (Exception e) {
                    e.printStackTrace();
                    //System.out.println("*************************" + AppName + " Application not found ****************************");


                }


            }

        public void openClose_Apps(String str) throws Exception {
            try {
                DeviceInit();
                //***********************************************************
                //Open the Messages App and return to the Home Screen
                //************************************************************

                device.pressBack();
                device.pressHome();

                ufMenu_srch_App(str);

                device.pressBack();
                device.pressHome();

                Thread.sleep(3000);
                System.out.println("**********************Open and close Messages app - PASS ********************");

            }catch (Exception e) {

                //device.takeScreenshot( );
                e.printStackTrace();
                System.out.println("**********************Open and close Messages app - FAILED********************");
                device.pressBack();
                device.pressHome();
            }
        }


    }

