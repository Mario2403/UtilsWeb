<template>
  <v-app id="inspire">
    <v-main>
      <v-container fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-12">
              <v-toolbar color="primary" dark flat>
                <v-toolbar-title>Login form</v-toolbar-title>
                <v-spacer></v-spacer>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field
                    label="Login"
                    name="login"
                    prepend-icon="mdi-account"
                    type="text"
                    v-model="username"
                  ></v-text-field>

                  <v-text-field
                    id="password"
                    label="Password"
                    name="password"
                    prepend-icon="mdi-lock"
                    type="password"
                    v-model="pwd"
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="primary" @click="handleSubmit()">Login</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import axios from "axios";
import Cookies from "js-cookie";

export default {
  data() {
    return {
      username: "",
      pwd: ""
    };
  },
  methods: {
    login() {
      console.log("LOGIN");

      var params = {"username" : this.username, "pwd" : this.pwd};

      axios
        .post(
          "/api/v1/user/login",
          params
        )
        .then(response => {
          Cookies.set("userLogged", response.data);
          console.log("LOGGED");
        });
    },


    handleSubmit(){
      const { dispatch } = this.$store;
      const { username, pwd } = this;
      if (username != "" && pwd != ""){
        dispatch('authentication/login', { username, pwd });
        }
    }
  }
};
</script>