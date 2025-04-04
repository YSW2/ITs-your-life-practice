<template>
  <div class="d-day">{{ dDay }}</div>
</template>

<script setup>
import { computed } from 'vue';

const props = defineProps(['dueDate']);

const dDay = computed(() => {
  const today = new Date() / (1000 * 60 * 60 * 24);
  const dueDate = new Date(props.dueDate) / (1000 * 60 * 60 * 24);

  return dueDate - today > 1
    ? `D-${Math.floor(today - dueDate)}`
    : dueDate - today >= -1
    ? 'D-Day'
    : '모집마감';
});
</script>

<style scoped>
.d-day {
  background-color: green;
  color: white;
  font-size: 0.75rem;
  padding: 0.2rem;
  border-radius: 0.3rem;
}
</style>
