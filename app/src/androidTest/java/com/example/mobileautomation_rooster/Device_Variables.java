package com.example.mobileautomation_rooster;

public class Device_Variables {

    //************************* Utility Functions  *********************
    String clr_All_rcnt_Apps_resource_Id = "com.android.systemui:id/button"; //Clear All - Recent Apps
    String recent_App_scroll_View_Class = "android.widget.ScrollView";// Scrollable - true  -------Recent Apps
    //************************* Test Cases Loops *********************
    int mst_Phone_loop = 1;
    int openclose_PhoneApp_Loop = 1;

    int openClose_Settings_Loop = 1;
    int mst_settings_loop = 1000;

    int openclose_Camera_Loop = 1;
    int openclose_Calendar_Loop = 1;
    int openclose_ClockApp_Loop = 1;
    int openclose_FMRadioApp_Loop = 1;
    int openclose_MessagesApp_Loop = 1;

    //**********************************************
    String all_Apps_Menu_Resource_Id = "com.android.launcher3:id/all_apps_handle";
    String Search_Apps_Resource_Id = "com.android.launcher3:id/search_box_input";


    //************************ Phone App Variables **********************
    String Phone_opt_Resource_Id = "com.google.android.dialer:id/main_options_menu_button";
    String Phone_Favorites_Resource_Id = "com.google.android.dialer:id/speed_dial_tab";
    String Phone_Recent_Resource_Id = "com.google.android.dialer:id/call_log_tab";
    String Phone_Contacts_Resource_Id = "com.google.android.dialer:id/contacts_tab";
    String Phone_Dial_KeyPad_Resource_Id = "com.google.android.dialer:id/fab";
    String Phone_opt_call_History_Text = "Call history";
    String Phone_opt_settings_Text = "Settings";
    String Phone_opt_help_Text = "Help & feedback";

    //************************ Settings Variables **********************

    String Settings_Ntwrk_n_Internet_Text = "Network & Internet";
    String Settings_Connected_Devices_Text = "Connected devices";
    String Settings_App_Notification_Text = "Apps & notifications";
    String Settings_Battery_Text = "Battery";
    String Settings_Display_Text = "Display";
    String Settings_Sound_Text = "Sound";
    String Settings_Storage_Text = "Storage";
    String Settings_Security_Location_Text = "Security & location";
    String Settings_User_Acc_Text = "Users & accounts";
    String Settings_Accessibility_Text = "Accessibility";
    String Settings_Google_Text = "Google";
    String Settings_System_Text = "System";
    String Setting_Dashboard_container_Resource_Id = "com.android.settings:id/dashboard_container";

}
