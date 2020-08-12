<template>
<div>
  <v-app>
    <router-view />
  <Footer/> 
  </v-app>   
  </div>
</template>

<script>
import Footer from "@/components/Footer.vue";
export default {
  components:{
    Footer
}
  
}
</script>

<style lang="scss">
</style>
