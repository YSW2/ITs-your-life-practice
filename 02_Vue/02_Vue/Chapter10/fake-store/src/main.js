import 'bootstrap/dist/css/bootstrap.min.css';
import './assets/main.css';

import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';

const app = createApp(App);

app.component('font-awesome-icon', FontAwesomeIcon);
library.add(fas, far);

app.use(router);
app.mount('#app');
