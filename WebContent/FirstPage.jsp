<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Application</title>
   <style type="text/css">             
.formLayout
{
    background-color: #f3f3f3;
    border: solid 1px #a1a1a1;
    padding: 10px;
    width: 300px;
}

.formLayout label, .formLayout input
{
    display: block;
    width: 120px;
    float: left;
    margin-bottom: 10px;
}

.formLayout label
{
    text-align: right;
    padding-right: 20px;
}

br
{
    clear: left;
}
</style>
</head>
<body>
<form name="page1data" method="post" action="${pageContext.request.contextPath}/page1">
<div class="formLayout">              
    <label>First Name</label>                                               
    <input name="fname"><br>                                                    
    <label>Last Name</label>                     
    <input name="lname"><br>
    <label>Sex</label>
     <select name="sex"> 																				
        <option value="Male">Male.</option>
        <option value="Female">Female.</option>
        <option value="Not Specified">Not Specified</option>
     </select><br>																						
   <label>City</label>		 												
     <select name="city">
     <c:forEach var="cities" items="${cityNames}">															
        <option value="${cities.value}">${cities.value}</option>
        </c:forEach>
     </select><br>																						
     <label>Zipcode</label>																 
     <input name="zip"><br>
     <label>Country</label>
     <input name="country"><br>																
     <label></label>
     <input type="submit" value="Submit for Page 2"><br>						
     <label></label>																	
     
</div>
</form>
</body>

</body>
</html>


