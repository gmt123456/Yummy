<template>
  <div id="managerApprove">
    <div style="margin: 40px 50px 10px 50px;text-align: left">
      <el-table
          :data="tableData"
          style="width: 100%;"
          max-height="300">
        <el-table-column
            prop="resID"
            label="餐厅ID">
        </el-table-column>
        <el-table-column
            prop="resName"
            label="餐厅名称">
        </el-table-column>
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
            label="申请时间">
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="50">
          <template slot-scope="scope">
            <el-button
                @click.native.prevent="accept(scope.$index, tableData)"
                type="text"
                size="small">
              同意
            </el-button>
          </template>
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="50">
          <template slot-scope="scope">
            <el-button
                @click.native.prevent="reject(scope.$index, tableData)"
                type="text"
                size="small">
              拒绝
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import {acceptRequest} from '~/api/request'
	import {rejectRequest} from '~/api/request'
	import {getInboxRequests} from '~/api/request'

	export default {
		name: "ManagerApprove",

    data() {
			return {
				tableData: [],
      }
    },

    methods: {
			accept(index, rows) {
				acceptRequest(rows[index].reqID, res => {
					if (res === 'FAIL') {
						this.$message.error("处理失败");
          }
          else {
						rows.splice(index, 1);
          }
        })
			},


			reject(index, rows) {
				rejectRequest(rows[index].reqID, res => {
					if (res === 'FAIL') {
						this.$message.error("处理失败");
					}
					else {
						rows.splice(index, 1);
          }
				})
			},

      initInbox() {
				let that = this;
				getInboxRequests(res => {
					that.tableData = res;
        })
      },

			changeType(type) {
				if (type === 'NAME') return '名称';
				else if (type === 'LOCATE') return '地址';
				else if (type === 'TYPE') return '类型';
			},
    },

    mounted() {
			this.initInbox();
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