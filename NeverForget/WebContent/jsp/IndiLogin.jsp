<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>sign in</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/IndiLogin.css" />
	
</head>
<body>
	<c:if test="${error==0}">
		<script type="text/javascript">
			alert("账号或密码输入有误");
		</script>
	</c:if>
	<div class="yemian" id ="box">
	
			<div class="head">
				<div class="circle">
					<img class="circle_img"
						src="${pageContext.request.contextPath}/statics/images/touxiang.jpg"
						alt="头像" />
				</div>
			</div>
			<div class="body">
				<div class="middle">

					<h3 align="center">Sign in to Things</h3>

					<div class="body_content">
						<form method="post" action="login.action">
							<label for="login_field" class="label_1"> UserName or
								email address </label>
							<!--label 元素不会向用户呈现任何特殊效果。不过，它为鼠标用户改进了可用性。如果您在 label 元素内点击文本，就会触发此控件。就是说，当用户选择该标签时，浏览器就会自动将焦点转到和标签相关的表单控件上。

                <label> 标签的 for 属性应当与相关元素的 id 属性相同。-->
							<input type="text" name="count" id="login_field"
								class="form-control" /><br /> <label for="password"
								class="label_1"> Password <a class=" label-link"
								href="#">Forgot password?</a>
							</label> <input type="password" name="userpassword" id="password"
								class="form-control" /><br /> <input type="submit"
								name="commit" value="Sign in" tabindex="3"
								class="btn btn-primary btn-block"
								data-disable-with="Signing in…" />

						</form>
					</div>
					<p class="login-callout">
						New to Things? <a data-ga-click="Sign in, switch to sign up"
							href="/join?source=login">Create an account</a>.
					</p>
				</div>

			</div>

			<!--注意,在html中不可随意用"   " 空格,而是应该用&nbsp;表示空格-->
			<div class="foot">
				<div class="nav">
					<ul class="foot_ul">
						<li class="ul_a"><a href="#">Terms</a></li>
						<li class="ul_a"><a href="#">Privacy</a></li>
						<li class="ul_a"><a href="#">Security</a></li>
						<li class="ul_a"><a href="#">Contact&nbsp;&nbsp;Things</a></li>
					</ul>
				</div>
			</div>
		
	
		
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/snow.js"></script> 
</body>
</html>