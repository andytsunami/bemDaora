 $(document).ready(function(){
 	$.paramsPage = {
		contexto: "/bemdaora/",
		uuid: ""
	};
 	
 	 $('select').material_select();
 	
 	$("#publicar").click(function(){
 		$("#form").attr("action",$.paramsPage.contexto + "publicaVaga/adm").submit();
 	});
 	
 	
});