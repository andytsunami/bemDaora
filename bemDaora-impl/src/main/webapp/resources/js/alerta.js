 $(document).ready(function(){
 	
 	$(".alerta").click(function(){
 		$(this).fadeOut("500",function(){
 			$(this).addClass("hidden");
 		});
 	});
});