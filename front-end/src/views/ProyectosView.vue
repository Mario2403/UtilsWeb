<template>
  <v-card outlined>
    <v-list :class="$vuetify.theme.dark ? 'dark-back' : 'light-back'">
      <v-list-item v-for="p in proyectos" :key="p.code">
        <v-row>
          <v-col cols="auto">
            <v-list-item-avatar>
              <v-icon large v-text="p.icon"></v-icon>
            </v-list-item-avatar>
          </v-col>
          <v-col cols="5">
            <v-list-item-content>
              <v-list-item-title>{{p.code + ' - ' + p.name}}</v-list-item-title>
              <v-list-item-subtitle v-text="p.name"></v-list-item-subtitle>
            </v-list-item-content>
          </v-col>
          <v-col cols="auto">
            <v-list-item-content>



                <v-tooltip bottom>
      <template v-slot:activator="{ on, attrs }">
        <v-btn text small
        v-bind="attrs"
        v-on="on">
                <v-icon class="pl-mail">mdi-email</v-icon>
                {{p.pl}}
              </v-btn>
      </template>
      <span>{{p.plEmail}}</span>
    </v-tooltip>
                </v-list-item-content>

          </v-col>
          <v-col justify="end" class="text-right">
            <v-btn icon class="icon-margin" right>
              <v-icon large :color="p.drive ? 'success' : 'error' ">mdi-google-drive</v-icon>
            </v-btn>

            <v-btn icon class="icon-margin" right>
              <v-icon large :color="p.wekan ? 'success' : 'error' ">mdi-developer-board</v-icon>
            </v-btn>

            <v-btn icon class="icon-margin" right>
              <v-icon large :color="p.mantis ? 'success' : 'error' ">mdi-bug</v-icon>
            </v-btn>

            <v-btn icon class="icon-margin" right>
              <v-icon large :color="p.gitlab ? 'success' : 'error' ">mdi-gitlab</v-icon>
            </v-btn>

            <v-btn icon class="icon-margin" right>
              <v-icon large>mdi-pencil</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-list-item>
    </v-list>
  </v-card>
</template>



<script>
export default {
  name: "proyectosView",

  data() {
    return {
      proyectos: []
    };
  },

  created() {
    this.proyectos = [
      {
        code: 1234,
        icon: "mdi-car",
        name: "Este es el primer proyecto",
        desc: "descripion del proyecto",
        wekan: true,
        drive: true,
        gitlab: true,
        mantis: false,
        pl: "Vicente Sáez",
        plEmail: "mariojuso2011@gmail.com"
      },
      {
        code: 3456,
        icon: "mdi-car",
        name: "Este es el segundo proyecto",
        desc: "descripion del proyecto",
        wekan: false,
        drive: false,
        gitlab: true,
        mantis: true,
        pl: "Pablo Arriaza",
        plEmail: "mariojuso2011@gmail.com"
      },
      {
        code: 6789,
        icon: "mdi-car",
        name: "Este es el tercero proyecto de esta app",
        desc: "descripion del proyecto",
        wekan: true,
        drive: false,
        gitlab: false,
        mantis: false,
        pl: "Santiago Lopez",
        plEmail: "mariojuso2011@gmail.com"
      },
      {
        code: 1111,
        icon: "mdi-car",
        name: "Este es el cuerto proyecto creado desde la app",
        desc: "descripion del proyecto",
        wekan: false,
        drive: false,
        gitlab: true,
        mantis: false,
        pl: "Montse Novo",
        plEmail: "mariojuso2011@gmail.com"
      },
      {
        code: 9809,
        icon: "mdi-car",
        name: "Este es el quinto proyecto de mentira",
        desc: "descripion del proyecto",
        wekan: false,
        drive: true,
        gitlab: true,
        mantis: true,
        pl: "Raúl Heras",
        plEmail: "mariojuso2011@gmail.com"
      },
      {
        code: 2345,
        icon: "mdi-car",
        name: "Otro proyecto",
        desc: "descripion del proyecto",
        wekan: false,
        drive: false,
        gitlab: true,
        mantis: false,
        pl: "Jose Luis Cambero",
        plEmail: "mariojuso2011@gmail.com"
      },
      {
        code: 5566,
        icon: "mdi-car",
        name: "Este es casi el ultimo proyecto",
        desc: "descripion del proyecto",
        wekan: true,
        drive: true,
        gitlab: true,
        mantis: false,
        pl: "Jose Muñoz",
        plEmail: "mariojuso2011@gmail.com"
      },
      {
        code: 3478,
        icon: "mdi-car",
        name: "Ahora si que si, este es el ultimo proyecto",
        desc: "descripion del proyecto",
        wekan: false,
        drive: false,
        gitlab: false,
        mantis: false,
        pl: "Pablo Arriaza",
        plEmail: "mariojuso2011@gmail.com"
      }
    ];
  }
};
</script>

<style scoped>
.light-back {
  background-color: #f5f5f5;
}
.dark-back {
  background-color: #272727;
}
.icon-margin {
  margin-left: 5px;
  margin-right: 5px;
}
.pl-mail {
  margin-right: 5px;
}
</style>