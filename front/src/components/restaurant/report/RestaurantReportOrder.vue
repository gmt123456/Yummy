<template>
  <div id="restaurantReportOrder">
    <div style="">
      <span class="second-font-color">下单金额统计表：</span>
      <div id="echarts" :style="{width: '600px', height: '250px'}"></div>
    </div>
    <el-table
        :data="tableData"
        style="width: 100%;"
        max-height="250"
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
          label="订单金额"
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

	export default {
		name: "RestaurantReportOrder",

    data() {
			return {
				tableData: [],
				data: {
					data0: 0,
					data1: 0,
					data2: 0,
					data3: 0,
					data4: 0,
					data5: 0,
					data6: 0,
				},
      }
    },

    methods: {
			init() {
				let that = this;
				getRecordResAndType('ORDER', res => {
					that.tableData = res;
					for(let item of res) {
						that.checkAmount(item.amount);
					}
					that.setEchart();
				});
      },

			checkAmount(amount) {
				if (0 <= amount && amount <= 9) {
					this.data.data0++;
				}
				else if (10 <= amount && amount <= 19) {
					this.data.data1++;
				}
				else if (20 <= amount && amount <= 29) {
					this.data.data2++;
				}
				else if (30 <= amount && amount <= 39) {
					this.data.data3++;
				}
				else if (40 <= amount && amount <= 49) {
					this.data.data4++;
				}
				else if (50 <= amount && amount <= 59) {
					this.data.data5++;
				}
				else if (60 <= amount) {
					this.data.data6++;
				}
			},

			setEchart() {
				let echartsData = [this.data.data0, this.data.data1, this.data.data2, this.data.data3, this.data.data4, this.data.data5, this.data.data6]
				let dom = document.getElementById('echarts');
				let myChart = this.echarts.init(dom);
				myChart.setOption({
					tooltip: {},
					xAxis: {
						data: ["0~9","10~19","20~29","30~39","40~49","50~59","60+"],
						name: '金额',
					},
					yAxis: {
						name: '次数',
					},
					series: [{
						name: '订单次数',
						type: 'bar',
						data: echartsData,
					}]
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
  .second-font-color {
    color: #606266;
  }
</style>