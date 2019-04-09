<template>
  <div id="restaurantCommodity">
    <div style="margin: 30px 0 0 40px;text-align: left">
      <div v-if="!isCheckList">
        <el-button type="primary" icon="el-icon-plus" @click="addVisible=true">发布信息</el-button>
      </div>
      <div v-if="isCheckList">
        <el-button type="primary" @click="openNewPackage" v-if="isPackage">选择完毕</el-button>
        <el-button type="primary" @click="openNewDiscount" v-if="isDiscount">选择完毕</el-button>
      </div>

      <commodity-blocks :isCheckList="isCheckList" ref="commodities"
                        v-on:setPackageAbleTrue="setPackageAbleTrue"
                        v-on:setDiscountAbleTrue="setDiscountAbleTrue"></commodity-blocks>

      <el-dialog
          :title="'选择类型'"
          :visible.sync="addVisible"
          width="400px"
          :before-close="beforeClose">
        <el-row>
          <el-col :span="24">
            <el-button type="primary" style="margin: 10px 0 0 110px" icon="el-icon-plus" @click="clickAddCommodity">新增商品</el-button>
          </el-col>
          <el-col :span="24">
            <el-button v-if="isPackageAble" style="margin: 20px 0 0 110px" type="primary" icon="el-icon-plus" @click="clickAddPackage">新增套餐</el-button>
          </el-col>
          <el-col :span="24">
            <el-button v-if="isDiscountAble" style="margin: 20px 0 80px 110px" type="primary" icon="el-icon-plus" @click="clickAddDiscount">新增优惠</el-button>
          </el-col>
        </el-row>
      </el-dialog>

      <el-dialog
          :title="isCommodity?'新增商品':'新增套餐'"
          :visible.sync="dialogVisible"
          width="410px"
          :before-close="beforeClose">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="名称">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="价格">
            <el-input v-model.number="form.price" placeholder="请输入价格" type="number"></el-input>
          </el-form-item>
          <el-form-item label="库存">
            <el-input v-model.number="form.count" placeholder="请输入库存数量" type="number"></el-input>
          </el-form-item>
          <el-form-item label="上架时间">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="开始时间" v-model="form.start" style="width: 100%;"></el-date-picker>
            </el-col>
            <el-col class="line" :span="2">-</el-col>
            <el-col :span="11">
              <el-date-picker type="date" placeholder="结束时间" v-model="form.end" style="width: 100%;"></el-date-picker>
            </el-col>
          </el-form-item>
        </el-form>
        <div>
          <div class="second-font-color" style="padding: 20px 0 0 0">设置图片</div><br/>
          <change-avatar :change-type="getChangeType"
                         ref="ChangeAvatar"
                         v-on:setCommodityImageData="setCommodityImageData"
                         v-on:setPackageImageData="setPackageImageData"></change-avatar>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="beforeClose">取 消</el-button>
          <el-button type="primary" @click="startNew">发 布</el-button>
        </span>
      </el-dialog>

      <el-dialog
          title="新增优惠"
          :visible.sync="discountVisible"
          width="400px"
          :before-close="beforeClose">
        <el-form>
          <el-form-item>
            <el-select v-model="discount.discount" placeholder="请选择">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="优惠时间">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="开始时间" v-model="discount.start" style="width: 100%;"></el-date-picker>
            </el-col>
            <el-col class="line" :span="2">-</el-col>
            <el-col :span="11" style="margin: 10px 0 0 70px">
              <el-date-picker type="date" placeholder="结束时间" v-model="discount.end" style="width: 100%;"></el-date-picker>
            </el-col>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="beforeClose">取 消</el-button>
          <el-button type="primary" @click="newDiscount">发 布</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import CommodityBlocks from "../commodity/CommodityBlocks";
  import ChangeAvatar from "../common/ChangeAvatar"
  import {addNewCommodity} from '../../api/commodity'
	import {setCommodityTime} from '../../api/commodity'
  import {addNewPackage} from '../../api/commodity'
  import {updateDiscounts} from '../../api/commodity'
  import {getCurrentDate} from "~/api/time";

	export default {
		name: "RestaurantCommodity",

    components: {CommodityBlocks, ChangeAvatar},

    data() {
			return {
				title: "",
				isPackageAble: false,
				isDiscountAble: false,
				isCheckList: false,
				dialogVisible: false,
				discountVisible: false,
        addVisible: false,
        isCommodity: false,
        isDiscount: false,
        isPackage: false,
				form: {
					name: "",
          price: 0.0,
          count: 0,
          imageData: "",
          start: "",
          end: "",
        },
        discount: {
					discount: 0,
          start: "",
          end: "",
        },
				options: [{
					value: 0,
					label: '不打折'
				}, {
					value: 1,
					label: '1折'
				}, {
					value: 2,
					label: '2折'
				}, {
					value: 3,
					label: '3折'
				}, {
					value: 4,
					label: '4折'
				}, {
					value: 5,
					label: '5折'
				}, {
					value: 6,
					label: '6折'
				}, {
					value: 7,
					label: '7折'
				}, {
					value: 8,
					label: '8折'
				}, {
					value: 9,
					label: '9折'
				}],
        commIDs: [],
      }
    },

    computed: {
			getChangeType() {
				if (this.isCommodity) return 'commodity';
				if (this.isPackage) return 'package';
			}
    },

    methods: {
			clearComms() {
				this.$refs.commodities.clearCheckList();
				this.commIDs = [];
      },

			clickAddCommodity() {
				this.addVisible = false;
				this.dialogVisible = true;
				this.isCommodity = true;
      },

      clickAddPackage() {
				this.addVisible = false;
				this.isPackage = true;
				this.isCheckList = true;
      },

      clickAddDiscount() {
				this.addVisible = false;
				this.isDiscount = true;
				this.isCheckList = true;
      },

			setPackageAbleTrue() {
				this.isPackageAble = true;
      },

      setDiscountAbleTrue() {
				this.isDiscountAble = true;
      },

      startNew() {
				this.newCommodity();
      },

			newCommodity() {
				this.$refs.ChangeAvatar.savePic();
      },

			setCommodityImageData(data) {
				let that = this;
				this.form.imageData = data;
				addNewCommodity(this.form.name, this.form.price, this.form.count, this.form.imageData, res => {
					setCommodityTime(res, that.form.start, that.form.end, result => {
						that.dialogVisible = false;
						that.$refs.commodities.updateCommodity();
						that.$message.success("增加商品成功");
						that.isCommodity = false;
					})
				})
			},

			setPackageImageData(data) {
				let that = this;
				this.form.imageData = data;
				addNewPackage(this.form.name, this.form.price, this.form.count, this.commIDs, this.form.imageData, res => {
					setCommodityTime(res, that.form.start, that.form.end, result => {
						that.dialogVisible = false;
						that.$refs.commodities.updatePackage();
						that.$message.success("增加套餐成功");
            that.isPackage = false;
            that.clearComms();
					})
				})
      },

			newDiscount() {
				let that = this;
				updateDiscounts(this.commIDs, this.discount.discount, this.transformDate(this.discount.start), this.transformDate(this.discount.end), res => {
					that.discountVisible = false;
					that.$message.success("发布成功");
					that.$refs.commodities.updateCommodity();
					that.$refs.commodities.updatePackage();
					that.isDiscount = false;
					that.clearComms();
        })
      },

      transformDate(date) {
				return getCurrentDate(date) + " 08:00:00";
      },

      openNewPackage() {
				let checkList = this.$refs.commodities.getCheckList();
				for (let commID of checkList) {
					this.commIDs.push(commID);
        }
				this.dialogVisible = true;
				this.isCheckList = false;
      },

			openNewDiscount() {
				let checkList = this.$refs.commodities.getCheckList();
				for (let commID of checkList) {
					this.commIDs.push(commID);
				}
				this.discountVisible = true;
				this.isCheckList = false;
      },

			beforeClose() {
				this.addVisible = false;
				this.isCommodity = false;
				this.isDiscount = false;
				this.isPackage = false;
				this.dialogVisible = false;
				this.discountVisible = false;
				this.clearComms();
      }
    }
	}
</script>

<style scoped>

</style>