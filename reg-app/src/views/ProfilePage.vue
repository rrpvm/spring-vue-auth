<template>
  <div class="profile-main-container">
    <div class="profile-header">
      <div>
        <p>{{ this.username }}</p>
        <img src="../assets/404.png" />
      </div>
    </div>
    <div class="profile-body"></div>
    <div class="profile-history"></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      username: String,
    };
  },
  watch: {
    async $route(to) {
      if (to.path != "/" && to.path.indexOf("profile") !== -1) {
        await this.getUserProfileData(); //on route change
      }
    },
  },
  async mounted() {
    await this.getUserProfileData(); //on mounted(dom generated)
  },
  methods: {
    async getUserProfileData() {
      if (this.$route.fullPath.indexOf("profile") == -1) return;
      try {
        const responce = await axios(
          "http://localhost:8081" + this.$route.fullPath
        ).catch((e) => {
          console.log(e);
        });
        if (responce.data === "") {
          throw "data null";
        }
        this.username = responce.data.username;
      } catch (e) {
        if (e === "data null") {
          this.$router.push("/404");
        }
      }
    },
  },
};
</script>

<style>
.profile-main-container {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 1600px;
  margin: 5px auto;
  border: 1px solid black;
}
.profile-header {
  display: flex;
}
</style>