<template>
  <div id="userMessage">
    <div style="margin: 30px 0 0 50px;text-align: left;font-size: 14px">
      <el-form :model="form"
               :rules="rules"
               ref="form"
               status-icon>
        <el-form-item prop="name">
          <div class="second-font-color">更改姓名</div>
          <el-input v-model="form.name" style="width: 230px"></el-input>
          <el-button @click="modifyName">保存</el-button>
        </el-form-item>
        <el-form-item prop="number">
          <div class="second-font-color">更改电话</div>
          <el-input v-model="form.number" style="width: 230px"></el-input>
          <el-button @click="modifyNumber">保存</el-button>
        </el-form-item>
      </el-form>
      <div>
        <div class="second-font-color" style="padding: 20px 0 0 0">更改用户头像</div><br/>
        <change-avatar :change-type="'user'" v-on:updateAvatar="updateAvatar"></change-avatar>
      </div>
    </div>
  </div>
</template>

<script>
  import ChangeAvatar from '../common/ChangeAvatar'
  import {modifyUserName} from "~/api/userModify";
  import {modifyUserNumber} from "~/api/userModify";

	export default {
		name: "UserMessage",

    components: {ChangeAvatar},

    data() {
			return {
				form: {
					name: "",
					number: "",
				},
				rules: {
					number: [
						{ required: true, message: '请输入电话号码', trigger: 'blur'},
					],
					name: [
						{ required: true, message: '请输入您的姓名', trigger: 'blur'}
					],
				}
      }
    },

    methods: {
			modifyName() {
				let that = this;
				this.$refs['form'].validateField('name', (error) => {
					if (!error) {
						modifyUserName(that.form.name, res => {
							if (res === "SUCCESS") {
								that.$message.success("修改成功");
								that.$emit("update");
							}
						})
					}
					else return false;
				})
      },

			modifyNumber() {
				let that = this;
				this.$refs['form'].validateField('number', (error) => {
					if (!error) {
						modifyUserNumber(this.form.number, res => {
							if (res === "SUCCESS") {
								this.$message.success("修改成功");
								this.$emit("update");
							}
						})
					}
				})
      },

			updateAvatar() {
				this.$emit("update");
      },
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