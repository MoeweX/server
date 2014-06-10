$(document).ready(function() {
	loadData();
	
});

/*
 * Load all necessary data
 */
function loadData() {
	$.ajax({ url : "myServlet", type : "GET", cache: false, success : function(json) {
		loadConfigTable(json);
	}, dataType : "json",
	});
}

/*
 * Initializes global config table
 */
function loadConfigTable(json) {
	console.log(json);
	$("#infoTable").empty();
	var table = "<table border=\"1\">";
	table += "<tr><th>Property</th><th>Value</th></tr>";
	for (var key in json) {
		if (json.hasOwnProperty(key)) {
			table += "<tr><td>"+key+"</td><td>"+json[key]+"</td></tr>";
		}
	}
	table += "</table>";
	$("#infoTable").append(table);
}