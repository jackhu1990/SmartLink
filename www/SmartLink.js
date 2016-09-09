var exec = require('cordova/exec');

var smartLink = function () {}

smartLink.getExtra = function(args, success, error) {
    exec(success, error, "SmartLink", "getExtra", args);
};

module.exports = smartLink;
