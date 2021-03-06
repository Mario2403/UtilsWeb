import Vue from "vue";
import App from "./App.vue";
import store from "./store";
import vuetify from "./plugins/vuetify";
import router from "./router";
import axios from "axios"

axios.defaults.baseURL = "http://192.168.1.68:8081"
Vue.config.productionTip = false;

if (Vue.config.productionTip){
  axios.defaults.baseURL = "http://192.168.1.68:8080"
}else{
  axios.defaults.baseURL = "http://192.168.1.68:8081"
}


new Vue({
  store,
  vuetify,
  router,
  render: h => h(App)
}).$mount("#app");
