<template>
  <div id="managerMain">
    <el-row>
      <el-col :span="6">
        <div style="text-align: left;border-right: #DCDFE6 solid 1px;min-height: 600px;">
          <el-menu
              :default-active="$route.path"
              :router="true"
              mode="vertical">
            <el-menu-item index="/manager/main/approve">
              <i class="el-icon-edit"></i>
              <span slot="title">审批申请</span>
            </el-menu-item>
            <el-menu-item index="/manager/main/settle">
              <i class="el-icon-document"></i>
              <span slot="title">餐厅结算</span>
            </el-menu-item>
            <el-menu-item index="/manager/main/report">
              <i class="el-icon-date"></i>
              <span slot="title">统计信息</span>
            </el-menu-item>
          </el-menu>
        </div>
      </el-col>
      <el-col :span="18">
        <router-view></router-view>
      </el-col>
    </el-row>
  </div>
</template>

<script>

	export default {
		name: "ManagerMain",



	}
</script>

<style scoped>

</style>