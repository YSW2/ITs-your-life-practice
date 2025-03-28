<template>
  <div>
    <nav class="navbar-container">
      <ul class="navbar-nav">
        <li :class="isCurrent('home')">
          <router-link class="nav-link" :to="{ name: 'home' }">
            홈
          </router-link>
        </li>

        <li :class="isCurrent('products')">
          <router-link class="nav-link" :to="{ name: 'products' }">
            상품 목록</router-link
          >
        </li>
        <li :class="isCurrent('cart')">
          <router-link class="nav-link" :to="{ name: 'cart' }">
            장바구니</router-link
          >
        </li>
      </ul>
    </nav>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';

const currentRoute = useRoute();

const isCurrent = (route) => {
  return route === currentRoute.name ? 'selected' : '';
};
</script>

<style scoped>
.selected {
  color: rgb(0, 119, 255);
}

.navbar-container {
  box-shadow: 1px 1px 5px rgb(194, 194, 194);
}
.navbar-nav {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  font-size: 20px;
  padding: 10px 0;
}
.navbar-small {
  display: none;
}

@media screen and (max-width: 768px) {
  .navbar-small {
    display: inline;
  }
  .navbar-wide {
    display: none;
  }
}
</style>
