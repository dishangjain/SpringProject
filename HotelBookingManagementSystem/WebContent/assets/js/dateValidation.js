function setMin(){
	checkin.min = new Date().toISOString().slice(0,10);
	checkout.disabled = true;
}
function validate(){
	checkout.disabled = false;
	var cInDate  = new Date(checkin.value);
	var cOutDate = new Date(cInDate);
	cOutDate.setDate(cInDate.getDate()+1);
	checkout.min = cOutDate.toISOString().slice(0,10);
}
