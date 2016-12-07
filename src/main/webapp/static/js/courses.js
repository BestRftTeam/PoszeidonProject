$(document).ready(function(){
	/*$.ajax({
		url:"/courses",
		type: "GET",
		data: {email:window.sessionStorage.getItem("username")},
		success: function(responseText){
			var table = $("#courses_t");
			$.each($.parseJSON(responseText), function(k,v) {
				var tr = table.insertRow(-1);
				var td = tr.insertCell(0);
				td.id = "course_"+k;
				td.innerHTML = v.courseName;
			});
		}
		
	})*/
	function Course_F(){
		var coursename = $("#"+this.id).innerHTML;
		
		$.ajax({
			url: "/course",
			type:"GET",
			data: {username:window.sessionStorage.getItem("username"),courseName: coursename},
			success: function(responseText){
				var table = document.getElementById("course_t");
				$.each((responseText), function(k,v) {
					var tr = table.insertRow(-1);
					var td = tr.insertCell(0);
					td.id = "course_"+k;
					td.onclick = Course_F;
					td.innerHTML = v.courseName;
				});

			}
		});
	}
	responseText = [{courseName:"egy"},{courseName:"kettő"},{courseName:"három"},{courseName:"négy"}];
	var table = document.getElementById("courses_t");
	$.each((responseText), function(k,v) {
		var tr = table.insertRow(-1);
		var td = tr.insertCell(0);
		td.id = "course_"+k;
		td.onclick = Course_F;
		td.innerHTML = v.courseName;
	});

});