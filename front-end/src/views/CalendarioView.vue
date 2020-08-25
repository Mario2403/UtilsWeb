<template >
<div>
  <v-card outlined>
<CalendarioComp/>
  </v-card>
</div>
</template>


<script>

import CalendarioComp from "@/components/CalendarioComp.vue";


export default {
name: "Calendario",
  components: {
    CalendarioComp
  }
}
</script>
