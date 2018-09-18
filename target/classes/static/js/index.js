
function initData(){
    $.ajax({
        type:'GET',
        dataType: "json",
        url:"../baseinfo.json",
        async:true,
        /*data:{
         email:$("#email").val(),
         password:$("#password").val()
         },*/
        success:function(res){
            if(res.code=="1"){
                var info = res.data;
                var baseinfo=info.baseinfo;
                var signature=info.signature;
                var workList=info.workList;
                var skillsList=info.skillsList;
                $("#name").html(baseinfo.name);
                $("#tagname").html(baseinfo.name);
                $("#profession").html(baseinfo.profession+"/"+baseinfo.role);
                $("#signature").html(signature.content);



            }else{
            console.log("基本信息获取失败!");
            }
        },
        error:function(){
//            $("#test").html("发生错误:"+jqXHR.status);
            alert("发生错误");
        }
    });
}



