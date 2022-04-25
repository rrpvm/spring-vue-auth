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
    path: '/signin',
    name: 'login',
    component: () => import('../views/LoginPage.vue')
  },
  {
    path: '/signup',
    name: 'register',
    component: () => import('../views/RegistrationView.vue')
  },
  {
    path: '/profile/:id',
    name: 'profile',
    component: () => import('../views/ProfilePage.vue')
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
  const canAccess = await canUserAccess(to);
  if (!canAccess){
    console.log("to "+ to.path)
    console.log("from "+ from.path)
    return '/signin';
  } 
});

const canUserAccess = async (to)=>{
  const accessPaths  = ["/signup","/signin","/"];
  for( let _path in accessPaths){//index 
    if(to.path == accessPaths[_path]){
      return true;//обход авторизации - свободные пути
    }
  }
  return isSessionValid();//все остальное только с авторизацией
}


const isSessionValid = async () =>{
  if(storage.state.auth.token === '' || storage.state.auth.username === '')return false;
  const responce =  await axios({
    method: "post",
    url: "http://localhost:8081/signin/authenticate",
    data: {
      token: storage.state.auth.token,
      username:  storage.state.auth.username,
    },
  });
  return  responce.data != "-1" && responce.status === 200; 
}
export default router
export { isSessionValid };
