<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de imagenes del banner</title>
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlbase"></spring:url>
    <link href="${urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic }/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">My CineSite</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">Acerca</a></li>
            <li><a href="#">Login</a></li>            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container theme-showcase" role="main">

      <h3>Listado de imagenes del Banner</h3>
      
      <a href="${urlbase }/banners/create" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>
		<c:if test="${messageInfo != null }">
			<div class="alert alert-success" role="alert">${messageInfo}</div>
		</c:if>
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Title</th>                           
                <th>Pub Date</th>              
                <th>File Name</th>
                <th>Status</th>
                <th>Options</th>              
            </tr>
            <c:forEach items="${banners}" var="banner">
            <tr>
                <td>${banner.id }</td>
                <td>${banner.title }</td>
                 <td><fmt:formatDate value="${banner.date }" pattern="yyyy-MM-dd"/> </td>    
                <td>${banner.file }</td>                         
                <td>
                	<c:choose>
                		<c:when test="${banner.status  == 'Active'}">
                			<span class="label label-success">Active</span>	
                		</c:when>
                		<c:otherwise>
                			<span class="label label-danger">Inactive</span>
                		</c:otherwise>
                	
                	</c:choose>
                </td>
                <td>
                    <a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="#" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>                
            </tr>
            </c:forEach>
            
        </table>
      </div>  
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <footer>        
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic }/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>
