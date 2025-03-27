<template>
  <div id="app" class="app-container">
    <div><h2>Simple Budget Diary</h2></div>
    <ExpenseForm @add-item="addItem" />
    <ExpenseList :expense-list="expenseList" @delete-expense="deleteExpense" />
    <div class="category-total-container">
      <h3>카테고리 별 지출 합계</h3>
      <div class="category-total-item">
        쇼핑: {{ formatNumber(totalShopping) }}원
      </div>
      <div class="category-total-item">
        식비: {{ formatNumber(totalFood) }}원
      </div>
      <div class="category-total-item">
        교통: {{ formatNumber(totalTransport) }}원
      </div>
    </div>
    <TotalDisplay :total-amount="totalAmount" :formatNumber="formatNumber" />
  </div>
</template>

<script setup>
import { computed, ref } from 'vue';
import ExpenseForm from './components/ExpenseForm.vue';
import TotalDisplay from './components/TotalDisplay.vue';
import ExpenseList from './components/ExpenseList.vue';

const expenseList = ref([]);

const addItem = (item, amount, category) => {
  if (item && amount && category)
    expenseList.value.push({ item: item, amount: amount, category: category });
};

const formatNumber = (number) => {
  return number.toLocaleString();
};

const totalAmount = computed(() => {
  return expenseList.value.reduce((acc, cur) => acc + cur['amount'], 0);
});

const totalShopping = computed(() => {
  return expenseList.value.reduce(
    (acc, cur) => acc + (cur['category'] === 'shopping' ? cur['amount'] : 0),
    0
  );
});
const totalTransport = computed(() => {
  return expenseList.value.reduce(
    (acc, cur) => acc + (cur['category'] === 'transport' ? cur['amount'] : 0),
    0
  );
});
const totalFood = computed(() => {
  return expenseList.value.reduce(
    (acc, cur) => acc + (cur['category'] === 'food' ? cur['amount'] : 0),
    0
  );
});

const deleteExpense = (index) => {
  expenseList.value.splice(index, 1);
};
</script>

<style scoped>
h2 {
  color: rgb(0, 255, 195);
}
h3 {
  color: rgb(126, 255, 231);
}
.app-container {
  background-color: #1e1e1e;
  color: #f0f0f0;
  padding: 30px;
  font-family: 'Segoe UI', sans-serif;
  max-width: 600px;
  margin: 50px auto;
  border-radius: 16px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.3);
}
.category-total-container {
  margin-bottom: 35px;
}
.category-total-item {
  background-color: rgb(56, 56, 56);
  padding: 10px;
  border-radius: 5px;
  margin-bottom: 8px;
}
</style>
