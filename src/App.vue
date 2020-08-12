<template>
  <div>
    <title>UtilsWeb</title>
    <v-app>
      <v-container fluid>
        <BarraSuperior title="Calendario" />
        <v-row no-gutters>
          <v-col class="flex-grow-0 flex-shrink-0">
          <LeftMenu/>
          </v-col>
          <v-col class="flex-grow-1 flex-shrink-0">
          <router-view />
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
  }
};
</script>

<style lang="scss">
</style>
