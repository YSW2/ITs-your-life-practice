<template>
  <div class="movie-detail-container">
    <h2>{{ currentMovie.title }} ({{ currentMovie.year }})</h2>
    <p>감독 - {{ currentMovie.director }}</p>
    <p>줄거리 - {{ currentMovie.description }}</p>
    <div
      class="img-container"
      :style="{ 'background-image': `url(${currentMovie.poster})` }"
    ></div>
  </div>
</template>

<script setup>
import axios from 'axios';
import { inject, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

const url = inject('url');
const currentRoute = useRoute();
const currentMovie = ref({});

onMounted(async () => {
  const id = currentRoute.params.id;
  const response = await axios.get(`${url}?id=${id}`);
  currentMovie.value = response.data[0];
});
</script>

<style scoped>
.movie-detail-container {
  width: 75%;
  background-color: #282828;
  border-radius: 0.625rem;
  padding: 1rem;
}
.img-container {
  height: 300px;
  background-size: cover;
  background-position: center;
  padding: 0.625rem;
}
</style>
