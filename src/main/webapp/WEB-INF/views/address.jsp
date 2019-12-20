<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

		<div class="well lead">Address</div>
	 	<form:form method="POST" modelAttribute="address" class="form-horizontal">
			<form:input type="hidden" path="addrId" id="addrId"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lineOne">Line1</label>
					<div class="col-md-7">
						<form:input type="text" path="lineOne" id="lineOne" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="lineOne" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lineTwo">Line2</label>
					<div class="col-md-7">
						<form:input type="text" path="lineTwo" id="lineTwo" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lineTwo" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="city">City</label>
					<div class="col-md-7">
						<form:input type="text" path="city" id="city" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="city" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="state">State</label>
					<div class="col-md-7">
						<form:input type="text" path="state" id="state" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="state" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="country">Country</label>
					<div class="col-md-7">
						<form:input type="text" path="country" id="country" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="country" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="postalCode">Postal Code</label>
					<div class="col-md-7">
						<form:input type="text" path="postalCode" id="postalCode" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="postalCode" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/addresslist' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Save" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/addresslist' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>