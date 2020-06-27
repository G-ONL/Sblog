import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Signup from "../views/Signup.vue";
import CreatePost from "../views/CreatePost.vue";
import EditPost from "../views/EditPost.vue";
import store from "../store";
Vue.use(VueRouter);

const rejectNotAuthUser = (to, from, next) => {
  if(store.state.isLoggedIn == false){
    next("/Login");
  }else{
    next();
  }
}
const rejectAuthUser = (to, from, next) => {
  if(store.state.isLoggedIn){
    next("/");
  }else{
    next();
  }
}
const routes = [
  {
    path: "/",
    name: "Home",
    beforeEnter: rejectNotAuthUser,
    component: Home
  },
  {
    path: "/post/create",
    name: "CreatePost",
    beforeEnter: rejectNotAuthUser,
    component: CreatePost
  },
  {
    path: "/post/edit",
    name: "EditPost",
    beforeEnter: rejectNotAuthUser,
    component: EditPost
  },
  {
    path: "/login",
    name: "Login",
    beforeEnter: rejectAuthUser,
    component: Login
  },
  {
    path: "/signup",
    name: "Signup",
    beforeEnter: rejectAuthUser,
    component: Signup
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
