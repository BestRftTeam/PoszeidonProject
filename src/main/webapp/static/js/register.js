$("#reg").click(function (){
	if($("#password").val()!=""){
		if ($("#password").val()==$("#password_confirmation").val()){
			$.ajax({
				type: "POST",
				url: 'Register',
				data: {	
							First_Name: $("#first_name").val(),
							Last_Name: $("#last_name").val(),
							Email: $("#email").val(),
							Password: $("#password").val(),
							Role: $("#role").val()	
				},
				success: function(responseText){
					alert("be");
					$.ajax({
						  url: 'RegToLogin',
						  success: function(responseText){
							  window.location.href = responseText;
						  }
						});
				},
				error: function(responseText){
					//alert("Nem jól töltötte ki valamelyik mezőt!");
					alert(responseText.responseText);
				}
				});
		}else{
			alert("Nem egyezik a jelszó és az ellenőrző kód!")
		}
	}else{
		alert("Nem töltötte ki a jelszó mezőt!")
	}
});
$("#back").click(function(){
	//window.location.assign("../");
	$.ajax({
		  url: 'RegToLogin',
		  success: function(responseText){
			  //alert(responseText);
			  window.location.href = responseText;
			 
		  }
		});
});