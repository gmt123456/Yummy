export function getCurrentDate(now) {
	
	let year = now.getFullYear();       //年
	let month = now.getMonth() + 1;     //月
	let day = now.getDate();            //日
	
	let clock = year + "-";
	
	if(month < 10)
		clock += "0";
	
	clock += month + "-";
	
	if(day < 10)
		clock += "0";
	
	clock += day;
	
	return(clock);
}

export function getSeconds(date) {
	let dateBegin = new Date(date.replace(/-/g, "/"));//将-转化为/，使用new Date
	let dateEnd = new Date(dateBegin.getTime() + 120 * 1000);
	let now = new Date();
	let seconds = dateEnd.getTime() - now.getTime();
	return seconds;
}