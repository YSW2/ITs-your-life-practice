<template>
  <div v-if="visible" class="modal-wrap">
    <div class="modal-container">
      <h2 class="modal-title">🎥</h2>
      <form class="modal-content" @submit.prevent="handleAddMovie">
        <input
          v-model="inputData.title"
          class="input-text"
          type="text"
          placeholder="제목"
        />
        <input
          v-model.number="inputData.year"
          class="input-text"
          type="text"
          placeholder="연도"
        />
        <input
          v-model="inputData.director"
          class="input-text"
          type="text"
          placeholder="감독"
        />
        <textarea
          v-model="inputData.description"
          class="input-text"
          type="text"
          placeholder="줄거리"
        ></textarea>
        <input
          v-model="inputData.poster"
          class="input-text"
          type="text"
          placeholder="포스터 이미지 URL"
        />
        <div class="modal-footer">
          <button class="modal-button add">등록</button>
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
import { inject, ref } from 'vue';
import '@/assets/modal.css';

const { visible } = defineProps(['visible']);
const emit = defineEmits(['movie-added', 'close']);

const url = inject('url');

const inputData = ref({
  title: '',
  year: '',
  director: '',
  description: '',
  poster: '',
});

const handleAddMovie = async () => {
  const response = await fetchMovieData();
  inputData.value = {
    title: '',
    year: '',
    director: '',
    description: '',
    poster: '',
  };
  emit('movie-added');
};

const fetchMovieData = async () => {
  try {
    console.log(inputData.value);
    const response = await axios.post(url, inputData.value);
    return response;
  } catch (error) {
    console.error(`post 에러: ${error}`);
  }
};
</script>

<style scoped></style>
