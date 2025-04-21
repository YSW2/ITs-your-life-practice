<template>
  <div class="card-container">
    <div class="card-title">
      <h2>저장된 MBTI 궁합 결과</h2>
    </div>
    <div class="card-content">
      <div v-if="savedResults.length === 0" style="text-align: center">
        저장된 결과가 없습니다.
      </div>

      <ul class="list-group">
        <li
          v-for="{
            id,
            myMBTI,
            friendMBTI,
            result,
            compatibility,
          } in savedResults"
          class="list-group-item"
          :key="id"
        >
          <div v-if="myMBTI || friendMBTI" class="result-container">
            <div class="result-title">{{ myMBTI }} 💖 {{ friendMBTI }}</div>
            <div class="result-content">{{ result }}</div>
            <div class="result-compatibility">궁합률: {{ compatibility }}%</div>
          </div>
          <button @click="handleDeleteResult(id)" class="result-delete-button">
            삭제
          </button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { useMbtiStore } from '@/stores/mbti.js';
import { storeToRefs } from 'pinia';
import { onMounted } from 'vue';

const MBTIStore = useMbtiStore();

const { savedResults } = storeToRefs(MBTIStore);
const { getSavedResult, deleteSavedResult } = MBTIStore;

const handleDeleteResult = (id) => {
  if (confirm('정말 삭제하시겠습니까?')) {
    deleteSavedResult(id, getSavedResult);
  }
};

onMounted(() => {
  getSavedResult();
});
</script>

<style scoped>
.card-container {
  background-color: white;
  margin: 0 2rem;
  padding: 2rem;
  border-radius: 1rem;
  box-shadow: 0 1px 20px rgb(160, 160, 160);
  display: flex;
  flex-direction: column;
  gap: 1rem;
}
.card-title {
  color: #3ca21a;
  text-align: center;
}
.card-content {
  display: flex;
  flex-direction: column;
}
.list-group {
  display: flex;
  flex-direction: column;
  padding-left: 0;
  margin-bottom: 0;
  border-radius: 0.3rem;
}
.list-group-item {
  display: flex;
  padding: 0.75rem 1.25rem;
  justify-content: space-between;
  align-items: center;
  background-color: #fff;
  border: 1px solid rgba(0, 0, 0, 0.277);
}
.list-group-item:first-child {
  border-top-left-radius: inherit;
  border-top-right-radius: inherit;
}
.list-group-item:last-child {
  border-bottom-left-radius: inherit;
  border-bottom-right-radius: inherit;
}
/* 아이템 사이의 겹치는 테두리 제거 */
.list-group-item + .list-group-item {
  border-top-width: 0;
}
.result-container {
  display: flex;
  flex-direction: column;
  gap: 0.6rem;
  border-radius: 0.3rem;
  margin-right: 1rem;
}
.result-title {
  font-size: 1.3rem;
  font-weight: bold;
}
.result-delete-button {
  background-color: white;
  border: 1px solid red;
  color: red;
  padding: 0.3rem 0.4rem;
  border-radius: 0.3rem;
  text-wrap: nowrap;
}
.result-delete-button:active {
  border: 1px solid rgb(253, 136, 136);
  color: rgb(253, 136, 136);
}
</style>
