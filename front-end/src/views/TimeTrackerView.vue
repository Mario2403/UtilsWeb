<template v-slot:activator="{ on, attrs }">
<v-card outlined>
  <div>
    <ModalProyectoForm v-if="showModalProyectos" @close="showModalProyectos = false"></ModalProyectoForm>
    <v-row>
      <v-btn id="show-modal" @click="showModalProyectos = true">Añadir proyecto</v-btn>
      <v-spacer />
      <v-btn>Generar daily report</v-btn>
    </v-row>
    <v-row>
      <v-col :key="proyecto.codigo" v-for="proyecto in proyectos" cols="3">
        
        <TimeCard :proyecto="proyecto" :titleColors="titleColors"></TimeCard>

      </v-col>
    </v-row>
  </div>
</v-card>
</template>

<script>
import ModalProyectoForm from "@/components/popups/ModalProyectoForm.vue";
import TimeCard from "@/components/TimeCard.vue";

import axios from "axios";

export default {
  name: "TimeTracker",
  data() {
    return {
      showModalProyectos: false,
      isPlaying: false,
      updater:null,
      titleColors: [
        { name: "Azul", color: "#0079C4", dark: true },
        { name: "Cian", color: "#26C1C9", dark: true },
        { name: "Rojo", color: "#E0102B", dark: true },
        { name: "Naranja", color: "#FD7B1F", dark: true },
        { name: "Verde", color: "#81C926", dark: true },
        { name: "Amarillo", color: "#FACA00", dark: false },
        { name: "Rosa", color: "#FFB6C1", dark: false },
        { name: "Negro", color: "black", dark: true },
        { name: "Blanco", color: "white", dark: false }
      ],
      proyectos: [
        {
          codigo: "4011",
          name: "Evolutivos Movistar Cloud",
          isPlaying: false,
          time: 0,
          timer: null,
          titleColor: { name: "Azul", color: "#0079C4", dark: true },
          tareas: [{ title: "Hacer cosas", completed: false }]
        },
        {
          codigo: "1234",
          name: "PCM - NEN",
          isPlaying: false,
          time: 0,
          timer: null,
          titleColor: { name: "Azul", color: "#0079C4", dark: true },
          tareas: []
        }
      ]
    };
  },
  components: {
    ModalProyectoForm,
    TimeCard
  },
  methods: {
    playProyecto(playingProyecto) {
      this.proyectos.forEach(p => {
        p.isPlaying = false;
        clearInterval(p.timer);
      });
      playingProyecto.isPlaying = true;
      this.startTimer(playingProyecto);
    },
    stopProyecto(playingProyecto) {
      playingProyecto.isPlaying = false;
      this.stopTimer(playingProyecto);
    },
    startTimer(proyecto) {
      var timer = setInterval(() => (proyecto.time = proyecto.time += 1), 1000);
      proyecto.timer = timer;
    },
    stopTimer(proyecto) {
      var timer = proyecto.timer;
      clearInterval(timer);
    },
    convertSecondsToHuman(totalSeconds) {
      var time = "";
      var hours =
        ("" + Math.floor(totalSeconds / 3600)).length < 2
          ? "0" + Math.floor(totalSeconds / 3600)
          : Math.floor(totalSeconds / 3600);
      var minutes =
        ("" + Math.floor(totalSeconds / 60)).length < 2
          ? "0" + Math.floor(totalSeconds / 60)
          : Math.floor(totalSeconds / 60);
      var seconds =
        ("" + (totalSeconds % 60)).length < 2
          ? "0" + (totalSeconds % 60)
          : totalSeconds % 60;

      time = hours + ":" + minutes + ":" + seconds;
      return time;
    },
    addProyectosToList(proyectos){
      proyectos.forEach((p) =>{
        var pVue = {}
        pVue.codigo = p.codigo;
        pVue.name = p.name;
        pVue.isPlaying= false;
        pVue.time= 0;
        pVue.timer= null;
        pVue.titleColor= { "name": "Azul", "color": "#0079C4", "dark": "true" };
        this.proyectos.push(pVue);
      })
  }
  },


codigo: "4011",
        //   name: "Evolutivos Movistar Cloud",
        //   isPlaying: false,
        //   time: 0,
        //   timer: null,
        //   titleColor: { name: "Azul", color: "#0079C4", dark: true },
        //   tareas: [{ title: "Hacer cosas", completed: false }]


  destroyed() {
    //backend update
    console.log(this.proyectos);
    axios.post("/api/v1/proyectos/saveAll", this.proyectos);
    clearInterval(this.updater);
  },
  mounted() {
    //update proyects in backend
    axios.get("/api/v1/proyectos/get").then(response => {
      console.log(response.data);
      this.addProyectosToList(response.data);
    })

    
    this.updater = setInterval(
      () => console.log("update de proyectos en back -> " + this.proyectos),
      10000
    );
  }
};
</script>

<style scoped>
.big-text {
  font-size: 20pt;
}

.mode-on {
  font-size: 25pt;
  color: green;
}
.mode-off {
  font-size: 30pt;
  color: red;
}
</style>