import {getUrl} from "~/api/tool";

export function sendEmailCode(email, callback) {
	let url = 'email/send';
	
	console.log(email);
	$.post(getUrl(url), {
		email: email,
	},function (res) {
		callback(res);
	});
}

export function confirmEmailCode(email, code, callback) {
	let url = 'email/confirm';
	
	$.post(getUrl(url), {
		email: email,
		code: code,
	}, function (res) {
		callback(res);
	})
}