<template>
  <div class="container">
    <div class="row">
      <tr>
        <td>
          <table id="head-table">
            <tr>
              <td>
                <table id="name-table" class="name-table">
                  <tr>
                    <td align="right">Nesterov Ivan, Р3231</td>
                  </tr>
                </table>
              </td>
            </tr>
            <tr>
              <td>
                <table id="variant-table" class="variant-table">
                  <tr>
                    <td>
                      <div id="var" align="right">Variant 34106</div>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>

.container {
  height: 100%;
  display: flex;
  flex-direction: column;
}

.row {
  background-color: navy;
}


</style>