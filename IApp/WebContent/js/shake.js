// JavaScript Document
function showError(inputname,msg){
	var element = $(inputname).addClass('shaker');
	$('h2').html(msg);
	setTimeout(function(){
		element.removeClass('shaker');
	},1000);
}

$(document).on('click','#btnCheck',function(){
	if($('#txtUsername').val() == ""){
		showError('#txtUsername','You have to enter an username.');
	}
	else if($('#txtPassword').val() == ""){
		showError('#txtPassword','It is not possible without a valid password.');		
	}else{
//		$('h2').html('Well Done !!');
//		$('form').hide();
		
		window.location.href = '../../src/com/login/Login.java';
	}
	return false;
});
