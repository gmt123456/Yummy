<template>
  <div id="restaurantNavi">
    <common-navi>
      <el-button type="text" @click="logout" style="width: 50px;margin-top: 10px">登出</el-button>
    </common-navi>
    <el-row>
      <el-col :span="6"><div>
        <div style="text-align: left;border-right: #DCDFE6 solid 1px;min-height: 600px" class="first-font-color">
          <div style="margin-left: 25px">
            <img v-if="!avatar" src=../../static/avatar.jpg alt="头像" width="80px" height="80px" style="margin: 30px 0 20px 0;border-radius: 3px"/>
            <img v-if="avatar" :src="getImageUrl(avatar)" width="80px" height="80px" style="margin: 30px 0 20px 0;border-radius: 3px"/>
            <div>
              <span class="first-font-color" style="font-weight: bolder;margin: 5px 0 5px 0">{{name}}</span>
              <el-tag size="small">{{resType}}</el-tag>
            </div>
            <div style="text-align: left;max-width: 200px;margin: 10px 0 10px 0;display: inline-block;font-size: 14px">
              <i class="el-icon-location"></i>
              <span>{{locate}}</span>
            </div><br>
            <div style="height: 20px;width: 60%;border-bottom: #DCDFE6 solid 1px;display: inline-block"></div>
          </div>
          <el-menu :default-active="$route.path"
                   mode="vertical"
                   :router="true">
            <el-menu-item index="/restaurant/main">
              <i class="el-icon-tickets"></i>
              <span slot="title">餐厅管理</span>
            </el-menu-item>
            <el-menu-item index="/restaurant/order" >
              <i class="el-icon-bell"></i>
              <span slot="title">订单管理</span>
            </el-menu-item>
            <el-menu-item index="/restaurant/commodity" >
              <i class="el-icon-menu"></i>
              <span slot="title">商品管理</span>
            </el-menu-item>
            <el-menu-item index="/restaurant/request" >
              <i class="el-icon-news"></i>
              <span slot="title">我的申请</span>
            </el-menu-item>
            <el-menu-item index="/restaurant/report" >
              <i class="el-icon-date"></i>
              <span slot="title">统计信息</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div></el-col>
      <el-col :span="18"><div>
        <router-view v-on:updateAvatar="getRestaurantInfo"></router-view>
      </div></el-col>
    </el-row>
  </div>
</template>

<script>
  import CommonNavi from '../common/CommonNavi'
  import {getResInfo} from '../../api/restaurant'
  import {getUrl} from '../../api/tool'

	export default {
		name: "RestaurantNavi",

		data() {
			return {
				resID: 0,
				name: "",
				locate: "",
				resType: "",
				avatar: ""
			}
		},

    components: {CommonNavi},

		methods: {
			getImageUrl(url) {
				return getUrl(url);
      },

      getRestaurantInfo() {
				let that = this;
				getResInfo(localStorage.resID, res => {
					that.resID = res.resID;
					that.name = res.name;
					that.locate = res.locate;
					that.resType = res.resType;
					that.avatar = res.avatar;
        })
      },

			logout() {
				localStorage.removeItem('resID');
				this.$message.success('登出成功');
				this.$router.push('/');
			},
		},

    mounted() {
			this.getRestaurantInfo();
    },

    watch: {
			"$route": "getRestaurantInfo"
    },
	}
</script>

<style scoped>
  .first-font-color {
    color: #303133;
  }
  .third-font-color {
    color: #909399;
  }
</style>