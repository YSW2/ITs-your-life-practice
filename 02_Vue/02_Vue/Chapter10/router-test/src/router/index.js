import PageHome from '@/pages/PageHome.vue';
import PageAbout from '@/pages/PageAbout.vue';
import { createRouter, createWebHistory } from 'vue-router';
import PageMembers from '@/pages/PageMembers.vue';
import PageVideos from '@/pages/PageVideos.vue';
import PageMemberInfo from '@/pages/PageMemberInfo.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: PageHome,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../pages/PageAbout.vue'),
    },
    {
      path: '/members',
      component: PageMembers,
    },
    {
      path: '/members/:id',
      component: PageMemberInfo,
    },
    {
      path: '/videos',
      component: PageVideos,
    },
  ],
});

export default router;
