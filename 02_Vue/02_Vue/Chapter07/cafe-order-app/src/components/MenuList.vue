<template>
  <div class="menu-container">
    <h2>메뉴 선택</h2>
    <input
      class="menu-button"
      v-for="menu in menus"
      type="button"
      :key="menu.name"
      @click="$emit('select-drink', { menu })"
      :value="`${menu.name} (${menu.price}원)`"
    />
  </div>
</template>
<script>
export default {
  name: 'MenuList',
  props: ['menus'],
  data() {
    return {};
  },
};
</script>
