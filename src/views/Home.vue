<template>
  <div>
    <v-row>
      <v-col :key="card" v-for="card in cards">

        <v-card display color="#FFDD66" max-width="400" heigth="900" class="d-flex flex-column arrow menu-card">
          <!-- <v-icon size="150" color="#092327">{{card.icon}}</v-icon> -->
         <v-card-title class= "icono justify-center card-title">⏱️</v-card-title>

          <v-card-title class="justify-center card-title">{{card.title}}</v-card-title>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "Home",
  mounted() {
    this.$emit("home", "true");
    console.log("emitido");
  },
  data() {
    return{
      cards:[
        { title: "Control de horas", icon: "mdi-clock-time-four-outline", route:"/" },
        { title: "Calendario", icon: "mdi-calendar-outline", route:"Calendario" },
        { title: "Notas", icon: "mdi-note-outline", route:"/" },
        { title: "Estadísticas", icon: "mdi-chart-areaspline", route:"Estadisticas"},
        { title: "Utilidades", icon: "mdi-ruler", route:"/" }
      ]
    }
  }
};
</script>

<style scoped>
.menu-card {
  height: 100%;
  max-width: 25%;
  max-height: 400px;
}
.menu-card:hover{
  background-color: black;
}
.card-title{
  color:black;
}
.icono{
  font-size: 50pt
}

.arrow {
  position: relative;
  top: 0;
  transition: top ease 0.5s;
}
.arrow:hover {
  top: -10px;
}
</style>
