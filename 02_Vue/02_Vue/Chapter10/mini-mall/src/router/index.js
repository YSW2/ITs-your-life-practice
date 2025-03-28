import { createRouter, createWebHistory } from 'vue-router';
import Products from '@/pages/Products.vue';
import Home from '@/pages/Home.vue';
import Cart from '@/pages/Cart.vue';
import ProductDetail from '@/components/ProductDetail.vue';
import CategoryFilter from '@/pages/CategoryFilter.vue';
import ProductDescription from '@/pages/ProductDescription.vue';
import ProductReview from '@/pages/ProductReview.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/products',
      name: 'products',
      components: { default: Products, left: CategoryFilter },
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart,
    },
    {
      path: '/products/:id',
      name: 'productDetail',
      components: { default: ProductDetail, description: ProductDescription },
      children: [
        {
          path: '/review',
          name: 'productReview',
          component: ProductReview,
        },
      ],
    },
  ],
});

export default router;
