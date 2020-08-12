import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import CalendarioView from "../views/CalendarioView.vue";
import EstadisticasView from "../views/EstadisticasView.vue";



Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path:"/Calendario",
    name: "Calendario",
    component: CalendarioView
  },
  {
    path: "/Estadisticas",
    name:"Estadisticas",
    component:EstadisticasView
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
