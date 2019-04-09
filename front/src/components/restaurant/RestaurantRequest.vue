<template>
  <div id="restaurantRequest">
    <div style="margin: 40px 50px 10px 50px;text-align: left">
      <el-table
          :data="tableData"
          style="width: 100%;"
          max-height="550"
          :default-sort = "{prop: 'reqTime', order: 'descending'}">
        <el-table-column
            prop="newInfo"
            label="修改后">
        </el-table-column>
        <el-table-column
            prop="oldInfo"
            label="修改前">
        </el-table-column>
        <el-table-column
            prop="reqType"
            label="类型">
          <template slot-scope="scope">
            {{changeType(scope.row.reqType)}}
          </template>
        </el-table-column>
        <el-table-column
            prop="reqTime"
            label="申请时间"
            sortable>
        </el-table-column>
        <el-table-column
            prop="state"
            label="状态">
          <template slot-scope="scope">
            {{changeState(scope.row.state)}}
          </template>
        </el-table-column>
        <el-table-column
            prop="apprTime"
            label="审批时间"
            sortable>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import {getRequestByResID} from "~/api/request";

	export default {
		name: "RestaurantRequest",

    data() {
			return {
				tableData: []
      }
    },

    methods: {
			getRequests() {
				let that = this;
				getRequestByResID(localStorage.resID, res => {
					that.tableData = res;
				})
			},
	
			changeType(type) {
				if (type === 'NAME') return '名称';
				else if (type === 'LOCATE') return '地址';
				else if (type === 'TYPE') return '类型';
			},
      
      changeState(state) {
				if (state === 'PENDING') return '待处理';
				else if (state === 'AGREE') return '已通过';
				else if (state === 'REJECT') return '未通过';
      },
    },

    mounted() {
			this.getRequests();
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