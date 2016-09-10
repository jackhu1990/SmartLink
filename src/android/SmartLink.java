package com.nodehope.cordova.plugins.smartlink;

import com.hiflying.smartlink.ISmartLinker;
import com.hiflying.smartlink.OnSmartLinkListener;
import com.hiflying.smartlink.SmartLinkedModule;
import com.hiflying.smartlink.v7.MulticastSmartLinker;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class SmartLink extends CordovaPlugin {
    //连接控制器
    protected ISmartLinker mSnifferSmartLinker;

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
            throws JSONException {
        if (action.equals("startLink")) {
            String ssid = args.getString(0);
            String password = args.getString(1);
            mSnifferSmartLinker = MulticastSmartLinker.getInstance();
            //设置要配置的ssid 和pswd
            try {
                mSnifferSmartLinker.setOnSmartLinkListener(new OnSmartLinkListener(){
                    @Override
                    public void onLinked(final SmartLinkedModule module) {
                        callbackContext.success(module.getMac());
                    }
                    @Override
                    public void onTimeOut() {
                        callbackContext.error("未连接成功,超时");
                    }

                });
                //开始 smartLink
                mSnifferSmartLinker.start(getApplicationContext(), password.toString().trim(),
                        ssid.toString().trim());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                callbackContext.error("连接wifi时出现异常");
            }
            return true;
        }
        else if (action.equals("getWifiInfo")) {
            WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
            if (wm !=null) {
                WifiInfo wi = wm.getConnectionInfo();
                String ssid = wi.getSSID();
                callbackContext.success(ssid);
            } else {
                callbackContext.error("未连接wifi,请连接");
            }
            return true;
        }
        return false;
    }
}