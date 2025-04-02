import MovieDetail from '@/components/MovieDetail.vue';
import MovieList from '@/components/MovieList.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: MovieList,
    },
    {
      path: '/movies/:id',
      name: 'movieDetail',
      component: MovieDetail,
    },
  ],
});

export default router;
