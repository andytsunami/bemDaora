 $(document).ready(function(){
 	$.paramsPage = {
		contexto: "",
		uuid: ""
	};
 	
 	$(".alerta").click(function(){
 		$(this).fadeOut("500",function(){
 			$(this).addClass("hidden");
 		});
 	});
});