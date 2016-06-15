<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript">
	
	function validation()
	{
		console.log("In function");
		var name= document.home.userName.value;
		var address= document.home.address.value;
		var pan= document.home.pan.value;
		var dob= document.home.dob.value;
		var assess_year= document.home.assess_year.value;
		var income= document.home.income.value;
		var tds= document.home.tds.value;
		var tax_deduct= document.home.tax_deduct.value;
	
		var validData = true;
	
		if(name==""||address==""||pan==""||dob==""||assess_year==""||income==""||tax_deduct==""||tds=="") {
			validData = false;
			console.log("Blank Validation");
		}
		
		var letterNumber = new RegExp("^[0-9]+$"); 
		
		if(!letterNumber.test(income)||!letterNumber.test(tds)){
			validData = false;
			console.log("Number Validation");
		}
		
		var letterNumber = new RegExp("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		if(!letterNumber.test(pan))
			{
			validData = false;
			console.log("Pancard Validation")
			}
	
		var yearReg = '(19[0-9][0-9]|20[0-9][0-9])';            
		var monthReg = '(0[1-9]|1[0-2])';
		var dayReg = '(0[1-9]|1[0-9]|2[0-9]|3[0-1])'; 

		var reg = new RegExp('^' + dayReg + '/' + monthReg + '/' + yearReg); 
		if(!reg.test(dob))
			{
			validData = false;
			console.log("Date Validation")
			}
		
			
		if(validData) {
			document.getElementById("document").submit();
		} else {
			alert('Please fill all required data in valid format');
		}
		
	};
	
	
	
	function checkIncome()
	{
		
		var income= document.home.income.value;
		var letterNumber = new RegExp("^[0-9]+$"); 
		
		if(!letterNumber.test(income)){
			alert("Please enter number");
		}
	};
	
	function calculateTax()
	{
		var income= document.home.income.value;
		var tds= document.home.tds.value;
		
		var letterNumber = new RegExp("^[0-9]+$"); 
		
		if(!letterNumber.test(income)){
			alert("Please enter number");
		}
	};

	
	</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tax Application</title>
</head>

<%
	int year = Calendar.getInstance().get(Calendar.YEAR);
	String val1= Integer.toString(year-2);
	String val2= Integer.toString(year-1);
	String val3= Integer.toString(year);
	String val4= Integer.toString(year+1);
	String a1= val1+"-"+val2;
	String a2= val2+"-"+year;
	String a3= year+"-"+val4;
	String[] assessmentYearList = {a1,a2,a3};
%>

<body>
<form action="servlet" method="post" id="document" name="home">

	<center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
							<th colspan="2">Personal Information</th>
					</tr>
				</thead>
			<tbody>
			<tr>	
					<td>Name:</td><td><input type="text" name="userName" id="name" placeholder="Name"/></td>
			</tr>
			<tr>
					<td>Address:</td><td><input type="text" name="address" placeholder="Address"/></td>
	    	</tr>
	    	<tr>	
	    			<td>PAN:</td><td><input type="text" name="pan" placeholder="Pan Card Number"/></td>
	    	</tr>
	    	<tr>
					<td>Date of Birth:</td><td><input type="text" name="dob" placeholder="DD/MM/YYYY"/"></td>
			</tr>
			<tr>
					  <td>Assessment Year:</td><!-- <td><input type="text" name="assess_year" /></td>--><td>
				<select name="assess_year" id="assess_year">
				 <option value="">Select one</option>
          			<% for(int i = 0; i < assessmentYearList.length; i++) {
          				out.println("<option value=\""+assessmentYearList[i]+"\">"+assessmentYearList[i]+"</option>");
          			 } %>
</select>
			</td></tr>
			<tr>
					<td>Income:</td><td><input type="text" name="income" placeholder="Income" onkeyup="checkIncome();"/></td>
			</tr>
			<tr>
					<td>TDS:</td><td><input type="text" name="tds" placeholder="TDS" onkeyup="calculateTax();" /></td>
			</tr>
			<tr>
					<td>Tax Deducted:</td><td><input type="text" id="taxDeduct" name="tax_deduct" placeholder="Tax Deducted"/></td>
			</tr>
			<tr><td><input type="button" value="Save" onclick="validation();"/></td></tr>
			<tr><td><input type="reset" value="Clear" onclick="this.form.reset()"/></td></tr>
</tbody>
</table>
</center>
	</form>
	
</body>
</html>