<template>
  <div class="card-container">
    <div class="card-title">
      {{ study.title }}
    </div>
    <div class="card-content">
      <p>📌 카테고리: {{ study.category }}</p>
      <p>📅 등록일: {{ study.createdAt }}</p>
      <p>📆 마감일: {{ study.dueDate }}</p>
      <p>👍 좋아요: {{ study.likes }}</p>
    </div>
    <div class="card-footer">
      <DDay :due-date="study.dueDate" />
    </div>
  </div>
</template>

<script setup>
import DDay from './DDay.vue';

const { study } = defineProps(['study']);
</script>

<style scoped>
.card-container {
  padding: 0.8rem;
  border: 1px solid #ccc;
  border-radius: 0.3rem;
}
.card-title {
  font-weight: bold;
  font-size: 1.25rem;
  margin-bottom: 1.25rem;
}
.card-content {
  color: #333;
  font-size: 0.9rem;
  line-height: 0.625rem;
  margin-bottom: 1.25rem;
}
.card-footer {
  display: flex;
}
</style>
