function test() {
	window.location.href = "http://yahoo.com";
}


function addTraditionalFamilyMember() {
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

function removeTraditionalFamilyMember(uid) {
	var uid = $('#input_uid').val();
	
	if(uid) {
		$.ajax(
			{
				type : "DELETE",
				url : "/tree/traditional/",
				data: {
					"uid" : uid
				},
				
				success : function(result) {
					location.reload();
				},
				
				error : function(jqXHR, exception) {
					alert("The UID entered was not found. Cannot delete Family Member.");
				}
			});
	}
	else {
		alert("Please enter a UID.");
	}
}
