<template>
  <div id="restaurantBlocks">
    <el-row :gutter="12" style="margin-top: 10px;text-align: left">
      <el-col :span="12" v-for="(item, index) in restaurantList" :key="index" style="margin: 10px 0 10px 0">
        <el-card shadow="always"
                 :body-style="{ padding: '15px' }"
                 style="cursor: pointer"
                 v-on:click.native="clickCard(item)">
          <restaurant-block :item="item"></restaurant-block>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
	import {getTimeAndDisBetwAddrs} from '../../api/address'
	import {getRecRestaurant} from '../../api/restaurant'
  import {getUserDefAddr} from "~/api/userMain";
	import RestaurantBlock from "~/components/restaurant/RestaurantBlock";

	export default {
		name: "RestaurantBlocks.vue",
		components: {RestaurantBlock},
		data() {
			return {
				restaurantList: [],
      }
    },

    methods: {
      clickCard(item) {
				this.$emit("clickCard", item.resID);
      },
    },

		mounted() {
			let that = this;
			getRecRestaurant(14, 0, res => {
				that.restaurantList = res;
				if (localStorage.userID) {
					getUserDefAddr(res => {
						if (res) {
							let userAddress = res.address;
							for (let restaurant of that.restaurantList) {
								getTimeAndDisBetwAddrs(userAddress, restaurant.locate, res => {
									if (res.status === 'success') {
										restaurant.distance = res.distance;
										restaurant.time = res.time.toFixed(0);
									}
									else that.$message.error('无法判断距离，请联网重试')
								});
							}
						}
					})
				}
			});
		}


	}
</script>

<style scoped>

</style>