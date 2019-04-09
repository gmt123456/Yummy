<template>
  <div id="managerNavi">
    <common-navi>
      <el-button type="text" @click="logout">登出</el-button>
    </common-navi>
    <router-view></router-view>
  </div>
</template>

<script>
	import CommonNavi from '../common/CommonNavi'

	export default {
		name: "ManagerNavi",

		components: {CommonNavi},

    methods: {
			logout() {
				localStorage.removeItem('manager');
				this.$message.success('登出成功');
				this.$router.push('/');
      },
    }
	}
</script>

<style scoped>

</style>