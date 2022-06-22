<template>
  <table id="main-table">
        <tr>
          <td>
            <table id="head-table">
              <Header/>
            </table>
          </td>
        </tr>
    <tr>
      <td>
        <table id="body-table" class="body-table">
          <tr class="background-with-shadow" id="background-tr">
            <td>
              <table class="background" id="background-table">
                <tr>
                  <td>
                    <div id="svg-picture">
                      <svg id="svg" width="386" height="386" xmlns="http://www.w3.org/2000/svg" @click="clickOnSVG">

                        <polygon points="193,333 193,193 333,193" class="svg-figure-color" stroke-width="2"></polygon>
                        <polygon points="53,193 53,53 193,53 193,193" class="svg-figure-color" stroke-width="2"></polygon>
                        <path d="M193 193 L 333 193 C 333 193 333 53 193 53" class="svg-figure-color" stroke-width="2"></path>
                        <!-- d="M150 150 L 270 150 C 270 150 270 30 150 30" -->

                        <line class="svg-line-color" x1="193" y1="0" x2="193" y2="386"/>
                        <line class="svg-line-color" x1="0" y1="193" x2="386" y2="193"/>
                        <polygon class="svg-line-color" points="383 193 367 183 367 203"/>
                        <polygon class="svg-line-color" points="193 3 183 20 203 20"/>

                        <line class="svg-line-color" x1="263" y1="198" x2="263" y2="188"/>
                        <line class="svg-line-color" x1="333" y1="198" x2="333" y2="188"/>
                        <line class="svg-line-color" x1="123" y1="198" x2="123" y2="188"/>
                        <line class="svg-line-color" x1="53" y1="198" x2="53" y2="188"/>
                        <line class="svg-line-color" x1="198" y1="263" x2="188" y2="263"/>
                        <line class="svg-line-color" x1="198" y1="333" x2="188" y2="333"/>
                        <line class="svg-line-color" x1="198" y1="123" x2="188" y2="123"/>
                        <line class="svg-line-color" x1="198" y1="53" x2="188" y2="53"/>

                        <text class="svg-text" font-size="15" x="367" y="177">X</text>
                        <text class="svg-text" font-size="15" x="204" y="19">Y</text>
                        <text class="svg-text" font-size="15" x="204" y="58">R</text>
                        <text class="svg-text" font-size="15" x="204" y="128">R/2</text>
                        <text class="svg-text" font-size="15" x="204" y="268">-R/2</text>
                        <text class="svg-text" font-size="15" x="204" y="338">-R</text>
                        <text class="svg-text" font-size="15" x="328" y="177">R</text>
                        <text class="svg-text" font-size="15" x="250" y="177">R/2</text>
                        <text class="svg-text" font-size="15" x="105" y="177">-R/2</text>
                        <text class="svg-text" font-size="15" x="42" y="177">-R</text>
                      </svg>
                    </div>
                  </td>
                  <td colspan="2">
                    <table id="numbers-table" class="background">
                      <tr class="numbers">
                        <td>X:</td>
                        <td>
                          <table id="x-table">
                            <tr>
                              <td>
                                <label> <input name="xCheckbox" v-model="param_x" class="defaultBox"
                                               type="checkbox" value="-2" checked :disabled="hasAdditionalX">
                                  <p>
                                    -2
                                  </p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="xCheckbox" v-model="param_x" type="checkbox"
                                         value="-1.5" :disabled="hasAdditionalX">
                                  <p>
                                    -1.5
                                  </p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="xCheckbox" v-model="param_x" type="checkbox"
                                         value="-1" :disabled="hasAdditionalX">
                                  <p>
                                    -1
                                  </p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="xCheckbox" v-model="param_x" type="checkbox"
                                         value="-0.5" :disabled="hasAdditionalX">
                                  <p>-0.5</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="xCheckbox" v-model="param_x" type="checkbox"
                                         value="0" :disabled="hasAdditionalX">
                                  <p>0</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="xCheckbox" v-model="param_x" type="checkbox"
                                         value="0.5" :disabled="hasAdditionalX">
                                  <p>0.5</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="xCheckbox" v-model="param_x" type="checkbox"
                                         value="1" :disabled="hasAdditionalX">
                                  <p>1</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="xCheckbox" v-model="param_x" type="checkbox"
                                         value="1.5" :disabled="hasAdditionalX">
                                  <p>1.5</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="xCheckbox" v-model="param_x" type="checkbox"
                                         value="2" :disabled="hasAdditionalX">
                                  <p>2</p>
                                </label>
                              </td>
                              <td colspan = "2">
                                <button class="button" @click="undoX">Reset</button>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <tr>
                        <td>Y:</td>
                        <td>
                          <input type="text" id="inputY" name="y" maxlength="17" autocomplete="off"
                                 placeholder="Enter value y ∈ (-5; 5):" v-model="param_y">
                        </td>
                      </tr>
                      <tr class="numbers">
                        <td>R:</td>
                        <td>
                          <table id="r-table">
                            <tr>
                              <td>
                                <label> <input name="rCheckbox" v-model="param_r" type="checkbox"
                                               value="-2" :disabled="hasAdditionalR">
                                  <p>-2</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="rCheckbox" v-model="param_r" type="checkbox"
                                         value="-1.5" :disabled="hasAdditionalR">
                                  <p>-1.5</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="rCheckbox" v-model="param_r" type="checkbox"
                                         value="-1" :disabled="hasAdditionalR">
                                  <p>-1</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="rCheckbox" v-model="param_r" type="checkbox"
                                         value="-0.5" :disabled="hasAdditionalR">
                                  <p>-0.5</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="rCheckbox" v-model="param_r" type="checkbox"
                                         value="0" :disabled="hasAdditionalR">
                                  <p>0</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="rCheckbox" v-model="param_r" type="checkbox"
                                         value="0.5" :disabled="hasAdditionalR">
                                  <p>0.5</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="rCheckbox" v-model="param_r" type="checkbox" class="defaultBox"
                                         value="1" :disabled="hasAdditionalR">
                                  <p>1</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="rCheckbox" v-model="param_r" type="checkbox"
                                         value="1.5" :disabled="hasAdditionalR">
                                  <p>1.5</p>
                                </label>
                              </td>
                              <td>
                                <label>
                                  <input name="rCheckbox" v-model="param_r" type="checkbox"
                                         value="2" :disabled="hasAdditionalR">
                                  <p>2</p>
                                </label>
                              </td>
                              <td colspan = "3" class="tr-for-buttons">
                                <button class="button" @click="undoR">
                                  Reset
                                </button>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <tr class="tr-for-buttons">
                        <td colspan="2">
                          <button class="button" @click="goBack">
                            Log out
                          </button>
                        </td>
                        <td colspan="2">
                          <button class="button" id="submit" @click="submit">
                            Submit result
                          </button>
                        </td>
                        <td colspan="2">
                          <button class="button" id="reset" @click="clear">
                            Clear
                          </button>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td rowspan="2" class="background" id="result-td">
              <div id="result-div">
                <table id="result-table" class="result-style">
                  <thead>
                  <tr>
                    <th id="real-time" class="result-style">Request time</th>
                    <th id="X" class="result-style">X</th>
                    <th id="Y" class="result-style">Y</th>
                    <th id="R" class="result-style">R</th>
                    <th id="flag" class="result-style">Result</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr v-for="point in data" :key="point">
                    <td>{{ point.time }}</td>
                    <td>{{ point.x }}</td>
                    <td>{{ point.y }}</td>
                    <td>{{ point.r }}</td>
                    <td>{{ point.answer }}</td>
                  </tr>
                  </tbody>
                </table>
              </div>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</template>

