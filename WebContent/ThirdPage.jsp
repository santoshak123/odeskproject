<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form name="page3data">
<div class="formLayout"> 
	 <label>First Name :</label>
    <label>${fdata.fname}</label><br>
    <label>Last Name :</label>
    <label>${fdata.lname}</label><br>																
    <label>Sex :</label>
    <label>${fdata.sex}</label><br>																						
   <label>City :</label>															
     <label>${fdata.city}</label><br>																		
     <label>Zipcode :</label>
     <label>${fdata.zip}</label><br>
     <label>Country :</label>
     <label>${fdata.country}</label><br>																							  					
     <label></label>
    																		      
</div>
</form>																										
</body>
</html>