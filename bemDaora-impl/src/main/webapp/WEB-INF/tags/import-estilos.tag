<%@tag description="Importação dos estilos do aplicativo" pageEncoding="UTF-8"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
	<link rel="stylesheet" type="text/css" href="/bemdaora/resources/css/normalize.css"/>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
	<link href="/bemdaora/resources/css/main.css" rel="stylesheet" type="text/css">
	
	
	<bd:import-jquery/>
	<!-- FONT AWESOME -->
	<link rel="stylesheet" href="/bemdaora/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<!-- FONT AWESOME -->
	<link rel="stylesheet" type="text/css" href="/bemdaora/resources/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="/bemdaora/resources/css/set1.css" />
	<link rel="stylesheet" type="text/css" href="/bemdaora/resources/css/default.css" />
	
	<script src="/bemdaora/resources/js/contextAction.js"></script>
	<script src="/bemdaora/resources/js/masked.js"></script>
	
	<script src="/bemdaora/resources/js/classie.js"></script>
	
	 <script>
         (function() {
         
         	// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
         
         	if (!String.prototype.trim) {
         
         		(function() {
         
         			// Make sure we trim BOM and NBSP
         
         			var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
         
         			String.prototype.trim = function() {
         
         				return this.replace(rtrim, '');
         
         			};
         
         		})();
         
         	}
         
         
         
         	[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
         
         		// in case the input is already filled..
         
         		if( inputEl.value.trim() !== '' ) {
         
         			classie.add( inputEl.parentNode, 'input--filled' );
         
         		}
         
         
         
         		// events:
         
         		inputEl.addEventListener( 'focus', onInputFocus );
         
         		inputEl.addEventListener( 'blur', onInputBlur );
         
         	} );
         
         
         
         	function onInputFocus( ev ) {
         
         		classie.add( ev.target.parentNode, 'input--filled' );
         
         	}
         
         
         
         	function onInputBlur( ev ) {
         
         		if( ev.target.value.trim() === '' ) {
         
         			classie.remove( ev.target.parentNode, 'input--filled' );
         
         		}
         
         	}
         
         })();
         
      </script>