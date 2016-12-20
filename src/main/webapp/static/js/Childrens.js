	

	function My_courses_F(){
		delete_childrens_table();
		$.ajax({
			url:"Childrens",
			type: "GET",
			async: false,
			success: function(responseText){
				if (responseText.length>4){
					var table = document.getElementById("childrens_t");
					$.each($.parseJSON(responseText), function(k,v) {
						var tr = table.insertRow(-1);
						var td = tr.insertCell(0);
						td.id = "childrens_"+k;
						td.innerHTML = v.courseName;
						td.onclick = Children_F;
					});
				}else{}
			},
			error: function(responseText){
				alert(responseText.responseText);
			}	
		});
	}
	
	function delete_courses_table(){
		var table = document.getElementById("childrens_t");
		var rownum = table.rows.length;
		for (var i = 0; i < rownum;i++){
			table.deleteRow(0);
		}
	}
	
	function delete_courses_table(){
		var table = document.getElementById("children_t");
		var rownum = table.rows.length;
		for (var i = 0; i < rownum;i++){
			table.deleteRow(0);
		}
	}