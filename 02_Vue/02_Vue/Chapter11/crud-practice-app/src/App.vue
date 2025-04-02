<template>
  <h1>🎥 지브리 영화 리스트</h1>
  <RouterView />
</template>

<script setup>
import axios from 'axios';
import { onMounted, provide, ref } from 'vue';

const url = 'http://localhost:3000/movies';
const movieList = ref([]);

const getMovieList = async () => {
  const response = await axios.get(url);
  movieList.value = response.data;
};

onMounted(getMovieList);

provide('movieList', movieList);
provide('getMovieList', getMovieList);
provide('url', url);
</script>

<style scoped></style>
