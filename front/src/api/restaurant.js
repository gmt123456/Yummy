import {getUrl} from "~/api/tool";

export function register(password, callback) {
	let url = 'restaurant/register';
	
	$.post(getUrl(url), {
		password: password,
	},function (res) {
		callback(res);
	});
}

export function loginR(resID, password, callback) {
	let url = 'restaurant/login';
	
	$.post(getUrl(url), {
		resID: resID,
		password: password,
	},function (res) {
		callback(res);
	});
}

export function getResInfo(resID, callback) {
	let url = 'restaurant/info';
	
	$.post(getUrl(url), {
		resID: resID,
	},function (res) {
		callback(res);
	});
}

export function modifyResLocate(newLocate, callback) {
	let url = 'restaurant/modify/locate';
	
	$.post(getUrl(url), {
		resID: localStorage.resID,
		newLocate: newLocate,
	},function (res) {
		callback(res);
	});
}

export function modifyResType(newTypeName, callback) {
	let url = 'restaurant/modify/type';
	
	$.post(getUrl(url), {
		resID: localStorage.resID,
		newTypeName: newTypeName,
	},function (res) {
		callback(res);
	});
}

export function modifyResName(newName, callback) {
	let url = 'restaurant/modify/name';
	
	$.post(getUrl(url), {
		resID: localStorage.resID,
		newName: newName,
	},function (res) {
		callback(res);
	});
}

export function getRecRestaurant(count, pageStart, callback) {
	let url = 'restaurant/recommend';
	
	$.post(getUrl(url), {
		count: count,
		pageStart: pageStart,
	},function (res) {
		callback(res);
	});
}

export function setAvatar(imageData, callback) {
	let url = 'restaurant/modify/avatar';
	
	$.post(getUrl(url), {
		resID: localStorage.resID,
		imageData: imageData,
	},function (res) {
		callback(res);
	});
}

export function getAllRestaurantType(callback) {
	let url = 'restaurant/type';
	
	$.post(getUrl(url), {
	
	},function (res) {
		callback(res);
	});
}

export function getDeliveries(orderID, callback) {
	let url = 'delivery/order';
	
	$.post(getUrl(url), {
		orderID: orderID,
	},function (res) {
		callback(res);
	});
}

