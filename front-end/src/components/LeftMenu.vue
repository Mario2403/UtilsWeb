<template>
  <v-navigation-drawer
    v-model="drawer"
    permanent
    :mini-variant="false"
    :expand-on-hover="true"
    :color="$vuetify.theme.dark  ? '#232323' : '#FFFFFF'"
    hide-overlay
    app
  >
    <v-img v-if="!$vuetify.theme.dark" src="../assets/Aperture-dark.png" min-height="90" contain></v-img>
    <v-img v-if="$vuetify.theme.dark" src="../assets/Aperture-light.png" min-height="90" contain></v-img>

    <v-list nav>
      <v-list-group
        value="true"
        sub-group
        no-action
        :key="group.name"
        v-for="group in groups"
        id="group"
      >
        <template v-slot:activator>
          <v-list-item-title
            class="padd-group-item"
            :class="$vuetify.theme.dark  ? 'group-title-dark' : 'group-title-light' "
          >{{group.name}}</v-list-item-title>
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
            <v-list-item-title
              :class="$vuetify.theme.dark ? 'custom-item-title-dark' : 'custom-item-title-light'"
            >{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider></v-divider>
      </v-list-group>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  name: "LeftMenu",
  data() {
    return {
      darkMode: true,
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
          groupItems: [
            { title: "Utilidades", icon: "mdi-ruler", route: "Utilidades" }
          ]
        }
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

<style scoped>
.custom-item-title-light {
  color: #666666;
  margin-left: 10px;
  font-size: 12pt;
  font-family: "Roboto";
}

.custom-item-title-dark {
  color: #eeeeee;
  margin-left: 10px;
  font-size: 12pt;
  font-family: "Roboto";
}
.group-title-light {
  font-size: 15pt;
  color: #444444;
  font-weight: bold;
  font-family: "Roboto";
}
.group-title-dark {
  font-size: 15pt;
  color: #dddddd;
  font-weight: bold;
  font-family: "Roboto";
}
.item {
  padding-left: 50px !important;
}
.logo {
  padding-left: 15px;
}
</style>