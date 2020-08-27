<template>
  <div :class="$vuetify.theme.dark ? 'back-dark' : 'back-light'">
    <title>UtilsWeb</title>
    <v-container>
      <v-layout justify-center>
        <v-flex class>
          <v-app>
            <v-app-bar app elevation="0">
              <router-link :to="{name: 'Home'}">
                <v-btn icon large>
                  <v-icon :color="darkMode ? '#FFFFFF' : '#000000' ">mdi-home</v-icon>
                </v-btn>
              </router-link>
              <v-spacer />
              <v-toolbar-title class="title">
                <h2>{{ this.$route.name }}</h2>
              </v-toolbar-title>

              <v-spacer />
              <v-btn icon @click="fun()">
                <v-icon :color="darkMode ? '#FFFFFF' : '#000000' ">mdi-brightness-4</v-icon>
              </v-btn>
            </v-app-bar>
            <LeftMenu v-show="true"></LeftMenu>
          <!-- Contenido de la vista -->
            <v-content>
              <router-view @home="isHome = true" />
            </v-content>

            <Footer></Footer>
          </v-app>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import Footer from "@/components/Footer.vue";
import LeftMenu from "@/components/LeftMenu.vue";

export default {
  components: {
    Footer,
    LeftMenu
  },
  data() {
    return {
      isHome: false,
      darkMode: false
    };
  },
  methods: {
    fun() {
      console.log("oscuro");
      this.$vuetify.theme.dark = !this.$vuetify.theme.dark;
      this.darkMode = this.$vuetify.theme.dark;
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 100%;
  margin-left: 0px;
}

.back-dark {
  background-color: #121212;
}
.back-light {
  background-color: white;
}
</style>
