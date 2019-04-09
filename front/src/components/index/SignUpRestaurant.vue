<template>
  <div id="signUpRestaurant">
    <el-dialog
        title="餐厅注册"
        v-bind:visible="visible"
        style="width: 700px;margin: auto;"
        v-bind:before-close="beforeClose"
        center>
      <div style="height: 300px;" v-if="!isLogin">
        <span class="second-font-color">注册之后您将收到系统分配的餐厅识别码，用于登录</span>
        <el-col :span="24">
          <el-form :model="signUpResForm"
                   :rules="rules"
                   ref="signUpResForm"
                   status-icon>
            <el-form-item label="密码" prop="password">
              <el-input v-model="signUpResForm.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input v-model="signUpResForm.checkPass" type="password"></el-input>
            </el-form-item>
          </el-form>
        </el-col>
      </div>

      <div style="height: 300px;" v-if="isLogin">
        <span class="second-font-color">这是您的餐厅识别码，请妥善保存</span>
        <div style="font-size: 25px;font-weight: bold;color: dodgerblue;margin: 20px 0 20px 100px">{{resID}}</div>
        <el-button type="primary" @click="goToLogin" style="margin: 0 0 0 50px; width: 200px">去登录</el-button>
      </div>

      <span slot="footer">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-button style="width: 100%" @click="login">登录</el-button>
          </el-col>
          <el-col :span="12">
            <el-button style="width: 100%" type="primary" @click="signUp" v-bind:disabled="signUpDisable">注册</el-button>
          </el-col>
        </el-row>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import {register} from '../../api/restaurant'

	export default {
		name: "SignUpRestaurant",

		props: {
			visible: Boolean
		},

		data: function () {
			const confirmPassword = (rule, value, callback) => {
				if (value !== this.signUpResForm.password) {
					callback(new Error("两次密码不一致"));
				} else {
					callback();
				}
			};

			return {
				resID: "",
				isLogin: false,
				signUpDisable: false,
        signUpResForm: {
					password: '',
					checkPass: '',
        },
        rules: {
					password: [
						{ required: true, message: '请输入密码', trigger: 'blur'},
						{ min: 6, message: '密码长度最小为6位', trigger: 'blur'}
					],
					checkPass: [
						{ validator: confirmPassword, trigger: 'blur'},
						{ required: true, message: '请再次输入密码', trigger: 'blur'}
					],
        }
			}
		},

    methods: {
	    login() {
	    	this.$emit("login");
	    },

			goToLogin() {
	    	this.$router.push("/restaurant/main");
      },

	    signUp() {
	    	let that = this;
				this.$refs['signUpResForm'].validate((valid) => {
					if (valid) {
						that.signUpDisable = true;
						register(that.signUpResForm.password, res => {
							localStorage.resID = res;
							that.resID = res;
							that.isLogin = true;
            })
					} else {
						return false;
					}
				})
	    },

	    beforeClose(done) {
		    done();
		    this.$emit("close");
	    },
    }
	}
</script>

<style scoped>

</style>