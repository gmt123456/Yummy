<template>
  <div id="restaurantShop">
    <el-row style="text-align: left;">
      <el-col :span="8">
        <div style="border-right: #DCDFE6 solid 1px;min-height: 600px;padding: 20px;position: relative;">
          <restaurant-block :item="resInfo"></restaurant-block>
          <div style="margin: 30px 0 10px 0;font-weight: bolder;width: 100%">购物车</div>
          <el-table
              :data="tableData"
              style="width: 100%"
              max-height="400">
            <el-table-column
                prop="name"
                label="名称"
                min-width="60">
            </el-table-column>
            <el-table-column
                prop="price"
                label="单价"
                width="60">
            </el-table-column>
            <el-table-column
                prop="count"
                label="数量"
                width="50">
            </el-table-column>
            <el-table-column
                prop="amount"
                label="总价"
                width="60">
            </el-table-column>
            <el-table-column
                fixed="right"
                label="操作"
                width="50">
              <template slot-scope="scope">
                <el-button
                    @click.native.prevent="deleteRow(scope.$index, tableData)"
                    type="text"
                    size="small">
                  移除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="position: absolute;bottom: 0;">
            <span style="font-weight: bolder;vertical-align: middle">送达</span>
            <el-time-select
                v-model="arrive"
                :picker-options="{
                  start: start,
                  step: '00:15',
                  end: '23:59'
                }"
                placeholder="选择时间"
                style="width: 150px;margin: 0 0 10px 0">
            </el-time-select>
            <div v-if="discount === 1">
              <span style="font-weight: bolder;vertical-align: middle">合计</span>
              <span style="font-weight: bold;color: dodgerblue;font-size: 30px;vertical-align: middle">¥{{getTableAmount.toFixed(2)}}</span>
            </div>
            <div v-if="discount !== 1">
              <span style="font-weight: bolder;vertical-align: middle">合计</span>
              <span style="font-size: 16px;vertical-align: middle;text-decoration:line-through" class="first-font-color">¥{{getTableAmount.toFixed(2)}}</span>
              <span style="font-weight: bold;color: dodgerblue;font-size: 30px;vertical-align: middle">¥{{(getTableAmount * discount).toFixed(2)}}</span>
              <el-tag size="mini">会员折扣</el-tag>
            </div>
          </div>
          <div style="position: absolute;bottom: 0;right: 20px;">
            <el-button type="primary" @click="addOrder">下单</el-button>
          </div>
        </div>
      </el-col>
      <el-col :span="16">
        <div style="padding: 30px 0 0 40px">
          <div v-if="commodities">
            <div class="second-font-color" style="margin: 0 0 10px 0">商品</div>
            <el-row :gutter="20" >
              <el-col :span="12"v-for="(item, index) in commodities" :key="index">
                <el-card :body-style="{ padding: '10px' }" style="margin-bottom: 5px">
                  <commodity-for-shop :item="item" v-on:handleChange="handleChange"></commodity-for-shop>
                </el-card>
              </el-col>
            </el-row>
          </div>
          <div v-if="packages">
            <div class="second-font-color" style="margin: 10px 0 10px 0">套餐</div>
            <el-row :gutter="20" >
              <el-col :span="12"v-for="(item, index) in packages" :key="index">
                <el-card :body-style="{ padding: '10px' }" style="margin-bottom: 5px">
                  <commodity-for-shop :item="item" v-on:handleChange="handleChange"></commodity-for-shop>
                </el-card>
              </el-col>
            </el-row>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import RestaurantBlock from './RestaurantBlock'
  import CommodityForShop from '../commodity/CommodityForShop'
  import {getResInfo} from "~/api/restaurant"
  import {getCurrentCommoditiesFromRes} from "~/api/commodity";
  import {addOrder} from "~/api/order";
  import {getUserInfo} from '~/api/userMain'
  import {getUserDefAddr} from "~/api/userMain";
  import {getTimeAndDisBetwAddrs} from "~/api/address";
  import {getCurrentDate} from "~/api/time";
  import {getUserDiscount} from "~/api/userMain";

	export default {
		name: "RestaurantShop",

    components: {RestaurantBlock, CommodityForShop},

    data() {
			return {
				start: '',
				arrive: null,
				resInfo: {},
				orderComms: [],
        orderComm:{
					commID: 0,
					name: '',
					price: 0.0,
					count: 0,
					amount: 0.0,
        },
        commodities: [],
        packages: [],
				tableData: [],
        discount: 0.0,
      }
    },

    computed: {
			getTableAmount() {
				let amount = 0.0;
				for (let comm of this.tableData) {
					amount = amount + comm.amount;
        }
        return amount;
      },
    },

    methods: {
	    addOrder() {
				if (this.tableData.length === 0) this.$message.error("未选择商品");
				else if (!this.arrive) this.$message.error("未选择送达时间");
				else {
					let that = this;
					getUserInfo(res => {
						if (!res.number) {
							that.$message.error("尚未填写个人号码");
						}
						else if (!res.address) {
							that.$message.error("尚未填写个人地址");
            }
            else if (!that.resInfo.locate) {
							that.$message.error("商家无地址，无法配送")
            }
            else if (that.resInfo.distance === 0) {
							that.$message.error("距离计算出错，检查联网")
						}
						else if (that.resInfo.distance > 4000) {
							that.$message.error("距离太远，无法配送")
            }
            else {
							addOrder(that.$route.params.resID, res.number, res.address, getCurrentDate(new Date()) + " " + that.setStartTime() + ":00", that.getAmount(), that.tableData, result => {
								if (result === -1) {
									that.$message.error('下单失败，不可超卖');
                }
								else {
									that.$message.success('下单成功');
									that.$router.push({ name: 'order', params: { orderID: result }});
								}
              })
            }
					});
				}
      },

			handleChange(item) {
				let hasItem = false;
				let price = item.price;
				if (item.discount !== 0) {
					price = item.price * item.discount / 10;
        }
				for (let i = 0; i < this.tableData.length; i++) {
					let orderComm = this.tableData[i];
					if (orderComm.commID === item.commID) {
						orderComm.count = item.num;
						orderComm.amount = price * item.num;
						hasItem = true;
						if (item.num === 0) {
							this.tableData.splice(i, 1);
						}
						break;
          }
        }
        if (!hasItem) {
					this.tableData.push({
						commID: item.commID,
						name: item.name,
						price: item.price,
						count: item.num,
						amount: price * item.num,
          })
        }
      },

			deleteRow(index, rows) {
				rows.splice(index, 1);
			},

			getResShopInfo() {
				let that = this;
				getResInfo(this.$route.params.resID, res => {
					that.resInfo = res;
					that.getDistance();
        })
      },

      getDistance() {
				let that = this;
				getUserDefAddr(res => {
				  if (!res)  that.$message.error("请先填写个人地址，否则无法下单")
          else {
						getTimeAndDisBetwAddrs(res.address, that.resInfo.locate, result => {
							if (result.status === 'fail') {
								that.$message.error("距离计算出错，检查联网");
							}
							else {
								that.resInfo.distance = result.distance;
								that.resInfo.time = result.time.toFixed(0);
								if (that.resInfo.distance > 4000) {
									that.$message.error("距离太远，无法配送")
								}
								that.setStartTime();
							}
						})
          }
			  })
			},

      setStartTime() {
				let myDate = new Date();
				let hours = myDate.getHours();
				let minutes = myDate.getMinutes() + parseInt(this.resInfo.time);
				if (minutes >= 60) {
					hours += minutes / 60;
					minutes = minutes % 60;
				}
				hours = hours.toFixed(0);
				if (hours < 10) {
					hours = "0" + hours;
				}
				if (minutes < 10) {
					minutes = "0" + minutes;
				}
				this.start = hours + ':' + minutes;
				return hours + ':' + minutes;
      },

      getResCommodities() {
				let that = this;
				getCurrentCommoditiesFromRes(this.$route.params.resID, "COMMODITY", res => {
					that.commodities = res;
        });
				getCurrentCommoditiesFromRes(this.$route.params.resID, "PACKAGE", res => {
					that.packages = res;
				})
      },

			getDiscount() {
	    	let that = this;
				getUserDiscount(res => {
					that.discount = res;
        })
      },

			getAmount() {
				let amount = 0.0;
				for (let comm of this.tableData) {
					amount = amount + comm.amount;
				}
				if (this.discount !== 0)
          return amount * this.discount;
				else
					return amount;
      },

      init() {
				this.getResShopInfo();
				this.getResCommodities();
				this.getDiscount();
      }

    },

    mounted() {
			this.init();
    },

		watch: {
			"$route": "init"
		},
	}
</script>

<style scoped>
  .first-font-color {
    color: #303133;
  }
  .second-font-color {
    color: #606266;
  }
  .third-font-color {
    color: #909399;
  }
</style>