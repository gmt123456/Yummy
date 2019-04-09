<template>
  <div id="commodityForShop">
    <div style="display: flex;">
      <div>
        <img v-if="item.avatar" :src="getImgSrc(item.avatar)" alt="商品" width="70px" height="70px"/>
      </div>
      <div style="margin-left: 10px;width: 100%">
        <span class="first-font-color" style="font-weight: bolder">{{item.name}}</span>
        <div class="third-font-color" style="font-size: 13px;float: right">库存{{item.count}}</div>
        <div v-if="item.commType === 'PACKAGE'" class="third-font-color" style="font-size: 12px;padding-top: 5px;">
          {{pkgNames}}
        </div>
        <div style="margin: 8px 0 8px 0">
          <span class="third-font-color" style="font-size: 13px">单价</span>
          <span v-if="!item.discount" class="first-font-color" style="font-weight: bolder;">¥{{item.price}}</span>
          <span v-if="item.discount" class="first-font-color" style="font-weight: bolder;text-decoration:line-through">¥{{item.price}}</span>
          <span v-if="item.discount" style="font-weight: bolder;color: red">¥{{item.price * item.discount / 10}}</span>
        </div>
        <el-input-number v-if="item.count !== 0" v-model="item.num" :step="1" size="mini" @change="handleChange(item)" :min="0" :max="10"></el-input-number>
      </div>
    </div>
  </div>
</template>

<script>
  import {getUrl} from "~/api/tool";
  import {getCommNamesFromPkg} from "~/api/commodity";

	export default {
		name: "CommodityForShop",

    props: {
			item: Object,
    },

    data() {
			return {
				pkgNames: '',
      }
    },

    methods: {
			getImgSrc(url) {
				return getUrl(url);
			},

			handleChange(item) {
				this.$emit("handleChange", item);
      },

			getPkgNames() {
				let that = this;
				let result = '';
				getCommNamesFromPkg(this.item.commID, res => {
					for (let i = 0; i < res.length; i++) {
						let name = res[i];
						if (i === 0) result += name;
						else result += "+" + name;
					}
					that.pkgNames = result;
				});
			},
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