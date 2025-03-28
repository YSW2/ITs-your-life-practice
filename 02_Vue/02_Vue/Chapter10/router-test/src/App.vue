<script>
import Header from '@/components/Header.vue';
export default {
  name: 'App',
  components: { Header },
};
</script>
<template>
  <div class="container">
    <Header />
    <router-view></router-view>
  </div>
</template>
<style>
.container {
  text-align: center;
  margin-top: 10px;
}
</style>
