import {getUrl} from "~/api/tool";

export function addOrder(resID, number, address, arrive, amount, orderCommVOs, callback) {
	let url = 'order/add';
	
	$.ajax({
		method: "POST",
		url: getUrl(url),
		contentType: 'application/json',
		data:JSON.stringify({
			userID: localStorage.userID,
			resID: resID,
			number: number,
			address: address,
			arrive: arrive,
			amount: amount,
			orderCommVOs: orderCommVOs
		}),
		success: function( res ) {
			callback(res);
		}
	});
	
}

export function getOrderInfoByID(orderID, callback) {
	let url = 'order/info';
	commonOrder(url, orderID, callback);
}

export function getOrdersByUser(callback) {
	let url = 'order/user';
	
	$.post(getUrl(url), {
		userID: localStorage.userID,
	},function (res) {
		callback(res);
	});
}

export function getOrderByRes(callback) {
	let url = 'order/restaurant';
	
	$.post(getUrl(url), {
		resID: localStorage.resID,
	},function (res) {
		callback(res);
	});
}

export function getAmountByID(orderID, callback) {
	let url = 'order/amount';
	commonOrder(url, orderID, callback)
}

export function receiveOrder(orderID, callback) {
	let url = 'order/receive';
	commonOrder(url, orderID, callback)
}

export function deliveryOrder(orderID, callback) {
	let url = 'order/delivery';
	commonOrder(url, orderID, callback)
}

export function arriveOrder(orderID, callback) {
	let url = 'order/arrive';
	commonOrder(url, orderID, callback)
}

export function payForOrder(orderID, callback) {
	let url = 'order/pay';
	
	$.post(getUrl(url), {
		userID: localStorage.userID,
		orderID: orderID,
	},function (res) {
		callback(res);
	});
}

export function unsubOrder(orderID, callback) {
	let url = 'order/unsub';
	
	$.post(getUrl(url), {
		userID: localStorage.userID,
		orderID: orderID,
	},function (res) {
		callback(res);
	});
}

export function confirmDelivery(orderID, callback) {
	let url = 'order/confirm';
	commonOrder(url, orderID, callback)
}

export function getStateByID(orderID, callback) {
	let url = 'order/state';
	commonOrder(url, orderID, callback)
}

export function getOrderCommsByOrderID(orderID, callback) {
	let url = 'order/commodities';
	commonOrder(url, orderID, callback)
}

export function transformState(state) {
	if (state === 'UNPAID') return '待支付';
	else if (state === 'UNACCEPTED') return '商家未接单';
	else if (state === 'ACCEPTED') return '商家已接单';
	else if (state === 'DELIVERY') return '商家派送中';
	else if (state === 'ARRIVE') return '商家已送达';
	else if (state === 'FINISH') return '已完成';
	else if (state === 'UNSUB') return '已退订';
	else if (state === 'CANCEL') return '已取消';
}

function commonOrder(url, orderID, callback) {
	$.post(getUrl(url), {
		orderID: orderID,
	},function (res) {
		callback(res);
	});
}