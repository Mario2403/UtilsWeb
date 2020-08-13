<template>
  <div>
    <v-row>
      <v-col :key="card.title" v-for="card in cards">
        <v-hover
        v-slot:default="{ hover }"
        
      >
        <v-card display color="#FFDD66" :elevation="hover?20:2" max-width="400" class="d-flex flex-column  menu-card ">
          <v-icon size="150" color="#092327">{{card.icon}}</v-icon>

          <v-card-title class="justify-center card-title">{{card.title}}</v-card-title>
          <!-- <v-card-subtitle>Subtitulo de la tarjeta</v-card-subtitle>
          <v-card-text>Textro de la tarjeta</v-card-text> -->
        </v-card>
        </v-hover>
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

  max-height: 400px;
}
.menu-card:hover{
  background-color: black;
}
.card-title{
  color:black;
}
</style>
