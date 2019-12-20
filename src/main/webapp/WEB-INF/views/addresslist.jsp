<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Address</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
		  	<div class="panel-heading"><span class="lead">Address</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Line1</th>
				        <th>Line2</th>
				        <th>City</th>
				        <th>State</th>
				        <th>Country</th>
				        <th>PostalCode</th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th>Action</th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
		    		<c:choose>
						<c:when test="${empty addrs}">
							<td colspan="7">No Record available</td>
						</c:when>
						<c:otherwise>
							<c:forEach items="${addrs}" var="addr">
								<tr>
									<td>${addr.lineOne}</td>
									<td>${addr.lineTwo}</td>
									<td>${addr.city}</td>
									<td>${addr.state}</td>
									<td>${addr.country}</td>
									<td>${addr.postalCode}</td>
								    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
										<td>
											<a href="<c:url value='/edit-addr-${addr.addrId}' />" style="text-decoration: none;">edit</a>
											&nbsp;&nbsp;&nbsp;
											<a href="<c:url value='/delete-addr-${addr.addrId}' />" style="text-decoration: none;">delete</a>
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
		 		<a href="<c:url value='/newaddress' />">New Address</a>
		 	</div>
	 	</sec:authorize>
   	</div>
</body>
</html>