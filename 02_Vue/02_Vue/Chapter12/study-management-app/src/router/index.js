import { createRouter, createWebHistory } from 'vue-router';
import Home from '../../pages/Home.vue';
import StudyDetail from '../../pages/StudyDetail.vue';
import AddStudy from '@/components/AddStudy.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/studies/:id',
      name: 'studyDetail',
      component: StudyDetail,
    },
    {
      path: '/studies/add',
      name: 'addStudy',
      component: AddStudy,
    },
  ],
});

export default router;
