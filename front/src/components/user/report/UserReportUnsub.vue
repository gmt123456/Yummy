<template>
  <div id="userReportUnsub">
    <div>
      <span class="second-font-color">退订次数：</span>
      <span style="color: dodgerblue;font-weight: bold">{{tableData.length}}</span>
    </div>
    <el-table
        :data="tableData"
        style="width: 100%;"
        max-height="530"
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
          label="退还金额"
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

	export default {
		name: "UserReportUnsub",

		data() {
			return {
				tableData: [],
			}
		},

		methods: {
			init() {
				let that = this;
				getRecordUserAndType('UNSUB', res => {
					that.tableData = res;
				});
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