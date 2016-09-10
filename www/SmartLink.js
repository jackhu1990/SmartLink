function SmartLink() {
}

SmartLink.prototype.startLink = function (successCallback, errorCallback, wifi, password) {
    cordova.exec(successCallback, errorCallback, "SmartLink", "startLink", [wifi, password]);
};
SmartLink.prototype.getWifiInfo = function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "SmartLink", "getWifiInfo", []);
};

SmartLink.install = function () {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.smartlink = new SmartLink();

    return window.plugins.smartlink;
};

cordova.addConstructor(SmartLink.install);