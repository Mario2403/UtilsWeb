<template>
  <div>
    <v-app-bar color="#092327" dark>
            <v-spacer />
      <v-toolbar-title light class="title">
        <h2>{{ title }}</h2>
        </v-toolbar-title>

      <v-spacer />
      <v-btn icon href="https://github.com/Mario2403/UtilsWeb">
        <v-icon color="#FFFFFF">mdi-github</v-icon>
      </v-btn>
    </v-app-bar>

  </div>
</template>

<script>
export default {
  name: "BarraSuperior",
  props: ["title"]
}
</script>


<style>
.item{
  font-family: Avenir, Arial, Helvetica, sans-serif;
}
.title{
    font-family: Avenir, Arial, Helvetica, sans-serif;
    font-size: 45pt;
}
.item-title{
  padding-left: 15px;
  font-size: 15pt;
}


</style>