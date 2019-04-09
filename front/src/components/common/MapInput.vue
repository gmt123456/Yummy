<template>
  <div id="mapInput" style="display: inline-block">
    <el-input
        placeholder="请输入内容"
        prefix-icon="el-icon-search"
        v-model="locate" id="search">
    </el-input>
  </div>
</template>

<script>
  import MapLoader from '../../api/amap'

	export default {
		name: "MapInput",

		data () {
			return {
				locate: "",
        poiID: "",
			}
		},

    methods: {
			getInput() {
				return this.locate;
      }
    },

		mounted () {
			let that = this;
			MapLoader().then(AMap => {
				AMap.plugin('AMap.Autocomplete', function(){
					let autoOptions = {
						input: 'search'
					};
					let autoComplete= new AMap.Autocomplete(autoOptions);
					autoComplete.on('select', function(e){
						that.locate = e.poi.name;
						that.poiID = e.poi.id;
					})
				})
			}, e => {
				console.log('地图加载失败' ,e)
			})
		}
	}
</script>

<style scoped>

</style>