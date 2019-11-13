<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Movie Create</title>
<spring:url value="/resources" var="publicUrl" />
<link href="${publicUrl}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${publicUrl}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Movie data</span>
			</h3>
		</div>

		<spring:url value="/movies/save" var="formUrl"></spring:url>

		<spring:hasBindErrors name="movie">
			<div class="alert alert-danger" role="alert">
				Please, fixed the next errors:
				<ul>
					<c:forEach items="${errors.allErrors}" var="error">
						<li><spring:message message="${error}"></spring:message></li>
					</c:forEach>
				</ul>
			</div>
	
		</spring:hasBindErrors>		

		<form action="${formUrl}" method="post">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for=""title"">Title</label> <input type="text"
							class="form-control" name="title" id=""
							title"" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="duration">Duration</label> <input type="text"
							class="form-control" name="duration" id="duration"
							required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="classification" class="control-label">Classification</label>
						<select id="classification" name="classificacion"
							class="form-control">
							<option value="A">Clasifitacion A</option>
							<option value="B">Clasifitacion B</option>
							<option value="C">Clasifitacion C</option>
						</select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="genre" class="control-label">Genre</label> <select
							id="genre" name="genre" class="form-control">
							<option value="Accion">Accion</option>
							<option value="Aventura">Aventura</option>
							<option value="Clasicas">Clasicas</option>
							<option value="Comedia Romantica">Comedia Romantica</option>
							<option value="Drama">Drama</option>
							<option value="Terror">Terror</option>
							<option value="Infantil">Infantil</option>
							<option value="Accion y Aventura">Accion y Aventura</option>
							<option value="Romantica">Romantica</option>
						</select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="status" class="control-label">Status</label> <select
							id="status" name="status" class="form-control">
							<option value="Active">Active</option>
							<option value="Inactive">Inactive</option>
						</select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="premiereDate">Premiere date</label> <input type="text"
							class="form-control" name="premiereDate" id="premiereDate"
							required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="image">Image</label> <input type="file" id="image"
							name="image" />
						<p class="help-block">Movie image</p>
					</div>
				</div>
			</div>

			<!--  
        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="director">Director</label>
              <input type="text" class="form-control" name="director" id="director" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="actores">Actores</label>
              <input type="text" class="form-control" name="actores" id="actores" required="required" />
            </div>  
          </div>

          <div class="col-sm-6">
            <div class="form-group">
              <label for="trailer">URL del Trailer (Youtube)</label>
              <input type="text" class="form-control" name="trailer" id="trailer" placeholder="URL completa del video de YOUTUBE" required="required" />
            </div>  
          </div> 
        </div> 

        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
              <textarea class="form-control" rows="5" name="sinopsis" id="sinopsis"></textarea>
            </div> 
          </div> 
        </div>
        -->

			<button type="submit" class="btn btn-danger">Save</button>
		</form>

		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${publicUrl}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#premiereDate").datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
	</script>
</body>
</html>
