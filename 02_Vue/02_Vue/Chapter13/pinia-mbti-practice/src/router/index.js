import MatchTest from '@/components/MatchTest.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/test',
      name: 'home',
    },
    {
      path: '/test',
      name: 'test',
      component: MatchTest,
    },
  ],
});

export default router;
