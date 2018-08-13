<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script src="js/jquery-3.2.1.min.js">
	
</script>
<body>
	<div id="operation">
		<table width="342" height="27" align="center">
			<tr>
				<td width="100" align="center"><button id="add">新增</button></td>
				<td width="100" align="center"><button id="update">编辑</button></td>
				<td width="100" align="center"><button id="delete">删除</button></td>
			</tr>
		</table>
	</div>
	<div id="showItems">
		<table width="766" height="44" border="1" align="center">
			<tr>

				<th width="94" align="center">电影ID</th>
				<th width="144" align="center">名称</th>
				<th width="200" align="center">信息</th>
				<th width="160" align="center">语言</th>
				<td width="56" align="center"><input type="button"
					name="allSelect" id="allSelect" value="全选" style="display:none" /></td>
			</tr>

			<form id="caseForm">
				<c:forEach items="${filmList }" var="film" varStatus="status">
					<tr>

						<td width="94" align="center">${film.filmId }</td>
						<td width="144" align="center">${film.title }</td>
						<td width="200" align="center">${film.description }</td>
						<td width="160" align="center">${film.languageName }</td>

						<td align="center"><input type="checkbox" name="case"
							id="case" value="${film.filmId }" /></td>
					</tr>
				</c:forEach>
			</form>

		</table>
	</div>
</body>
<script>
	var itemId;
	$(document).ready(function() {
		/* 新增 */
		$("#add").click(function() {
			location.href = "addFilm.jsp";
		});
		/*更新  */

		$("#update").click(function() {
			$.each($('input:checkbox'), function() {
				if (this.checked) {
					filmId = $(this).val();
				}
			});
			location.href = "toUpdateServlet?filmId=" + filmId;
		});
		/*删除  */
		$("#delete").click(function() {
			/* $("#allSelect").show(); */
			data = $("#caseForm").serialize();
			$.ajax({
				type : 'POST',
				url : "deleteFilmServlet",
				data : data,
				success : function(msg) {
					$("#showItems").html(msg);
				}
			});

		})
		/* $("#allSelect").click(function(){
			$("input:checkbox").prop("checked","true");
		}); */
		/* if(${message}!=null){
			alert(${message});
		} */
	});
	
</script>
</html>