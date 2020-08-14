<template>
  <div>
    <v-card outlined :style="outlinedStyle">
      <v-card-title class="title-size justify-center">Expresiones regulares</v-card-title>
      <v-card-actions>
        <v-row width="100%">
          <v-col>
            <v-card flat>
              <v-text-field id="styled-input" class="styled-input" label="Expresion regular"></v-text-field>
            </v-card>
          </v-col>
        </v-row>
      </v-card-actions>
            <v-card-actions>
        <v-row width="100%">
          <v-col>
            <v-card flat>
              <v-text-field id="styled-input" class="styled-input" label="Texto a comprobar"></v-text-field>
            </v-card>
          </v-col>
        </v-row>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "RegexChecker",
  data() {
    return {
      outlinedStyle: { border: "2px solid green" }
    };
  }
};
</script>

<style >
#styled-input {
  height: 45px;
  font-size: 18pt;
}
.styled-input label[for] {
  height: 45px;
  font-size: 18pt;
}
</style>