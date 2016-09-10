package com.nodehope.cordova.plugins.smartlink;

import com.hiflying.smartlink.ISmartLinker;
import com.hiflying.smartlink.OnSmartLinkListener;
import com.hiflying.smartlink.SmartLinkedModule;
import com.hiflying.smartlink.v7.MulticastSmartLinker;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;


public class SmartLink extends CordovaPlugin implements OnSmartLinkListener{
    //连接控制器
    protected ISmartLinker mSnifferSmartLinker;
    //回调上下文
    protected CallbackContext mCallbackContext;

    @Override
    public void onLinked(final SmartLinkedModule module) {
        mCallbackContext.success(module.getMac());
    }
    @Override
    public void onCompleted() {
    }
    @Override
    public void onTimeOut() {
        mCallbackContext.error("未连接成功,超时");
    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mSnifferSmartLinker.setOnSmartLinkListener(null);
//        mSnifferSmartLinker.stop();
//    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
            throws JSONException {

        mSnifferSmartLinker = MulticastSmartLinker.getInstance();
        mCallbackContext = callbackContext;
        Context context = this.cordova.getActivity().getApplicationContext();

        if (action.equals("startLink")) {
            String ssid = args.getString(0);
            String password = args.getString(1);
            //设置要配置的ssid 和pswd
            try {
                mSnifferSmartLinker.setOnSmartLinkListener(SmartLink.this);
                //开始 smartLink
                mSnifferSmartLinker.start(context, password.trim(), ssid.trim());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                mCallbackContext.error("连接wifi时出现异常");
            }
            return true;
        }
        else if (action.equals("getWifiInfo")) {
            WifiManager wm = (WifiManager)this.cordova.getActivity().getSystemService(Context.WIFI_SERVICE);
            if (wm !=null) {
                WifiInfo wi = wm.getConnectionInfo();
                String ssid = wi.getSSID();
                mCallbackContext.success(ssid);
            } else {
                mCallbackContext.error("未连接wifi,请连接");
            }
            return true;
        }
        else if (action.equals("isSmartLinking")) {
            if ( mSnifferSmartLinker.isSmartLinking()) {
                mCallbackContext.success("连接中");
            } else {
                mCallbackContext.error("未连接中");
            }
            return true;
        }
        return false;
    }
}