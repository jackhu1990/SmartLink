var exec = require('cordova/exec');

var SmartLink = function () {}

SmartLink.prototype.getExtra = function(args, success, error) {
    exec(success, error, "SmartLink", "getExtra", args);
};
var smartLink = new SmartLink();
module.exports = smartLink;