<script>
import Header from "@/components/Header";

export default {
  components: {
    Header
  },
  name: 'Main',
  data() {
    return {
      param_x: [-2],
      param_y: "",
      param_r: [1],
      data: new Array(0)
    }
  },
  watch: {
    param_r(val) {
      if (val.length > 0 && !isNaN(val[0]) && parseFloat(val[0]) > 0 && parseFloat(val[0]) <= 3) {
        this.drawAll();
      }
    }
  },
  methods: {
    undoR(){
      this.param_r = [];
    },
    undoX(){
      this.param_x = [];
    },
    goBack(){
      localStorage.removeItem("par");
      this.$router.push({name: 'auth-page'});
    },
    clickOnSVG() {
      if (this.checkR(this.param_r)) {
        this.param_x[0] = (event.offsetX - 193) / 140 * this.param_r[0];
        this.param_y = (193 - event.offsetY) / 140 * this.param_r[0];
        this.sendRequestWithArgs();
      } else {
        alert('Выберите радиус R!');
      }
    },
    sendRequestWithArgs() {
      const requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/json", "Authorization": "Bearer " + localStorage.getItem("par")},
        body: JSON.stringify({"x": this.param_x[0], "y": this.param_y, "r": this.param_r[0]})
      };
      fetch("/api/data/add-data", requestOptions)
          .then(response => {
            if (response.ok) return response;
            else {
              let error = new Error(response.statusText);
              error.response = response;
              throw error
            }
          }).then(() => (this.loadData())).catch((e) => {
        this.showError(e.response);
      });
    },
    loadData() {
      const requestOptions = {
        method: "GET",
        headers: {"Authorization": "Bearer " + localStorage.getItem("par")},
      };
      fetch("/api/data/get-data", requestOptions)
          .then(response => {
            if (response.ok) return response.json();
            else {
              let error = new Error(response.statusText);
              error.response = response;
              throw error
            }
          }).then(data => {
        this.data = data;
        this.drawAll();
      }).catch((e) => {
        this.showError(e.response);
      });
    },
    drawAll() {
      this.deletePointsFromSVG();
      if (this.data.length !== 0) {
        for (let i = 0; i < this.data.length; i++) {
          let point = this.data[i];
          const x = point.x;
          const y = point.y;
          const r = point.r;
          const ans = point.answer;
          let flagForR;
          let flagForColor;
          if (!isNaN(x) && !isNaN(y)) {
            flagForColor = ans.includes("да");
            if (this.param_r.length > 0) {
              flagForR = (this.param_r[0] == r);
              this.drawPoint(x, y, this.param_r[0], flagForColor, flagForR);
            } else {
              flagForR = (1 == r);
              this.drawPoint(x, y, 1, flagForColor, flagForR);
            }
          }
        }
      }
    },
    drawPoint(x, y, r, flagForColor, flagForR) {
      let point = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
      point.setAttribute('cx', (193 + 140 * x / r).toString());
      point.setAttribute('cy', (193 - 140 * y / r).toString());
      //point.setAttribute('r', 4 .toString());
      point.setAttributeNS(null, 'r', '4');
      point.setAttribute('data-x', x);
      point.setAttribute('data-y', y);
      if (!flagForR) point.classList.add("old-coord");
      else if (flagForColor)
        point.classList.add("good-coord");
      else point.classList.add("bad-coord");
      document.getElementById("svg").appendChild(point);
    },
    deletePointsFromSVG() {
      document.querySelectorAll(".good-coord").forEach(x => x.remove());
      document.querySelectorAll(".bad-coord").forEach(x => x.remove());
      document.querySelectorAll(".old-coord").forEach(x => x.remove());
    },
    clear() {
      const requestOptions = {
        method: "DELETE",
        headers: {"Authorization": "Bearer " + localStorage.getItem("par")},
      };
      fetch("/api/data/delete", requestOptions)
          .then(() => {
            //document.getElementById('result-table').getElementsByTagName("tbody")[0].remove();
            this.data = [];
            document.getElementById("inputY").value = "";
            document.querySelector("#inputY").classList.remove('errorY');
            document.querySelectorAll('input[name="rCheckbox"]').forEach(r => r.checked = false);
            document.querySelectorAll('input[name="xCheckbox"]').forEach(x => x.checked = false);
            document.querySelectorAll('.defaultBox').forEach(x => x.checked = true);
            this.deletePointsFromSVG();
          });
    },

    checkY(y) {
      const MAX = 5;
      const MIN = -5;
      if (!isNaN(y) && parseFloat(y) > MIN && parseFloat(y) < MAX) {
        document.querySelector('#inputY').classList.remove('errorY');
        return true;
      } else {
        document.querySelector('#inputY').classList.add('errorY');
        this.showError("Check if y ∈ (-5; 5)")
        return false;
      }
    },

    checkR(r) {
      const MAX = 4;
      const MIN = -4;
      if (r.length > 0 && !isNaN(r[0]) && parseFloat(r[0]) >= MIN && parseFloat(r[0]) <= MAX)
        return true;
      else {
        this.showError("Check if r ∈ [-4;4]")
        return false;
      }
    },

    checkX(x) {
      const MAX = 4;
      const MIN = -4;
      if (x.length > 0 && !isNaN(x[0]) && parseFloat(x[0]) >= MIN && parseFloat(x[0]) <= MAX)
        return true;
      else {
        this.showError("Check if x ∈ [-4;4]")
        return false;
      }
    },
    submit() {
      if (this.checkX(this.param_x) && this.checkY(this.param_y) && this.checkR(this.param_r)) this.sendRequestWithArgs();
    },
    showError(text){
      this.$notify({
        group: "error",
        title: 'Error',
        text: text,
        type: 'error'
      });
    }
  },
  computed: {
    hasAdditionalR() {
      return this.param_r.length > 0
    },
    hasAdditionalX() {
      return this.param_x.length > 0
    }
  },
  mounted() {
    document.querySelectorAll('.defaultBox').forEach(x => {
      x.checked = true;
    });
    this.loadData();
  }
}
</script>
<style>
.body {
  color: darkslateblue;
  font-size: 26px;
  font-family: "Open Sans", cursive;
  background-color: #FFEBCD;
}

