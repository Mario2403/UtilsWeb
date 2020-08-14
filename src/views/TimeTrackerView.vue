<template>
  <div>
        <ModalProyectoForm v-if="showModalProyectos" @close="showModalProyectos = false"></ModalProyectoForm>
    <v-row>
      <v-btn id="show-modal" @click="showModalProyectos = true">Añadir proyecto</v-btn>
      <v-spacer />
      <v-btn>Generar daily report</v-btn>
    </v-row>
  </div>
</template>

<script>
import ModalProyectoForm from "@/components/popups/ModalProyectoForm.vue"
export default {
  name: "TimeTracker",
  data() {
    return {
      showModalProyectos: false
    };
  },
  components:{
      ModalProyectoForm
  }
};
</script>