<template>
<div >
   <title>UtilsWeb</title>
   <v-container>
    <v-layout justify-center>
                <v-flex class="text-xs-center">

    <v-app>
      <v-container >
        <v-row class = "d-flex" width="400">
          <v-col>
        <BarraSuperior />
          </v-col>
        </v-row>
        <v-row >
          <v-col class="flex-grow-0 flex-shrink-0">
            <LeftMenu v-show="false"/>
          </v-col>
          <v-col class="flex-grow-1 flex-shrink-0">
          <router-view @home="isHome = true" />
          </v-col>
        </v-row>
      </v-container>
      <Footer />
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

<style >
#div {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
