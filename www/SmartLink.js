
var exec = require('cordova/exec');
var SmartLink = {};
SmartLink.getExtra = function(success, error, args) {
    exec(success, error, "SmartLink", "getExtra", args);
}

module.exports = SmartLink;