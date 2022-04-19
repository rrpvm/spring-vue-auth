import { createApp } from 'vue'
import router from './router'
import App from './App.vue'
import storage  from './storage/storage'


createApp(App).use(router).use(storage).mount('#app')

