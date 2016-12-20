	function Course_F(){
		var coursename = document.getElementById(this.id).innerHTML;
		window.sessionStorage.setItem("coursename",coursename);
		var HadExam = false;
		$.ajax({
			url: "course",
			type:"GET",
			data: {courseName: coursename},
			success: function(responseText){
				delete_course_table();
				var table = document.getElementById("course_t");
				$.each($.parseJSON(responseText), function(k,v) {
					if (k==="HadExam") {
						HadExam = v;
						if(HadExam===true){
						if (document.getElementById("StartExam")!==null){
							document.getElementById("StartExam").remove();
						}else{}
						}
					}else{
					if (k!=="Enrolled"){
						var tr = table.insertRow(-1);
						var td = tr.insertCell(0);
						td.id = "course_"+v;
						if (k==="courseName"){
							td.innerHTML = "Course: "+v;
						}else{
							if (k==="courseLeader"){
								td.innerHTML = "Course Leader: "+v;
							}
						}
						
						
					}else{
						if (v!=="Yes"){
							if (document.getElementById("new_course_name")===null){
								var row = table.insertRow(-1);
								var cell = row.insertCell(0);
								var but = document.createElement("BUTTON");
								but.id = "Enroll";
								but.innerHTML = "Enroll";
								but.onclick = Enroll_F;
								cell.appendChild(but);
							}
						}else{
							Learnings_F();
							if (document.getElementById("new_course_name")!==null){
							var row = table.insertRow(-1);
							var cell = row.insertCell(0);
							cell.innerHTML = "<form id = \"upload_form\" method=\"POST\" action=\"upload\" enctype=\"multipart/form-data\" \" >\
            File:\
            <input type=\"file\" name=\"file\" id=\"file\" /> <br/>\
            Destination:\
            <input type=\"text\" value=\"../Learnings\" name=\"destination\" disabled/>\
            </br>\
            <input value="+window.sessionStorage.getItem("coursename")+" name=coursename hidden />\
            		<input type=\"submit\" value=\"Upload\" name=\"upload\" id=\"upload\" />\
        </form>";
							/*var erow = table.insertRow(-1);
							var ecell = erow.insertCell(0);*/
							var ebut = document.createElement("BUTTON");
							ebut.innerHTML = "Add Exam";
							ebut.id = "AddExam";
							ebut.onclick = function(){
								window.location.assign("UrlapKeszito.html");
							}
							cell.appendChild(ebut);

							}else{
								if(HadExam===false){
									var esbut = document.createElement("BUTTON");
									esbut.innerHTML = "Start Exam";
									esbut.id = "StartExam";
									esbut.onclick = function(){
										window.location.assign("Exam.html");
									}
									var row = table.insertRow(-1);
									var cell = row.insertCell(0);
									cell.appendChild(esbut);
								}
							}
						}
					}
					}
				});
				
			}
		});
	}

	function File_Download_F(){
	
	}
	function redirect() {
		  location.reload();
		  return false;
		}
	function Learnings_F(){
		$.ajax({
			url: "Learnings",
			data: {courseName:window.sessionStorage.getItem("coursename")},
			success:function(responseText){
				if (responseText.length>4){
					var table = document.getElementById("course_t");
					var row = table.insertRow(-1);
					var cell = row.insertCell(0);
					cell.innerHTML = "Learnings: "
					$.each($.parseJSON(responseText), function(k,v) {

						var tr = table.insertRow(-1);
						var td = tr.insertCell(0);
						var name = v.Learning.split("/");
						td.innerHTML = "<a href="+v.Learning+" download="+name[2]+">"+name[2]+"</a>";
					});
				}
			}
		});
	}
	function New_Learning_F(){
		var up = document.getElementById("New_Learning").value;
		$.ajax({
			url: "NewLearning",
			type: "POST",
			success: function(responseText){
				
			}
		});
		
	}
	function Learnings(){
		
	}
	function Enroll_F(){
		$.ajax({
			url: "Enroll",
			data: {Course_Name: window.sessionStorage.getItem("coursename")},
			success: function(responseText){
				alert("You have been Enrolled for this course");
				document.getElementById("Enroll").remove();
			},
			type: "POST"
			
		})
	}
	function My_courses_F(){
		delete_courses_table();
		$.ajax({
			url:"courses",
			type: "GET",
			async: false,
			success: function(responseText){
				if (responseText.length>4){
					var table = document.getElementById("courses_t");
					$.each($.parseJSON(responseText), function(k,v) {
						var tr = table.insertRow(-1);
						var td = tr.insertCell(0);
						td.id = "courses_"+k;
						td.innerHTML = v.courseName;
						td.onclick = Course_F;
					});
				}else{}
				document.getElementById("My_Courses").disabled = true;
				document.getElementById("All_Courses").disabled = false;
			},
			error: function(responseText){
				alert(responseText.responseText);
			}	
		});
	}
	
	function All_courses_F(){
		delete_courses_table();
		$.ajax({
			url:"allcourses",
			type: "GET",
			async: false,
			success: function(responseText){
				if (responseText.length>0){
					var table = document.getElementById("courses_t");
					$.each($.parseJSON(responseText), function(k,v) {
						var tr = table.insertRow(-1);
						var td = tr.insertCell(0);
						td.id = "courses_"+k;
						td.innerHTML = v.courseName;
						td.onclick = Course_F;
					});
				}
				document.getElementById("My_Courses").disabled = false;
				document.getElementById("All_Courses").disabled = true;
			},
			error: function(responseText){
				alert(responseText.responseText);
			}	
		});
	}
	

	function delete_courses_table(){
		var table = document.getElementById("courses_t");
		var rownum = table.rows.length;
		for (var i = 0; i < rownum;i++){
			table.deleteRow(0);
		}
	}

	function delete_course_table(){
		var table = document.getElementById("course_t");
		var rownum = table.rows.length;
		for (var i = 0; i < rownum;i++){
			table.deleteRow(0);
		}
	}

	$( document ).ready(function() {
		$.ajax({
			url: "GetRole",
			type: "GET",
			success: function(response){
				var tmp = response.split(";");
				for (var i = 0;i<tmp.length;i++){
					if (tmp[i]==="TEACHER"){
						var div = document.getElementById("course_add");
						var input = document.createElement("input");
						input.id = "new_course_name";
						var but = document.createElement("BUTTON");
						but.id = "but";
						but.innerHTML = "+";
						but.onclick = function(){
							if(document.getElementById("new_course_name").value!==""){
								$.ajax({
									url: "Save_course",
									data: {Course_Name:document.getElementById("new_course_name").value},
									type: "POST",
									success: function(responseText){
										var table = document.getElementById("courses_t");
										var newCours_r = table.insertRow(0);
										var newCours_c = newCours_r.insertCell(0);
										newCours_c.id = "courses_"+document.getElementById("new_course_name").value;
										newCours_c.innerHTML = document.getElementById("new_course_name").value;
										newCours_c.onclick = Course_F;
										document.getElementById("new_course_name").value = "";
									},
									error: function(responseText){
										
									}
								});
							}
						}
						div.appendChild(input);
						div.appendChild(but);
					}
				}
				
			},
			error: function(response){
				alert(response.responseText);
			}
		});
		My_courses_F();
	});