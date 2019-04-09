import MapLoader from './amap'

export function getTimeAndDisBetwAddrs(address1, address2, callback) {
	
	let res = {
		distance: 0,
		time: 0,
		status: 'fail',
	};
	let points = [
		{ keyword: address1 },
		{ keyword: address2 }
	];
	MapLoader().then(AMap => {
		AMap.plugin('AMap.Riding', function(){
			let riding = new AMap.Riding();
			riding.search(points, function (status, result) {
				res.distance = result.routes[0].distance;
				res.time = (result.routes[0].time + 600) / 60;
				res.status = 'success';
				callback(res);
			});
			
		})
	}, e => {
		console.log('地图加载失败' ,e)
		this.$message.warning('无法连接至高德地图，将使用自定义数据');
		callback({
			distance: 2,
			time: 15,
			status: 'success',
		});
	})
}