<template>
  <div class="card">
    <div class="card-header">
      <h3>주문 내역</h3>
    </div>
    <div v-for="order in orderHistory" :key="order.time" class="card-body">
      <p>
        <b>{{ order.time }}</b>
      </p>
      <p>음료: {{ order.name }}</p>
      <p>사이즈: {{ order.size }}</p>
      <p>추가샷: {{ order.extraShot }}</p>
      <p>얼음 양: {{ order.ice }}</p>
      <p>금액: {{ order.price.toLocaleString() }}원</p>
      <hr class="mb-0" />
    </div>
    <div class="card-body">
      <p v-if="orderHistory.length === 0">주문 내역이 없습니다.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderHistory',
  props: ['orderHistory'],
};
</script>
