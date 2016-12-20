	function My_exams_F(){
		$.ajax({
			url:"Exams",
			type: "GET",
			async: false,
			success: function(responseText){
				if (responseText.length>4){
					var table = document.getElementById("exams_t");
					$.each($.parseJSON(responseText), function(k,v) {
						var tr = table.insertRow(-1);
						var td = tr.insertCell(0);
						td.id = "exams_"+v.ExamName;
						td.innerHTML = v.ExamName;
						td.onclick = Exam_F;
					});
				}else{}

			},
			error: function(responseText){
				alert(responseText.responseText);
			}	
		});
	}
	
	function Exam_F(){
		var exam_name = document.getElementById(this.id).innerHTML;
		window.sessionStorage.setItem("examname",exam_name);
		$.ajax({
			url: "OneExam",
			type:"GET",
			data: {examName: exam_name},
			success: function(responseText){
				if (responseText.length>4){
					delete_exam_table();
					var table = document.getElementById("exam_t");
					$.each($.parseJSON(responseText), function(k,v) {
						if (k==="courseName"){
							var tr = table.insertRow(0);
							var td = tr.insertCell(0);
							td.id = "course_courseName";
							td.innerHTML = "Course: "+v;
							td.value = v;
						}
						if (k==="courseLeader"){
							var tr2 = table.insertRow(0);
							var td2 = tr2.insertCell(0);
							td2.id = "course_courseLeader";
							td2.innerHTML = "Course Leader: "+ v;
						}
						if (k==="score"){
							var row = table.insertRow(0);
							var cell = row.insertCell(0);
							var but = document.createElement("BUTTON");
							but.id = "CheckExam";
							but.innerHTML = "CheckExam";
							but.onclick = CheckExam_F;
							cell.appendChild(but);
							
							var tr3 = table.insertRow(0);
							var td3 = tr3.insertCell(0);
							td3.id = "exam_score";
							td3.innerHTML = "Score: "+v;
							

						}


					});
				}else{}
		}
		});
	}
	
	function delete_exam_table(){
		var table = document.getElementById("exam_t");
		var rownum = table.rows.length;
		for (var i = 0; i < rownum;i++){
			table.deleteRow(0);
		}
	}
	
	function CheckExam_F(){
		window.sessionStorage.setItem("coursename",document.getElementById("course_courseName").value)
		window.location.assign("GetExam.html");
	}
	
	$( document ).ready(function() {
		
		My_exams_F();
		
	});