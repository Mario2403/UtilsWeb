<template>
  <div>
    <v-card outlined max-width="320" :style="outlinedStyle">
      <v-card-title class="title-size">Conversor de Unidades</v-card-title>
      <v-card-actions>
        <v-row width="100%">
          <v-col>
            <v-card flat>
              <v-text-field
                id="styled-input"
                class="styled-input"
                label="Byte"
                suffix="B"
                v-model="conversor.Byte"
                @change="calcula('byte')"
              ></v-text-field>
            </v-card>
          </v-col>
        </v-row>
      </v-card-actions>
      <v-card-actions>
        <v-row width="100%">
          <v-col>
            <v-card flat>
              <v-text-field
                id="styled-input"
                class="styled-input"
                label="KiloByte"
                suffix="KB"
                v-model="conversor.KiloByte"
                @change="calcula('kilo')"
              ></v-text-field>
            </v-card>
          </v-col>
        </v-row>
      </v-card-actions>
      <v-card-actions>
        <v-row width="100%">
          <v-col>
            <v-card flat>
              <v-text-field
                id="styled-input"
                class="styled-input"
                label="MegaByte"
                suffix="MB"
                v-model="conversor.MegaByte"
                @change="calcula('mega')"
              ></v-text-field>
            </v-card>
          </v-col>
        </v-row>
      </v-card-actions>
      <v-card-actions>
        <v-row width="100%">
          <v-col>
            <v-card flat>
              <v-text-field
                id="styled-input"
                class="styled-input"
                label="GigaByte"
                suffix="GB"
                v-model="conversor.GigaByte"
                @change="calcula('giga')"
              ></v-text-field>
            </v-card>
          </v-col>
        </v-row>
      </v-card-actions>
      <v-card-actions>
        <v-row width="100%">
          <v-col>
            <v-card flat>
              <v-text-field
                id="styled-input"
                class="styled-input"
                label="TeraByte"
                suffix="TB"
                v-model="conversor.TeraByte"
                @change="calcula('tera')"
              ></v-text-field>
            </v-card>
          </v-col>
        </v-row>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "ByteConverter",
  data() {
    return {
      outlinedStyle: { border: "2px solid blue" },

      conversor: {
        units: [
          { name: "Bytes", symbol: "B" },
          { name: "KiloBytes", symbol: "KB" },
          { name: "MegaBytes", symbol: "MB" },
          { name: "GigaBytes", symbol: "GB" },
          { name: "TeraBytes", symbol: "TB" }
        ],
        Byte: "",
        KiloByte: "",
        MegaByte: "",
        GigaByte: "",
        TeraByte: ""
      }
    };
  },

  methods: {
    calcula(type) {
      if (type == "byte") {
        if (this.conversor.Byte == "") {
          this.conversor.KiloByte = "";
          this.conversor.MegaByte = "";
          this.conversor.GigaByte = "";
          this.conversor.TeraByte = "";
        } else {
          this.conversor.KiloByte = parseInt(this.conversor.Byte, 10) / 1024;
          this.conversor.MegaByte = parseInt(this.conversor.Byte, 10) / (1024 * 1024);
          this.conversor.GigaByte = parseInt(this.conversor.Byte, 10) / (1024 * 1024 * 1024);
          this.conversor.TeraByte = parseInt(this.conversor.Byte, 10) / (1024 * 1024 * 1024 * 1024);
        }
      } else if (type == "kilo") {
        if (this.conversor.KiloByte == "") {
          this.conversor.Byte = "";
          this.conversor.MegaByte = "";
          this.conversor.GigaByte = "";
          this.conversor.TeraByte = "";
        } else {
          this.conversor.Byte = parseInt(this.conversor.KiloByte, 10) * 1024;
          this.conversor.MegaByte = parseInt(this.conversor.KiloByte, 10) / 1024;
          this.conversor.GigaByte = parseInt(this.conversor.KiloByte, 10) / (1024 * 1024);
          this.conversor.TeraByte = parseInt(this.conversor.KiloByte, 10) / (1024 * 1024 * 1024);
        }
      } else if (type == "mega") {
        if (this.conversor.MegaByte == "") {
          this.conversor.Byte = "";
          this.conversor.KiloByte = "";
          this.conversor.GigaByte = "";
          this.conversor.TeraByte = "";
        } else {
          this.conversor.Byte = parseInt(this.conversor.MegaByte, 10) * 1024 * 1024;
          this.conversor.KiloByte = parseInt(this.conversor.MegaByte, 10) * 1024;
          this.conversor.GigaByte = parseInt(this.conversor.MegaByte, 10) / 1024;
          this.conversor.TeraByte = parseInt(this.conversor.MegaByte, 10) / (1024 * 1024);
        }
      } else if (type == "giga") {
        if (this.conversor.GigaByte == "") {
          this.conversor.Byte = "";
          this.conversor.KiloByte = "";
          this.conversor.MegaByte = "";
          this.conversor.TeraByte = "";
        } else {
          this.conversor.Byte = parseInt(this.conversor.GigaByte, 10) * 1024 * 1024 * 1024;
          this.conversor.KiloByte = parseInt(this.conversor.igaByte, 10) * 1024 * 1024;
          this.conversor.MegaByte = parseInt(this.conversor.igaByte, 10) * 1024;
          this.conversor.TeraByte = parseInt(this.conversor.igaByte, 10) / 1024;
        }
      } else if (type == "tera") {
        if (this.conversor.TeraByte == "") {
          this.conversor.Byte = "";
          this.conversor.KiloByte = "";
          this.conversor.MegaByte = "";
          this.conversor.GigaByte = "";
        } else {
          this.conversor.Byte = parseInt(this.conversor.TeraByte, 10) * 1024 * 1024 * 1024 * 1024;
          this.conversor.KiloByte = parseInt(this.conversor.TeraByte, 10) * 1024 * 1024 * 1024;
          this.conversor.MegaByte = parseInt(this.conversor.TeraByte, 10) * 1024 * 1024;
          this.conversor.GigaByte = parseInt(this.conversor.TeraByte, 10) * 1024;
        }
      }
    }
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
.title-size {
  font-size: 20pt;
}
</style>