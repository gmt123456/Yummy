<template>
  <div id="orderForUser">
    <el-row>
      <el-col :span="12" :offset="6">
        <el-card style="width: 100%;margin-top: 30px">
          <div style="position: relative;min-height: 550px;">
            <div style="width: 100%;border-bottom: #DCDFE6 solid 1px;padding-bottom: 15px;margin-bottom: 10px">
              <div style="position: absolute">
                <el-button type="text" size="small" style="position: absolute;left: 0" @click="back">{{'<< 返回'}}</el-button>
              </div>
              <span class="first-font-color" style="font-weight: bolder;font-size: 20px;">订单详情</span>
            </div>
            <el-row>
              <el-col :span="12">
                <div style="padding: 15px;font-size: 15px" class="first-font-color">
                  <div style="text-align: left;display: inline-block">
                    <div v-if="state === 'UNPAID'" style="margin-bottom: 5px">
                      <span class="second-font-color" style="font-size: 14px;">支付倒计时</span>
                      <span style="color: dodgerblue;font-weight: bold;font-size: 16px">{{timeCountsShow}}</span>
                    </div>
                    <div style="margin-bottom: 5px">
                      <span class="second-font-color" style="font-size: 14px;">餐厅名称</span>
                      <span style="font-weight: bold;margin: 15px">{{resName}}</span>
                    </div>
                    <div>
                      <span class="second-font-color" style="font-size: 14px;">订单状态</span>
                      <el-tag style="margin-left: 15px" size="small">{{changeState}}</el-tag>
                    </div>
                    <div style="margin-bottom: 4px">
                      <span class="second-font-color" style="font-size: 14px;">下单时间</span>
                      <span style="margin-left: 15px;font-size: 13px">{{time}}</span>
                    </div>
                  </div>
                </div>
              </el-col>
              <el-col :span="12">
                <div style="padding: 15px;font-size: 15px;" class="first-font-color">
                  <div style="text-align: left;display: inline-block">
                    <div style="margin-bottom: 5px">
                      <span class="second-font-color" style="font-size: 14px;">电话号码</span>
                      <span style="margin-left: 15px;font-size: 14px">{{number}}</span>
                    </div>
                    <div style="margin-bottom: 5px">
                      <span class="second-font-color" style="font-size: 14px;">住址信息</span>
                      <span style="margin-left: 15px;font-size: 14px">{{address}}</span>
                    </div>
                    <div>
                      <span class="second-font-color" style="font-size: 14px;">预计送达</span>
                      <span style="margin-left: 15px;font-size: 13px">{{arrive}}</span>
                    </div>
                  </div>
                </div>
              </el-col>
            </el-row>
            <el-table
                :data="tableData"
                style="width: 90%;display: inline-block"
                max-height="300">
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
            <div style="width: 100%;border-top: #DCDFE6 solid 1px;padding-top: 10px;position: absolute;bottom: 0;">
              <el-row>
                <el-col :span="12">
                  <div>
                    <span class="first-font-color" style="font-weight: bolder;vertical-align: middle">合计</span>
                    <span style="font-weight: bold;color: dodgerblue;font-size: 30px;vertical-align: middle">¥{{amount.toFixed(2)}}</span>
                  </div>
                </el-col>
                <el-col :span="12">
                  <el-button type="primary" style="width: 40%" v-if="getOperate() !== '不可退订'" @click.native.prevent="operate">{{getOperateC}}</el-button>
                  <el-button type="primary" style="width: 40%" v-if="getComfirmAble()" @click.native.prevent="confirm">确认收货</el-button>
                </el-col>
              </el-row>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import {getOrderCommsByOrderID} from "~/api/order";
	import {getOrderInfoByID} from "~/api/order";
	import {transformState} from "~/api/order";
	import {payForOrder} from "~/api/order";
	import {unsubOrder} from "~/api/order";
	import {confirmDelivery} from "~/api/order"
  import {getSeconds} from "~/api/time";

	export default {
		name: "OrderForUser",

    data() {
			return {
				orderID: '',
        userName: '',
        resName: '',
        number: '',
        address: '',
        time: '',
        arrive: '',
        amount: 0.0,
        state: '',
				tableData: [],
        timeCounts: 0,
        timeCountsShow: '',
      }
    },

    computed: {
			changeState() {
				return transformState(this.state);
      },

      getOperateC() {
				return this.getOperate();
      }
    },

    methods: {
			timeCount() {
				let that = this;
				if (that.state === 'UNPAID') {
					let interval = window.setInterval(function() {
						let date = new Date(that.timeCounts * 1000);
						that.timeCountsShow = date.getMinutes() + ":" + (date.getSeconds() < 10? "0"+date.getSeconds() : date.getSeconds());
						that.timeCounts--;
						if(that.timeCounts < 0) {
							that.update();
							window.clearInterval(interval);
						}
					}, 1000);
        }
			},

			confirm() {
				let that = this;
				confirmDelivery(this.$route.params.orderID, res => {
					that.$message.success('确认收货成功');
					that.init();
				})
      },

			back() {
				this.$router.go(-1);
      },

      operate() {
				if (this.getOperate() === '支付') this.pay();
				else if (this.getOperate() === '退订') this.unsub();
      },

      pay() {
				let that = this;
				payForOrder(this.$route.params.orderID, res => {
					if (res === 'SUCCESS') {
						that.$message.success("支付成功");
						that.init();
          } 
          else if (res === 'FAIL') {
						that.$message.error('支付失败');
          }
          else if (res === 'NOT_SUFFICIENT_FUNDS') {
						that.$message.error('余额不足');
          }
        })
      },

      unsub() {
				let that = this;
				unsubOrder(this.$route.params.orderID, res => {
					if (res === 'FAIL') {
						that.$message.error("退订失败");
          }
          else if(res === 'SUCCESS') {
						that.$message.success('退订成功，部分金额已返还');
						that.init();
          }
				})
      },

      getOperate() {
				if (this.state === 'UNPAID') return '支付';
				else if (this.state === 'UNACCEPTED') return '退订';
				else if (this.state === 'ACCEPTED') return '退订';
				else if (this.state === 'DELIVERY') return '退订';
				else if (this.state === 'ARRIVE') return '不可退订';
				else if (this.state === 'FINISH') return '不可退订';
				else if (this.state === 'UNSUB') return '不可退订';
				else if (this.state === 'CANCEL') return '不可退订';
      },

      getComfirmAble() {
				if (this.state === 'UNPAID') return false;
				else if (this.state === 'UNACCEPTED') return true;
				else if (this.state === 'ACCEPTED') return true;
				else if (this.state === 'DELIVERY') return true;
				else if (this.state === 'ARRIVE') return true;
				else if (this.state === 'FINISH') return false;
				else if (this.state === 'UNSUB') return false;
				else if (this.state === 'CANCEL') return false;
      },

			getOrderInfo(isCounting) {
				let that = this;
				getOrderInfoByID(this.$route.params.orderID, res => {
					that.orderID = res.orderID;
					that.userName = res.userName;
					that.resName = res.resName;
					that.number = res.number;
					that.address = res.address;
					that.time = res.time;
					that.arrive = res.arrive;
					that.amount = res.amount;
					that.state = res.state;
					if (isCounting) {
						that.timeCounts = getSeconds(that.time) / 1000;
						that.timeCount();
          }
        })
      },

      getOrderCommodities() {
				let that = this;
				getOrderCommsByOrderID(this.$route.params.orderID, res => {
					that.tableData = res;
        })
      },

      update() {
				this.getOrderInfo(false);
				this.getOrderCommodities();
      },

      init() {
				this.getOrderInfo(true);
				this.getOrderCommodities();
      }
    },

    mounted() {
			this.init();
    },

    watch: {
			"$route": "init",
    }

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