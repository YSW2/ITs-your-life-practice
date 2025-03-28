<template>
  <div class="products-container">
    <div class="products-title"><h2>상품 목록</h2></div>
    <div class="row">
      <div class="col col-auto mb-3" v-for="product in products">
        <div class="card">
          <img :src="product.image" class="card-img-top" />
          <div class="card-body">
            {{ product.name }}<br />{{ product.price.toLocaleString() }}원<br />
            <router-link :to="`products/${product.id}`"> 상세보기 </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import products from '@/data/products.json';
</script>

<style scoped>
.products-title {
  text-align: center;
  margin: 50px 10px;
}
.card-img-top {
  border: 1px solid rgb(194, 194, 194);
  max-height: 200px;
  object-fit: cover; /* 이미지 비율을 유지하면서 영역을 채움 */
}

.card-body {
  text-align: center;
}
</style>
