<template>
  <Header />
  <div class="layout">
    <router-view name="left" />
    <router-view class="router-view" />
  </div>
</template>

<script setup>
import { provide, reactive } from 'vue';
import Header from './components/Header.vue';

const cartState = reactive({ cartList: [] });

const addToCart = (product) => {
  cartState.cartList.push(product);
};

provide('cartState', { cartState, addToCart });
</script>

<style scoped>
.layout {
  display: flex;
}
</style>
