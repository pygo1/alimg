<!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Amaze UI Admin index Examples</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="/static/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/static/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/static/assets/css/amazeui.min.css" />
  <link rel="stylesheet" href="/static/assets/css/app.css">
  <link rel="stylesheet" href="/static/assets/css/admin.css">
</head>

<body data-type="login">

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				Alimg Admin<span> Login</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="login-font">
			<i>Log In ~</i>
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form class="am-form" onsubmit="return false">
				<fieldset>
					<div class="am-form-group">
						<input type="text" name="email" value="" class="" id="doc-ipt-email-1" placeholder="输入用户名">
					</div>
					<div class="am-form-group">
						<input type="password" name="password" value="" class="" id="doc-ipt-pwd-1" placeholder="输入密码">
					</div>
					<p><button id="submit" class="am-btn am-btn-default">登录</button></p>
				</fieldset>
			</form>
		</div>
	</div>
</div>

  <script src="/static/assets/js/jquery.min.js"></script>
  <script src="/static/assets/js/amazeui.min.js"></script>
  <script src="/static/assets/js/app.js"></script>
  <script src="/static/js/ajax.js"></script>
  <script>
	$(function(){
        $("#submit").on("click",function(){

            getdataAjax({
                methods:"POST",
                url:"/login/checkUser",
                params:{
                    email:$("input[name='email']").val(),
                    password:$("input[name='password']").val()
                },
                context:this,
                success:function(param,res) {
                    var data = res.data;
                    if(data.state == 1){
                        window.location.href ="/admin"
					}else{
                        //处理登录错误
					}
                },
                done:function () {
                    alert();
                }

            })

		});
	})
  </script>
</body>

</html>