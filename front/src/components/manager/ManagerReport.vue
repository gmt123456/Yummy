<template>
  <div id="managerReport">
    <div style="margin: 40px 50px 10px 50px;text-align: left">
      <div>
        <span class="second-font-color">用户总数量：</span>
        <span class="first-font-color">{{userCount}}</span>
        <span class="second-font-color" style="margin-left: 100px">餐厅总数量：</span>
        <span class="first-font-color">{{resCount}}</span>
      </div>
      <div style="margin-top: 30px">
        <span class="second-font-color">下单金额统计表：</span>
        <div id="echarts" :style="{width: '600px', height: '300px'}"></div>
      </div>
      <div v-if="finish !== 0 || settle !== 0">
        <span class="second-font-color">财务状况：</span>
        <div id="echarts2" :style="{width: '600px', height: '200px'}"></div>
      </div>
    </div>
  </div>
</template>

<script>
  import {getUserCounts} from "~/api/manager";
  import {getResCounts} from "~/api/manager";
  import {getOrderAmountList} from "~/api/record";
  import {getFinishAmount} from "~/api/record";
  import {getSettleAmount} from "~/api/record";

	export default {
		name: "ManagerReport",

    data() {
			return {
				userCount: 0,
        resCount: 0,
				data: {
					data0: 0,
          data1: 0,
          data2: 0,
          data3: 0,
          data4: 0,
          data5: 0,
          data6: 0,
        },
        finish: 0.0,
        settle: 0.0,
      }
    },

    methods: {
			init() {
				let that = this;
				getUserCounts(res => {
					that.userCount = res;
				});
				getResCounts(res => {
					that.resCount = res;
				});
        getOrderAmountList(res => {
        	for(let amount of res) {
        		that.checkAmount(amount);
          }
        	that.setEchart();
        })
        getFinishAmount(res => {
        	that.finish = res;
					getSettleAmount(res => {
						that.settle = res;
						that.setEchart2();
					})
        })
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

			setEchart2() {
				let that = this;
				let dom = document.getElementById('echarts2');
				let myChart = this.echarts.init(dom);
				myChart.setOption({
					series : [
						{
							name: '访问来源',
							type: 'pie',
							radius: '55%',
							data:[
								{value:(that.finish - that.settle).toFixed(2), name:'公司利润'},
								{value:that.settle.toFixed(2), name:'商店总收入'},
							],
              label: {
								show: true,
								formatter: '{b}: ¥{c}',
              }
						}
					]
				});
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