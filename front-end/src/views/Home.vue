<template>
  <div>
    <v-row >
      <v-col :key="card.title" v-for="card in cards">

        <v-card display color="#FFDD66" max-width="400" height="150" router :to="card.route" class="d-flex flex-column arrow menu-card">
          <!-- <v-icon size="150" color="#092327">{{card.icon}}</v-icon> -->
          <v-spacer/>
         <v-card-title class= "icono justify-center card-title">{{card.icon}}</v-card-title>

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
        { title: "Control de horas", icon: "⏱️", route:"/ControlHoras" },
        { title: "Calendario", icon: "🗓️", route:"Calendario" },
        { title: "Notas", icon: "📝", route:"/" },
        { title: "Estadísticas", icon: "📈", route:"Estadisticas"},
        { title: "Utilidades", icon: "📐", route:"/Utilidades" },
      ],
    }
  }
};
</script>

<style scoped>
.menu-card {
  height: 100;
  max-width: 25%;

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
