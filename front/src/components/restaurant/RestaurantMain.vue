<template>
  <div id="restaurantMain">
    <div style="margin: 30px 0 0 50px;text-align: left">
      <el-form :model="form"
               :rules="rules"
               ref="form"
               status-icon>
        <el-form-item prop="name">
          <div class="second-font-color">更改名称</div>
          <el-input v-model="form.name" style="width: 230px"></el-input>
          <el-button @click="modifyName" v-if="nameAble">提交申请</el-button>
          <el-button disabled v-if="!nameAble">等待申请通过</el-button>
        </el-form-item>
        <el-form-item prop="locate">
          <div class="second-font-color">更改地址</div>
          <map-input ref="mapInput" style="width: 230px"></map-input>
          <el-button @click="modifyLocate" v-if="locateAble">提交申请</el-button>
          <el-button disabled v-if="!locateAble">等待申请通过</el-button>
        </el-form-item>
        <el-form-item prop="resType">
          <div class="second-font-color">更改类型</div>
          <el-select v-model="form.resType" placeholder="请选择" style="width: 230px">
            <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
          <el-button @click="modifyType" v-if="resTypeAble">提交申请</el-button>
          <el-button disabled v-if="!resTypeAble">等待申请通过</el-button>
        </el-form-item>
      </el-form>
      <div>
        <div class="second-font-color" style="padding: 20px 0 0 0">更改餐厅头像</div><br/>
        <change-avatar :change-type="'restaurant'" v-on:updateAvatar="updateAvatar"></change-avatar>
      </div>
    </div>
  </div>
</template>

<script>
  import ChangeAvatar from '../common/ChangeAvatar'
  import MapInput from '../common/MapInput'
  import {getAllRestaurantType} from '../../api/restaurant'
  import {modifyResLocate} from '../../api/restaurant'
	import {modifyResName} from '../../api/restaurant'
	import {modifyResType} from '../../api/restaurant'
  import {getCurrentRequestByResID} from '../../api/request'

	export default {
		name: "RestaurantMain",

    components: {MapInput, ChangeAvatar},

    data() {
			return {
				form: {
					name: "",
					locate: "",
					resType: "",
				},
        nameAble: true,
        locateAble: true,
				resTypeAble: true,
				options: [],
				rules: {
					resType: [
						{ required: true, message: '请选择餐厅类型', trigger: 'blur'},
					],
					name: [
						{ required: true, message: '请输入餐厅名', trigger: 'blur'}
					],
				}
      }
    },

    methods: {
			updateAvatar() {
				this.$emit("updateAvatar");
      },

			modifyLocate() {
				let that = this;
				modifyResLocate(this.$refs.mapInput.getInput(), res => {
					if (res === "SUCCESS") {
						that.$message.success("提交申请成功，等待审批")
            that.locateAble = false;
					}
				})
      },

      modifyName() {
				let that = this;
				this.$refs['form'].validateField('name', (error) => {
					if (!error) {
						modifyResName(that.form.name, res => {
							if (res === "SUCCESS") {
								that.$message.success("提交申请成功，等待审批")
                that.nameAble = false;
							}
						})
					}
					else return false;
				})
      },

      modifyType() {
				let that = this;
				this.$refs['form'].validateField('resType', (error) => {
					if (!error) {
						modifyResType(that.form.resType, res => {
							if (res === "SUCCESS") {
								that.$message.success("提交申请成功，等待审批")
                that.resTypeAble = false;
							}
						})
					}
					else return false;
				})
      },

      getOptions() {
				let that = this;
				getAllRestaurantType(res => {
					for (let type of res) {
						that.options.push({
							value: type.typeName,
							label: type.typeName,
            });
          }
        })
      },

      updateAble() {
				let that = this;
				getCurrentRequestByResID(localStorage.resID, res => {
					if (res.length > 0) {
						for (let request of res) {
							if (request.reqType === "NAME") {
								that.nameAble = false;
							}
							else if (request.reqType === "LOCATE") {
								that.locateAble = false;
							}
							else if (request.reqType === "TYPE") {
								that.resTypeAble = false;
							}
						}
					}
				})
      }
		},

    mounted() {
			this.getOptions();
			this.updateAble();
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