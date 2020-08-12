<template>
    <div class ="fill-height">
        
    <v-navigation-drawer
      clipped
      v-model="drawer"
      bottom
      permanent
      color="#00A9A5"
      dark
      :mini-variant="true"
      :expand-on-hover="true"

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
              <v-list-item-title class="item-title"> {{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
    </div>
</template>

<script>
export default {
    name:"LeftMenu",
    data() {
    return {
      drawer: true,
      group: null,
      expandOnHover: true,
      items: [
        { title: "Control de horas", icon: "mdi-clock-time-four-outline", route:"/" },
        { title: "Calendario", icon: "mdi-calendar-outline", route:"Calendario" },
        { title: "Notas", icon: "mdi-note-outline", route:"/" },
        { title: "Estadísticas", icon: "mdi-chart-areaspline", route:"Estadisticas"},
        { title: "Utilidades", icon: "mdi-ruler", route:"/" }
      ]
    };
  },
  watch: {
    group() {
      this.drawer = true;
    }
  }
};
</script>