<template>
  <div id="userNavi">
    <common-navi>
      <el-menu :default-active="$route.path" mode="horizontal" :router="true">
        <el-menu-item index="/user/main" style="height: 55px;">首页</el-menu-item>
        <el-menu-item index="/user/center/info" style="height: 55px;">个人中心</el-menu-item>
        <el-button type="text" @click="logout" style="width: 50px;margin-top: 10px">登出</el-button>
      </el-menu>
    </common-navi>
    <router-view></router-view>
  </div>
</template>

<script>
  import CommonNavi from '../common/CommonNavi'

	export default {
		name: "UserNavi",

    components: {CommonNavi},

		methods: {
			logout() {
				localStorage.removeItem('userID');
				this.$message.success('登出成功');
				this.$router.push('/');
			},
		}
	}
</script>

<style scoped>

</style>