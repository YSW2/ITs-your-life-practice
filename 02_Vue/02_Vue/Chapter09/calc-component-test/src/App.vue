<template>
  <div>
    <Calc />
    <Calc2 />
    <Calc3 />
  </div>
</template>
<script>
import Calc from './components/Calc.vue';
import Calc2 from './components/Calc2.vue';
import Calc3 from './components/Calc3.vue';

export default {
  name: 'App',
  components: { Calc, Calc2, Calc3 },
};
</script>
