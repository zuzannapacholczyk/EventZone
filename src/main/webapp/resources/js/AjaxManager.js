/**
 * 
 */

	makeRestURL = function(restCall) {
		console.log("/" + window.location.pathname.split( '/' )[1]  + restCall);
		return "/" + window.location.pathname.split( '/' )[1]  + restCall;
	}; 

	function submitRegisterForm(){
		console.log("Argheehhatsshtt");
		var formData = JSON.stringify($("#registerForm").serializeArray());
		console.log("fData: " +formData);
		$.ajax({
			contentType: "application/json",
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			type: "POST",
			url: "http://localhost:8040/EventZone/register/registerUser/",
			data: formData,
			success: function(){
				console.log("sukces?");
			},
			dataType: "json"
		});
	}