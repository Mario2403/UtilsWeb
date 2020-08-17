<template>
<div>
      <h1>Reportar un problema</h1>
    <form>
        <v-text-field v-model="name" :counter="30" :error-messages="errors" label="Nombre" required></v-text-field>
        <v-text-field v-model="email" :error-messages="errors" label="E-mail" required></v-text-field>
        <v-select
          v-model="select"
          :items="items"
          :error-messages="errors"
          label="Módulo"
          data-vv-name="select"
          required
          outlined
        ></v-select>
          <v-textarea
            v-model="text"
            label="Explica el problema"
            :error-messages="errors"
            :counter="500"
            auto-grow
            clearable
          ></v-textarea>

      <v-btn class="mr-4" @click="submit">submit</v-btn>
      <v-btn @click="clear">clear</v-btn>
    </form>
</div>
</template>

<script>

export default {
  name: "BugForm",
  data() {
    return {
      name: "",
      email: "",
      select: null,
      items: [
        "General",
        "Control de horas",
        "Calendario",
        "Notas",
        "Estadísticas",
        "Utilidades",
        "Otro"
      ],
      checkbox: null
    };
  },

  methods: {
    async submit() {
      const isValid = await this.$refs.observer.validate();
      if (isValid) {
        console.log("Datos enviados, gracias!");
        alert("Datos enviados gracias!")
        this.$emit("close");
      } else {
        console.log("KO");
        alert("Datos inválidos")

      }
    },
    clear() {
      this.name = "";
      this.email = "";
      this.select = null;
      this.checkbox = null;
      this.text="";
      this.$refs.observer.reset();
    }
  }
};
</script>