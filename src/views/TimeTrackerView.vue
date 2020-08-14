<template>
  <div>
    <ModalProyectoForm v-if="showModalProyectos" @close="showModalProyectos = false"></ModalProyectoForm>
    <v-row>
      <v-btn id="show-modal" @click="showModalProyectos = true">Añadir proyecto</v-btn>
      <v-spacer />
      <v-btn>Generar daily report</v-btn>
    </v-row>
    <v-row>
      <v-col :key="proyecto.codigo" v-for="proyecto in proyectos" cols="3">
        <v-card :style="proyecto.outlineStyle">
          <v-card-title>{{proyecto.codigo}} - {{proyecto.name}}</v-card-title>
          <v-card-actions class="justify-center">
            <v-btn icon  color="#000000">
              <v-icon size="50px" v-show="!proyecto.isPlaying" @click="playProyecto(proyecto)">mdi-play</v-icon>
              <v-icon size="50px" v-show="proyecto.isPlaying" @click="stopProyecto(proyecto)">mdi-pause</v-icon>
            </v-btn>
          </v-card-actions>
          <v-row>
              <v-col>
          <v-card-subtitle class="big-text">{{convertSecondsToHuman(proyecto.time)}}</v-card-subtitle>
              </v-col>
              <v-col class="align-rigth">
                <v-card-text class="text-right" :class="proyecto.isPlaying ? 'mode-on' : 'mode-on' ">
                    <strong>{{proyecto.isPlaying ? 'ON' : 'OFF'}}</strong></v-card-text>
              </v-col>
          </v-row>
          <v-progress-linear height="6" v-show="proyecto.isPlaying" indeterminate color="success"></v-progress-linear>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import ModalProyectoForm from "@/components/popups/ModalProyectoForm.vue";
export default {
  name: "TimeTracker",
  data() {
    return {
      showModalProyectos: false,
      isPlaying: false,
      proyectos: [
        {
          codigo: "4011",
          name: "Nueva asdadsq",
          isPlaying: false,
          time: 0,
          timer: null,
          outlineStyle: "",
          tareas:[
              {title: "Hacer cosas", completed: false}
          ]
        },
        {
          codigo: "1234",
          name: "Proyecto nuevo",
          isPlaying: false,
          time: 0,
          timer: null,
          outlineStyle: "",
          tareas:[]
        }
      ]
    };
  },
  components: {
    ModalProyectoForm
  },
  methods: {
    playProyecto(playingProyecto) {
      this.proyectos.forEach(p => {
        p.isPlaying = false;
        clearInterval(p.timer);
        p.outlineStyle = "";
      });
      playingProyecto.isPlaying = true;
      this.startTimer(playingProyecto);
      playingProyecto.outlineStyle = "";
    },
    stopProyecto(playingProyecto) {
      playingProyecto.isPlaying = false;
      this.stopTimer(playingProyecto);
      playingProyecto.outlineStyle = "";
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
    }
  },
  destroyed(){
      //backend update
      console.log(this.proyectos);
  },
  mounted(){
      //update proyects in backend
      setInterval(() => console.log("update de proyectos en back -> " + this.proyectos), 10000);
      
  }
};
</script>

<style scoped>
.big-text{
    font-size: 20pt;
}

.mode-on{
    font-size: 25pt;
    color:green;
}
.mode-off{
    font-size: 30pt;
    color:red;
}
</style>