<template>
  <div>
    <title>UtilsWeb</title>
    <v-app>
      <v-container fluid>
        <v-row >
          <v-col>
        <BarraSuperior title="Calendario" />
          </v-col>
        </v-row>
        <v-row >
          <v-col class="flex-grow-0 flex-shrink-0">
            <LeftMenu v-show="!isHome"/>
          </v-col>
          <v-col class="flex-grow-1 flex-shrink-0">
          <router-view @home="isHome = true" />
          </v-col>
        </v-row>
      </v-container>
      <Footer />
    </v-app>
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

<style lang="scss">
</style>
