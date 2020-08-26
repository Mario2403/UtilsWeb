<template>
  <div>
    <v-app-bar elevation="0" >
      <router-link :to="{name: 'Home'}">
        <v-btn icon large>
          <v-icon :color="darkMode ? '#FFFFFF' : '#000000' ">mdi-home</v-icon>
        </v-btn>
      </router-link>
      <v-spacer />
      <v-toolbar-title class="title">
        <h2>{{ this.$route.name }} </h2>
      </v-toolbar-title>

      <v-spacer />
      <v-btn icon @click="fun()">
        <v-icon :color="darkMode ? '#FFFFFF' : '#000000' ">mdi-brightness-4</v-icon>
      </v-btn>
    </v-app-bar>
  </div>
</template>

<script>
export default {
  name: "BarraSuperior",
  data() {
    return{
      darkMode: false,
    }
  }, methods:{
    fun() {
      console.log("oscuro");
      this.$vuetify.theme.dark = !this.$vuetify.theme.dark;
      this.darkMode = this.$vuetify.theme.dark;
    }
  },
};
</script>


<style>
.item {
  font-family: Avenir, Arial, Helvetica, sans-serif;
}
.title {
  font-family: Avenir, Arial, Helvetica, sans-serif;
  font-size: 45pt;
}
.item-title {
  padding-left: 15px;
  font-size: 15pt;
}

</style>