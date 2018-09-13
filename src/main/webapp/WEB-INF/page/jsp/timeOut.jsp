<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>" />
<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<style type="text/css">
</style>
</head>

<body onload="skip();">
	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h2>服务超时，请重新登录。</h2>
			<p>
				<span id="skip"></span>秒钟之后，自动跳转
			</p>
			<p>
				<a href="http://erp.bizpartner.cn/drp" target="_top"
					class="btn btn-primary btn-large">点此返回首页</a>
			</p>
		</div>
	</div>

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script type="text/javascript">
		var i = 4;
		function skip() {
			i -= 1;
			document.getElementById('skip').innerHTML = i;
			if (i == 1) {
				top.location.href = 'http://erp.bizpartner.cn/drp';
			}
			window.setTimeout("skip()", 1000);
		}
	</script>
</body>
</html>