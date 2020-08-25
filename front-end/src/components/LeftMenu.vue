<template>
  <div class="fill-height">
    <v-navigation-drawer
      clipped
      v-model="drawer"
      bottom
      permanent
      color="#FFFFFF"
      :mini-variant="false"
      :expand-on-hover="false"
      :width="325"
    >
      <v-list nav>
        <v-list-group
          value="false"
          sub-group
          no-action
          :key="group.name"
          v-for="group in groups"
        >
          <template v-slot:activator>
            <v-list-item-title class="group-title">{{group.name}}</v-list-item-title>
          </template>

          <v-list-item
            link
            router
            :key="item.title"
            v-for="item in group.groupItems"
            :to="item.route"
            class="item"
          >
            <v-icon color="#666666">{{ item.icon }}</v-icon>

            <v-list-item-content>
              <v-list-item-title class="custom-item-title">{{ item.title }}</v-list-item-title>
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
          groupItems: [{ title: "Utilidades", icon: "mdi-ruler", route: "/" }]
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
.custom-item-title {
  color: #666666;
  margin-left: 10px;
  font-size: 13pt;
}
.group-title {
  font-size: 15pt;
    color: #444444;
   font-weight: bold;

}
</style>