<template>
<div>
    <h1>Añadir un proyecto</h1>
    <form>
      <v-row>
        <v-col cols ="2">
            <v-text-field
              v-model="codigo"
              :counter="4"
              :error-messages="errors"
              label="Código"
              required
            ></v-text-field>
        </v-col>

        <v-col>
            <v-text-field
              v-model="name"
              :counter="100"
              :error-messages="errors"
              label="Nombre del proyecto"
              required
            ></v-text-field>
        </v-col>
      </v-row>
      <v-btn class="mr-4" @click="submit">submit</v-btn>
      <v-btn @click="clear">clear</v-btn>
    </form>
</div>
</template>

<script>

export default {
  name: "ProyectoForm",
  data() {
    return {
      name: "",
      codigo: null,
    };
  },

  methods: {
    async submit() {
      const isValid = await this.$refs.observer.validate();
      if (isValid) {
        console.log("Datos enviados, gracias!");
        alert("Datos enviados gracias!");
        this.$emit("close");
      } else {
        console.log("KO");
        alert("Datos inválidos");
      }
    },
    clear() {
      this.name = "";
      this.codigo = "";
      this.$refs.observer.reset();
    }
  }
  
};
</script>