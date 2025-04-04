<template>
  <h2>스터디 등록</h2>
  <div class="add-study-container">
    <form @submit.prevent="handleAddStudy">
      <div class="add-input-container">
        스터디명 <br />
        <input type="text" required v-model="addStudyData.title" />
      </div>
      <div class="add-input-container">
        설명 <br />
        <textarea type="text" required v-model="addStudyData.desc"></textarea>
      </div>
      <div class="add-input-container">
        카테고리 <br />
        <!-- <input type="text" required v-model="addStudyData.category" /> -->
        <select name="category" v-model="addStudyData.category">
          <option value="">선택하세요</option>
          <option value="프론트엔드">프론트엔드</option>
          <option value="백엔드">백엔드</option>
          <option value="AI">AI</option>
          <option value="알고리즘">알고리즘</option>
          <option value="디자인">디자인</option>
          <option value="CS">CS</option>
          <option value="크리에이티브">크리에이티브</option>
          <option value="데이터 분석">데이터 분석</option>
          <option value="자격증">자격증</option>
          <option value="기타">기타</option>
        </select>
      </div>
      <div class="add-input-container">
        마감일 <br />
        <input type="date" required v-model="addStudyData.dueDate" />
      </div>
      <div class="add-input-container">
        최대 인원 수 <br />
        <input type="number" required v-model="addStudyData.max" />
      </div>
      <div class="button-container">
        <button class="add-button">등록하기</button
        ><button class="cancel-button">취소</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { inject } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const { fetchAddStudy, getStudyList } = inject('actions');
const addStudyData = {
  title: '',
  desc: '',
  category: '',
  dueDate: new Date(),
  createdAt: '',
  max: 0,
};

const checkValidate = () => {
  const { title, desc, category, dueDate } = addStudyData;

  if (title === '' || desc === '' || category === '' || dueDate === '') {
    alert('모든 항목을 입력해주세요');
    return false;
  }

  if (new Date(dueDate) < new Date()) {
    alert('마감일은 오늘 이후로 선택해주세요');
    return false;
  }

  return true;
};

const handleAddStudy = async () => {
  if (!checkValidate()) return;
  const result = await fetchAddStudy(addStudyData);
  if (result) {
    await getStudyList();
    router.push('/');
  }
};
</script>
<style scoped>
.add-input.container {
}
input,
textarea,
select {
  width: 100%;
  padding: 0.6rem;
  margin-bottom: 1rem;
  border: 1px solid #bbb;
  border-radius: 0.2rem;
}

.add-button {
  background-color: rgb(51, 105, 255);
  color: white;
  border: none;
  padding: 0.625rem;
  border-radius: 0.3rem;
  margin-right: 0.625rem;
}
.cancel-button {
  background-color: rgb(255, 255, 255);
  color: #888;
  border: 1px solid #888;
  padding: 0.625rem;
  border-radius: 0.3rem;
}
</style>
