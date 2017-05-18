 $(document).ready(function(){
 	$.paramsPage = {
		contexto: "/bemdaora/adm/",
		uuid: ""
	};
 	
 	$("#salvar").click(function(){
 		$("#form").attr("action",$.paramsPage.contexto + "salvaInstituicao").submit();
 	});
});