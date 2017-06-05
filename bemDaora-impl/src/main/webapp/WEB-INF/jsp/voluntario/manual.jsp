<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="myApp">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Manual de Práticas e Condutas Éticas</title>
      <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
      <link href="<c:url value='/resources/css/main.css?version=3'/>" rel="stylesheet" type="text/css">
      <!-- FONT AWESOME -->
      <link rel="stylesheet" href="/bemdahora/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
      <!-- FONT AWESOME -->
      
   </head>
   <body>
      <div class="container">
         <div id="cont">
         	<div style=" height: 58px; width: 100%; margin-bottom: 10px; background: #007dbe;">
               <span style="float:left; padding: 16px 0 0 18px; font-size: 20px;">
                    <a href="<c:url value='/voluntario/home/${idVoluntario}'/>" style="color:white">
                    	<i class="fa fa-arrow-left" aria-hidden="true"></i>
                    </a>
               </span>
            </div><!--top-layout-->
            
            <div style="background:url(<c:url value='/resources/images/top.png'/>);height:10px; width: 100%; margin-bottom: 30px"></div>
            <div class="saiba-mais">
            	<table>
                    <tr>
                    	<td><img src="<c:url value='/resources/images/logo.png'/>" style="width:100px"/></td>
                        <td><h2 style="color: #007dbe; margin-left: 15px;">Manual de Práticas e Condutas Éticas</h2></td>
                    </tr>
                </table>
                <br/>
                <h3>Deveres do Voluntário para com os Destinatários:</h3>                         
                <p>· Respeitar a vida privada e a dignidade da pessoa;</p>   
                <p>· Respeitar as convicções ideológicas, religiosas e culturais;</p>   
                <p>· Guardar sigilo sobre assuntos confidenciais;</p>   
                <p>· Usar de bom senso na resolução de assuntos imprevistos, informando os respectivos responsáveis;</p>   
                <p>· Actuar de forma gratuita e interessada, sem esperar contrapartidas e compensações patrimoniais;</p>   
                <p>· Contribuir para o desenvolvimento pessoal e integral do destinatário;</p>   
                <p>· Garantir a regularidade do exercício do trabalho voluntário.</p>
                <br/>
                <h3>Deveres do Voluntário para com a Organização Promotora:</h3>
                <p>· Observar os princípios e normas inerentes à atividade, em função dos domínios em que se insere;</p>
                <p>· Conhecer e respeitar estatutos e funcionamento da organização, bem como as normas dos respectivos programas e projetos;</p>
                <p>· Atuar de forma diligente, isenta e solidária;</p>
                <p>· Zelar pela boa utilização dos bens e meios postos ao seu dispor;</p>
                <p>· Participar em programas de formação para um melhor desempenho do seu trabalho;</p>
                <p>· Dirimir conflitos no exercício do seu trabalho de voluntário;</p>
                <p>· Garantir a regularidade do exercício do trabalho voluntário.</p>
                <p>· Não assumir o papel de representante da organização sem seu conhecimento ou prévia autorização;</p>
                <p>· Utilizar devidamente a identificação como voluntário no exercício da sua atividade;</p>
                <p>· Informar a organização promotora com a maior antecedência possível sempre que pretenda interromper ou cessar o trabalho voluntário.</p>
                <br/>
                <h3>Deveres do Voluntário para com os Profissionais:</h3>
                <p>· Colaborar com os profissionais da organização promotora, potenciando a sua atuação no âmbito de partilha de informação e em função das orientaçõestécnicas inerentes ao respectivo domínio de atividade;</p>
                <p>· Contribuir para o estabelecimento de uma relação fundada no respeito pelo trabalho que cada um compete desenvolver.</p>
                <br/>
                <h3>Deveres do Voluntário para com os outros voluntários:</h3>
                <p>· Respeitar a dignidade e liberdade dos outros voluntários, reconhecendo-os como pares e valorizando o seu trabalho;</p>
                <p>· Fomentar o trabalho de equipe, contribuindo para uma boa comunicação e um clima de trabalho e convivência agradável;</p>
                <p>· Facilitar a integração, formação e participação de todos os voluntários.</p>
                <br/>
               	<h3>Deveres do Voluntário para com a Sociedade:</h3>
                <p>· Fomentar uma cultura de solidariedade;</p>
                <p>· Difundir o voluntariado;</p>
                <p>· Conhecer a realidade sócio-cultural da comunidade, onde desenvolve a sua atividade de voluntário;</p>
                <p>· Complementar a ação social das entidades em que se integra;</p>
                <p>· Transmitir com a sua atuação, os valores e os ideais do trabalho voluntário.</p>
            </div>
           	
         </div>
      </div>
      </div>
   </body>
</html>