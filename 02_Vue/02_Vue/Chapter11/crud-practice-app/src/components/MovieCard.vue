<template>
  <div class="card-container">
    <div
      class="card-img-container"
      :style="{ 'background-image': `url(${movie.poster})` }"
    ></div>
    <div class="card-content-container">
      <h3>{{ movie.title }} ({{ movie.year }})</h3>
      <p>감독 - {{ movie.director }}</p>
      <div class="card-event-container">
        <button class="edit-button" @click="emit('edit-requested', movie)">
          수정
        </button>
        <button class="edit-button" @click="emit('delete-requested', movie)">
          삭제
        </button>
      </div>
      <router-link :to="`/movies/${movie.id}`">자세히 보기</router-link>
    </div>
  </div>
</template>

<script setup>
const { movie } = defineProps(['movie']);
const emit = defineEmits(['edit-requested', 'delete-requested']);
</script>

<style scoped>
.card-container {
  background-color: #282828;
  padding: 0.8rem;
  border-radius: 0.3rem;
  text-align: center;
}
.card-img-container {
  height: 300px;
  background-size: cover;
  background-position: center;
  padding: 0.625rem;
}
.card-event-container {
  display: flex;
  justify-content: center;
  gap: 10px;
}
.edit-button {
  background-color: rgb(255, 217, 28);
  border-radius: 0.3rem;
  border: none;
  padding: 0.4rem 0.6rem;
}
.edit-button:active {
  background-color: rgb(183, 159, 39);
}
</style>
