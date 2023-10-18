<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm</title>

<style>
	
</style>
</head>
<body>
	here is uploadForm.
	
	<form id="uploadForm">
	<table border="1">
		<tr>
			<th>상품명</th>
			<td>
				<input type="text" name="imageName" id="imageName" size="35">
				<div id="imageNameDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<textarea name="imageContent" id="imageContent" rows="10" cols="50"></textarea>
				<div id="imageContentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<span id="showImgList"></span>
				
				<img id="camera" src="../image/camera.jpg" width="30" height="30" alt="카메라">
				<input type="file" name="img[]" id="img" multiple="multiple" style="visibility: hidden;">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="이미지 업로드" id="uploadBtn">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	<br>
	<div id = "resultDiv"></div>
	
	</form>
</body>
<script src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
	<script type = "text/javascript" src = "../js/upload.js"></script>
	
	<script type = "text/javascript">
		$('#camera').click(function(){
				$('#img').trigger('click');// 강제 이벤트 발생
			
		}); // #camera.click
		
		/*
		$('#img').change(function(){
			readURL(this);
			
			FileReader 란?
			FileReader는 type이 file인 input 태그 또는 API 요청과 같은 인터페이스를 통해 
			File 또는 Blob 객체를 편리하게 처리할수있는 방법을 제공하는 객체이며
			abort, load, error와 같은 이벤트에서 발생한 프로세스를 처리하는데 주로 사용되며,
			File 또는 Blob 객체를 읽어서 result 속성에 저장한다.

			FileReader도 비동기로 동작한다.

			FileReader.onload()
			load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료되었을 때마다 발생한다.
						
		})
		
		
		// 이미지 한 개만 미리보기 
		function readURL(input){
			var reader = new FileReader();
			
			var show;
			reader.onload = function(e){
				$('#showImage').attr('src', e.target.result);
				//e.target -> 이벤트가 발생하는 요소를 반환해 준다.
				
				show+=`<img src = "e.target.result" width = "70" height = "70" />`;
			}
			reader.readAsDataURL(input.files[0]);
			
		}
		*/
		
		function readURL(file){
			var reader = new FileReader();
			var show;
			reader.onload = function(e){
				var img = document.createElement('img')
				img.src = e.target.result;
				img.width = 70;
				img.height = 70;
				$('#showImgList').append(img);
				// <img src = ~~ width = "70" height = "70">의 이미지 태그 기능
			}
			reader.readAsDataURL(file);
		}
		
		$('#img').change(function(){
			$('#showImgList').empty();
			for(i=0; i<this.files.length; i++){
				readURL(this.files[i]);
			}
		}); // #img.change
	</script>
</html>