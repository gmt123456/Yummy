<template>
  <div id="userCenter">
    <el-row>
      <el-col :span="6">
        <div style="text-align: left;border-right: #DCDFE6 solid 1px;min-height: 600px;">
          <div class="first-font-color" style="margin-left: 25px">
            <img v-if="!avatar" src=../../static/avatar.jpg alt="头像" width="80px" height="80px" style="margin: 30px 0 20px 0;border-radius: 3px"/>
            <img v-if="avatar" :src="getImageUrl(avatar)" width="80px" height="80px" style="margin: 30px 0 20px 0;border-radius: 3px"/>
            <div>
              <span class="first-font-color" style="font-weight: bolder;">{{name}}</span>
              <el-tag>L{{level}}</el-tag>
            </div>
            <div v-if="email" class="second-font-color" style="font-size: 14px;margin: 10px 0 10px 0;">
              <span class="el-icon-message"> {{email}}</span>
            </div>
            <div v-if="number" class="second-font-color" style="font-size: 14px;margin: 10px 0 10px 0;">
              <span class="el-icon-phone"> {{number}}</span>
            </div>
            <div v-if="address" class="second-font-color" style="font-size: 14px;text-align: left;max-width: 150px;display: inline-block;">
              <span class="el-icon-location"> {{address}}</span>
            </div>
            <div></div>
            <div style="border-bottom: #DCDFE6 solid 1px;height: 20px;width: 60%;display: inline-block"></div>
          </div>
          <el-menu
              :default-active="$route.path"
              :router="true"
              mode="vertical">
            <el-menu-item index="/user/center/info">
              <i class="el-icon-edit"></i>
              <span slot="title">个人信息</span>
            </el-menu-item>
            <el-menu-item index="/user/center/address">
              <i class="el-icon-location-outline"></i>
              <span slot="title">地址管理</span>
            </el-menu-item>
            <el-menu-item index="/user/center/order">
              <i class="el-icon-document"></i>
              <span slot="title">查看订单</span>
            </el-menu-item>
            <el-menu-item index="/user/center/report" >
              <i class="el-icon-date"></i>
              <span slot="title">统计信息</span>
            </el-menu-item>
            <el-menu-item>
              <el-button @click="writeOffUser">注销账号</el-button>
            </el-menu-item>
          </el-menu>
        </div>
      </el-col>
      <el-col :span="18">
        <router-view v-on:update="getUserInfo"></router-view>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import {getUrl} from "~/api/tool";
  import {getUserInfo} from "~/api/userMain";
  import {writeOff} from "~/api/userMain";

	export default {
		name: "UserCenter",

		data() {
			return {
				userID: 0,
        email: '',
				level: 0,
				number: '',
				name: '',
				address: '',
				avatar: '',
			}
		},

		methods: {
			writeOffUser() {
		    let that = this;
				this.$confirm('此操作将永久注销该账户, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					writeOff(res => {
						if (res === 'SUCCESS') {
							that.$router.push('/');
							that.$message.success('注销成功');
						}
						else
							that.$message.error('注销失败');
          })
				}).catch(() => {
					that.$message({
						type: 'info',
						message: '已取消注销'
					});
				});
			},
      
			getImageUrl(url) {
				return getUrl(url);
			},

			getUserInfo() {
				let that = this;
				getUserInfo(res => {
					that.userID = res.userID;
					that.email = res.email;
					that.level = res.level;
					that.number = res.number;
					that.name = res.name;
					that.address = res.address;
					that.avatar = res.avatar;
        })
			}
		},

		mounted() {
			this.getUserInfo();
		},

		watch: {
			"$route": "getUserInfo"
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