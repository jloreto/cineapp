<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Movie List</title>
<spring:url value="/resources" var="publicUrl" />
<link href="${publicUrl}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${publicUrl}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Movie List</h3>


		<spring:url value="/movies/create" var="formUrl" />

		<a href="${formUrl}" class="btn btn-success" role="button"
			title="Nueva Pelicula">New</a><br> <br>
		<c:if test="${messageInfo != null }">
			<div class="alert alert-success" role="alert">${messageInfo}</div>
		</c:if>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Title</th>
					<th>Genre</th>
					<th>Classification</th>
					<th>Duration</th>
					<th>Premiere Date</th>
					<th>Status</th>
					<th>Options</th>
				</tr>

				<c:forEach items="${movies}" var="mov">
					<tr>
						<td>${mov.title }</td>
						<td>${mov.genre }</td>
						<td>${mov.classification }</td>
						<td>${mov.duration }</td>
						<td><fmt:formatDate value="${mov.premiereDate }"
								pattern="yyyy-MM-dd" /></td>
						<td><c:choose>
								<c:when test="${mov.status == 'Active' }">
									<span class="label label-success">${mov.status }</span>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">${mov.status }</span>
								</c:otherwise>
							</c:choose></td>
						<td><a href="#" class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="#" class="btn btn-danger btn-sm" role="button"
							title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>

				</c:forEach>

			</table>
		</div>

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
</body>
</html>
