<template>
  <div>
      <Modal v-if="showModal" @close="showModal = false"></Modal>

    <v-footer absolute padless color="#FFFFFF">

      <v-card flat tile  width="100%" class="year-and-name">
        <v-card-text>
          {{ new Date().getFullYear() }} -
          <strong>Mario Jurado Soba</strong>
        </v-card-text>
      </v-card>
      <v-card flat tile  width="100%">

        <v-card-actions>
          <v-spacer />

          <v-btn v-for="icon in icons" :key="icon.name" icon :href="icon.link">
            <v-icon size="24px" >{{ icon.icon }}</v-icon>
          </v-btn>

          <v-spacer />

          <v-btn icon id="show-modal" @click="showModal = true" class="bug-icon">
            <v-icon size="24px" color="#666666">mdi-bug</v-icon>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-footer>
  </div>
</template>


<script>
import Modal from "@/components/popups/ModalBugForm.vue";
export default {
  name: "Footer",
  data() {
    return {
      icons: [
        { name: "linkedIn", icon: "mdi-linkedin", link:"https://www.google.com" },
        { name: "twitter", icon: "mdi-twitter",  link:"https://www.google.com" },
        {name: "github", icon: "mdi-github",  link:"https://github.com/Mario2403/UtilsWeb" }
      ],
      showModal: false
    };
  },
  components:{
    Modal
  }
};
</script>
<v-btn icon href="https://github.com/Mario2403/UtilsWeb">
        <v-icon large :color="this.$vuetify.theme.dark ? '#FFFFFF' : '#000000' ">mdi-github</v-icon>
      </v-btn>

<style lang="scss" scoped>
.year-and-name {
  color: black;
  font-family: Avenir, Arial, Helvetica, sans-serif;
  size: 10pt;
  text-align: center;
}
</style>