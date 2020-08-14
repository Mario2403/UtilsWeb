<template v-slot:activator="{ on, attrs }">
  <div>
    <ModalProyectoForm v-if="showModalProyectos" @close="showModalProyectos = false"></ModalProyectoForm>
    <v-row>
      <v-btn id="show-modal" @click="showModalProyectos = true">Añadir proyecto</v-btn>
      <v-spacer />
      <v-btn>Generar daily report</v-btn>
    </v-row>
    <v-row>
      <v-col :key="proyecto.codigo" v-for="proyecto in proyectos" cols="3">
        <v-card>
          <v-card style="margin-bottom: 10px; padding:10px" flat :color="proyecto.titleColor.color">
            <v-row>
              <v-card-title
                :style="!proyecto.titleColor.dark ? 'color : black' : 'color : white'"
              >{{proyecto.codigo}} - {{proyecto.name}}</v-card-title>
              <v-spacer />
              <v-menu transition="slide-x-transition" bottom right offset-x="true">
                <template v-slot:activator="{ on, attrs }">
                  <v-btn icon v-bind="attrs" v-on="on">
                    <v-icon
                      :color="!proyecto.titleColor.dark ? 'black' : 'white'"
                      class="dark-icon"
                    >mdi-palette</v-icon>
                  </v-btn>
                </template>
                <v-list>
                  <v-list-item
                    v-for="(item, index) in titleColors"
                    :key="index"
                    @click="proyecto.titleColor=item"
                  >
                    <v-list-item-icon>
                      <v-icon large :color="item.color">mdi-rectangle</v-icon>
                    </v-list-item-icon>
                    <v-list-item-title>{{ item.name }}</v-list-item-title>
                  </v-list-item>
                </v-list>
              </v-menu>
            </v-row>
          </v-card>
          <v-card-actions class="justify-center">
            <v-btn icon color="#000000">
              <v-icon
                size="50px"
                v-show="!proyecto.isPlaying"
                @click="playProyecto(proyecto)"
              >mdi-play</v-icon>
              <v-icon
                size="50px"
                v-show="proyecto.isPlaying"
                @click="stopProyecto(proyecto)"
              >mdi-pause</v-icon>
            </v-btn>
          </v-card-actions>
          <v-row>
            <v-col>
              <v-card-subtitle class="big-text">{{convertSecondsToHuman(proyecto.time)}}</v-card-subtitle>
            </v-col>
            <v-col class="align-rigth">
              <v-card-text class="text-right" :class="proyecto.isPlaying ? 'mode-on' : 'mode-on' ">
                <strong>{{proyecto.isPlaying ? 'ON' : 'OFF'}}</strong>
              </v-card-text>
            </v-col>
          </v-row>
          <v-progress-linear height="4" v-show="proyecto.isPlaying" indeterminate color="success"></v-progress-linear>
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
    ModalProyectoForm
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
    }
  },
  destroyed() {
    //backend update
    console.log(this.proyectos);
  },
  mounted() {
    //update proyects in backend
    setInterval(
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