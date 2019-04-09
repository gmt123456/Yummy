<template>
  <div id="signUpUser">
    <el-dialog
        title="注册"
        v-bind:visible="visible"
        style="width: 700px;margin: auto;"
        v-bind:before-close="beforeClose"
        center>
      <div style="height: 350px;">
        <el-col :span="24">
          <el-form :model="signUpUserForm"
                   :rules="rules"
                   ref="signUpUserForm"
                   status-icon>
            <el-form-item label="邮箱" prop="email">
              <el-input v-model="signUpUserForm.email" type="email"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input v-model="signUpUserForm.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input v-model="signUpUserForm.checkPass" type="password"></el-input>
            </el-form-item>
            <el-form-item label="验证码" prop="code">
              <br/>
              <el-row :gutter="20">
                <el-col :span="12">
                  <el-input v-model="signUpUserForm.code" type="text"></el-input>
                </el-col>
                <el-col :span="12">
                  <el-button style="width: 100%" @click="confirmEmail" v-bind:loading="loading">验证邮箱</el-button>
                </el-col>
              </el-row>
            </el-form-item>
          </el-form>
        </el-col>
      </div>
      <span slot="footer">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-button style="width: 100%" @click="login">登录</el-button>
          </el-col>
          <el-col :span="12">
            <el-button style="width: 100%" type="primary" @click.native.prevent="signUp">注册</el-button>
          </el-col>
        </el-row>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import {sendEmailCode} from "../../api/email"
	import {confirmEmailCode} from "../../api/email"
  import {register} from "../../api/userMain"

	export default {
		name: "SignUpUser",

		props: {
			visible: Boolean
		},

		data: function () {
			const confirmPassword = (rule, value, callback) => {
				if (value !== this.signUpUserForm.password) {
					callback(new Error("两次密码不一致"));
				} else {
					callback();
				}
			};

			return {
				loading: false,
        signUpDisable: false,
				signUpUserForm: {
					email: '',
					password: '',
					checkPass: '',
					code: ''
        },
        rules: {
					email: [
						{ type: 'email', required: true, trigger: ['blur', 'change'], message: '请输入正确的邮箱地址'},
						{ required: true, message: '请输入邮箱', trigger: 'blur'}
					],
					password: [
						{ required: true, message: '请输入密码', trigger: 'blur'},
						{ min: 6, message: '密码长度最小为6位', trigger: 'blur'}
					],
					checkPass: [
						{ validator: confirmPassword, trigger: 'blur'},
						{ required: true, message: '请再次输入密码', trigger: 'blur'}
          ],
					code: [
						{ required: true, message: '请输入验证码', trigger: 'blur'}
					]
        }
			}
		},

		methods: {
			login() {
				this.$emit("login");
			},

			signUp() {
				let that = this;
				this.$refs['signUpUserForm'].validate((valid) => {
					if (valid) {
						confirmEmailCode(that.signUpUserForm.email, that.signUpUserForm.code, res => {
							if (res === 'FAIL') {
								that.$message.error('验证码错误');
							}
							else if (res === 'SUCCESS') {
								register(that.signUpUserForm.email, that.signUpUserForm.password, res => {
									if (res.result === "SUCCESS") {
										localStorage.userID = res.userID;
										that.$message.success('注册成功');
										that.login();
                  }
                  else if(res.result === "EMAIL_EXIST") {
										that.$message({message: '邮箱已经注册，请前往登录', type: 'success'});
                  }
                  else {
										that.$message.error('登录失败');
                  }
                })
              }
						})
					} else {
						return false;
					}
				})
			},

			confirmEmail() {
				let that = this;
        this.$refs['signUpUserForm'].validateField('email', (error) => {
					if (!error) {
						that.loading = true;
						sendEmailCode(that.signUpUserForm.email, res => {
							that.loading = false;
							if (res === "FAIL") {
								that.$message.error('发送失败');
							}
							else if (res === "SUCCESS") {
								that.$message({message: '发送成功', type: 'success'});
              }
						})
					} else {
						return false;
					}
        });
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