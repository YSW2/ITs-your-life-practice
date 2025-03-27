<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
    <div>결과 : {{ result }}</div>
  </div>
</template>

<script>
import { computed, ref } from 'vue';

export default {
  name: 'Calc3',
  setup() {
    const x = ref(10);
    const y = ref(20);
    const result = computed(() => {
      return x.value + y.value;
    });

    return { x, y, result };
  },
};
</script>

<style lang="scss" scoped></style>
