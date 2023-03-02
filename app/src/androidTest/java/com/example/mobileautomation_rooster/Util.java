package com.example.mobileautomation_rooster;

import android.util.Log;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiSelector;

/**
 * common interface
 * added Some function for performing the actions depending on the elements locators
 *
 */

public class Util {
    private static final String TAG = "Util";
    private static final int CLICK_ID   = 1000;
    private static final int CLICK_DESC = 1001;
    private static final int CLICK_TEXT = 1002;
    private static final int WAIT_TIMES = 5;
    private static final int TIME_OUT = 5 * 1000;

    public static boolean clickByID(UiDevice uiDevice, String id) throws Exception {
        return clickByInfo(uiDevice, CLICK_ID, id);
    }

    public static boolean clickByDesc(UiDevice uiDevice, String desc) throws Exception {
        return clickByInfo(uiDevice, CLICK_DESC, desc);
    }

    public static boolean clickByText(UiDevice uiDevice, String text) throws Exception {
        return clickByInfo(uiDevice, CLICK_TEXT, text);
    }

    public static void waitForWindowUpdate(UiDevice uiDevice, String packageName) {
        uiDevice.waitForWindowUpdate(packageName, TIME_OUT);
    }

    private static UiObject findObjectEx(UiDevice uiDevice, UiSelector selector) throws Exception {
        UiObject uiObject = null;

        Thread.sleep(500);
        uiObject = uiDevice.findObject(selector);
        int waitTimes = 0;

        while ((null == uiObject || !uiObject.exists()) && waitTimes < WAIT_TIMES) {
            waitTimes++;
            Log.d(TAG, "can not find uiObject, sleep 500ms, waitTimes:"+waitTimes);

            Thread.sleep(500);
            uiObject = uiDevice.findObject(selector);
        }

        if (null != uiObject && !uiObject.exists()) {
            Log.e(TAG, "slept "+WAIT_TIMES*500+" still can not find uiObject");
        }

        return uiObject;
    }

    private static UiObject2 findObjectEx(UiDevice uiDevice, BySelector selector) throws Exception {
        UiObject2 uiObject2 = null;

        Thread.sleep(500);
        uiObject2 = uiDevice.findObject(selector);
        int waitTimes = 0;

        while (null == uiObject2 && waitTimes < WAIT_TIMES) {
            waitTimes++;
            Log.d(TAG, "can not find uiObject2, sleep 500ms, waitTimes:"+waitTimes);

            Thread.sleep(500);
            uiObject2 = uiDevice.findObject(selector);
        }

        if (null == uiObject2) {
            Log.e(TAG, "slept "+WAIT_TIMES*500+" still can not find uiObject2");
        }

        return uiObject2;
    }

    private static boolean clickByInfo(UiDevice uiDevice, int CLICK, String info) throws Exception {
        UiObject uiObject = null;
        UiObject2 uiObject2 = null;

        switch (CLICK) {
            case CLICK_ID:
            {
                uiObject = findObjectEx(uiDevice, new UiSelector().resourceId(info));
                break;
            }

            case CLICK_DESC:
            {
                uiObject2 = findObjectEx(uiDevice, By.desc(info));
                break;
            }

            case CLICK_TEXT:
            {
                uiObject2 = findObjectEx(uiDevice, By.text(info));
                break;
            }

            default:
                return false;
        }

        if (CLICK_ID == CLICK && null != uiObject && !uiObject.exists()) {
            Log.e(TAG, "can not find uiObject: "+info);
            return false;
        } else if (CLICK_ID != CLICK && null == uiObject2) {
            Log.e(TAG, "can not find uiObject2: "+info);
            return false;
        }

        if (null != uiObject && uiObject.exists()) {
            uiObject.click();
        }

        if (null != uiObject2) {
            uiObject2.click();
        }

        return true;
    }
}