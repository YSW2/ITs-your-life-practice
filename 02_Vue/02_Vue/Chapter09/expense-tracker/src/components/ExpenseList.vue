<template>
  <div class="expense-container">
    <h3>지출 내역</h3>
    <ul>
      <li v-if="expenseList.length === 0" class="expense-item no-item">
        지출이 없습니다
      </li>
      <li
        v-for="(expense, index) in expenseList"
        class="expense-item"
        :key="index"
      >
        {{ expense.item }}: {{ expense.amount.toLocaleString() }}원
        <button class="delete-button" @click="emit('deleteExpense', index)">
          <font-awesome-icon icon="fa-solid fa-x" style="color: red" />
        </button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

const props = defineProps({ expenseList: Array });
const emit = defineEmits(['deleteExpense']);
</script>

<style scoped>
h3 {
  color: rgb(126, 255, 231);
}
ul {
  padding-left: 0px;
}
.expense-container {
  margin-bottom: 35px;
}
.expense-item {
  display: flex;
  justify-content: space-between;
  list-style: none;
  background-color: rgb(56, 56, 56);
  padding: 10px;
  border-radius: 5px;
  margin-bottom: 8px;
}
.delete-button {
  background-color: rgb(0, 0, 0, 0);
  border: none;
  color: white;
  font-weight: bold;
  cursor: pointer;
}
.no-item {
  color: rgb(155, 155, 155);
  justify-content: center;
}
</style>
