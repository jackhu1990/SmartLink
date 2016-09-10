package com.nodehope.cordova.plugins.smartlink;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

public class SmartLink extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
            throws JSONException {
        if (action.equals("startLink")) {
            String ssid = args.getString(0);
            String password = args.getString(1);
            if (ssid.equals("wifi")) {
                callbackContext.success(ssid);
            } else {
                callbackContext.error(password);
            }
            return true;
        }
        return false;
    }
}