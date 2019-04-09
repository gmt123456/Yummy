import Vue from 'vue'
import VueRouter from 'vue-router'

import RestaurantNavi from '../components/restaurant/RestaurantNavi'
import RestaurantMain from '../components/restaurant/RestaurantMain'
import RestaurantCommodity from '../components/restaurant/RestaurantCommodity'
import RestaurantShop from '../components/restaurant/RestaurantShop'
import RestaurantRequest from '../components/restaurant/RestaurantRequest'
import RestaurantOrder from '../components/restaurant/RestaurantOrder'
import RestaurantReport from '../components/restaurant/report/RestaurantReport'

import UserNavi from '../components/user/UserNavi'
import UserMain from '../components/user/UserMain'
import UserCenter from '../components/user/UserCenter'
import UserInfo from '../components/user/UserInfo'
import UserOrder from '../components/user/UserOrder'
import UserAddress from '../components/user/UserAddress'
import UserReport from '../components/user/report/UserReport'

import ManagerNavi from '../components/manager/ManagerNavi'
import ManagerMain from '../components/manager/ManagerMain'
import ManagerApprove from '../components/manager/ManagerApprove'
import ManagerSettle from '../components/manager/ManagerSettle'
import ManagerReport from '../components/manager/ManagerReport'

import OrderForUser from '../components/order/OrderForUser'

import Index from '../components/index/Index'

Vue.use(VueRouter);

const router = new VueRouter({
	mode: "history",

	routes:[
		{
			path: '/', component: Index
		},
		{
			path: '/restaurant', component: RestaurantNavi,
			children: [
				{path: 'main', component: RestaurantMain},
				{path: 'commodity', component: RestaurantCommodity},
				{path: 'request', component: RestaurantRequest},
				{path: 'order', component: RestaurantOrder},
				{path: 'report', component: RestaurantReport},
			]
		},
		{
			path: '/user', component: UserNavi,
			children: [
				{path: 'main', component: UserMain},
				{
					path: 'center', component: UserCenter,
					children: [
						{path: 'info', component: UserInfo},
						{path: 'order', component: UserOrder},
						{path: 'address', component: UserAddress},
						{path: 'report', component: UserReport},
					]
				},
				{
					path: 'shop/:resID', component: RestaurantShop, name: 'shop'
				},
				{
					path: 'order/:orderID', component: OrderForUser, name: 'order'
				}
			]
		},
		{
			path: '/manager', component: ManagerNavi,
			children: [
				{
					path: 'main', component: ManagerMain,
					children: [
						{path: 'approve', component: ManagerApprove},
						{path: 'settle', component: ManagerSettle},
						{path: 'report', component: ManagerReport},
					]
				},
			]
		}

	]

})

export default router;