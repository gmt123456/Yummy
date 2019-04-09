export default function MapLoader () {
	return new Promise((resolve, reject) => {
		if (window.AMap) {
			resolve(window.AMap)
		} else {
			var script = document.createElement('script')
			script.type = 'text/javascript'
			script.async = true
			script.src = 'http://webapi.amap.com/maps?v=1.3&callback=initAMap&key=482a936b92ba8353dfcb806ddb38128d'
			script.onerror = reject
			document.head.appendChild(script)
		}
		window.initAMap = () => {
			resolve(window.AMap)
		}
	})
}