table {
  color: #FFF2F8;
  font-size: 26px;
  font-family: "Courier New", cursive, bold;
  margin: auto;
  padding: 10px;
  border-radius: 10px;
  border-spacing: 10px;
  table-layout: auto;
}

#body-table {
  table-layout: fixed;
  height: 80%;
}

input[type='radio'] {
  padding: 7%;
  margin: 7%;
}

.good-coord {
  stroke: black;
  fill: green;
}

.bad-coord {
  stroke: black;
  fill: red;
}

.old-coord {
  stroke: black;
  fill: dodgerblue;
}

input[type='text'] {
  font-family: cursive;
  display: inline-block;
}

.tr-for-buttons{
  text-align: left;
}

#head-table {
  width: 100%;
  border-spacing: 0;
  padding-top: 0;
}

#body-table {
  font-size: 20px;
  margin: auto;
  height: 550px;
}

.body-table {
  background-color: navy;
}

#numbers-table {
  padding: 0;
  margin: 0;
  width: 100%;
  font-size: 20px;
}

table#numbers-table{
  color: navy;
}

.background-with-shadow {
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  box-shadow: 0 0 8px 8px #f1d2ff inset;
}

.background {
  width: 50%;
  background: mediumblue;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  border-radius: 10px;
}

select {
  width: 165px;
}

