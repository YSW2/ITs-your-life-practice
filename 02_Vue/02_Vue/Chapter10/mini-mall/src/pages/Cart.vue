<template>
  <div class="cart-list-container">
    <h2>장바구니</h2>
    <div>
      <div class="cart-list-item" v-for="item in cartState.cartList">
        <div class="item-img-container">
          <img :src="item.image" class="item-img" />
        </div>
        <div class="item-info">
          <h3>{{ item.name }}</h3>
          {{ item.price.toLocaleString() }}원
        </div>
      </div>
    </div>
    <div class="total-price-container">
      <h2>총{{ totalPrice.toLocaleString() }}원</h2>
    </div>
  </div>
</template>

<script setup>
import { computed, inject } from 'vue';

const { cartState } = inject('cartState');
const totalPrice = computed(() => {
  return cartState.cartList.reduce((acc, cur) => acc + cur['price'], 0);
});
</script>

<style scoped>
.cart-list-container {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  text-align: center;
  margin: 0 15%;
  padding: 30px 0;
}
.cart-list-item {
  flex: 1;
  display: flex;
  flex-direction: row;
  border-bottom: 1px solid #ededed;
  padding: 15px 0;
  text-align: left;
  margin: 30px 0;
}
.item-img {
  width: 135px;
  height: 135px;
  object-fit: cover;
  border-radius: 10px;
  margin-right: 20px;
}
.item-info {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}
.total-price-container {
  margin: 20px 0;
}
</style>
