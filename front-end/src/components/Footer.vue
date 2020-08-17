<template>
  <div>
      <Modal v-if="showModal" @close="showModal = false"></Modal>

    <v-footer absolute padless color="#FFFFFF">

      <v-card flat tile color="#FFFFFF" width="100%" class="year-and-name">
        <v-card-text>
          {{ new Date().getFullYear() }} -
          <strong>Mario Jurado Soba</strong>
        </v-card-text>
      </v-card>
      <v-card flat tile color="#FFFFFF" width="100%">

        <v-card-actions>
          <v-spacer />

          <v-btn v-for="icon in icons" :key="icon.name" icon>
            <v-icon size="24px" color="#000000">{{ icon.icon }}</v-icon>
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
        { name: "linkedIn", icon: "mdi-linkedin" },
        { name: "twitter", icon: "mdi-twitter"},
      ],
      showModal: false
    };
  },
  components:{
    Modal
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
  color: black;
  font-family: Avenir, Arial, Helvetica, sans-serif;
  size: 10pt;
  text-align: center;
}
</style>