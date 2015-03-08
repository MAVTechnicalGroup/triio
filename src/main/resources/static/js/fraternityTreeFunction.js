function addFraternityFamilyMember(uid) {
	var firstName = document.getElementsByName("input_firstName")[0].value;
	var lastName = document.getElementsByName("input_lastName")[0].value;
	//var middleName = document.getElementsByName("input_middleName")[0].value;
	var gender = document.getElementsByName("input_gender")[0].value;
	var chapter = document.getElementsByName("input_chapter")[0].value;
	var line = document.getElementsByName("input_line")[0].value;
	var crossingClass = document.getElementsByName("input_class")[0].value;

	/*var dd = document.getElementsByName("input_day")[0].value;
	var mm = document.getElementsByName("input_month")[0].value;
	var yyyy = document.getElementsByName("input_year")[0].value;*/
	
	var big = document.getElementsByName("input_big")[0].value;
		
	if(firstName && lastName && gender && chapter && line && crossingClass) {
		$.ajax(
			{
				type : "POST",
				url : "/tree/fraternity/" + uid,
				data: {
					"firstName" : firstName,
					"lastName" : lastName,
					//"middleName" : middleName,
					"gender" : gender,
					/*"dd" : dd,
					"mm" : mm,
					"yyyy" : yyyy,*/
					"chapter" : chapter,
					"line" : line,
					"crossingClass" : crossingClass,
					"big" : big,
				},
				
				success : function(result) {
					loadTree(uid);
				},
				
				error : function(jqXHR, exception) {
					alert("Failed to add the Family Member. Please check your inputs.");
				}
			});
	}
	else {
		alert("Invalid First Name, Last Name, Gender, Chapter, Line, or Class");
	}					
}

function removeFraternityFamilyMember(uid) {
	var uid = $('#input_uid').val();
	
	if(uid) {
		$.ajax(
			{
				type : "DELETE",
				url : "/tree/fraternity/",
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
	var firstName = document.getElementsByName("input_firstName")[0].value;
	var lastName = document.getElementsByName("input_lastName")[0].value;
	var gender = document.getElementsByName("input_gender")[0].value;
	var chapter = document.getElementsByName("input_chapter")[0].value;
	var line = document.getElementsByName("input_line")[0].value;
	var crossingClass = document.getElementsByName("input_class")[0].value;

	if(firstName && lastName && gender && chapter && line && crossingClass) {
		$.ajax(
			{
				type : "POST",
				url : "/tree/fraternity/create",
				data: {
					"firstName" : firstName,
					"lastName" : lastName,
					"gender" : gender,
					"chapter" : chapter,
					"line" : line,
					"crossingClass" : crossingClass
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
				url : "/tree/fraternity/" + uid,
				data: {
					"uid" : uid
				},
				
				success : function(result) {
					location.href = "/tree/fraternity/" + uid;
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