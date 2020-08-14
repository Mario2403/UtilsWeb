<template>
  <div>
    <v-card max-width="320">
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
                v-model="Byte"
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
                v-model="KiloByte"
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
                v-model="MegaByte"
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
                v-model="GigaByte"
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
                v-model="TeraByte"
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
      Byte: "",
      KiloByte: "",
      MegaByte: "",
      GigaByte: "",
      TeraByte: "",

      conversor: {
        units: [
          { name: "Bytes", symbol: "B" },
          { name: "KiloBytes", symbol: "KB" },
          { name: "MegaBytes", symbol: "MB" },
          { name: "GigaBytes", symbol: "GB" },
          { name: "TeraBytes", symbol: "TB" }
        ]
        // Byte:10,
        // Kilobyte:45,
        // MegaByte:0,
        // GigaByte:0,
        // TeraByte:0
      }
    };
  },

  methods: {
    calcula(type) {
      if (type == "byte") {
        if (this.Byte == "") {
          this.KiloByte = "";
          this.MegaByte = "";
          this.GigaByte = "";
          this.TeraByte = "";
        } else {
          this.KiloByte = parseInt(this.Byte, 10) / 1024;
          this.MegaByte = parseInt(this.Byte, 10) / (1024 * 1024);
          this.GigaByte = parseInt(this.Byte, 10) / (1024 * 1024 * 1024);
          this.TeraByte = parseInt(this.Byte, 10) / (1024 * 1024 * 1024 * 1024);
        }
      } else if (type == "kilo") {
        if (this.KiloByte == "") {
          this.Byte = "";
          this.MegaByte = "";
          this.GigaByte = "";
          this.TeraByte = "";
        } else {
          this.Byte = parseInt(this.KiloByte, 10) * 1024;
          this.MegaByte = parseInt(this.KiloByte, 10) / 1024;
          this.GigaByte = parseInt(this.KiloByte, 10) / (1024 * 1024);
          this.TeraByte = parseInt(this.KiloByte, 10) / (1024 * 1024 * 1024);
        }
      } else if (type == "mega") {
        if (this.MegaByte == "") {
          this.Byte = "";
          this.KiloByte = "";
          this.GigaByte = "";
          this.TeraByte = "";
        } else {
          this.Byte = parseInt(this.MegaByte, 10) * 1024 * 1024;
          this.KiloByte = parseInt(this.MegaByte, 10) * 1024;
          this.GigaByte = parseInt(this.MegaByte, 10) / 1024;
          this.TeraByte = parseInt(this.MegaByte, 10) / (1024 * 1024);
        }
      } else if (type == "giga") {
        if (this.GigaByte == "") {
          this.Byte = "";
          this.KiloByte = "";
          this.MegaByte = "";
          this.TeraByte = "";
        } else {
          this.Byte = parseInt(this.GigaByte, 10) * 1024 * 1024 * 1024;
          this.KiloByte = parseInt(this.GigaByte, 10) * 1024 * 1024;
          this.MegaByte = parseInt(this.GigaByte, 10) * 1024;
          this.TeraByte = parseInt(this.GigaByte, 10) / 1024;
        }
      } else if (type == "tera") {
        if (this.TeraByte == "") {
          this.Byte = "";
          this.KiloByte = "";
          this.MegaByte = "";
          this.GigaByte = "";
        } else {
          this.Byte = parseInt(this.TeraByte, 10) * 1024 * 1024 * 1024 * 1024;
          this.KiloByte = parseInt(this.TeraByte, 10) * 1024 * 1024 * 1024;
          this.MegaByte = parseInt(this.TeraByte, 10) * 1024 * 1024;
          this.GigaByte = parseInt(this.TeraByte, 10) * 1024;
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