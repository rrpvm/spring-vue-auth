<template>
  <header>
    <div class="navbar-bar">
      <router-link to="/" class="navbar-item">
        <div>Home</div>
      </router-link>
      <router-link to="/signin" class="navbar-item" v-if="!isLogged">
        <div>Log in</div>
      </router-link>
      <router-link
        :to="{
          path: '/profile',
          name: 'profile',
          params: { id: this.$store.state.auth.id},
        }"
        class="navbar-item"
        v-if="isLogged"
      >
        <div>Profile</div>
      </router-link>
      <router-link
        to="/home"
        class="navbar-item"
        v-if="isLogged"
        @click="logOut"
      >
        <div>Log out</div>
      </router-link>
      <router-link to="/signup" class="navbar-item" v-if="!isLogged">
        <div>Sign up</div>
      </router-link>
    </div>
  </header>
</template>

<script>
import { isSessionValid } from "@/router";
import _event from "../event/eventListener.js";
export default {
  data() {
    return {
      isLogged: Boolean,
    };
  },
  methods: {
    async getLoggedState() {
      const value = await isSessionValid();
      this.isLogged = value;
      return value;
    },
    logOut() {
      this.$store.commit("setJwtToken", "");
      this.$store.commit("setUsernameToken", "");
      this.$store.commit("setUserId", -1);
      this.getLoggedState();
      this.$router.push("/signin");
    },
  },
  /*lifecycle hook before BEFORE_MOUNTED & MOUNTED*/ created() {
    this.getLoggedState();
    _event.on("userLogged", () => {
      this.getLoggedState();
    });
  },
};
</script>

<style>
header {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  width: 100%;
  max-width: 1600px;
  margin: 0 auto;
  background: #141414;
}
.navbar-bar {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: flex-end;
  width: 80%;
  background: #141414;
}
.navbar-item {
  padding: 20px 25px;
  background: #141414;
  text-decoration: none;
  color: rgb(250, 250, 250);
  cursor: pointer;
  transition: all 0.2s;
}
.navbar-item:hover {
  background: #971919;
}
</style>