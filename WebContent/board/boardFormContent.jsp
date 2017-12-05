<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-sm-8 blog-main">
		<div class="blog-post">
			<h2 class="blog-post-title">게시글 작성</h2>
			
			<form action="/page/test/send.jsp" method="post" id="frm">
				<textarea name="smarteditor" id="smarteditor" rows="10" cols="100"
					style="width: 766px; height: 412px;"></textarea>
			</form>
			<input type="button" id="savebutton" value="서버전송" />
		</div>
	</div>
</div>
