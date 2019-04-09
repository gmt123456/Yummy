<template>
  <div id="userAddress">
    <div style="margin: 30px 0 0 50px;text-align: left;font-size: 14px">
      <div class="second-font-color" style="padding: 10px 0 10px 0">默认地址</div>
      <div class="first-font-color" style="font-weight: bolder;">{{defAddress.address}}</div>

      <div class="second-font-color" style="padding: 40px 0 10px 0">新增地址</div>
      <map-input ref="mapInput" style="width: 230px"></map-input>
      <el-button @click="addAddress">保存</el-button>

      <div class="second-font-color" style="padding: 40px 0 0 0">地址列表</div>
      <el-table
          :data="tableData"
          style="width: 100%;"
          max-height="300">
        <el-table-column
            type="index">
        </el-table-column>
        <el-table-column
            prop="address"
            label="名称">
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="100">
          <template slot-scope="scope">
            <el-button
                @click.native.prevent="handleRow(scope.$index, tableData)"
                type="text"
                size="small" v-if="tableData[scope.$index].addrID !== defAddress.addrID">
              设为默认地址
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import MapInput from '../common/MapInput'
	import {modifyUserAddress} from "~/api/userModify";
	import {modifyUserDefAddr} from "~/api/userModify";
	import {addUserAddress} from "~/api/userModify";
	import {getUserDefAddr} from "~/api/userMain";
	import {getUserAllAddr} from "~/api/userMain";

	export default {
		name: "UserAddress",

    components: {MapInput},

    data() {
			return {
        defAddress: {
					addrID: 0,
          address: '',
        },
        tableData: [],
      }
    },

    methods: {
			handleRow(index, rows) {
				let addressVO = rows[index];
				this.setDefAddress(addressVO.addrID, addressVO.address);
			},

			addAddress() {
				let that = this;
				addUserAddress(this.$refs.mapInput.getInput(), res => {
					that.$message.success('添加成功');
					that.init();
        })
      },

      setDefAddress(addrID, address) {
				let that = this;
				modifyUserDefAddr(addrID, res => {
					if (res === 'SUCCESS') {
						that.$message.success('设置成功');
						that.defAddress.addrID = addrID;
						that.defAddress.address = address;
						that.$emit("update");
          }
        })
      },

      getDefAddress() {
				let that = this;
				getUserDefAddr(res => {
					if (res) {
						that.defAddress = res;
          }
        })
      },

      getAllAddress() {
				let that = this;
				getUserAllAddr(res => {
					if (res && res.length > 0) {
						that.tableData = res;
          }
        })
      },

      init() {
				this.getDefAddress();
				this.getAllAddress();
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