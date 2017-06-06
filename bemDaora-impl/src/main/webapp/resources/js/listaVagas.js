 $(document).ready(function(){
 	$.paramsPage = {
		contextoVaga: "/bemdahora/vaga/",
		contexto: "/bemdahora/",
		uuid: "",
		box: ""
	};
 	
 	$(".editaVaga").click(function(){
 		window.location = $.paramsPage.contexto + "editaVaga/" + $(this).attr("data-vaga") + "/adm";
 	});
 	
 	$(".excluiVaga").click(function(){
 		var vaga = $(this).attr("data-vaga");
 		$(this).addClass("hide");
 		$.post($.paramsPage.contexto + "excluiVaga/adm",{idVaga: vaga})
 		.done(function(){
 			$("#tr-" + vaga).fadeOut(700,function(){
 				$("#tr-" + vaga).remove();
 	 		})
 		})
 		.fail(function(){
 			$(this).removeClass("hide");
 			alert("Não foi possivel excluir esta instituição.");
 		});
 	});
 	
 	$("#add").click(function(){
 		window.location = $.paramsPage.contexto + "cadastraInstituicao";
 	});
 	
	$(".candidatos").click(function(){
		window.location = $.paramsPage.contextoVaga + "listaCandidatos/" + $(this).attr("data-vaga") + "/adm";
	});
	
	/*
	 * APROVAÇÃO DAS VAGAS
	 * 
	*/
 	
	$(".aprova").click(function(){
		$.post($.paramsPage.contextoVaga + "aprova/adm",{idAtividade: $(this).attr("data-atividade")}).
		done(function(){
			alert("Candidato foi aprovado e informado com sucesso!");
			//window.location = $.paramsPage.contextoVaga + "instituicao/" + $("#idVaga").val() + "/adm"; 
		}).
		fail(function(){
			alert("Não foi possivel aprovar essa vaga. Tente mais tarde.");
		});
	});
	
	$(".reprova").click(function(){
		alert("Reprovado!!!");
	});
	
	$(".conclui").click(function(){
		$("#quantidade").val($(this).attr("data-quantidade"));
		$("#atv").val($(this).attr("data-atividade"));
		$.paramsPage.box = $.fancybox.open([{
			href : "#conf",
			type:'inline',
			 afterClose : function() {
				$(this).remove();
		    },
			tpl: { 
				closeBtn: '<div title="Fechar" class="fancybox-item fancybox-close"></div>' 
			}}], {padding : 10});
	});
	
	$("#confirmar").click(function(){
		$.post($.paramsPage.contexto + "atividade/confirmaRealizado/adm",{
			idAtividade : $("#atv").val(),
			qtdHoras : $("#quantidade").val(),
			
		})
		.done(function(){
			
			$("#tr-"+$("#atv").val()).remove();
			$.fancybox.close();
		})
		.fail();
	});
});