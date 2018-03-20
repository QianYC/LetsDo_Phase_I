/**
 * submit.js
 * 在workSpace引入,用于导出标记图片和加载下一张
 */

function getPicture(id,projectId){
	$.get("/workSpace/getPic/"+id+"/"+projectId,function(data,status){
		alert(data);
		$("#penal").css("background-image","url('/workSpace/getPic/"+id+"/"+projectId+"')");
	});
	
}

function submitAsPicture(){
	var a = document.createElement('a');
            a.href = document.getElementById('penal').toDataURL('image/png');     //把画布转化为base64
            a.download = 'image.jpeg';
            a.id = 'download';
            a.innerHTML = 'download';
            document.body.appendChild(a);
            document.getElementById('download').style.display = 'none';
            document.getElementById('download').click();    //默认出发下载操作

}

function submitAsPoints(){
	
}