<template>
  <div id="commonNavi" class="down-line" style="position: relative;display: flex;">
    <img src="../../static/yummy.png" height="60px" style="padding: 0 0 2px 0"/>
    <span class="second-font-color" style="padding: 26px 0 0 10px">简单、方便、快捷的订餐平台</span>
    <div style="right: 0" class="child-bottom">
      <slot></slot>
    </div>
  </div>
</template>

<script>
	export default {
		name: "CommonNavi"
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
  .fourth-font-color {
    color: #C0C4CC;
  }
  .first-border-color {
    color: #DCDFE6;
  }
  .second-border-color {
    color: #E4E7ED;
  }
  .third-border-color {
    color: #EBEEF5;
  }
  .fourth-border-color {
    color: #F2F6FC;
  }
  .down-line {
    border-bottom: #DCDFE6 solid 1px;
  }
  .child-bottom {
    position: absolute;
    bottom: 0;
  }
</style>