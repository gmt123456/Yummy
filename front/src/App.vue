<template>
  <div id="app">
    <div style="width: 100%;height: 100%;">
      <div style="width: 1100px;margin-left: auto;margin-right: auto;min-height: 700px;">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
}
</script>

<style>
#app {
  font-family: Helvetica, sans-serif;
  text-align: center;
}
</style>
