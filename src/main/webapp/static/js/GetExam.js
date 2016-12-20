	var idk = new Array();
	var GoodAnswers = new Array();
	function StartExam_F(){
		//alert(window.sessionStorage.getItem("coursename"));
		$.ajax({
			url:"StartExam",
			type: "GET",
			async: false,
			data: {courseName: window.sessionStorage.getItem("coursename")},
			success: function(responseText){
				//alert(responseText);
				var test = $.parseJSON(responseText);
				var i = 1;
				//alert(test);
				$.each(test.testSheet, function(k,v) {
					//if (k==="testSheet"){
					//alert(v.score);
						var score = v.score; 
						var question=v.question;
						var tp = new Array();
						var answerOptions = v.answerOptions;
						var answers = v.answers;
						//alert(v.answerOptions);
						//alert(answerOptions);
						/*$.each($.parseJSON(v.answerOptions),function(kq,vq){
							alert(vq);
							//score = vq.score;
							//question = vq.question;
							tp.add(vq);
							//answers = vq.answers;
							
						});*/
						KerdestHozzaad_f(i,score,question,answerOptions,answers);
						i++;
						//alert(i);
					//}	
					
				});
				/*var d = new Date;
				var hour = d.getHours()+1;
				if (hour>=24) hour=hour-24;
				document.getElementById("StartTime").value = d.getHours()+":"+d.getMinutes();
				document.getElementById("EndTime").value = hour+":"+d.getMinutes();*/
				//document.getElementById("Questions").value = i-1;
				window.sessionStorage.setItem("kerdesszam",i-1);
				window.sessionStorage.setItem("testName",test.testName);
				
				

				//document.getElementById("KerdesHozzaadoBody").appendChild(div);
				
			},
			error: function(responseText){
				alert(responseText.responseText);
			}
		})
	}
	
	function KerdestHozzaad_f(kerdesszam,score,question,questionanswerOptions,answers){
		//alert(questionanswerOptions);
		var valami = questionanswerOptions+"";
		var answ = answers+"";
		var answt = answ.split(",");
		var div = document.getElementById("KerdesHozzaadoBody");
		var tmp = valami.split(",");
		//kinézetcheat:D
		var szokoz = document.createElement("Label");
		szokoz.innerHTML = "    ";
		var szokoz1 = document.createElement("Label");
		szokoz1.innerHTML = "    ";
		var szokoz2 = document.createElement("Label");
		szokoz2.innerHTML = "    ";
		//tábla létrehozása
		var table = document.createElement("table");
		var k_szam = kerdesszam;//parseInt(window.sessionStorage.getItem("kerdesszam"));
		idk.push(2);
		table.id = "Table_" + k_szam;
		table.class = "table table-striped table-hover";
		//table.border = 0;
		table.style.width = "550px";
		//1. sor objektumai
		var input = document.createElement("label");
		input.id = "Kerdes_" + k_szam;
		input.style.width = "450px";
		//input.disabled = true;;
		input.innerHTML = k_szam+".  "+question;
		var input2 = document.createElement("label");
		input2.id = "KerdesValue_" + k_szam;
		input2.style.width = "20px";
		//input2.disabled = true;
		input2.innerHTML = score;
		
		//1. sor
		var row0 = table.insertRow(0);
		var cell0 = row0.insertCell(0);
		
		cell0.appendChild(input);
		cell0.appendChild(szokoz);
		cell0.appendChild(input2);
		
		div.appendChild(table);
		

		//2. sor
		var row1 = table.insertRow(1);
		var cell1 = row1.insertCell(0);
		cell1.id = "Cell_"+k_szam;
		//2. sor objektumai
		var input_a1 = document.createElement("label");
		input_a1.id = k_szam +"_"+1;
		input_a1.style.width = "450px";
		input_a1.innerHTML = "		1. "+tmp[0];
		//input_a1.disabled = true;
		var c_box1 = document.createElement("input");
		c_box1.id = "c_"+k_szam+"_"+1;
		c_box1.type = "checkbox";
		c_box1.disabled = true;
		GoodAnswers.push(answt[0]);
		//if (answt[0]==="True") c_box1.checked = true;
		var input_a2 = document.createElement("label");
		input_a2.id = k_szam +"_"+2;
		input_a2.style.width = "450px";
		input_a2.innerHTML = "		2. "+tmp[1];
		
		//input_a2.disabled = true;
		var c_box2 = document.createElement("input");
		c_box2.id = "c_"+k_szam+"_"+2;
		c_box2.type = "checkbox";
		c_box2.disabled = true;
		GoodAnswers.push(answt[1]);
		//if (answt[1]==="True") c_box2.checked = true;
		cell1.appendChild(input_a1);
		cell1.appendChild(szokoz1);
		cell1.appendChild(c_box1);

		cell1.appendChild(input_a2);
		cell1.appendChild(szokoz2);
		cell1.appendChild(c_box2);
		
		for (var i = 2;i < tmp.length;i++){
			Valaszok(tmp[i],k_szam,answt[i])
		}
		
		
	}
	
	function Valaszok(questionanswerOption,tab,boxvalue){
		//var table = document.getElementById;
		var szokoz = document.createElement("Label");
		//alert(tab);
		//alert(document.getElementById("Table_"+k_szam));
		szokoz.innerHTML = "    ";
		//var tmp = table.split("_");
		var k_szam = tab;
		idk[k_szam-1] = idk[k_szam-1] + 1;
		var cell = document.getElementById("Table_"+k_szam).rows[1].cells[0];
		var input = document.createElement("label");
		input.id = k_szam +"_"+idk[k_szam-1];
		input.style.width = "450px";
		//input.disabled = true;
		input.innerHTML = "		"+idk[k_szam-1] +".  "+ questionanswerOption;
		var c_box = document.createElement("input");
		c_box.id = "c_"+k_szam+"_"+idk[k_szam-1];
		c_box.type = "checkbox";
		c_box.disabled = true;
		GoodAnswers.push(boxvalue);
		//if (boxvalue==="True") c_box.checked = true;
		cell.appendChild(input);
		cell.appendChild(szokoz);
		cell.appendChild(c_box);
	}
	
	$( document ).ready(function() {
		//alert(window.sessionStorage.getItem("testName"));
		StartExam_F();
		var studentAnswers = new Array();
		var i = 0;
		$.ajax({
			url : "GetStudentAnswers",
			data : {testName: window.sessionStorage.getItem("testName")},
			type : "GET",
			async: false,
			success : function(responseText){
				//alert(responseText);
				
				if (responseText.length>4){
					$.each($.parseJSON(responseText), function(k,v) {
						studentAnswers.push(v.userAnswer);
						/*alert($.parseJSON(responseText));
						if (v.userAnswer==="T") studentAnswers.push("true");
						else studentAnswers.pop("false");*/
					});
					var k_sz = parseInt(window.sessionStorage.getItem("kerdesszam"));
					var k = 0;
					//alert(studentAnswers);
					//alert(GoodAnswers);
					for (var i = 1;i < (k_sz +1) ; i++){
						for (var j = 1;j < idk[i-1]+1;j++){
							//alert("student <-->"+studentAnswers[k]+"<-->Good<-->"+GoodAnswers[k]);
							if (studentAnswers[k])	document.getElementById("c_"+i+"_"+j).checked = true;
							if (studentAnswers[k]&&(GoodAnswers[k]==="true")) 
								document.getElementById(i+"_"+j).style.backgroundColor = "green";
							if ((studentAnswers[k]===false)&&(GoodAnswers[k]==="true")) 
								document.getElementById(i+"_"+j).style.backgroundColor = "yellow";
							if (studentAnswers[k]&&(GoodAnswers[k]==="false")) 
								document.getElementById(i+"_"+j).style.backgroundColor = "red";
							k++;
						}
					}
					
				}
			}
		});
		//alert(studentAnswers)

	});
