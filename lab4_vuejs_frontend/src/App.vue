<template>
  <div id="app">
    <notifications class="notify" group="error" position="top right" max="6" close-on-click width="30%"/>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>
<style>
body {
  background-color: #FFF2F8;
}
.notify{
  font-family: cursive;
  font-size: 26px;
}
</style>