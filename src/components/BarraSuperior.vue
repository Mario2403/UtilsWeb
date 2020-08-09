<template>
  <div>
    <v-app-bar color="#092327" dark>
      <v-app-bar-nav-icon
        color="white"
        @click.stop="drawer = !drawer"
      ></v-app-bar-nav-icon>
      <v-toolbar-title light>{{ title }}</v-toolbar-title>

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
    >
      <v-list nav>
        <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item link :key="item.title" v-for="item in items">
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
        { title: "Control de horas", icon: "mdi-clock-time-four-outline" },
        { title: "Calendario", icon: "mdi-calendar-outline" },
        { title: "Notas", icon: "mdi-note-outline" },
        { title: "Utilidades", icon: "mdi-ruler" }
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
