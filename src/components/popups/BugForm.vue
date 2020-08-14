<template>
  <ValidationObserver ref="observer" v-slot="{  }">
      <h1>Reportar un problema</h1>
    <form>
      <ValidationProvider v-slot="{ errors }" name="Name" rules="required|max:30">
        <v-text-field v-model="name" :counter="30" :error-messages="errors" label="Nombre" required></v-text-field>
      </ValidationProvider>
      <ValidationProvider v-slot="{ errors }" name="Email" rules="required|email">
        <v-text-field v-model="email" :error-messages="errors" label="E-mail" required></v-text-field>
      </ValidationProvider>
      <ValidationProvider v-slot="{ errors }" name="Módulo" rules="required">
        <v-select
          v-model="select"
          :items="items"
          :error-messages="errors"
          label="Módulo"
          data-vv-name="select"
          required
          outlined
        ></v-select>
      </ValidationProvider>
      <ValidationProvider  v-slot="{ errors }" name="problema" rules="required|max: 500">
          <v-textarea
            v-model="text"
            label="Explica el problema"
            :error-messages="errors"
            :counter="500"
            auto-grow
            clearable
          ></v-textarea>
      </ValidationProvider>

      <v-btn class="mr-4" @click="submit">submit</v-btn>
      <v-btn @click="clear">clear</v-btn>
    </form>
  </ValidationObserver>
</template>

<script>
import { required, email, max } from "vee-validate/dist/rules";
import {
  extend,
  ValidationObserver,
  ValidationProvider,
  setInteractionMode
} from "vee-validate";

setInteractionMode("eager");

extend("required", {
  ...required,
  message: "{_field_} no puede estar vacío"
});

extend("max", {
  ...max,
  message: "El campo no debe superar los {length} caracteres"
});

extend("email", {
  ...email,
  message: "Introduce un email válido"
});

export default {
  name: "BugForm",
  components: {
    ValidationProvider,
    ValidationObserver
  },
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