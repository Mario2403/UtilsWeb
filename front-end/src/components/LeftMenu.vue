<template>
  <v-navigation-drawer
    stateless
    permanent
    value="true"
    :mini-variant="false"
    :expand-on-hover="true"
    :color="$vuetify.theme.dark  ? '#232323' : '#FFFFFF'"
    hide-overlay
    app
  >
    <v-img v-if="!$vuetify.theme.dark" src="../assets/Aperture-dark.png" min-height="90" contain></v-img>
    <v-img v-if="$vuetify.theme.dark" src="../assets/Aperture-light.png" min-height="90" contain></v-img>

    <v-list nav dense>
     
      <v-list-group
        value="true"
        :key="group.name"
        v-for="group in groups"
        :prepend-icon="group.icon"

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
          :prepend="item.icon"
          value="true"
        >
          <v-icon :color="$vuetify.theme.dark ? '#FFFFFF' : '#666666'">{{ item.icon }}</v-icon>

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
      expandOnHover: true,
      groups: [
        {
          name: "Control",
          icon: "mdi-file-chart",
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
          icon: "mdi-calendar-check",

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
          icon: "mdi-chart-bar",
          groupItems: [
            {
              title: "Estadísticas",
              icon: "mdi-chart-areaspline",
              route: "Estadisticas"
            }
          ]
        },
               {
          name: "Configuración",
          icon: "mdi-cog",
          groupItems: [
            {
              title: "Proyectos",
              icon: "mdi-briefcase",
              route: "Proyectos"
            }
          ]
        },
        {
          name: "Otros",
          icon: "mdi-dots-horizontal-circle-outline",
          groupItems: [
            { title: "Utilidades", icon: "mdi-ruler", route: "Utilidades" }
          ]
        }
      ]
    };
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