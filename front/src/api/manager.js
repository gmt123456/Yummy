import {getUrl} from "~/api/tool";

export function loginM(managerID, password, callback) {
	let url = 'manager/login';
	
	$.post(getUrl(url), {
		managerID: managerID,
		password: password,
	},function (res) {
		callback(res);
	});
}

export function settle(discount, callback) {
	let url = 'restaurant/settle';
	
	$.post(getUrl(url), {
		discount: discount,
	},function (res) {
		callback(res);
	});
}

export function getAllAmount(callback) {
	let url = 'restaurant/amount';
	
	$.post(getUrl(url), {
	},function (res) {
		callback(res);
	});
}

export function getAccount(callback) {
	let url = 'account/number';
	
	$.post(getUrl(url), {
	},function (res) {
		callback(res);
	});
}

export function getUserCounts(callback) {
	let url = 'user/count';
	
	$.post(getUrl(url), {
	},function (res) {
		callback(res);
	});
}

export function getResCounts(callback) {
	let url = 'restaurant/count';
	
	$.post(getUrl(url), {
	},function (res) {
		callback(res);
	});
}