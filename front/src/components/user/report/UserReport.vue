<template>
  <div id="userReport">
    <div style="margin: 30px 0 0 40px;text-align: left">
      <el-tabs v-model="activeName" type="card">
        <el-tab-pane label="点餐" name="order">
          <user-report-order></user-report-order>
        </el-tab-pane>
        <el-tab-pane label="退订" name="unsub">
          <user-report-unsub></user-report-unsub>
        </el-tab-pane>
        <el-tab-pane label="财务" name="account">
          <user-report-account></user-report-account>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
  import UserReportAccount from './UserReportAccount'
  import UserReportOrder from './UserReportOrder'
  import UserReportUnsub from './UserReportUnsub'

	export default {
		name: "UserReport",

		components: {UserReportAccount, UserReportOrder, UserReportUnsub},

		data() {
			return {
				activeName: "order",
			}
		},
	}
</script>

<style scoped>

</style>