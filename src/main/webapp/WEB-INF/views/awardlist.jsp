<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Awards</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
		  	<div class="panel-heading"><span class="lead">Awards</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Name</th>
				        <th>Year</th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th>Action</th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
		    		<c:choose>
						<c:when test="${empty awards}">
							<td colspan="3">No Record available</td>
						</c:when>
						<c:otherwise>
							<c:forEach items="${awards}" var="award">
								<tr>
									<td>${award.name}</td>
									<td>${award.year}</td>
								    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
										<td>
											<a href="<c:url value='/edit-award-${award.awdId}' />" style="text-decoration: none;">edit</a>
											&nbsp;&nbsp;&nbsp;
											<a href="<c:url value='/delete-award-${award.awdId}' />" style="text-decoration: none;">delete</a>
										</td>
							        </sec:authorize>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
	    		</tbody>
	    	</table>
		</div>
		<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
		 	<div class="well">
		 		<a href="<c:url value='/newaward' />">New Award</a>
		 	</div>
	 	</sec:authorize>
   	</div>
</body>
</html>