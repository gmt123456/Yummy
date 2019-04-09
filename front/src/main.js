import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import router from './router/index'
import jQuery from 'jquery'
import Echarts from 'echarts'

import Test from './components/user/UserCenter'

Vue.prototype.echarts = Echarts
Vue.use(Echarts);
Vue.use(ElementUI);
Vue.config.devtools = true

window.$ = jQuery;
window.jQuery = jQuery;

new Vue({
  el: '#app',
	router,
  render: h => h(App),
});
