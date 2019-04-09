import {getUrl} from "~/api/tool";

export function register(email, password, callback) {
	let url = 'user/register';
	
	$.post(getUrl(url),{
		email: email,
		password: password,
	},function (res) {
		callback(res);
	});
}

export function login(email, password, callback) {
	let url = 'user/login';
	
	$.post(getUrl(url), {
		email: email,
		password: password,
	}, function (res) {
		callback(res);
	})
}

export function writeOff(callback) {
	let url = 'user/writeOff';
	common(url, callback);
}

export function getUserInfo(callback) {
	let url = 'user/info';
	common(url, callback);
}

export function getUserDefAddr(callback) {
	let url = 'user/defAddress';
	common(url, callback);
}

export function getUserAllAddr(callback) {
	let url = 'user/allAddress';
	common(url, callback);
}

export function getUserDiscount(callback) {
	let url = 'user/discount';
	common(url, callback);
}

function common(url, callback) {
	$.post(getUrl(url), {
		userID: localStorage.userID,
	}, function (res) {
		callback(res);
	})
}