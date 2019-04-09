<template>
  <div id="managerSettle">
    <div style="margin: 40px 50px 10px 50px;text-align: left">
      <div class="second-font-color">账户余额</div>
      <div style="font-size: 22px;font-weight: bolder;color: dodgerblue;margin: 15px 0 30px 0">¥{{account.toFixed(2)}}</div>
      <div class="second-font-color">餐厅总收益（需结算金额）</div>
      <div style="font-size: 22px;font-weight: bolder;color: hotpink;margin: 15px 0 30px 0">¥{{amount.toFixed(2)}}</div>
      <div v-if="amount !== 0" class="second-font-color">结算</div>
      <div style="margin: 15px 0 30px 0" v-if="amount !== 0">
        <span>以</span>
        <el-select v-model="discount" placeholder="请选择" size="small" style="width: 100px;display: inline-block;">
          <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
        <span>结算给餐厅，共</span>
        <span style="font-size: 22px;font-weight: bolder;color: dodgerblue;">¥{{(amount * discount).toFixed(2)}}</span>
        <div style="margin-top: 15px">
          <el-button type="primary" style="width: 150px" @click.native.prevent="settle">开始结算</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {settle} from '~/api/manager';
	import {getAccount} from '~/api/manager';
	import {getAllAmount} from '~/api/manager';

	export default {
		name: "ManagerSettle",

    data() {
			return {
				account: 0.0,
        amount: 0.0,
        discount: 0.9,
				options: [ {
					value: 1,
					label: '全部'
				}, {
					value: 0.9,
					label: '9折'
				}, {
					value: 0.8,
					label: '8折'
				}, {
					value: 0.7,
					label: '7折'
				}, {
					value: 0.6,
					label: '6折'
				}, {
					value: 0.5,
					label: '5折'
				}, {
					value: 0.4,
					label: '4折'
				}, {
					value: 0.3,
					label: '3折'
				}, {
					value: 0.2,
					label: '2折'
				}, {
					value: 0.1,
					label: '1折'
				}],
      }
    },

    methods: {
			settle() {
				let that = this;
				settle(this.discount, res => {
					that.$message.success('结算成功');
					that.init();
        })
      },

			getAccount() {
				let that = this;
				getAccount(res => {
					that.account = res;
        })
      },

      getAllAmount() {
				let that = this;
				getAllAmount(res => {
					that.amount = res;
        })
      },

      init() {
				this.getAccount();
				this.getAllAmount();
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