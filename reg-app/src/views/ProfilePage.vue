<template>
  <div class="profile-main-container">
    <div class="profile-header">
      <div>
        <p> {{this.username}}</p>
        <img src="../assets/404.png">
      </div>
    </div>
    <div class="profile-body"></div>
    <div class="profile-history"></div>
   
  </div>
</template>

<script> 
import axios from 'axios';

export default {
  data(){
    return{
        username : String,
    }
  },
  async mounted(){
    const responce =  await axios( "http://localhost:8081"+ this.$route.fullPath);
    this.username = responce.data.username;
  }
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
.profile-header{
  display: flex;

}
</style>