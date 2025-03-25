<template>
  <div id="app" class="container">
    <h1>카페 주문 앱</h1>
    <MenuList :menus="menus" @select-drink="selectHandler" />
    <div class="coffee-container">선택한 음료: {{ selected.name }}</div>
    <div v-if="selected">
      <DrinkOptions
        @options-changed="optionHandler"
        :selectedDrink="selected.name"
      />
      <div class="coffee-container">
        <h4>현재 선택 옵션:</h4>
        <p>사이즈: {{ selectedOptions.size }}</p>
        <p>추가샷: {{ selectedOptions.extraShot ? '있음' : '없음' }}</p>
        <p>얼음 양: {{ selectedOptions.ice }}</p>
      </div>
    </div>
    <OrderSummary
      class="mb-3"
      v-if="selected"
      :drink="selected"
      :optionData="selectedOptions"
      @place-order="submitOrder"
    />
    <OrderHistory class="mb-3" :orderHistory="orderHistory" />
    <button
      v-if="orderHistory.length > 0"
      class="btn mb-3"
      @click="toggleShowStats"
    >
      {{ showStats ? '통계 숨기기' : '통계 보이기' }}
    </button>
    <Statistics v-if="showStats" :orders="orderHistory" />
  </div>
</template>
<script>
import DrinkOptions from './components/DrinkOptions.vue';
import MenuList from './components/MenuList.vue';
import OrderHistory from './components/OrderHistory.vue';
import OrderSummary from './components/OrderSummary.vue';
import Statistics from './components/Statistics.vue';

export default {
  name: 'App',
  components: {
    MenuList,
    DrinkOptions,
    OrderSummary,
    OrderHistory,
    Statistics,
  },
  data() {
    return {
      menus: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
      ],
      selected: '',
      selectedOptions: {
        size: '',
        extraShot: '',
        ice: '',
      },
      orderHistory: [],
      showStats: false,
    };
  },
  methods: {
    selectHandler({ menu }) {
      this.selected = menu;
    },
    optionHandler({ selectedOptions }) {
      Object.assign(this.selectedOptions, selectedOptions);
    },
    submitOrder() {
      this.orderHistory.push({
        time: new Date().toLocaleString(),
        name: this.selected.name,
        size: this.selectedOptions.size,
        extraShot: this.selectedOptions.extraShot,
        ice: this.selectedOptions.ice,
        price: this.selected.price,
      });
    },
    toggleShowStats() {
      this.showStats = !this.showStats;
    },
  },
};
</script>
<style scoped>
.container {
  padding: 20px;
}
.coffee-container {
  background: rgba(243, 243, 243, 0.966);
  border: 1px solid lightgray;
  padding: 20px;
  margin-bottom: 20px;
}
.btn {
  background-color: #8fbc8f;
  color: white;
}
.btn :hover {
  background-color: #78a678;
}
</style>
