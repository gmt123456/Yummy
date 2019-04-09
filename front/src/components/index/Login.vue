<template>
  <div id="login">
    <el-dialog
        title="登录"
        v-bind:visible="visible"
        style="width: 700px;margin: auto;"
        v-bind:before-close="beforeClose"
        center>
      <div style="height: 250px;">
        <el-col :span="24">
          <el-form>

            <el-form-item label="邮箱 / 识别码">
              <el-input clearable v-model="email" type="text"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input clearable v-model="password" type="password"></el-input>
            </el-form-item>
            <el-form-item>
              <el-radio-group v-model="userType">
                <el-radio label="user">我是顾客</el-radio>
                <el-radio label="restaurant">我是商家</el-radio>
                <el-radio label="manager">我是经理</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" style="width: 100%" @click="login">登录</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </div>
      <span slot="footer">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-button type="text" @click="signUpUser">注册用户</el-button>
          </el-col>
          <el-col :span="12">
            <el-button type="text" @click="signUpRestaurant">注册餐厅</el-button>
          </el-col>
        </el-row>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import {login} from '../../api/userMain'
  import {loginR} from '../../api/restaurant'
  import {loginM} from "~/api/manager";

	export default {
		name: "Login",

		props: {
			visible: Boolean
    },

    data: function () {
      return {
	      email: '',
	      password: '',
	      userType: 'user',
      }
    },

		methods: {
			login() {
				let that = this;
				if (this.userType === 'user') {
					login(this.email, this.password, res => {
						if (res.result === "SUCCESS") {
							localStorage.userID = res.userID;
							that.$message.success("登录成功");
              that.$router.push("/user/main");
            }
            else if (res.result === "PASSWORD_ERROR")  {
							that.$message.error("密码错误");
            }
            else if (res.result === "ID_ERROR") {
							that.$message.error("邮箱错误");
            }
          })
        }
        else if (this.userType === 'restaurant') {
					if(!/^[0-9]+$/.test(this.email)) that.$message.error("识别码格式不正确");
					else {
						loginR(this.email, this.password, res => {
							if (res === "SUCCESS") {
								localStorage.resID = that.email;
								that.$message.success("登录成功");
								that.$router.push("/restaurant/main");
							}
							else if (res === "PASSWORD_ERROR") {
								that.$message.error("密码错误");
							}
							else if (res === "ID_ERROR") {
								that.$message.error("识别码错误");
							}
						})
					}
        }
        else if (this.userType === 'manager') {
					loginM(this.email, this.password, res => {
						if (res === "SUCCESS") {
							localStorage.manager = that.email;
							that.$message.success("登录成功");
							that.$router.push("/manager/main/approve");
						}
						else if (res === "PASSWORD_ERROR")  {
							that.$message.error("密码错误");
						}
						else if (res === "ID_ERROR") {
							that.$message.error("账号错误");
						}
          })
        }
			},

			signUpUser() {
        this.$emit("user");
			},

			signUpRestaurant() {
				this.$emit("restaurant");
			},

			beforeClose(done) {
				done();
				this.$emit("close");
      }
		}
	}
</script>

<style scoped>

</style>