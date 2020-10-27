<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>

<link rel="stylesheet" href="${rootPath}/resources/css/form.css?=ver=1">
<link rel="stylesheet" href="${rootPath}/resources/css/button.css?=ver=1">

<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/c1d8b25418.js" crossorigin="anonymous"></script>

<title>나의 홈페이지</title>
<style>
	html, body{
		margin: 0;
		padding: 0;
		height: 100%;
		width: 100%;
	}

	section{
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: row;
		margin: 5px auto;
		
		width : 55%;
		height: 65%;
		
		position: absolute;
		top: 50%;
		left: 50%;
		
		transform: translate(-50%, -50%);
		border: 15px solid navy;
    	border-radius: 15px;
	}
	
	section div{
		border: 1px solid black;
		height: 100%;
		width: 20%;
		display: flex;
		justify-content: flex-start;
		align-content:space-between;
		flex-direction: column;	
	}
	
	section div *{
		margin: 5px auto;
		width: 95%;
	}
	
	article{
		width: 100%;
		height: 100%;
		display: flex;
    	flex-direction: column;
	}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function()
	{
        let nav_button = document.querySelectorAll(".nav_button");
        nav_button.forEach(function(nav_button)
        {
            nav_button.onclick = function()
            { document.location.href = "${rootPath}/" + nav_button.value; }
        })
	})
</script>
</head>
<body>
<section>
	<div>
		<button class="nav_button" value="email/send">보낸 메일함</button>
		<button class="nav_button">메일 작성</button>
	</div>
	<article>
		<c:choose>
			<c:when test="${BODY == 'SEND_HOME'}">
				<%@ include file="/WEB-INF/views/ems/send.jspf" %>
			</c:when>
			
			<c:when test="${BODY == 'DETAIL_HOME'}">
				<%@ include file="/WEB-INF/views/ems/detail.jspf" %>
			</c:when>
			
			<c:otherwise>
				<%@ include file="/WEB-INF/views/ems/write.jspf" %>
			</c:otherwise>
		</c:choose>
	</article>
</section>
</body>
</html>