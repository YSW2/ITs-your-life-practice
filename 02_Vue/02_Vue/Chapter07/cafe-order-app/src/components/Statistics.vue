<template>
  <div class="card">
    <div class="card-body">
      <div class="card-title">
        <h4>주문 통계</h4>
      </div>
      <p class="card-text">총 주문 횟수: {{ orders.length }}회</p>
      <p class="card-text">총 매출: {{ totalPrice.toLocaleString() }}원</p>
      <p class="card-text">
        가장 인기 있는 음료: {{ bestMenu[0] }} ({{ bestMenu[1] }}회)
      </p>
      <p class="card-text">가장 많이 선택된 사이즈: {{ bestSize[0] }}</p>
      <p class="card-text">추가 샷 비율: {{ extraShotRate.toFixed(2) }}%</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Statistics',
  props: ['orders'],
  methods: {
    getStaticList(key) {
      const menuCountMap = new Map([]);

      this.orders.forEach((order) => {
        const value = order[key];
        menuCountMap.set(value, (menuCountMap.get(value) ?? 0) + 1);
      });

      return menuCountMap;
    },
  },
  computed: {
    totalPrice() {
      return this.orders.reduce((acc, cur) => cur.price + acc, 0);
    },
    bestMenu() {
      const menuStaticList = [...this.getStaticList('name')];
      menuStaticList.sort((a, b) => b[1] - a[1]);

      return menuStaticList[0] || ['', 0];
    },
    bestSize() {
      const sizeStaticList = [...this.getStaticList('size')];
      sizeStaticList.sort((a, b) => b[1] - a[1]);

      return sizeStaticList[0] || '';
    },
    extraShotRate() {
      const shotStaticList = this.getStaticList('extraShot');

      return ((shotStaticList.get(true) ?? 0) / this.orders.length) * 100;
    },
  },
};
</script>

<style scoped>
.card {
  background-color: #e6ffe6;
  border: 1px solid #8fbc8f;
}
</style>
