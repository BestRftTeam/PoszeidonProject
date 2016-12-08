$("#reg").click(function (){
	if($("#password").val()!=""){
		if ($("#password").val()==$("#password_confirmation").val()){
			$.ajax({
				type: "GET",
				url: 'PoszeidonProject/register',
				/*data: {	
							First_Name: $("#first_name").val(),
							Last_Name: $("#last_name").val(),
							Email: $("#email").val(),
							Password: $("#password").val(),
							Role: $("#role").val()	
				},*/
				success: function(responseText){
					  window.location.assign("../");
				},
				error: function(responseText){
					//alert("Nem jól töltötte ki valamelyik mezőt!");
					alert(responseText.responseText);
				},
				dataType: 'JSON'
				});
		}else{
			alert("Nem egyezik a jelszó és az ellenőrző kód!")
		}
	}else{
		alert("Nem töltötte ki a jelszó mezőt!")
	}
});
$("#back").click(function(){
	window.location.assign("../");
});