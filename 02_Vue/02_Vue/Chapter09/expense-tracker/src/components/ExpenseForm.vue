<template>
  <div class="form-container">
    <input
      class="form-text-input"
      type="text"
      v-model="item"
      placeholder="항목명 입력"
    /><input class="form-text-input" type="number" v-model.number="amount" />
    <select class="form-text-input" v-model="category">
      <option value="">카테고리 선택</option>
      <option value="food">식비</option>
      <option value="transport">교통</option>
      <option value="shopping">쇼핑</option>
    </select>
    <button class="form-add-button" @click="handleAdd">추가</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const item = ref('');
const amount = ref(0);
const category = ref('');

const emit = defineEmits(['add-item']);

const handleAdd = () => {
  emit('add-item', item.value, amount.value, category.value);
  item.value = '';
  amount.value = 0;
  category.value = '';
};
</script>

<style scoped>
.form-container {
  display: flex;
  margin-bottom: 35px;
}

.form-text-input {
  flex: auto;
  background-color: rgb(56, 56, 56);
  border: 1px solid rgb(83, 83, 83);
  color: white;
  border-radius: 5px;
  padding: 8px;
  margin-right: 8px;
}

.form-add-button {
  flex: auto;
  border-radius: 5px;
  background-color: rgb(0, 255, 195);
  border: none;
  padding: 8px;
  font-weight: bold;
}

.form-add-button:active {
  background-color: rgb(0, 165, 127);
}

@media screen and (max-width: 575px) {
  .form-container {
    flex-wrap: wrap; /* nowrap에서 wrap으로 변경 */
  }

  .form-text-input {
    flex: 1 0 100%; /* 전체 너비 사용 */
    margin-right: 0; /* 오른쪽 마진 제거 */
    margin-bottom: 8px; /* 아래쪽 마진 추가 */
  }
}
</style>
