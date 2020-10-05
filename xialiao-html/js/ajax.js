function xmlHttpRequest(url,method,data,dataType,callback){
	$.ajax({
		url:"http://127.0.0.1:8081/XialiaoSSM/"+url,
		method:method,
		data:data,
		dataType:dataType,
		success:callback,
		error:function(){
			alert("服务器连接失败");
		}
		
	})
}