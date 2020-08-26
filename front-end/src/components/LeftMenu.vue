<template>
  <div class="fill-height">
    <v-navigation-drawer
      clipped
      v-model="drawer"
      bottom
      permanent
      
      :mini-variant="false"
      :expand-on-hover="false"
      :width="325"
    >
      <template v-slot:append>
        <v-btn @click="fun()">BOTON</v-btn>
      </template>
      <v-list nav>
        <v-list-group value="false" sub-group no-action :key="group.name" v-for="group in groups">
          <template v-slot:activator>
            <v-list-item-title :class="darkMode ? 'group-title-dark' : 'group-title-light' ">{{group.name}}</v-list-item-title>
          </template>

          <v-list-item
            link
            router
            :key="item.title"
            v-for="item in group.groupItems"
            :to="item.route"
            class="item"
          >
            <v-icon :color="darkMode ? '#FFFFFF' : '#666666'">{{ item.icon }}</v-icon>

            <v-list-item-content>
              <v-list-item-title :class="darkMode ? 'custom-item-title-dark' : 'custom-item-title-light'">{{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<script>
export default {
  name: "LeftMenu",
  data() {
    return {
      darkMode : false,
      drawer: true,
      group: null,
      expandOnHover: true,
      groups: [
        {
          name: "Control",
          groupItems: [
            {
              title: "Control de horas",
              icon: "mdi-clock-time-four-outline",
              route: "/ControlHoras"
            },
            {
              title: "Reporte semanal",
              icon: "mdi-calendar-outline",
              route: "Calendario"
            }
          ]
        },
        {
          name: "Tareas",
          groupItems: [
            { title: "Notas", icon: "mdi-note-outline", route: "/" },
            {
              title: "Calendario",
              icon: "mdi-calendar-outline",
              route: "Calendario"
            }
          ]
        },

        {
          name: "Estadisticas",
          groupItems: [
            {
              title: "Estadísticas",
              icon: "mdi-chart-areaspline",
              route: "Estadisticas"
            }
          ]
        },
        {
          name: "Otros",
          groupItems: [{ title: "Utilidades", icon: "mdi-ruler", route: "Utilidades" }]
        }
      ]
    };
  },
  watch: {
    group() {
      this.drawer = true;
    }
  },
  methods:{
    fun() {
      console.log("oscuro");
      this.$vuetify.theme.dark = !this.$vuetify.theme.dark;
      this.darkMode = this.$vuetify.theme.dark;
    }
  },
  created:{
  mode() {
    this.darkMode =  this.$vuetify.theme.dark;
  }
}
};
</script>

<style scoped>
.custom-item-title-light {
  color: #666666;
  margin-left: 10px;
  font-size: 13pt;
}

.custom-item-title-dark {
  color: #EEEEEE;
  margin-left: 10px;
  font-size: 13pt;
}
.group-title-light {
  font-size: 15pt;
  color: #444444;
  font-weight: bold;
}
.group-title-dark {
  font-size: 15pt;
  color: #DDDDDD;
  font-weight: bold;
}
</style>