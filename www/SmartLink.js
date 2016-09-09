var exec = require('cordova/exec');

exports.getExtra = function(success, error) {
    exec(success, error, "SmartLink", "getExtra", []);
};