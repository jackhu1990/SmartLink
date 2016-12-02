##使用方式

###安装
```
cordova plugin add https://github.com/jackhu1990/SmartLink.git
```
    
###代码使用
```
               $scope.testCordova = function () {
                   window.plugins.smartlink.startLink(function (data) {
                       alert(data);
                   }, function (data) {
                       alert(data);
                   }, "wifi", "password")
               }
```

