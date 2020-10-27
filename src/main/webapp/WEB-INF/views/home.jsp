<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
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
	
	form{
		width: 80%;
		height:100%;
		
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}
	
	form input, form textarea, form button{
		width: 95%;
		margin-bottom: 20px;
	}
	
	form input{
		outline: none;
    	border: none;
    	border-bottom: 1px solid #555;
	}
	
	form input:nth-child(5){
		border: none;
		text-align: center;
	}
	
	form textarea {
		height: 50%;
		resize: none;
	}
	
	
	input:-webkit-autofill,
    input:-webkit-autofill:hover,
    input:-webkit-autofill:focus,
    input:-webkit-autofill:active {
	 transition: background-color 5000s ease-in-out 0s;
	 -webkit-transition: background-color 9999s ease-out;
     -webkit-box-shadow: 0 0 0px 1000px white inset !important;
     -webkit-text-fill-color: black !important;
   }
	
</style>
<script>
	document.addEventListener("DOMContentLoaded", function()
	{
	})
</script>
</head>
<body>
<section>
	<div>
		<button>보낸 메일함</button>
		<button>받은 메일함</button>
	</div>
	<form method="post" action="${rootPath}/file/save/" enctype="multipart/form-data">
	
		<input name="to_email" placeholder="받는 Email">
		<input name="from_email" placeholder="보내는 Email">
		<input name="s_subject" placeholder="제목">
		
		<textarea name="s_content" placeholder="내용"></textarea>
		
		<input name="files" type="file" multiple="multiple">
		
		<button type="submit">전송</button>
	</form>
</section>
</body>
</html>