.numbers {
  text-align: center;
  vertical-align: middle;
}

.button {
  font-family: cursive;
  font-weight: 700;
  text-decoration: none;
  padding: .8em 1em calc(.8em + 3px);
  border-radius: 3px;
  background: #FFF2F8;
  box-shadow: 0 -3px dodgerblue inset;
  transition: 0.2s;
}

.button:hover {
  background: #b4ffb3;
}

.button:active {
  outline: none;
  background: dodgerblue;
  box-shadow: 0 3px dodgerblue inset;
}

.result-style tbody td {
  border-collapse: collapse;
  border: 4px solid darkslateblue;
  font-size: 20px;
}

.result-style tbody th {
  border-collapse: collapse;
  border: 4px solid darkslateblue;
  font-size: 20px;
}

.errorY {
  border-color: red;
  background-color: deeppink;
}


.imagine3 {
  width: 210px;
  height: 210px;
}

#result-table::first-line {
  text-transform: uppercase;
  font-weight: bold;
}

#result-table {
  border-collapse: collapse;
  text-align: center;
  border: 4px solid darkslateblue;
  font-size: 20px;
  width: 100%;
  table-layout: fixed;
}

#r-table, #x-table {
  padding: 0;
  margin: 0;
  table-layout: fixed;
  font-size: 20px;
}

::-webkit-scrollbar {
  width: 10px;
}

::-webkit-scrollbar-track {
  box-shadow: inset 0 0 6px darkslateblue;
}

::-webkit-scrollbar-thumb {
  box-shadow: inset 0 0 6px darkslateblue;
}

#result-div {
  overflow-x: auto;
  height: 300px;
}

#result-td {
  width: 100%;
}

.svg-line-color {
  stroke: darkslateblue;
}

.svg-figure-color {
  fill: #FFF2F8;
  stroke: navy;
}

</style>