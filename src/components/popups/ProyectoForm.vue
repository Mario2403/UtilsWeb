<template>
  <ValidationObserver ref="observer" v-slot="{  }">
    <h1>Añadir un proyecto</h1>
    <form>
      <v-row>
        <v-col cols ="2">
          <ValidationProvider v-slot="{ errors }" name="Codigo" rules="required|digits:4">
            <v-text-field
              v-model="codigo"
              :counter="4"
              :error-messages="errors"
              label="Código"
              required
            ></v-text-field>
          </ValidationProvider>
        </v-col>

        <v-col>
          <ValidationProvider v-slot="{ errors }" name="Nombre" rules="required|max: 100">
            <v-text-field
              v-model="name"
              :counter="100"
              :error-messages="errors"
              label="Nombre del proyecto"
              required
            ></v-text-field>
          </ValidationProvider>
        </v-col>
      </v-row>
      <v-btn class="mr-4" @click="submit">submit</v-btn>
      <v-btn @click="clear">clear</v-btn>
    </form>
  </ValidationObserver>
</template>

<script>
import { required, max, digits } from "vee-validate/dist/rules";
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
  message: "El nombre no debe superar los {length} caracteres"
});

extend("digits", {
  ...digits,
  message: "El campo ha de ser numérico"
});

export default {
  name: "ProyectoForm",
  components: {
    ValidationProvider,
    ValidationObserver
  },
  data() {
    return {
      name: "",
      codigo: null
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