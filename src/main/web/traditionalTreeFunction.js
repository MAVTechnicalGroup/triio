function addUser() {
	var firstName = $('#input_firstName').val();
	var lastName = $('#input_lastName').val();
	var middleName = $('#input_middleName').val();
	var gender = $('#input_gender').val();
	var dd = $('#input_day').val();
	var mm = $('#input_month').val();
	var yyyy = $('#input_year').val();
	
	if(firstName && lastName && gender) {
		$.ajax(
			{
				type : "POST",
				url : "/tree/traditional/",
				data: {
					"firstName" : firstName,
					"lastName" : lastName,
					"middleName" : middleName,
					"gender" : gender,
					"dd" : dd,
					"mm" : mm.
					"yyyy" : yyyy
				},
				
				success : function(result) {
					location.reload();
				},
				
				error : function(jqXHR, exception) {
					alert("Failed to add the Family Member. Please check your inputs.");
				}
			});
	}
	else {
		alert("Invalid First Name, Last Name, or Gender");
	}					
}
