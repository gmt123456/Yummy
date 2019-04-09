<template>
  <div id="restaurantBlock">
    <div class="horizontal-block">
      <div>
        <img :src="getImageUrl(item.avatar)" width="70px" height="70px"/>
      </div>
      <div style="margin-left: 10px;position: relative;width: 100%">
        <span class="first-font-color" style="font-weight: bolder">{{item.name}}</span>
        <el-tag>{{item.resType}}</el-tag>
        <div style="float: right" v-if="item.locate">
          <div v-if="item.distance < 1000" class="third-font-color" style="font-size: 13px">{{item.distance}} m</div>
          <div v-else class="third-font-color" style="font-size: 13px">{{(item.distance / 1000).toFixed(2)}} km</div>
          <div class="third-font-color" style="font-size: 13px">{{item.time}} 分钟</div>
        </div>
        <div v-if="item.locate">
          <span class="el-icon-location-outline child-bottom third-font-color" style="font-size: 14px">{{item.locate}}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {getUrl} from "~/api/tool";

	export default {
		name: "RestaurantBlock",

    props: {
			item: Object,
    },

    methods: {
			getImageUrl(url) {
				return getUrl(url);
			},
    }
	}
</script>

<style scoped>
  .horizontal-block {
    display: flex;
  }
  .child-bottom {
    position: absolute;
    bottom: 0;
  }
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