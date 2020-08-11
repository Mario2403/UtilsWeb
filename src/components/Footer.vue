<template>
  <div>
    <v-footer padless color="#00A9A5">
      <v-card flat tile color="#00A9A5" width="100%">
        <v-card-title class="dark-text">
          <strong>Get connected with us on social networks!</strong>
        <v-spacer/>
        <v-btn v-for="icon in icons" :key="icon" class="RRSSicon" icon>
          <v-icon size="24px" color="#000000">{{ icon.icon }}</v-icon>
        </v-btn>
       
         </v-card-title>
      </v-card>
      
      <v-spacer />
      <v-card-text class="year-and-name">
        {{ new Date().getFullYear() }} —
        <strong>Mario Jurado Soba</strong>
      </v-card-text>
    </v-footer>
  </div>
</template>


<script>
export default {
  name: "Footer",
  data() {
    return {
      icons: [{ name: "linkedIn", icon: "mdi-linkedin" }]
    };
  }
};
</script>


<style lang="scss" scoped>
.card {
  background-color: "#00A9A5";
}
.dark-text {
  font-family: Avenir, Arial, Helvetica, sans-serif;
  color: "#092327";
}
.year-and-name {
  color: white;
  font-family: Avenir, Arial, Helvetica, sans-serif;
  size: 10pt;
  text-align: center;
  background-color: black;
}
.RRSSicon {
  color: red;
}
</style>