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
					"mm" : mm,
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

function myFunction() {
	alert("Message");
}

function makeTree() {
	//var firstName = $('input_firstName').value;
	var firstName = document.getElementsByName("input_firstName")[0].value;
	var lastName = document.getElementsByName("input_lastName")[0].value;
	var gender = document.getElementsByName("input_gender")[0].value;

	if(firstName && lastName && gender) {
		$.ajax(
			{
				type : "POST",
				url : "/tree/traditional/create",
				data: {
					"firstName" : firstName,
					"lastName" : lastName,
					"gender" : gender
				},
				
				success : function(result) {
					loadTree(result);
				},
				
				error : function(jqXHR, exception) {
					alert("The tree could not be created. Please refresh the page and try again.");
				}
			});
	}
	else {
		alert("Please fill out every field.");
	}
}

function loadTree(uid) {
	if(uid) {
		$.ajax(
			{
				type : "GET",
				url : "/tree/traditional/" + uid,
				data: {
					"uid" : uid
				},
				
				success : function(result) {
					location.href = "/tree/traditional/" + uid;
				},
				
				error : function(jqXHR, exception) {
					alert("The tree could not be loaded.");
				}
			});

	}
	else {
		alert("Invalid UID");
	}
}