<template>
  <div id="commodity">
    <div class="horizontal-block">
      <div>
        <img :src="getImgSrc(commodities.avatar)" alt="商品" width="70px" height="70px"/>
      </div>
      <div style="margin-left: 10px;width: 100%;position: relative;height: 70px">
        <span class="first-font-color" style="font-weight: bolder">{{commodities.name}}</span>
        <el-tag size="mini" v-if="commodities.discount && commodities.discount !== 0">{{commodities.discount}}折</el-tag>
        <div style="float: right">
          <span class="third-font-color" style="font-size: 13px">库存 {{commodities.count}}</span><br/>
        </div>
        <div class="child-bottom">
          <span style="font-size: 20px;color: dodgerblue;font-weight: bolder">¥ {{commodities.price}}</span><br/>
        </div>
        <div v-if="commodities.commType === 'PACKAGE'" class="third-font-color" style="font-size: 12px;padding-top: 5px;">
          {{pkgNames}}
        </div>
        <div v-if="commodities.discount && commodities.discount !== 0" class="third-font-color" style="font-size: 14px;padding-top: 5px;">
          <i class="el-icon-time"></i>
          {{commodities.discStart}} ~ {{commodities.discEnd}} (折扣)
        </div>
        <div v-if="commodities.start && commodities.start" style="font-size: 14px;position: absolute;bottom: 0;">
          <i class="el-icon-date"></i>
          <span class="second-font-color">{{commodities.start}} ~ {{commodities.end}}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
	import {getUrl} from "~/api/tool";
	import {getCommNamesFromPkg} from "~/api/commodity";

	export default {
		name: "Commodity",

    props:{
			commodities: Object,
    },

    data() {
			return {
				pkgNames: '',
      }
    },

    computed: {

    },

		methods: {
			getImgSrc(src) {
				return getUrl(src);
			},

			getPkgNames() {
				let that = this;
				let result = '';
				getCommNamesFromPkg(this.commodities.commID, res => {
					for (let i = 0; i < res.length; i++) {
						let name = res[i];
						if (i === 0) result += name;
						else result += "+" + name;
					}
					that.pkgNames = result;
				});
			}
		},

    mounted() {
			this.getPkgNames();
    },

    watch: {
			"$route": "getPkgNames"
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
    right: 0;
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