<template>
  <div id="userReportAccount">
    <div>
      <span class="second-font-color">账户余额：</span>
      <span style="color: dodgerblue;font-weight: bold">¥{{balance.toFixed(2)}}</span>
    </div>
    <div style="margin: 10px 0 0 0">
      <span class="second-font-color">累计消费：</span>
      <span style="color: dodgerblue;font-weight: bold">¥{{amount.toFixed(2)}}</span>
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
          prop="resID"
          label="餐厅编号"
          sortable>
      </el-table-column>
      <el-table-column
          prop="amount"
          label="金额"
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
  import {getRecordUserAndType} from "~/api/record";
  import {getUserInfo} from "~/api/userMain";

	export default {
		name: "UserReportAccount",

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
				getRecordUserAndType('FINISH', res => {
					that.tableData = res;
					let count = 0.0;
					for (let item of res) {
						count += item.amount;
          }
          that.amount = count;
				});
				getUserInfo(res => {
					that.balance = res.balance;
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