import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomePage.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/LoginPage.vue')
  },
  {
    path: '/signup',
    name: 'signup',
    component: () => import(/* webpackChunkName: "about" */ '../views/RegistrationView.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

router.beforeEach(async (to, from) => {
  from;//skip error
  const canAccess = await canUserAccess(to)
  if (!canAccess) return '/login'
});

const canUserAccess = async (to)=>{
  to;//skip error
                             

}
export default router
