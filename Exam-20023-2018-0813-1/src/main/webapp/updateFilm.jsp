<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form1" name="form1" method="post" action="updateFilmServlet">
		<table width="439" height="307" border="1" align="center">
			<tr>
				<td colspan="2" align="center">编辑电影</td>
			</tr>
			<tr>
				<td width="98" align="right">名称</td>
				<td width="325"><label for="textfield"></label> <input
					type="text" name="title" id="textfield" size="40" value="${film.title }"/></td>
			</tr>
			<tr>
				<td align="right">信息</td>
				<td><label for="textfield2"></label> <input type="text"
					name="description" id="textfield2" size="40" value="${film.description }" /></td>
			</tr>
			<tr>
				<td align="right">语言</td>
				<td><label for="select"></label> 
				<select name="languageId" id="select">

					<c:forEach items="${Languages }" var="language">
						<option value="${language.languageId }">${language.name }</option>
					</c:forEach>		
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="button" id="button" value="提交" />
					<button id="return" value="return">返回</button>
				</td>
				<input type="hidden" name="filmId" value="${film.filmId }" />
			</tr>
		</table>
	</form>
	
</body>
</html>