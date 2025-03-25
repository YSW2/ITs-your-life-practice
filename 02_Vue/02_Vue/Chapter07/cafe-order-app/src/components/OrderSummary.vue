<template>
  <div class="card">
    <div class="card-header pt-3">
      <h3>주문 내역서</h3>
      <p>주문 시간: {{ currentTime }}</p>
    </div>
    <div class="card-body">
      <p>음료: {{ drink.name }}</p>
      <p>사이즈: {{ optionData.size }}</p>
      <p>추가 샷: {{ optionData.extraShot ? '있음' : '없음' }}</p>
      <p>얼음 양: {{ optionData.ice }}</p>
    </div>
    <div class="card-footer">
      <p>결제 금액: {{ drink.price.toLocaleString() }}원</p>
      <button class="btn" @click="$emit('place-order', {})">
        주문 확정하기
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderSummary',
  props: ['drink', 'optionData'],
  computed: {
    currentTime() {
      return new Date().toLocaleString();
    },
  },
};
</script>
<style scoped>
.card {
  background-color: #fffaf0;
}
.card-header {
  border-bottom: 1px dashed #d2b48c;
}
.card-body {
  border-bottom: 1px dashed #d2b48c;
}
.card-footer {
  border-top: 1px dashed #d2b48c;
}
.btn {
  background: #d2b48c;
  border: none;
  color: white;
}
</style>
