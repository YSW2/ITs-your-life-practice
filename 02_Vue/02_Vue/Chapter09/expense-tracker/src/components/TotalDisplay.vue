<template>
  <div class="total-amount-container">
    총 지출: ₩{{ formatNumber(totalAmount) }}
  </div>
</template>

<script setup>
const props = defineProps({
  totalAmount: {
    type: Number,
    required: false,
  },
  formatNumber: {
    type: Function,
    required: true,
  },
});
</script>

<style scoped>
.total-amount-container {
  background-color: rgb(56, 56, 56);
  color: rgb(126, 255, 231);
  padding: 10px;
  border-radius: 5px;
  font-size: 16px;
  text-align: center;
}
</style>
