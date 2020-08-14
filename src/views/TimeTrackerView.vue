<template>
  <div>
    <ModalProyectoForm v-if="showModalProyectos" @close="showModalProyectos = false"></ModalProyectoForm>
    <v-row>
      <v-btn id="show-modal" @click="showModalProyectos = true">Añadir proyecto</v-btn>
      <v-spacer />
      <v-btn>Generar daily report</v-btn>
    </v-row>
    <v-row >
      <v-col :key="proyecto.codigo" v-for="proyecto in proyectos" cols = "5" >
        <v-card>
          <v-card-title>{{proyecto.codigo}} - {{proyecto.name}}</v-card-title>
          <v-card-actions class="justify-center">
              <v-btn icon color="#000000">
                  <v-icon large v-show="!isPlaying" @click="isPlaying = true">mdi-play</v-icon>
                  <v-icon large v-show="isPlaying" @click="isPlaying = false">mdi-pause</v-icon>
              </v-btn>
               </v-card-actions>
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
          { codigo: "4011", name: "Nueva asdadsq" },
          { codigo: "1234", name: "Proyecto nuevo" },


      ]
    };
  },
  components: {
    ModalProyectoForm
  },
//   mounted() {
//     //pedir proyectos a back
//     this.proyectos = [{ codigo: "4011", name: "Nueva intranet" }];
//   }
};
</script>