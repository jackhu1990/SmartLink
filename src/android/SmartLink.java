package com.nodehope.ecloud.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

public class SmartLink extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) 
            throws JSONException {
        if (action.equals("getExtra")) {
            long i = args.getLong(0);
            if (i==27) {
                callbackContext.success("³É¹¦"));
            } else {
                callbackContext.error("´íÎó");
            }
            return true;
        }
        return false;
    }
}