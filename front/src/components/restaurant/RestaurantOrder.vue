<template>
  <div id="restaurantOrder">
    <div style="margin: 40px 0px 10px 50px;text-align: left">
      <el-table
          :data="tableData"
          style="width: 100%;"
          max-height="550"
          :default-sort = "{prop: 'time', order: 'descending'}">
        <el-table-column
            prop="orderID"
            label="订单编号" width="50">
        </el-table-column>
        <el-table-column
            prop="userName"
            label="顾客姓名" width="60">
        </el-table-column>
        <el-table-column
            prop="number"
            label="顾客电话号码">
        </el-table-column>
        <el-table-column
            prop="address"
            label="顾客地址">
        </el-table-column>
        <el-table-column
            prop="time"
            label="下单时间"
            sortable>
        </el-table-column>
        <el-table-column
            prop="arrive"
            label="预计到达时间">
        </el-table-column>
        <el-table-column
            prop="amount"
            label="总支付"
            width="60">
        </el-table-column>
        <el-table-column
            prop="state"
            label="状态">
          <template slot-scope="scope">
            {{changeState(scope.row.state)}}
          </template>
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="50">
          <template slot-scope="scope">
            <el-button
                @click.native.prevent="showOrder(scope.row.orderID)"
                type="text"
                size="small">
              查看
            </el-button>
          </template>
        </el-table-column>
        <el-table-column
            fixed="right"
            width="50">
          <template slot-scope="scope">
            <el-button
                @click.native.prevent="operate(scope.row)"
                type="text"
                size="small" v-if="getOperate(scope.row.state) !== '不可操作'">
              {{getOperate(scope.row.state)}}
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <el-dialog
        title="商品列表 / 配送时间"
        :visible.sync="dialogVisible"
        width="600px"
        :before-close="handleClose"
        center>
      <div style="width: 100%;min-height: 300px;text-align: center">
        <el-table
            :data="orderComms"
            style="width: 90%;display: inline-block"
            max-height="250">
          <el-table-column
              prop="name"
              label="商品名称">
          </el-table-column>
          <el-table-column
              prop="price"
              label="单价">
          </el-table-column>
          <el-table-column
              prop="count"
              label="数量">
          </el-table-column>
          <el-table-column
              prop="amount"
              label="总价">
          </el-table-column>
        </el-table>
        <el-table
            :data="deliveryData"
            style="width: 90%;display: inline-block;margin-top: 30px;margin-bottom: 20px"
            max-height="300">
          <el-table-column
              prop="receive"
              label="接单时间">
          </el-table-column>
          <el-table-column
              prop="delivery"
              label="配送时间">
          </el-table-column>
          <el-table-column
              prop="arrive"
              label="送达时间">
          </el-table-column>
        </el-table>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {getOrderByRes} from '~/api/order'
  import {getOrderCommsByOrderID} from "~/api/order";
	import {transformState} from "~/api/order";
	import {receiveOrder} from "~/api/order";
	import {deliveryOrder} from "~/api/order";
	import {arriveOrder} from "~/api/order";
	import {getDeliveries} from "~/api/restaurant"

	export default {
		name: "RestaurantOrder",

    data() {
			return {
				tableData: [],
				orderComms: [],
				dialogVisible: false,
				deliveryData: [],
			}
    },

    methods: {
			handleClose() {
				this.dialogVisible = false;
      },

			showOrder(orderID) {
				let that = this;
				getOrderCommsByOrderID(orderID, res => {
					that.orderComms = res;
					that.dialogVisible = true;
        });
				getDeliveries(orderID, res => {
					let delivery = {
						receive: '',
						delivery: '',
						arrive: '',
					};
					for (let deliveryItem of res) {
						if (deliveryItem.delType === 'RECEIVE') {
							delivery.receive = deliveryItem.time;
            }
						else if (deliveryItem.delType === 'DELIVERY') {
							delivery.delivery = deliveryItem.time;
						}
						else if (deliveryItem.delType === 'ARRIVE') {
							delivery.arrive = deliveryItem.time;
						}
					}
					that.deliveryData.pop();
					that.deliveryData.push(delivery);
        })
      },

			operate(row) {
				let that = this;
				if (this.getOperate(row.state) === '接单') {
					receiveOrder(row.orderID, res => {
						that.getOrders();
          })
        }
        else if (this.getOperate(row.state) === '配送') {
					deliveryOrder(row.orderID, res => {
						that.getOrders();
					})
				}
				else if (this.getOperate(row.state) === '送达') {
					arriveOrder(row.orderID, res => {
						that.getOrders();
					})
				}
      },

			getOrders() {
				let that = this;
				getOrderByRes(res => {
					that.tableData = res;
        })
      },

      changeState(state) {
				return transformState(state);
      },

      getOperate(state) {
				if (state === 'UNPAID') return '不可操作';
				else if (state === 'UNACCEPTED') return '接单';
				else if (state === 'ACCEPTED') return '配送';
				else if (state === 'DELIVERY') return '送达';
				else if (state === 'ARRIVE') return '不可操作';
				else if (state === 'FINISH') return '不可操作';
				else if (state === 'UNSUB') return '不可操作';
				else if (state === 'CANCEL') return '不可操作';
      }
    },

    mounted() {
			this.getOrders();
		},

    watch: {
			"$route": "getOrders",
    }
	}
</script>

<style scoped>

</style>