 $(document).ready(function(){
 	$.paramsPage = {
		contexto: "/bemdahora/",
		uuid: ""
	};
 	
 	 $('select').material_select();
 	
 	$("#publicar").click(function(){
 		$("#form").attr("action",$.paramsPage.contexto + "publicaVaga/adm").submit();
 	});
 	
 	$("#voltaInstituicao").click(function(){
 		window.location =  $.paramsPage.contexto + "adm/editarInstituicao/" + $("#idInstituicao").val() + "/adm";
 	});
});