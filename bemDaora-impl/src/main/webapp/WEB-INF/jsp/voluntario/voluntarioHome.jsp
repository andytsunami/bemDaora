<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>BemdaHora</title>
	<bd:import-estilos/>
  	<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
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
  <div style="max-width: 600px; margin: auto; box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 7px;">
    <div id="demo">
        <div class="first dragend-page">
          <div class="top-layout">
			<span class="level-profile">Level ${voluntario.level}</span>
            <table>
              <tr>
                <td><a href="perfil.html"><img src="${voluntario.avatarNoJeito}" class="img-profile" /></a></td>
                <td><a href="perfil.html"><p class="name-profile">${voluntario.nome}</p></a></td>
              </tr>
            </table>
          </div>
          <h3 class="title-pages">INSTITUIÇÕES PRÓXIMAS</h3>
          
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
	            <center><a href="/bemdahora/instituicao/${inst.id}" style="text-decoration:none"><p class="botao-company">SAIBA MAIS</p></a></center>
	          </div>          	
          </c:forEach>
        </div>
        
<div class="middle dragend-page">
	<div id="map"></div>
</div>
        <div class="middle dragend-page">
        	<div style="height: 58px; width: 100%; box-shadow: 1px 1px 6px rgba(204, 204, 204, 0.31); background: white;">    
            	<p class="title-page">RANKING</p>
        	</div>
            <table style="width: 200px; margin: 40px auto">
            	<tr>
                	<td><center><a href="perfil.html"><img src="imgs/profile.jpg" class="img-ranking"/></a></center></td>
                </tr>
                <tr>
                	<td><p class="name-profile" style="text-align:center">${voluntario.nome}</td>
                </tr>
                <tr>
                	<td><center>Nº 2</center></td>
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
            <div class="ranking">
            <table>
            	<tr>
                	<td><span class="position">2</span></td>
                	<td><img src="imgs/profile.jpg" class="img-profile" /></td>
                	<td width="250px"><span class="nome-ranking">NOME</span></td>
                    <td><span class="medals">GOLD</span></td>
                </tr>
            </table>
            </div>
            <div class="ranking">
            <table>
            	<tr>
                	<td><span class="position">3</span></td>
                	<td><img src="imgs/profile.jpg" class="img-profile" /></td>
                	<td width="250px"><span class="nome-ranking">NOME</span></td>
                    <td><span class="medals">GOLD</span></td>
                </tr>
            </table>
            </div>
            <div class="ranking">
            <table>
            	<tr>
                	<td><span class="position">4</span></td>

                	<td><img src="imgs/profile.jpg" class="img-profile" /></td>

                	<td width="250px"><span class="nome-ranking">NOME</span></td>

                    <td><span class="medals">GOLD</span></td>

                </tr>

            </table>

            </div>

            <div class="ranking">

            <table>

            	<tr>

                	<td><span class="position">5</span></td>

                	<td><img src="imgs/profile.jpg" class="img-profile" /></td>

                	<td width="250px"><span class="nome-ranking">NOME</span></td>

                    <td><span class="medals">GOLD</span></td>

                </tr>

            </table>

            </div>

        </div>



        <div class="dragend-page saiba-mais">

        	<div style="height: 58px; width: 100%; box-shadow: 1px 1px 6px rgba(204, 204, 204, 0.31); background: white;">    

            	<p class="title-page">SAIBA MAIS...</p>

        	</div>

            <p>Termos de Voluntariado</p>

            <p>Sobre Bem da Hora</p>

            <p>Manual de Condutas e práticas </p>

            <p>Legislação e Direitos do Trabalhador Voluntário</p>

            <p>Requisitos para namorar o james: DINHEIRO</p>

            <p>Éticas do Voluntário</p>

        

        </div>









    </div>











    <ul class="nav">

	<center>

      <li data-page="1" class="active"><i class="fa fa-home" aria-hidden="true"></i></li>



      <li data-page="2"><i class="fa fa-map-o" aria-hidden="true"></i></li>



      <li data-page="3"><i class="fa fa-bar-chart" aria-hidden="true"></i></li>



      <li data-page="4"><i class="fa fa-plus-circle" aria-hidden="true"></i></li>

	</center>

    </ul>







  







  </div>
  <script type="text/javascript" src="<c:url value='/resources/js/dragend.js'/>"></script>
  <script>
    $(function() {
      $("#demo").dragend({
        afterInitialize: function() {
          this.container.style.visibility = "visible";
        },
        onSwipeEnd: function() {



          var first = this.pages[0],



              last = this.pages[this.pages.length - 1];







          $(".prev, .next").removeClass("deactivated");



          $(".nav li").removeClass("active");







          if (first === this.activeElement) {



            $(".prev").addClass("deactivated")



          };







          if (last === this.activeElement) {



            $(".next").addClass("deactivated")



          }







          $(".nav li").eq(this.page).addClass("active");







        }



      });







      $(".prev").click(function() {



        $("#demo").dragend("right");



      });







      $(".next").click(function() {



        $("#demo").dragend("left");



      });







      $(".nav").click(function() {



        var page = $(event.target).data("page");







        $("#demo").dragend({



          scrollToPage: page



        });







        $(event.target).addClass("active");







      })







    });







    var _gaq = _gaq || [];



    _gaq.push(['_setAccount', 'UA-219062-10']);



    _gaq.push(['_trackPageview']);







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
	 	['${inst.nome}','${inst.endereco}','...'],
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
