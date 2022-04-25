<template>
  <input v-model="bindedTxt" :placeholder="this.placehText" @input="$emit('inputChanged', this.bindedTxt)"/>
</template>

<script>
export default {
  name: "input-form",
  props:{
    placehText : String,
  },
  emits: ["inputChanged"],
  data() {
    return {
      bindedTxt: "",
    };
  },
};
</script>

<style scoped>
input {
  width: 33%;
  border: 2px solid rgb(111, 111, 255);
  box-shadow: 0px 0px 3px 0.5px rgb(69, 220, 247);
  border-radius: 20px;
  background: none;
  padding: 10px 30px;
  margin: 15px;
  color: white;
}
input::placeholder {
  font-size: 1rem;
  align-items: center;
  text-align: center;
  color: rgb(109, 109, 109);
}
</style>