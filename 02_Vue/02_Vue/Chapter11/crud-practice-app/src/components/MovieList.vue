<template>
  <button @click="addModalOpen" class="movie-add-button">
    🎥 영화 추가하기
  </button>
  <div class="grid">
    <div v-for="movie in movieList">
      <MovieCard
        :movie="movie"
        @edit-requested="handleEditMovie(movie)"
        @delete-requested="handleDelete(movie.id)"
      />
    </div>
  </div>

  <AddMovieModal
    :visible="addVisible"
    @close="addModalClose"
    @movie-added="addedMovie"
  />
  <EditMovieModal
    v-if="editVisible"
    :movie="seledtedMovie"
    @close="editModalClose"
    @update-done="editMovie"
  />
</template>

<script setup>
import { inject, ref } from 'vue';
import AddMovieModal from './AddMovieModal.vue';
import MovieCard from './MovieCard.vue';
import EditMovieModal from './EditMovieModal.vue';
import axios from 'axios';

const getMovieList = inject('getMovieList');
const movieList = inject('movieList');
const url = inject('url');
const addVisible = ref(false);
const editVisible = ref(false);
const seledtedMovie = ref({
  title: '',
  year: '',
  director: '',
  description: '',
  poster: '',
});

const handleDelete = async (id) => {
  if (confirm('정말 삭제하시겠습니까?')) {
    await fetchDelete(id);
    alert('삭제 완료!');
    await getMovieList();
  }
};

const fetchDelete = async (id) => {
  try {
    const response = await axios.delete(`${url}/${id}`);
    return response;
  } catch (e) {
    console.error(e);
  }
};

const handleEditMovie = (movie) => {
  seledtedMovie.value = movie;
  editModalOpen();
};

const editMovie = async () => {
  await getMovieList();
  editModalClose();
};

const addedMovie = async () => {
  await getMovieList();
  addModalClose();
};

const editModalClose = () => {
  editVisible.value = false;
};

const editModalOpen = () => {
  editVisible.value = true;
};

const addModalClose = () => {
  addVisible.value = false;
};

const addModalOpen = () => {
  addVisible.value = true;
};
</script>

<style scoped>
.movie-add-button {
  background-color: rgb(255, 217, 28);
  padding: 0.5rem 0.8rem;
  border: none;
  border-radius: 0.3rem;
}
.movie-add-button:active {
  background-color: rgb(183, 159, 39);
}
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
  gap: 1rem;
}
</style>
