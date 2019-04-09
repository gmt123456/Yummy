import {getUrl} from "~/api/tool";

export function addNewCommodity(name, price, count, imageData, callback) {
	let url = 'commodity/add/commodity';
	
	$.post(getUrl(url), {
		resID: localStorage.resID,
		name: name,
		price: price,
		count: count,
		imageData: imageData,
	},function (res) {
		callback(res);
	});
}

export function addNewPackage(name, price, count, commIDs, imageData, callback) {
	let url = 'commodity/add/package';
	
	$.ajax({
		method: "POST",
		url: getUrl(url),
		contentType: 'application/json',
		data:JSON.stringify({
			resID: localStorage.resID,
			name: name,
			price: price,
			count: count,
			commIDs: commIDs,
			imageData: imageData
		}),
		success: function( res ) {
			callback(res);
		}
	});
}

export function setCommodityTime(commID, start, end, callback) {
	let url = 'commodity/set/time';
	
	$.post(getUrl(url), {
		commID: commID,
		start: start,
		end: end,
	},function (res) {
		callback(res);
	});
}

export function updateDiscounts(commIDs, discount, start, end, callback) {
	let url = 'commodity/set/discount';
	
	$.ajax({
		method: "POST",
		url: getUrl(url),
		contentType: 'application/json',
		data:JSON.stringify({
			commIDs: commIDs,
			discount: discount,
			start: start,
			end: end,
		}),
		success: function( res ) {
			callback(res);
		}
	});
}

export function getCommNamesFromPkg(commID, callback) {
	let url = 'commodity/package';
	
	$.post(getUrl(url), {
		pkgID: commID,
	},function (res) {
		callback(res);
	});
}

export function getCommoditiesFromRes(commodityType, callback) {
	let url = 'commodity/all';
	
	$.post(getUrl(url), {
		resID: localStorage.resID,
		commodityType: commodityType,
	},function (res) {
		callback(res);
	});
}

export function getCurrentCommoditiesFromRes(resID, commodityType, callback) {
	let url = 'commodity/current';
	
	$.post(getUrl(url), {
		resID: resID,
		commodityType: commodityType,
	},function (res) {
		callback(res);
	});
}