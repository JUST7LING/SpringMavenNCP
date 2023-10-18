/**
 * 
 */
 
 $(function(){
 	$.ajax({
 		type: 'post',
 		url: '/springMavenNCP/user/getUploadList',
 		dataType: 'json',
 		success: function(data){
 			 var result;
		 			 // back-tick
		 			 $.each(data, function(index, items){
		 			 	result = `<tr>` +
		 			 			`<td align = "center">`+items.seq+`</td>` +
		 			 			`<td align = "center"><a href = "#"><img src = "https://kr.object.ncloudstorage.com/bitcamp-edu-bucket-107/storage/`+items.imageFileName+`" style = "width:50px; height: 50px;" alt = "`+items.imageName+`"></td>`+
		 			 			`<td align = "center">`+items.imageOriginalName+`</td>`+
		 			 			`</tr>`;
		 			 	$('#imageListTable').append(result);
		 			 })//$.each
		 			 
		 			 // alt 없으면 Ncloud 업로드 시 에러 남
 		
 		}, error: function(e){
 			console.log(e)
 		}
 	
 	});
 })