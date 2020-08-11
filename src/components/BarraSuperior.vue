<template>
  <div>
    <v-app-bar color="#092327" dark>
      <v-app-bar-nav-icon
        color="white"
        @click.stop="drawer = !drawer"
      ></v-app-bar-nav-icon>
            <v-spacer />
      <v-toolbar-title light class="title">{{ title }}</v-toolbar-title>

      <v-spacer />
      <v-btn icon href="https://github.com/Mario2403/UtilsWeb">
        <v-icon color="#FFFFFF">mdi-github</v-icon>
      </v-btn>
    </v-app-bar>

    <v-navigation-drawer
      clipped
      v-model="drawer"
      bottom
      temporary
      color="#00A9A5"
      dark
      expand-on-hover=true
    >
      <v-list nav>
        <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item 
          link 
          :key="item.title" 
          v-for="item in items" 
          router :to="item.route"
          class="item">
            <v-icon color="#FFFFFF">{{ item.icon }}</v-icon>

            <v-list-item-content>
              <v-list-item-title> {{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<script>
export default {
  name: "BarraSuperior",
  props: ["title"],
  data() {
    return {
      drawer: false,
      group: null,
      items: [
        { title: "Control de horas", icon: "mdi-clock-time-four-outline", route:"/" },
        { title: "Calendario", icon: "mdi-calendar-outline", route:"Calendario" },
        { title: "Notas", icon: "mdi-note-outline", route:"/" },
        { title: "Utilidades", icon: "mdi-ruler", route:"/" }
      ]
    };
  },
  watch: {
    group() {
      this.drawer = false;
    }
  }
};
</script>


<style>
.item{
  font-family: Avenir, Arial, Helvetica, sans-serif;
}
.title{
    font-family: Avenir, Arial, Helvetica, sans-serif;
    font-size: 20pt;

}


</style>