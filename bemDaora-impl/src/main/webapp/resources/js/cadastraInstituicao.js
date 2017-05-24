 $(document).ready(function(){
 	$.paramsPage = {
		contexto: "/bemdaora/adm/",
		uuid: ""
	};
 	
 	$("#salvar").click(function(){
 		$("#form").attr("action",$.paramsPage.contexto + "salvaInstituicao").submit();
 	});
 	
 	$("#add-vaga").click(function(){
 		window.location = "/bemdaora/cadastraVaga/"+$("#idInstituicao").value()+"/adm";
 	});
});