<template>
  <div id="userOrder">
    <div style="margin: 40px 0px 10px 50px;text-align: left">
      <el-table
          :data="tableData"
          style="width: 100%;"
          max-height="550"
          :default-sort = "{prop: 'time', order: 'descending'}">
        <el-table-column
            prop="resName"
            label="餐厅名称">
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
            width="80">
          <template slot-scope="scope">
            <el-button
                @click.native.prevent="goShop(scope.row.resID)"
                type="text"
                size="small">
              进入店铺
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import {getOrdersByUser} from "~/api/order";
  import {transformState} from "~/api/order";

	export default {
		name: "UserOrder",

    data() {
			return {
				tableData: [],
      }
    },

    methods: {
			goShop(resID) {
				this.$router.push({ name: 'shop', params: { resID: resID }});
      },

			showOrder(orderID) {
				this.$router.push({ name: 'order', params: { orderID: orderID }});
      },

			changeState(state) {
				return transformState(state);
      },

      getOrderInfo() {
				let that = this;
				getOrdersByUser(res => {
					that.tableData = res;
        });
      },
    },

    mounted() {
			this.getOrderInfo();
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