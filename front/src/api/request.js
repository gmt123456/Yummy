import {getUrl} from "~/api/tool";

export function getInboxRequests(callback) {
	let url = 'request/inbox';
	
	$.post(getUrl(url), {
	},function (res) {
		callback(res);
	});
}

export function acceptRequest(reqID, callback) {
	let url = 'request/accept';
	
	$.post(getUrl(url), {
		reqID: reqID,
	},function (res) {
		callback(res);
	});
}

export function rejectRequest(reqID, callback) {
	let url = 'request/reject';
	
	$.post(getUrl(url), {
		reqID: reqID,
	},function (res) {
		callback(res);
	});
}

export function getRequestByResID(resID, callback) {
	let url = 'request/restaurant';
	
	$.post(getUrl(url), {
		resID: resID,
	},function (res) {
		callback(res);
	});
}

export function getCurrentRequestByResID(resID, callback) {
	let url = 'request/restaurant/current';
	
	$.post(getUrl(url), {
		resID: resID,
	},function (res) {
		callback(res);
	});
}
