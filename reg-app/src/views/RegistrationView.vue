<template>
  <div class="login-container">
    <form
      action="submit"
      method="post"
      name="logForm"
      v-on:submit.prevent="onSubmit"
    >
      <h1>SIN UP</h1>
      <InputForm placehText="Username" @inputChanged="handleLoginFormEvent" />
      <InputForm placehText="Password" @inputChanged="handlePassFormEvent" />
      <SubmitButton :callback="signUp">Sign Up</SubmitButton>
    </form>
  </div>
</template>

<script>
import SubmitButton from "../components/SubmitButton.vue";
import InputForm from "../components/Input.vue";
import axios from "axios";

export default {
  components: {
    SubmitButton,
    InputForm,
  },
  mounted() {
   
  },
  data() {
    return {
      login: String,
      pass: String,
    };
  },
  methods: {
    signUp() {
      axios({
        method: "post",
        url: "http://localhost:8081/signup",
        data: {
          login: this.login,
          password: this.pass,
        },
      })
        .then((responce) => {
          console.log(responce);
        })
        .catch((e) => console.log(e));
    },
    handleLoginFormEvent(e) {
      this.login = e;
    },
    handlePassFormEvent(e) {
      this.pass = e;
    },
  },
};
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
  position: relative;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 50vh;
  margin: auto;
  background: #171717;
}
h1 {
  color: white;
  text-align: center;
  margin: 0;
  margin-top: 20px;
}
.login-container {
  background: #141414;
  max-width: 1600px;
  margin: auto;
}
</style>