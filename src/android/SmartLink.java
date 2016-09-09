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
                callbackContext.success("成功");
            } else {
                callbackContext.error("错误");
            }
            return true;
        }
        return false;
    }
}