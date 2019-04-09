import {getUrl} from "~/api/tool";

export function getRecordUserAndType(recType, callback) {
	let url = 'record/user';
	
	$.post(getUrl(url), {
		userID: localStorage.userID,
		recType: recType,
	},function (res) {
		callback(res);
	});
}

export function getRecordResAndType(recType, callback) {
	let url = 'record/restaurant';
	
	$.post(getUrl(url), {
		resID: localStorage.resID,
		recType: recType,
	},function (res) {
		callback(res);
	});
}

export function getOrderAmountList(callback) {
	let url = 'record/amount';
	
	$.post(getUrl(url), {
	},function (res) {
		callback(res);
	});
}

export function getFinishAmount(callback) {
	let url = 'record/finish';
	
	$.post(getUrl(url), {
	},function (res) {
		callback(res);
	});
}

export function getSettleAmount(callback) {
	let url = 'record/settle';
	
	$.post(getUrl(url), {
	},function (res) {
		callback(res);
	});
}