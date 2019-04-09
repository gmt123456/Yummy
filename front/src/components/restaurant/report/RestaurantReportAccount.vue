<template>
  <div id="restaurantReportAccount">
    <div>
      <span class="second-font-color">账户余额：</span>
      <span style="color: dodgerblue;font-weight: bold">¥{{balance.toFixed(2)}}</span>
    </div>
    <div style="margin: 10px 0 0 0">
      <span class="second-font-color">餐厅收益（等待系统按比例结算）：</span>
      <span style="color: hotpink;font-weight: bold">¥{{amount.toFixed(2)}}</span>
    </div>
    <el-table
        :data="tableData"
        style="width: 100%;"
        max-height="470"
        :default-sort = "{prop: 'time', order: 'descending'}">
      <el-table-column
          prop="orderID"
          label="订单编号"
          sortable>
      </el-table-column>
      <el-table-column
          prop="level"
          label="顾客等级"
          sortable>
      </el-table-column>
      <el-table-column
          prop="amount"
          label="收入"
          sortable>
      </el-table-column>
      <el-table-column
          prop="time"
          label="操作时间"
          sortable>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
	import {getRecordResAndType} from "~/api/record";
	import {getResInfo} from "~/api/restaurant";

	export default {
		name: "RestaurantReportAccount",

		data() {
			return {
				tableData: [],
        balance: 0.0,
        amount: 0.0,
			}
		},

		methods: {
			init() {
				let that = this;
				getRecordResAndType('FINISH', res => {
					that.tableData = res;
				});
				getResInfo(localStorage.resID, res => {
					that.balance = res.balance;
					that.amount = res.amount;
        })
			},
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

</style>