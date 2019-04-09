<template>
  <div id="userMain">
    <restaurant-blocks v-on:clickCard="clickCard"></restaurant-blocks>
  </div>
</template>

<script>
  import RestaurantBlocks from '../restaurant/RestaurantBlocks'

	export default {
		name: "UserMain",

    components: {RestaurantBlocks},

    methods: {
			clickCard(resID) {
				this.$router.push({ name: 'shop', params: { resID: resID }});
      }
    }
	}
</script>

<style scoped>

</style>