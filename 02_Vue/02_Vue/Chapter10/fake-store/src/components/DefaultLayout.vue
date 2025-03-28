<template>
  <div class="content-container">
    <h1><font-awesome-icon v-if="icon" :icon="icon" /> {{ title }}</h1>
  </div>
</template>

<script setup>
const props = defineProps(['title', 'icon']);
</script>

<style scoped>
.content-container {
  padding-top: 30px;
  padding-left: 10px;
}
</style>
