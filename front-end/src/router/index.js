import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import CalendarioView from "../views/CalendarioView.vue";
import EstadisticasView from "../views/EstadisticasView.vue";
import UtilidadesView from "../views/UtilidadesView.vue";
import TimeTrackerView from "../views/TimeTrackerView.vue";
import LoginView from "../views/LoginView.vue";
import TestView from "../views/TestView.vue";
import ProyectosView from "../views/ProyectosView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/calendario",
    name: "Calendario",
    component: CalendarioView
  },
  {
    path: "/estadisticas",
    name:"Estadisticas",
    component: EstadisticasView
  },
  {
    path: "/login",
    name:"Login",
    component: LoginView
  },
  {
    path: "/controlHoras",
    name:"Control de Horas",
    component: TimeTrackerView
  },
  {
    path: "/utilidades",
    name:"Utilidades",
    component: UtilidadesView
  },
  {
    path: "/test",
    name:"Test",
    component: TestView
  },
  {
    path: "/proyectos",
    name:"Proyectos",
    component: ProyectosView
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;

router.beforeEach((to, fromn, next) =>{
const publicPages = ['/login'];
const authRequired = !publicPages.includes(to.path);
const loggedIn = localStorage.getItem('user');

if( authRequired && !loggedIn){
  return next('/login');
}
next();
})
