import {getUrl} from "~/api/tool";

export function modifyUserNumber(newNumber, callback) {
	let url = 'user/modify/number';
	
	$.post(getUrl(url),{
		userID: localStorage.userID,
		newNumber: newNumber,
	},function (res) {
		callback(res);
	});
}

export function modifyUserName(newName, callback) {
	let url = 'user/modify/name';
	
	$.post(getUrl(url),{
		userID: localStorage.userID,
		newName: newName,
	},function (res) {
		callback(res);
	});
}

export function modifyUserPassword(oldPassword, newPassword, callback) {
	let url = 'user/modify/password';
	
	$.post(getUrl(url),{
		userID: localStorage.userID,
		oldPassword: oldPassword,
		newPassword: newPassword,
	},function (res) {
		callback(res);
	});
}

export function addUserAddress(address, callback) {
	let url = 'user/modify/addAddress';
	
	$.post(getUrl(url),{
		userID: localStorage.userID,
		address: address,
	},function (res) {
		callback(res);
	});
}

export function modifyUserDefAddr(addrID, callback) {
	let url = 'user/modify/defAddress';
	
	$.post(getUrl(url),{
		userID: localStorage.userID,
		addrID: addrID,
	},function (res) {
		callback(res);
	});
}

export function modifyUserAddress(addrID, address, callback) {
	let url = 'user/modify/address';
	
	$.post(getUrl(url),{
		userID: localStorage.userID,
		addrID: addrID,
		address: address,
	},function (res) {
		callback(res);
	});
}

export function modifyUserAvatar(imageData, callback) {
	let url = 'user/modify/avatar';
	
	$.post(getUrl(url),{
		userID: localStorage.userID,
		imageData: imageData,
	},function (res) {
		callback(res);
	});
}