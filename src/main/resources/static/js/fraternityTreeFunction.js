function addFraternityFamilyMember() {
    var chapter = $('#input_chapter').val();
    var family = $('#input_family').val();
    var line = $('#input_line').val();
    var crossingClass = $('#input_crossingClass').val();
    var crossingDate = $('#input_crossingDate').val();

    //if( ... )
}

function removeFraternityFamilyMember(uid) {
    var uid = $('#input_uid').val();
    
    if (uid) {
        $.ajax (
            {
                type : "DELETE",
                url : "/tree/fraternity/",
                data : {
                    "uid" : uid
                },
                
                success : function(result) {
                    location.reload();
                },
                
                error : function(jqXHR, exception) {
                    alert("The UID entered was not found. Cannot delete Fraternity Member.");
                }
            }
        );
    }
    else {
        alert("Please enter a UID.");
    }
}
