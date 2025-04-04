<template>
  <div class="card-container">
    <div class="card-title"><h2>MBTI 궁합 테스트</h2></div>
    <div class="card-content">
      <form class="mbti-form-container" @submit.prevent="handleSearch">
        <div class="form-input-line">
          나의 MBTI <br />
          <select name="myMBTI" v-model="myMBTI" class="form-select">
            <option value="">선택하세요</option>
            <option v-for="mbti in mbtiList">
              {{ mbti }}
            </option>
          </select>
        </div>
        <div class="form-input-line">
          친구의 MBTI <br />
          <select name="friendMBTI" v-model="friendMBTI" class="form-select">
            <option value="">선택하세요</option>
            <option v-for="mbti in mbtiList">
              {{ mbti }}
            </option>
          </select>
        </div>
        <button type="submit" class="form-button">궁합 계산</button>
      </form>
    </div>
    <div v-if="myMBTI || friendMBTI" class="result-container">
      <div class="result-title">{{ myMBTI }} 💖 {{ friendMBTI }}</div>
      <div class="result-content">{{ matchMBTI.result }}</div>
      <div class="result-compatibility">
        {{ matchMBTI.compatibility === -1 ? '??' : matchMBTI.compatibility }}%
      </div>
    </div>
  </div>
</template>

<script setup>
import { useMbtiStore } from '@/stores/mbti.js';
import { storeToRefs } from 'pinia';
import { computed } from 'vue';

const MBTIStore = useMbtiStore();

const matchMBTI = computed(() => MBTIStore.matchMBTI);
const { myMBTI, friendMBTI } = storeToRefs(MBTIStore);
const { getMBTIMatch, mbtiList } = MBTIStore;

const handleSearch = () => {
  if (!(myMBTI.value === '' || friendMBTI.value === '')) {
    getMBTIMatch();
  } else {
    alert('MBTI를 모두 선택하세요');
  }
};
</script>

<style scoped>
.card-container {
  background-color: white;
  margin: 0 2rem;
  padding: 2rem;
  border-radius: 1rem;
  box-shadow: 0 1px 20px rgb(158, 158, 158);
  display: flex;
  flex-direction: column;
}
.card-title {
  color: #0d6efd;
  text-align: center;
}
.card-content {
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
}
.form-input-line {
  margin-bottom: 1rem;
  font-weight: bold;
}
.form-select {
  width: 100%;
  border: 1px solid rgb(208, 208, 208);
  padding: 0.5rem;
  border-radius: 0.4rem;
  margin: 0.6rem 0;
}
.form-button {
  background-color: #0d6efd;
  color: white;
  width: 100%;
  padding: 0.6rem 0.4rem;
  border-radius: 0.3rem;
  border: none;
}
.form-button:active {
  background-color: #0853c4;
}
.result-container {
  display: flex;
  flex-direction: column;
  gap: 0.6rem;
  background-color: #b5e6d3;
  border-radius: 0.3rem;
  border: 1px solid #5ec19b;
  text-align: center;
  padding: 1rem;
}
.result-title {
  font-size: 2rem;
  font-weight: bold;
}
</style>
