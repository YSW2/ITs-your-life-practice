<template>
  <h2>{{ studyDetail.title }}</h2>
  <p>{{ studyDetail.desc }}</p>
  <ul class="study-detail-list">
    <li class="study-detail-item">📆 마감일: {{ studyDetail.dueDate }}</li>
    <hr />
    <li class="study-detail-item">📅 등록일: {{ studyDetail.createdAt }}</li>
    <hr />

    <li class="study-detail-item">📌 카테고리: {{ studyDetail.category }}</li>
    <hr />

    <li class="study-detail-item">👨‍👨‍👧 최대 인원: {{ studyDetail.max }}</li>
    <hr />

    <li class="study-detail-item">👍 좋아요: {{ studyDetail.likes }}</li>
  </ul>
  <div class="study-detail-footer">
    <button @click="handleAddLike">좋아요</button>
    <DDay :due-date="studyDetail.dueDate" />
  </div>
  <button class="redirect-button" @click="router.push('/')">목록으로</button>
</template>

<script setup>
import DDay from '@/components/DDay.vue';
import { inject, onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const { getStudyDetail, fetchLike, getStudyList } = inject('actions');
const { params } = useRoute();
const router = useRouter();

const studyDetail = ref({});

const handleAddLike = async () => {
  const result = await fetchLike(studyDetail.value);
  if (result) {
    await getStudyList();
  }
};
onMounted(async () => {
  studyDetail.value = await getStudyDetail(params.id);
});
</script>

<style scoped>
.study-detail-list {
  border: 1px solid #ccc;
  border-radius: 0.625rem;
  padding: 0.3rem 0;
}
.study-detail-item {
  margin: 0.3rem;
}
.study-detail-footer {
  display: flex;
  margin-bottom: 1rem;
}
.redirect-button {
  background-color: rgb(0, 0, 0, 0);
  border: 1px solid #999;
  color: #666;
  padding: 0.3rem 0.5rem;
  border-radius: 0.3rem;
}
hr {
  border: 1px solid #ccc;
}
</style>
