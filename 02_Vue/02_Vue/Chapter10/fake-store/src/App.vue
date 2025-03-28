<template>
  <div>
    <Header />
    <Navbar />
    <router-view />
    <Footer class="footer-component" />
  </div>
</template>

<script setup>
import Footer from './components/Footer.vue';
import Header from './components/Header.vue';
import Navbar from './components/Navbar.vue';
</script>

<style scoped>
.footer-component {
  position: absolute;
  bottom: 0;
}
</style>
