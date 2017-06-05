<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <title>BemdaHora</title>
		<bd:import-estilos/>
		<script type="text/javascript" src="<c:url value='/resources/js/voluntarioHome.js?version=3'/>"></script>
	  	<link href="<c:url value='/resources/css/main.css?version=3'/>" rel="stylesheet" type="text/css">
	  	<link href="<c:url value='/resources/css/style.css?version=3'/>" rel="stylesheet" type="text/css">
	  	
	  <style>
		      #map {
		        height: 100%;
		      }
	
			 html, body {
			        height: 100%;
			        margin: 0;
			        padding: 0;
			}
	    </style>
	  
	
	</head>
	<body>
		<input type="hidden" id="login" value="${voluntario.email}">
		<!-- Events-->
		<input id="app-event-1" type="radio" name="app-event-1" checked="checked"/>
		<input id="app-event-2" type="radio" name="app-event-1"/>
		<input id="app-event-3" type="radio" name="app-event-1"/>
		<input id="app-event-4" type="radio" name="app-event-1"/>
		<div class="body">
		  <div class="app">
		 
		    <div class="app-header">
		      <div class="app-tabs">
		        <label class="app-tabs__tab app-tabs__tab--one" for="app-event-1"><i class="fa fa-home" aria-hidden="true"></i></label>
		        <label class="app-tabs__tab app-tabs__tab--two" for="app-event-2"><i class="fa fa-map-o" aria-hidden="true"></i></label>
		        <label class="app-tabs__tab app-tabs__tab--three" for="app-event-3"><i class="fa fa-bar-chart" aria-hidden="true"></i></label>
		        <label class="app-tabs__tab app-tabs__tab--four" for="app-event-4"><i class="fa fa-plus-circle" aria-hidden="true"></i></label>
		      </div>
		    </div>
		    <div class="app-body">
		      <div class="app-panel app-panel--one">
		      	<div class="top-layout">
		        	<span class="level-profile">Level ${voluntario.level}</span>
		        	<table>
		            	<tr>
		                    <td><a href="perfil.html"><img src="${voluntario.avatarNoJeito}" class="img-profile" width="49" height="49"/></a></td>
		                    <td>
		                    	<a href="perfil.html">
		                            <p class="name-profile">${voluntario.nome}</p>
		                        </a>
		                     </td>
		                  </tr>
		           </table>
		        </div>
		        <div class="sucesso hidden">
		        	<a href="solicitacao-aceita.html">
						<table>
							<tr>
								<td><i class="fa fa-check fa-2x" aria-hidden="true"></i></td>
								<td><h3 style="margin-left: 15px;">Sua solicitação foi aceita.</h3>
		                        <p style="margin-left: 15px;">Clique aqui e confirme e receba suas instruções</p></td>
							</tr>
						</table>
		            </a>
		        </div>
		        
		        <c:set value="${agendado =='true' ? 'ok' : 'hidden'}" var="hidden"/>       
		        <div class="alerta ${hidden}">
		        	<a href="solicitacao-analise.html">
						<table>
							<tr>
								<td><i class="fa fa-clock-o fa-2x" aria-hidden="true"></i></td>
								<td><h3 style="margin-left: 15px;">Sua solicitação está em analize.</h3></td>
							</tr>
						</table>
		            </a>
		        </div>
		              
		        <div class="erro hidden">
		          	<a href="solicitacao-recusada.html">
						<table>
							<tr>
								<td><i class="fa fa-times fa-2x" aria-hidden="true"></i></td>
								<td><h3 style="margin-left: 15px;">Sua solicitação foi recusada.</h3>
		                        <p style="margin-left: 15px;">Clique aqui e veja os motivos</p></td>
							</tr>
						</table>
		            </a>
		        </div>	
		                
		        <h3 class="title-pages">INSTITUIÇÕES MAIS PRÓXIMAS</h3>
		        <c:forEach items="${instituicoes}" var="inst">
			          	<div class="intituicoes-proximas">
			          	<table>
			            	<tr>
								<c:if test="${not empty inst.avatar }">
				                	<td><span><a href="/bemdahora/instituicao/${inst.id}"><img src="${inst.avatarNoJeito}" class="img-profile-company" width="40" height="40"/></span></a></td>
								</c:if>	            	
			                    <td><span class="name-profile-company"><a href="/bemdahora/instituicao/${inst.id}">${inst.razaoSocial}</a></span></td>
			                </tr>
			            </table>
						<p>${inst.sobre}</p></td>
			          	<section>
				          	<c:forEach items="${inst.fotosInstituicao}" var="foto">
				          		<img src="${foto.fotoNoJeito}"  width="90" height="90"/>
				          	</c:forEach>
			          	</section>
			            <center>
		                    <a href="/bemdahora/instituicao/${inst.id}" style="text-decoration:none">
		                        <p class="botao-company">SAIBA MAIS</p>
		                    </a>
		                </center>
			          </div>          	
		          </c:forEach>      
		      </div> <!--/app-panel--one-->
		      
		      <div class="app-panel app-panel--two">
		        <div id="map"></div>
		      </div><!--/app-panel--two-->
		      
		      <div class="app-panel app-panel--three">
		      	<div class="top-layout">
		        	<p class="title-page">RANKING</p>
		        </div>
		        <table style="width: 200px; margin: 40px auto">
		           	<tr>
		               	<td>
		                   	<center><a href="perfil.html"><img src="imgs/profile.jpg" class="img-ranking"/></a></center>
		                </td>
		            </tr>
		            <tr>
		              	<td>
		       	    		<p class="name-profile" style="text-align:center; color:#999">ANDRÉ VASCONCELOS
		                </td>
		            </tr>
		            <tr>
		              	<td>
		            	    <center>Nº 2</center>
		                </td>
		            </tr>
		        </table>
		        <div class="top-ranking">
		          	<table>
		               	<tr>
		                  	<td><span class="position">1</span></td>
		                    <td><img src="imgs/profile.jpg" class="img-profile" /></td>
		                    <td width="250px"><span class="nome-ranking">NOME</span></td>
		                    <td><span class="medals">GOLD</span></td>
		                </tr>
		            </table>
		       	</div>
		        <div class="top-ranking2">
		           	<table>
		        	   	<tr>
		                  	<td><span class="position">2</span></td>
		                    <td><img src="imgs/profile2.jpg" class="img-profile" /></td>
		                    <td width="250px"><span class="nome-ranking">NOME</span></td>
		                    <td><span class="medals">GOLD</span></td>
		            	</tr>
		            </table>
		        </div>
		        <div class="top-ranking3">
		         	<table>
		        	  	<tr>
		                 	<td><span class="position">3</span></td>
		                    <td><img src="imgs/profile3.jpg" class="img-profile" /></td>
		                    <td width="250px"><span class="nome-ranking">NOME</span></td>
		                    <td><span class="medals">GOLD</span></td>
		                </tr>
		            </table>
		        </div>
		        <div class="ranking">
		          	<table>
		              	<tr>
		                 	<td><span class="position">4</span></td>
		                    <td><img src="imgs/profile4.jpg" class="img-profile" /></td>
		                    <td width="250px"><span class="nome-ranking">NOME</span></td>
		                    <td><span class="medals">GOLD</span></td>
		                </tr>
		            </table>
		        </div>
		        <div class="ranking">
		          	<table>
		              	<tr>
		        	        <td><span class="position">5</span></td>
		                    <td><img src="imgs/profile5.jpg" class="img-profile" /></td>
		                    <td width="250px"><span class="nome-ranking">NOME</span></td>
		                    <td><span class="medals">GOLD</span></td>
		                </tr>
		            </table>
		        </div>
		      </div><!--app-panel--three-->
		      
		      
		      <div class="app-panel app-panel--four">
			  	<div class="top-layout">
		        	<h3 class="title-page">SAIBA MAIS...</h3>
		        </div>
		        <div class="saiba-mais">
		        	<a href="<c:url value='/resources/files/guia.pdf'/>" download><p><img src="<c:url value='/resources/images/termos-de-voluntariado.png'/>"> Termos de Voluntariado <i class="fa fa-download" aria-hidden="true"></i></p></a>
		            <a href="#"><p><img src="<c:url value='/resources/images/ndh.png'/>"> Sobre Bem da Hora</p></a>
		            <a href="/bemdahora/manual/${voluntario.id}"><p><img src="<c:url value='/resources/images/manual.png'/>"> Manual de Condutas e práticas </p></a>
		            <a href="/bemdahora/legislacao/${voluntario.id}"><p><img src="<c:url value='/resources/images/legislacao.png'/>"> Legislação e Direitos do Trabalhador Voluntário</p></a>               
		            <!--<a href="#"><p><img src="imgs/eticas.png"> Éticas do Voluntário</p></a>-->
		        </div>
		      </div><!--app-panel--four-->
		 
		    </div>
		  </div>
		</div>
		<!--  <script src='https://codepen.io/andytran/pen/vLmRVp.js'></script>-->
		  
		 <script>
		    (function() {
		      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		    })();
		  </script>
		
		  <!-- Mapa -->
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCQ0oVU7CttR8ps9vNZ8UMxwDFQ5eNeJM4&callback=initialize"></script>
		
		<script>
		
		console.log("Iniciando...");
		var locations = [
			 <c:forEach items="${instituicoes}" var="inst">
			 	['${inst.nome}','${inst.endereco}','/bemdahora/instituicao/${inst.id}'],
			 </c:forEach>
			/*
		    ['Abrigo para crianças Santa Sara', 'Rua Cesar Marengo 161, São Paulo, Brasil', 'Location 1 URL'],
		    ['Escola Estadual Jão José Abraão', 'Rua Lourenço Marques 158, São Paulo, Brasil', 'Location 2 URL'],
		    ['Restaurante Comunitario Carlos Alberto', 'Avenida Santo Amaro 50, São Paulo, Brasil', 'Location 3 URL']
			*/
		];
	
		var geocoder;
		var map;
		var bounds = new google.maps.LatLngBounds();
		/*
		 * 
		 function initialize() {
			    var loc = {};
			    var geocoder = new google.maps.Geocoder();
			    if(google.loader.ClientLocation) {
			        loc.lat = google.loader.ClientLocation.latitude;
			        loc.lng = google.loader.ClientLocation.longitude;
		
			        var latlng = new google.maps.LatLng(loc.lat, loc.lng);
			        geocoder.geocode({'latLng': latlng}, function(results, status) {
			            if(status == google.maps.GeocoderStatus.OK) {
			                alert(results[0]['formatted_address']);
			            };
			        });
			    }
			}
		*/
		 
		function initialize() {
		    map = new google.maps.Map(
		    document.getElementById("map"), {
		    	center: new google.maps.LatLng(37.4419, -122.1419),
		        zoom: 13,
		        mapTypeId: google.maps.MapTypeId.ROADMAP
		    });
		    geocoder = new google.maps.Geocoder();
		
		    for (i = 0; i < locations.length; i++) {
		        geocodeAddress(locations, i);
		    }
		}
		google.maps.event.addDomListener(window, "load", initialize);
		
		function geocodeAddress(locations, i) {
		    var title = locations[i][0];
		    var address = locations[i][1];
		    var url = locations[i][2];
		    geocoder.geocode({
		        'address': locations[i][1]
		    },
		
		    function (results, status) {
		        if (status == google.maps.GeocoderStatus.OK) {
		            var marker = new google.maps.Marker({
		                icon: 'http://maps.google.com/mapfiles/ms/icons/blue.png',
		                map: map,
		                position: results[0].geometry.location,
		                title: title,
		                animation: google.maps.Animation.DROP,
		                address: address,
		                url: url
		            })
		            infoWindow(marker, map, title, address, url);
		            bounds.extend(marker.getPosition());
		            map.fitBounds(bounds);
		        } else {
		            alert("geocode of " + address + " failed:" + status);
		        }
		    });
		    
		}
		
		function infoWindow(marker, map, title, address, url) {
		    google.maps.event.addListener(marker, 'click', function () {
		        var html = "<div><h3>" + title + "</h3><p>" + address + "<br></div><a href='" + url + "'>View location</a></p></div>";
		        infoWindow = new google.maps.InfoWindow({
		            content: html,
		            maxWidth: 350
		        });
		        
		    	infoWindow.open(map, marker);
		    });
		}
		    </script> 
	</body>
</html>