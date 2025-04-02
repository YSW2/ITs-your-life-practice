<template>
  <div class="modal-wrap">
    <div class="modal-container">
      <h2 class="modal-title" style="color: black">수정</h2>
      <form class="modal-content" @submit.prevent="handleEditMovie">
        <input
          v-model="editedData.title"
          class="input-text"
          type="text"
          placeholder="제목"
        />
        <input
          v-model.number="editedData.year"
          class="input-text"
          type="text"
          placeholder="연도"
        />
        <input
          v-model="editedData.director"
          class="input-text"
          type="text"
          placeholder="감독"
        />
        <textarea
          v-model="editedData.description"
          class="input-text"
          type="text"
          placeholder="줄거리"
        ></textarea>
        <input
          v-model="editedData.poster"
          class="input-text"
          type="text"
          placeholder="포스터 이미지 URL"
        />
        <div class="modal-footer">
          <button class="modal-button add">저장</button>
          <button @click="$emit('close')" class="modal-button cancel">
            닫기
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios';
import { inject, onMounted, ref } from 'vue';
import '@/assets/modal.css';

const { movie } = defineProps(['movie']);
const emit = defineEmits(['update-done', 'close']);
const url = inject('url');
const editedData = ref({
  id: '',
  title: '',
  year: '',
  director: '',
  description: '',
  poster: '',
});

onMounted(() => {
  editedData.value = { ...movie };
});

const handleEditMovie = async () => {
  const response = await fetchMovieEdit();
  editedData.value = {
    id: '',
    title: '',
    year: '',
    director: '',
    description: '',
    poster: '',
  };
  emit('update-done');
};

const fetchMovieEdit = async () => {
  try {
    const response = await axios.put(
      `${url}/${editedData.value.id}`,
      editedData.value
    );
    return response;
  } catch (error) {
    console.error(`put 에러: ${error}`);
  }
};
</script>

<style scoped></style>
