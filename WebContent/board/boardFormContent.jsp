<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-sm-8 blog-main">
		<div class="blog-post">
			<h2 class="blog-post-title">게시글 작성</h2>
			<form action="/page/test/send.jsp" method="post" id="frm">
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="userAlias"
							name="title" placeholder="제목" value="">
					</div>
				</div>
				
				<div class="form-group">
					<label for="smarteditor" class="col-sm-2 control-label">내용</label>
					<div class="col-sm-10">
						<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height: 412px;"></textarea>
					</div>
				</div>
			</form>
			<div class="form-group">
				<div class="col-sm-12">
					<input type="button" id="savebutton" class="btn btn-default pull-right" value="글 저장하기" />
				</div>
			</div>
		</div>
	</div>
</div>
