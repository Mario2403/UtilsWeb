<template>
<div >
   <title>UtilsWeb</title>
   <v-container>
    <v-layout justify-center>
                <v-flex class="">

    <v-app>
      <v-container >
        <v-row class = "d-flex" no-gutters>
          <v-col>
        <BarraSuperior v-if="this.$route.name != 'Login'"></BarraSuperior>
          </v-col>
        </v-row>
        <v-row >
          <v-col class="flex-grow-0 flex-shrink-0" :width="325">
            <LeftMenu v-show="true"></LeftMenu>
          </v-col>
          <v-col class="flex-grow-1 flex-shrink-0">
          <router-view @home="isHome = true" />
          </v-col>
        </v-row>
      </v-container>
      <Footer ></Footer>
    </v-app>
                </v-flex>
    </v-layout>
   </v-container>
  
  </div>
</template>

<script>
import Footer from "@/components/Footer.vue";
import BarraSuperior from "@/components/BarraSuperior.vue";
import LeftMenu from "@/components/LeftMenu.vue";

export default {
  components: {
    Footer,
    BarraSuperior,
    LeftMenu
  },
  data () {
    return {
      isHome:false
    }
  },
  methods: {
    hola() {
      console.log("hola");
    }
  }
};
</script>

<style scoped>
.container{
  max-width: 100%;
  margin-left: 0px;
}
</style>
