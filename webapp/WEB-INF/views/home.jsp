<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to CineApp</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<spring:url value="/resources" var="publicUrl" />
</head>
<body>
	<%-- 
	<h1>Movie List</h1>

	<ol>
		<c:forEach items="${movies}" var="mov">
			<li>${mov}</li>
		</c:forEach>

	</ol>
--%>
	<div class="card">

		<div class="card-header">Movie Table</div>
		<div class="card-body">

			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Duration</th>
						<th>Classification</th>
						<th>Genre</th>
					<tr>
				</thead>
				<tbody>
					<c:forEach items="${movies}" var="mov">

						<tr>
							<td>${mov.id }</td>
							<td>${mov.title }</td>
							<td>${mov.duration }min.</td>
							<td>${mov.classification }</td>
							<td>${mov.genre }</td>
							<td><img width="80" src="${publicUrl}/images/${mov.image }" /></td>
							<td><fmt:formatDate value="${mov.premiereDate}"
									pattern="yyyy-MM-dd" /></td>
							<td><c:choose>
									<c:when test="${mov.status == 'Active' }">
										<span class="badge badge-success">Active</span>
									</c:when>
									<c:otherwise>
										<span class="badge badge-danger">Inactive</span>
									</c:otherwise>
								</c:choose></td>
						</tr>

					</c:forEach>

				</tbody>


			</table>
		</div>
	</div>
</body>
</html>