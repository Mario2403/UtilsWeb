<template>
  <v-app>
    <v-main>
      <BarraSuperior/>
    </v-main>
  </v-app>
</template>

<script>
import BarraSuperior from "./components/BarraSuperior.vue";

export default {
  name: "App",
  components: {
    BarraSuperior
  },

  data: () => ({
    //
  })
};
</script>
