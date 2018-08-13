<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="js/jquery-3.2.1.min.js">  </script>

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