<template>
  <button type="submit" @click="callback" class="submit-btn">
    <slot></slot>
  </button>
</template>

<script>
export default {
  name: "submit-button",
  props: {
    callback: Function,
  },
};
</script>

<style scoped>
.submit-btn {
  width: 33%;
  border: 1px solid green;
  border-radius: 5px;
  padding: 10px 30px;
  margin: 15px;
  background: none;
  font-weight: bold;
  font-size: 1.5rem;
  color: white;
  cursor: pointer;
}
</style>