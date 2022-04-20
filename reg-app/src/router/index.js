import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomePage.vue'
import storage from '../storage/storage'
import axios from 'axios'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/LoginPage.vue')
  },
  {
    path: '/signup',
    name: 'signup',
    component: () => import('../views/RegistrationView.vue')
  },
  
  { path: '/:pathMatch(.*)*', redirect: "/404" },
  { path: '/404', name: 'NotFound', component: ()=>import("../views/NotFoundPage.vue") }
  
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
  const responce =  await axios({
    method: "post",
    url: "http://localhost:8081/login/authenticate",
    data: {
      token: storage.state.auth.token,
      username:  storage.state.auth.username,
    },
  }); 
   return  (((to.path === "/signup")||(to.path === "/login")) ? true : false) || responce.data === true ;
}
export default router
