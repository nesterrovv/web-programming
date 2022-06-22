<template>
  <div class="container">
    <div class="row">
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
              <tr class="background" id="background-tr">
                <td>
                  <table>
                    <tr>
                      <td colspan="3" class="title">
                        <h2>Authorization</h2>
                      </td>
                    </tr>
                    <td>Login:</td>
                    <td>
                      <input type="text" id="loginInput" maxlength="17" autocomplete="off"
                             placeholder="Enter login" v-model.trim="login">
                    </td>
                    <tr>
                      <td>Password:</td>
                      <td>
                        <input type="password" id="password" maxlength="17" autocomplete="off"
                               placeholder="Enter password" v-model.trim="password">
                      </td>
                    </tr>
                    <tr>
                      <td colspan="2">
                        <button class="button" id="logIn" @click="logIn">
                          Sign in
                        </button>
                      </td>
                      <td colspan="3">
                        <button class="button" id="createUser" @click="createUser">
                          Sign up
                        </button>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";
export default {
  components: {
    Header,
  },
  name: "Index",
  data(){
    return{
      login: "",
      password: ""
    }
  },
  methods: {
    createUser(e) {
      e.preventDefault()
      const requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username: this.login, password: this.password})
      };
      fetch("/api/user/new-user", requestOptions)
          .then(response => {
            if (response.ok) return response.text();
            else {
              let error = new Error(response.statusText);
              error.response = response;
              throw error
            }
          }).then(data => {
        localStorage.setItem("par", data);
        this.$router.push({name: 'main-page'});
      }).catch((e) => {
        localStorage.removeItem("par");
        this.$notify({
          group: "error",
          title: 'Error',
          text: e.message,
          type: 'error'
        });
      });
    },
    logIn(e) {
      e.preventDefault()
      const requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username: this.login, password: this.password})
      };
      fetch("/api/user/user", requestOptions)
          .then(response => {
            if (response.ok) return response.text();
            else {
              let error = new Error(response.statusText);
              error.response = response;
              throw error
            }
          }).then(data => {
        localStorage.setItem("par", data);
        this.$router.push({name: 'main-page'});
      }).catch((e) => {
        localStorage.removeItem("par");
        this.$notify({
          group: "error",
          title: 'Error',
          text: e.message,
          type: 'error'
        });
      });
    }
  }
}
</script>

<style scoped>
input[type='password'] {
  font-family: cursive;
  display: inline-block;
}

.container {
  height: 100%;
  display: flex;
  flex-direction: column;
}


</style>