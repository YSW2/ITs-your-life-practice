<template>
  <h2>📚 스터디 목록</h2>
  <button class="study-add-button" @click="router.push('/studies/add')">
    + 스터디 등록
  </button>
  <div class="util-container">
    <label
      ><input type="checkbox" v-model="filterDueDate" /> 모집 중만 보기</label
    >
    <select name="sorted" v-model="sortedProp">
      <option value="dueDate">마감일 임박순</option>
      <option value="createdAt">최신 등록일순</option>
      <option value="likes">좋아요순</option>
    </select>
  </div>
  <div class="grid">
    <router-link v-for="study in sortedList" :to="`/studies/${study.id}`">
      <StudyCard :study="study" />
    </router-link>
  </div>
</template>

<script setup>
import { computed, inject, ref } from 'vue';
import StudyCard from './StudyCard.vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const studyList = inject('studyList');
const filterDueDate = ref(false);
const sortedProp = ref('dueDate');

const sortedList = computed(() => {
  const copiedList = [...studyList.value];

  copiedList.sort((a, b) => {
    switch (sortedProp.value) {
      case 'dueDate':
        return new Date(a.dueDate) - new Date(b.dueDate);

      case 'createdAt':
        return new Date(b.createdAt) - new Date(a.createdAt);

      case 'likes':
        return b.likes - a.likes;
    }
  });
  return copiedList.filter((study) => {
    return new Date(study.dueDate) > new Date() || !filterDueDate.value;
  });
});
</script>

<style scoped>
.grid {
  display: grid;
  grid-template-columns: repeat(2, minmax(17.5rem, 1fr));
  gap: 1rem;
}
.util-container {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1rem;
}
.study-add-button {
  background-color: rgb(51, 105, 255);
  color: white;
  border: none;
  padding: 0.625rem;
  border-radius: 0.3rem;
  margin-right: 0.625rem;
  margin-bottom: 1rem;
}
</style>
