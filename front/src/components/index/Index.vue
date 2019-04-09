<template>
  <div id="indexNavi">
    <common-navi>
      <el-button type="text" @click="showDialog">登录 / 注册</el-button>
    </common-navi>
    <login v-bind:visible="getLoginVisible"
           v-on:close="closeDialog"
           v-on:login="showLoginDialog"
           v-on:user="showUserDialog"
           v-on:restaurant="showRestaurantDialog"></login>
    <sign-up-user v-bind:visible="getUserVisible"
                  v-on:close="closeDialog"
                  v-on:login="showLoginDialog"></sign-up-user>
    <sign-up-restaurant v-bind:visible="getRestaurantVisible"
                        v-on:close="closeDialog"
                        v-on:login="showLoginDialog"></sign-up-restaurant>
    <restaurant-blocks v-on:clickCard="clickCard"></restaurant-blocks>
  </div>
</template>

<script>
	import commonNavi from '../common/CommonNavi'
  import login from './Login'
	import signUpUser from './SignUpUser'
  import signUpRestaurant from './SignUpRestaurant'
  import restaurantBlocks from '../restaurant/RestaurantBlocks'

	export default {
		name: "IndexNavi",

		components: {
			commonNavi, login, signUpUser, signUpRestaurant, restaurantBlocks
		},

		data: function () {
			return {
				dialogState: "false", // login, user, restaurant, false
			}
		},

    computed: {
	    getLoginVisible() {
		    return this.dialogState === "login";
	    },

	    getRestaurantVisible() {
		    return this.dialogState === "restaurant";
	    },

	    getUserVisible() {
		    return this.dialogState === "user";
	    },
    },

    methods: {
			clickCard() {
				this.showDialog();
      },

			closeDialog() {
				this.dialogState = "false";
      },

	    showDialog() {
		    this.showLoginDialog();
      },

      showLoginDialog() {
	      this.dialogState = "login";
      },

	    showUserDialog() {
		    this.dialogState = "user";
	    },

	    showRestaurantDialog() {
		    this.dialogState = "restaurant";
	    },
    }
	}
</script>

<style scoped>

</style>