<template>
  <div id="restaurantReport">
    <div style="margin: 30px 0 0 40px;text-align: left">
      <el-tabs v-model="activeName" type="card">
        <el-tab-pane label="点餐" name="order">
          <restaurant-report-order></restaurant-report-order>
        </el-tab-pane>
        <el-tab-pane label="退订" name="unsub">
          <restaurant-report-unsub></restaurant-report-unsub>
        </el-tab-pane>
        <el-tab-pane label="财务" name="account">
          <restaurant-report-account></restaurant-report-account>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
  import RestaurantReportOrder from './RestaurantReportOrder'
  import RestaurantReportUnsub from './RestaurantReportUnsub'
  import RestaurantReportAccount from './RestaurantReportAccount'

	export default {
		name: "RestaurantReport",

    components: {RestaurantReportAccount, RestaurantReportUnsub, RestaurantReportOrder},

    data() {
			return {
				activeName: "order",
      }
    },
	}
</script>

<style scoped>

</style>