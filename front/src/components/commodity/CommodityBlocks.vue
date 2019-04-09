<template>
  <div id="commodityBlocks">
    <div class="second-font-color" style="margin: 15px 0 0 0;" v-if="!isCheckList">商品</div>
    <div class="second-font-color" style="margin: 20px 0 10px 0;" v-if="isCheckList">选择商品</div>
    <el-row :gutter="12" v-if="!isCheckList">
      <el-col :span="12" v-for="(item, index) in commodities" :key="index" style="margin: 10px 0 10px 0">
        <div>
          <el-card shadow="always" :body-style="{ padding: '15px' }">
            <commodity :commodities="item"></commodity>
          </el-card>
        </div>
      </el-col>
    </el-row>
      <el-row :gutter="12">
        <el-checkbox-group v-model="checkList" v-if="isCheckList">
          <el-col :span="12" v-for="(item, index) in commodities" :key="index" style="margin: 10px 0 10px 0">
            <el-checkbox :label="item.commID">
              <div style="width: 320px">
                <el-card shadow="always" :body-style="{ padding: '15px' }">
                  <commodity :commodities="item"></commodity>
                </el-card>
              </div>
            </el-checkbox>
          </el-col>
        </el-checkbox-group>
      </el-row>
    <div v-if="!isCheckList">
      <div class="second-font-color" style="margin: 5px 0 0 0;">套餐</div>
      <el-row :gutter="12">
        <el-col :span="12" v-for="(item, index) in packages" :key="index" style="margin: 10px 0 10px 0">
          <div>
            <el-card shadow="always" :body-style="{ padding: '15px' }">
              <commodity :commodities="item"></commodity>
            </el-card>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  import {getCommoditiesFromRes} from '../../api/commodity'
  import Commodity from './Commodity'

	export default {
		name: "CommodityBlocks",

    components: {Commodity},

    props: {
			isCheckList: Boolean,
    },

    data() {
			return {
				commodities: [],
        packages: [],
				checkList: [],
      }
    },

    methods: {
			clearCheckList() {
				this.checkList = [];
      },

			getCheckList() {
				return this.checkList;
      },

      updateCommodity() {
				let that = this;
				getCommoditiesFromRes("COMMODITY", res => {
					that.commodities = res;
					if (res.length >= 1) {
						that.$emit("setDiscountAbleTrue");
          }
					if (res.length >= 2) {
						that.$emit("setPackageAbleTrue");
          }
				});
      },

      updatePackage() {
				let that = this;
				getCommoditiesFromRes("PACKAGE", res => {
					that.packages = res;
				})
      },
    },

		mounted() {
			this.updateCommodity();
			this.updatePackage();
		},

	}
</script>

<style scoped>
  .second-font-color {
    color: #606266;
  }
</style>