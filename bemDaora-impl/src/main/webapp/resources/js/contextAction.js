(function($) {

$().ready(function() {
		
	$.context = {
			card: null,
			tempFiltersHeight: 0,
			mensagemErro: [],
			botoesDesativados: false,
			travarVoltar : null,
			
		};
	
	
	$(".cpf").mask("999.999.999-99");
	//$(".email").mask("999.999.999-99");
	$(".numerico").numeric({decimal:false,negative:false});
	
	$(".telefone").focusout(function(){
	    var phone, element;
	    element = $(this);
	    element.unmask();
	    phone = element.val().replace(/\D/g, '');
	    if(phone.length > 10) {
	        element.mask("(99) 99999-999?9");
	    } else {
	        element.mask("(99) 9999-9999?9");
	    }
	}).trigger('focusout');
		
	$.extend({
		
		disableButtonsAndSubmit: function (desativar,url){
			if(desativar){
				if(!$.context.botoesDesativados){
					$.context.botoesDesativados = true;
					$(":button").prop("disabled",true);
					$(".bt").removeClass("bt").addClass("btdisabled");
					$(".btn-action").removeClass("btn-action").addClass("btn-action-disabled");
					$(".btn-small").removeClass("btn-small").addClass("btn-small-disabled");
					$(".loading-footer").fadeIn('fast', function() {});
					$("#form").attr("action", url).submit();
					return true;
				}
				else{
					return false;
				}
			}
			else{
				$.context.botoesDesativados = false;
				$(":button").prop("disabled",false);
				$(".btdisabled").removeClass("btdisabled").addClass("bt");
				$(".btn-action-disabled").removeClass("btn-action-disabled").addClass("btn-action");
				$(".btn-small-disabled").removeClass("btn-small-disabled").addClass("btn-small");
				$(".loading-footer").fadeOut('fast', function() {});
				return true;
			}
		},
		disableButtons: function (desativar){
			if(desativar){
				if(!$.context.botoesDesativados){
					$.context.botoesDesativados = true;
					$(":button").prop("disabled",true);
					$(".bt").removeClass("bt").addClass("btdisabled").prop("disabled",true);
					$(".btn-action").removeClass("btn-action").addClass("btn-action-disabled").prop("disabled",true);
					$(".btn-small").removeClass("btn-small").addClass("btn-small-disabled").prop("disabled",true);
					$(".loading-footer").fadeIn('fast', function() {});
					return true;
				}
				else{
					return false;
				}
			}
			else{
				$.context.botoesDesativados = false;
				$(":button").prop("disabled",false);
				$(".btdisabled").removeClass("btdisabled").addClass("bt").prop("disabled",false);
				$(".btn-action-disabled").removeClass("btn-action-disabled").addClass("btn-action").prop("disabled",false);
				$(".btn-small-disabled").removeClass("btn-small-disabled").addClass("btn-small").prop("disabled",false);
				$(".loading-footer").fadeOut('fast', function() {});
				return true;
			}
		},
		preValidate: function(){
			var correct = true;
			$.context.mensagemErro = [];
			if(!$.validateEmpty().liberado){correct = false;$.context.mensagemErro.push($.validateEmpty().mensagem);}
			if(!$.validateSelected().liberado){correct = false;$.context.mensagemErro.push($.validateSelected().mensagem);}
			if(!$.validateDate().liberado){correct = false;$.context.mensagemErro.push($.validateDate().mensagem);}
			if(!$.validateDateTime().liberado){correct = false;$.context.mensagemErro.push($.validateDateTime().mensagem);}
			if(!$.validateEmail().liberado){correct = false;$.context.mensagemErro.push($.validateEmail().mensagem);}
			if(!$.validateFone().liberado){correct = false;$.context.mensagemErro.push($.validateFone().mensagem);}
			if(!$.validateHour().liberado){correct = false;$.context.mensagemErro.push($.validateHour().mensagem);}
			return correct;
		},
		validateEmpty: function(){
			var correct = true;
			$( "form .obrigatorio:input[type='text'],form select.obrigatorio,form .obrigatorio:input[type='password'],form textarea.obrigatorio,form .obrigatorio:input[type='file'],form .obrigatorio:input[type='radio']" ).each(function() {
				if($(this).is("input[type='radio']")){
					var selecionou = false;
					$("form .obrigatorio:input[type='radio'][name='"+$(this).attr("name")+"']").each(function(index,campo){
						if($(campo).is(':checked')){
							selecionou = true;
							return false;
						}

					});
					if(!selecionou){
						correct = false;
						$("form .obrigatorio:input[type='radio'][name='"+$(this).attr("name")+"']").each(function(index,campo){
							if($(campo).hasClass("default") || $(campo).hasClass("prevent")){
								$(campo).addClass("error");	
							}
						});						
					}
					else{
						if($(this).hasClass("default") || $(this).hasClass("prevent")){							
							$(this).removeClass("error");
						}
					}
				}
				else{
					if($.trim($(this).val())==""){
						if($(this).is('select') && ($(this).hasClass("tags-select") || $(this).hasClass("selectized"))){
							$(this).next().find(".selectize-input").addClass("error");
						}
						else if($(this).is('textarea') && $(this).hasClass("html")){
							$(this).prev().find(".froala-element").css("border","solid 1px #ff0000");
						}
						else if($(this).is("input[type='file']") && $(this).hasClass("pw-file")){
							$(this).parent().parent().addClass("error");
						}
						else{
							$(this).addClass("error");						
						}
						correct = false;
					}
					else{
						if($(this).is('select') && ($(this).hasClass("tags-select") || $(this).hasClass("selectized"))){
							$(this).next().find(".selectize-input").removeClass("error");
						}
						else if($(this).is('textarea') && $(this).hasClass("html")){
							$(this).prev().find(".froala-element").css("border","solid 1px #BFBFBF");
						}
						else if($(this).is("input[type='file']") && $(this).hasClass("pw-file")){
							$(this).parent().removeClass("error");
						}
						else{
							$(this).removeClass("error");						
						}
					}
				}
			});
			
			return {liberado: correct, mensagem: "Por favor preencha os campos obrigatórios"};
		},
		validateSelected: function(){
			var correct = true;		
			return {liberado: correct, mensagem: "Por favor preencha os campos obrigatórios"};
		},
		validateDateTime: function(){
			var correct = true;
			$( "form .datahora" ).each(function() {
				if($.trim($(this).val())!=""){
					if(!$.isValidDateTime($(this).val())){
						$(this).addClass("error");
						correct = false;
					}
					else{
						$(this).removeClass("error");
					}
				}
			});
			return {liberado: correct, mensagem: "Por favor preencha uma data válida"};
		},
		validateHour: function(){
			var correct = true;
			$( "form .hora" ).each(function() {
				if($.trim($(this).val())!=""){
					if(!$.isValidHour($(this).val())){
						$(this).addClass("error");
						correct = false;
					}
					else{
						$(this).removeClass("error"); 
					}
				}
			});
			return {liberado: correct, mensagem: "Por favor preencha uma hora válida"};
		},
		validateDate: function(){
			var correct = true;
			$( "form .data" ).each(function() {
				if($.trim($(this).val())!=""){
					if(!$.isValidDate($(this).val())){
						$(this).addClass("error");
						correct = false;
					}
					else{
						$(this).removeClass("error"); 
					}
				}
			});
			return {liberado: correct, mensagem: "Por favor preencha uma data válida"};
		},
		validateEmail: function(){
			var correct = true;
			$( "form .email" ).each(function() {
				if($.trim($(this).val())!=""){
					if(!$.isValidEmail($(this).val())){
						$(this).addClass("error");
						correct = false;
					}
					else{
						$(this).removeClass("error");
					}
				}
			});
			return {liberado: correct, mensagem: "Por favor preencha um e-mail válido"};
		},
		validateFone: function(){
			var correct = true;
			$( "form .telefoneDDD" ).each(function() {
				if($.trim($(this).val())!=""){
					if(!$.isValidTelefoneDDD($(this).val())){
						$(this).addClass("error");
						correct = false;
					}
					else{
						$(this).removeClass("error");
					}
				}
			});
			return {liberado: correct, mensagem: "Por favor preencha um telefone com DDD"};
		},
		isValidDateTime: function(s){
			var correct = false;
			var regex = /^\d{1,2}[\.|\/|-]\d{1,2}[\.|\/|-]\d{1,4} \d{1,2}:\d{1,2}$/;
			if (regex.test(s)){
				var dateArray = s.split(" ");
				correct = $.isValidDate(dateArray[0]) && $.isValidHour(dateArray[1]);
			}
			
			return correct;
		},
		isValidHour: function(s){
			var regex = /^([01]\d|2[0-3]):?([0-5]\d)$/;
			return regex.test(s);
		},
		isValidDate: function(s) {
		    // format D(D)/M(M)/(YY)YY
		    var dateFormat = /^\d{1,4}[\.|\/|-]\d{1,2}[\.|\/|-]\d{1,4}$/;

		    if (dateFormat.test(s)) {
		        // remove any leading zeros from date values
		        s = s.replace(/0*(\d*)/gi,"$1");
		        var dateArray = s.split(/[\.|\/|-]/);
		      
		        // correct month value
		        dateArray[1] = dateArray[1]-1;

		        // correct year value
		        if (dateArray[2].length<4) {
		            // correct year value
		            dateArray[2] = (parseInt(dateArray[2]) < 50) ? 2000 + parseInt(dateArray[2]) : 1900 + parseInt(dateArray[2]);
		        }

		        var testDate = new Date(dateArray[2], dateArray[1], dateArray[0], 12, 0, 0, 0);
		        if (testDate.getDate()!=dateArray[0] || testDate.getMonth()!=dateArray[1] || testDate.getFullYear()!=dateArray[2]) {
		            return false;
		        } else {
		            return true;
		        }
		    } else {
		        return false;
		    }
		},
		isValidEmail: function(email) {
		    regex = /^[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2}/;
		    if(regex.exec(email))
		        return true;
		    else
		        return false;
		},
		isValidTelefoneDDD: function(tel) {
		    if(tel.length >= 14) {
		    	return true;
		    }
		    else {
		    	return false;
		    }
		},
		isValidUF: function(uf) {
			regex = /^([A-Z]{2})$/;
			if(regex.exec(uf))
				return true;
			else
				return false;
		},
		isValidCep: function(cep) {
			regex = /^[0-9]{5}\-[0-9]{3}$/;
			if(regex.exec(cep))
				return true;
			else
				return false;
		},
		
			
	});
});

})(jQuery);