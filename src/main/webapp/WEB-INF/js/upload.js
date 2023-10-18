
 $(function(){
 	$('#uploadBtn').click(function(){
 		$('#imageNameDiv').empty();
 		$('#imageContentDiv').empty();
 		
 		if($('#imageName').val() == ''){
 			$('#imageNameDiv').text('상품명 입력');
 			$('#imageName').focus();
 		
 		}else if($('#imageContent').val() == ''){
 			$('#imageContentDiv').text('상품 내용 입력');
 			$('#imageContent').focus();
 		}else{
 			var formData = new FormData($('#uploadForm')[0]);
 			
 			$.ajax({
 				type: 'post',
 				enctype: 'multipart/form-data',
 				processData: false,
 				contentType: false,
 				url: '/SpringMavenNCP/user/upload',
 				data: formData,
 				dataType: 'text',
 				success: function(data){
 					alert(data);
 					location.href = '/SpringMavenNCP/user/uploadList'
 				},
 				error: function(e){
 					console.log(e);
 				}
 			}); // ajax
 		}
 	});
 });