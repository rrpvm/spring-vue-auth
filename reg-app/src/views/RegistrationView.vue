<template>
  <div class="registration-container">
    <form
      action="submit"
      method="post"
      name="regForm"
      v-on:submit.prevent="onSubmit"
    >
      <h1>SIGN UP</h1>
      <InputForm name="login" placeholder="login" />
      <InputForm name="password" placeholder="password" type="password" />
      <SubmitButton :callback="doLogin">sign  up</SubmitButton>
    </form>
  </div>
</template>

<script>
import SubmitButton from "../components/SubmitButton.vue";
import InputForm from "../components/Input.vue";
export default {
  components: {
    SubmitButton,
    InputForm,
  },
  mounted() {
    console.log(this.$route.path);
  },
  methods: {
    doLogin() {},
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
.registration-container {
  background: #141414;
  max-width: 1600px;
  margin: auto;
}
</style>