<template>
  <ValidationObserver ref="observer" v-slot="{  }">
    <form>
      <ValidationProvider v-slot="{ errors }" name="Name" rules="required|max:30">
        <v-text-field v-model="name" :counter="30" :error-messages="errors" label="Nombre" required></v-text-field>
      </ValidationProvider>
      <ValidationProvider v-slot="{ errors }" name="email" rules="required|email">
        <v-text-field v-model="email" :error-messages="errors" label="E-mail" required></v-text-field>
      </ValidationProvider>
      <ValidationProvider v-slot="{ errors }" name="select" rules="required">
        <v-select
          v-model="select"
          :items="items"
          :error-messages="errors"
          label="Sección del error"
          data-vv-name="select"
          required
          outlined
        ></v-select>
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
  message: "{_field_}no debe superar los {length} caracteres"
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
        "Utilidades"
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
      this.$refs.observer.reset();
    }
  }
};
</script>