<template>
  <div>
    <v-row>
      <v-col cols="3">
      <ByteConverter/>
      </v-col>
      <v-col cols="9">
        <RegexChecker/>
      </v-col>
    </v-row>
  </div>
</template>
<script>
import ByteConverter from "@/components/utilidadesComp/ByteConverter.vue";
import RegexChecker from "@/components/utilidadesComp/RegexChecker.vue";

export default {
  name: "Utilidades",
  components: {
    ByteConverter,
    RegexChecker
  }
};
</script>