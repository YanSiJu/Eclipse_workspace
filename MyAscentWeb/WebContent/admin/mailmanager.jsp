<%@ page language="java" import="com.ascent.bean.*" pageEncoding="GB2312" errorPage="./error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>邮件设置</title>
		<link rel="stylesheet" href="./css/andreas08(blue).css"
			type="text/css" media="screen,projection" />

		<script type="text/javascript">
function check() {
	if (form.fromaddressname.value == "") {
		alert("请输入邮件地址");
		form.fromaddressname.focus();
		return false;
	}
	if (form.frompassword.value == "") {
		alert("请输入邮件密码");
		form.frompassword.focus();
		return false;
	}
	return true;
}

function findEmail() {
	send_request("<%=request.getContextPath()%>/mail?a=all");
}

var http_request = false;

function send_request(url) { //初始化、指定处理函数、发送请求的函数
	http_request = false;
	//开始初始化XMLHttpRequest对象
	if (window.XMLHttpRequest) { //Mozilla 浏览器
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {//设置MiME类别
			http_request.overrideMimeType('text/xml');
		}
	} else if (window.ActiveXObject) { // IE浏览器
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	if (!http_request) { // 异常，创建对象实例失败
		window.alert("不能创建XMLHttpRequest对象实例.");
		return false;
	}
	http_request.onreadystatechange = processRequest;
	// 确定发送请求的方式和URL以及是否同步执行下段代码
	http_request.open("POST", url, true);
	http_request.send(null);
}
// 处理返回信息的函数
function processRequest() {
	if (http_request.readyState == 4) { // 判断对象状态
		if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
			var divhtml = http_request.responseText;
			document.getElementById('xianshi').innerHTML = "管理员邮箱：";
			document.getElementById('email').innerHTML = divhtml;
		}
	}

}
</script>
	</head>
	<body>
		<div id="container">
			<div id="header">
			</div>
			<div id="navigation">
				<ul>
					<li class="selected"></li>
					<li>
						<a href="./index.jsp">首页</a>
					</li>
					<li>
						<a href="./product/itservice.jsp">IT服务</a>
					</li>
					<li>
						<a href="./product/products.jsp">电子商务系统</a>
					</li>
					<li>
						<a href="./product/employee.jsp">员工招聘</a>
					</li>
					<li>
						<a href="./product/ContactUs.jsp">关于我们</a>
					</li>
					<li></li>
				</ul>
			</div>

			<div id="content2">
				<%
					Usr p = (Usr) session.getAttribute("productuser");
					if ((p != null && p.getSuperuser().equals("3"))||p != null && p.getSuperuser().equals("2")) { //管理员
				%>
				<table width="100%" height="20" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="20">
							<div class="table_t">
								|&nbsp;&nbsp;欢迎,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="./login?a=out" class="table_t">注销</a>&nbsp;&nbsp;|
							</div>
						</td>
						<td>
							<div>
								<a href="./user?a=all"><img src="./images/userlist.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="./product?a=all"><img src="./images/productslist.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="./admin/mailmanager.jsp"><img src="./images/mailmanager.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</td>
					</tr>
				</table>
				<br />


				<table width="100%" height="41" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="#467AA7" colspan="2" height="5"></td>
					</tr>
					<tr>
						<td width="15" height="18" align="left" valign="top">
							<div align="left"></div>
						</td>
						<td width="385" align="left" valign="bottom" class="12">
						</td>
					</tr>
					<tr>
						<td height="4" colspan="2" align="left" valign="bottom"></td>
					</tr>

					<tr>
						<td height="15" align="left" valign="top">
						</td>
						<td height="15" align="left" valign="top" class="12">
							<div id="xianshi">
								<a href="javascript:findEmail();">已设邮箱</a>
							</div>
							<div id="email">
							</div>
							<div align="center">
								<form name="form" method="post" action="./mail?a=save">
									<table width="70%" border="0" cellpadding="0" cellspacing="8"
										bgcolor="f3f3f3">
										<tbody>
											<tr>
												<td width="26%">
													<div align="center">
														发件Email地址
													</div>
													<div align="center"></div>
												</td>
												<td width="43%" align="left">
													<input name="fromaddressname" type="text"
														id="fromaddressname" />
												</td>
												<td width="31%">
													<select name="fromaddresstype" id="fromaddresstype">
														<option value="@163.com" selected="selected">
															@163.com
														</option>
														<option value="@126.com">
															@126.com
														</option>
														<option value="@sohu.com">
															@sohu.com
														</option>
														<option value="@sina.com">
															@sina.com
														</option>
														<option value="@gmail.com">
															@gmail.com
														</option>
													</select>
												</td>
											</tr>
											<tr>
												<td>
													<div align="center">
														发件Email密码
													</div>
												</td>
												<td align="left">
													<input name="frompassword" type="password"
														id="frompassword" />
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td>
													<div align="center">
														收件Email地址
													</div>
												</td>
												<td align="left">
													<input name="toaddress" type="text" id="toaddress" />
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<div align="center">
														<input type="submit" name="Submit" value="提交"
															onclick="return check();" />
														&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="reset" name="Reset" value="取消" />
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
							<div>
								<br />
								帮助：
								<br />
								&lt;1&gt;请正确的设置发件箱地址及密码，该邮件是负责发送邮件的地址
								<br />
								&lt;2&gt;请正确的设置收件箱地址，该邮件是接收邮件的地址，当客户在
								<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结算中心提交后，邮件会发送到该邮件
								<br />
								&lt;3&gt;试运行时请重新设置自己的邮箱，库中邮件地址您无法查看测试
								<br />
								&lt;4&gt;请点击已置邮箱，查看你设置的邮箱邮箱是否正确
							</div>
							<br />
							<div class="table_wz"></div>
						</td>
					</tr>
				</table>
				<%
					} else {
				%>
				<div class="padding">
					<div id="middlebody">
						<center>
							<font size="3">您无权限浏览此页</font>
						</center>
					</div>
				</div>
				<%
					}
				%>
			</div>
			<div id="footer">
				<p>
					<a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司
						&copy;2004-2008|京ICP备05005681</a>
				</p>
			</div>

		</div>
	</body>
</html>
