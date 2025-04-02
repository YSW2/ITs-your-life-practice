<template>
  <div class="product-detail-container">
    <div class="detail-name">
      <h2>{{ name }}</h2>
    </div>
    <div><img :src="image" class="detail-image" /></div>
    <div class="detail-price">
      <h2>{{ price.toLocaleString() }}원</h2>
    </div>
    <div>
      <button
        class="btn btn-primary"
        @click="handleAddtoCart({ name, price, image })"
      >
        장바구니 담기
      </button>
    </div>
    <div class="route-btn-container">
      <router-link
        class="route-btn"
        :to="`/products/${productId}`"
        exact-active-class="active-tab"
        name="productDescription"
        >상세정보</router-link
      ><router-link
        class="route-btn"
        :to="`/products/${productId}/review`"
        exact-active-class="active-tab"
        name="ProductReview"
        >리뷰</router-link
      >
    </div>
    <router-view></router-view>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router';
import products from '@/data/products.json';
import { inject } from 'vue';

const currentRoute = useRoute();
const router = useRouter();
const productId = currentRoute.params.id;

const [{ name, price, image }] = products.filter((item) => {
  return item.id === Number(productId);
});
const { addToCart } = inject('cartState');

const handleAddtoCart = (product) => {
  addToCart(product);
  router.push({ name: 'cart' });
};
</script>

<style scoped>
.product-detail-container {
  text-align: center;
  margin: auto;
}
.detail-image {
  max-width: 400px;
}
.detail-name {
  margin: 30px 0;
}
.route-btn-container {
  margin: 20px 0;
}
.route-btn {
  text-decoration: none;
  padding: 10px;
  border-radius: 5px;
}
.active-tab {
  text-decoration: none;
  padding: 10px;
  border-radius: 5px;
  background-color: rgb(73, 137, 255);
  color: white;
}
</style>
