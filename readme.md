##使用方式

###安装
```
cordova plugin add https://github.com/jackhu1990/SmartLink.git
```
    
###代码使用
```
        $scope.testCordova = function () {
            SmartLink.getExtra(
                function (data) {
                    alert(data.res)
                },
                function (data) {
                    alert(data.res)
                },15
            )
        }
```

