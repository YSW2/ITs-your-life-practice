<template>
  <router-view />
</template>

<script setup>
import axios from 'axios';
import { computed, onMounted, provide, reactive } from 'vue';

const url = '/api/studies';

const states = reactive({ studyList: [] });

const getStudyList = async () => {
  try {
    const response = await axios.get(url);
    if (response.status === 200) {
      states.studyList = response.data;
    } else {
      throw 'GET 실패';
    }
  } catch (e) {
    console.error('getStudyList error', e);
  }
};

const getStudyDetail = async (id) => {
  try {
    const response = await axios.get(`${url}?id=${parseInt(id)}`);
    if (response.status === 200) {
      return response.data[0];
    } else {
      throw 'GET 실패';
    }
  } catch (e) {
    console.error('getStudyList error', e);
  }
};

const fetchAddStudy = async (study) => {
  const today = new Date().toISOString().split('T')[0];

  try {
    const response = await axios.post(url, {
      ...study,
      createdAt: today,
      likes: 0,
    });
    console.log(response.status);
    if (response.status === 201) {
      return true;
    }
  } catch (e) {
    console.error(e);
  }
};

const fetchLike = async (study) => {
  try {
    const response = await axios.put(`${url}?id=${parseInt(study.id)}`, {
      ...study,
      likes: study.likes + 1,
    });
    if (response.status < 300) {
      return true;
    }
  } catch (e) {
    console.error('fetchLike Error', e);
  }
};

provide('actions', { getStudyList, getStudyDetail, fetchAddStudy, fetchLike });
provide(
  'studyList',
  computed(() => states.studyList)
);

getStudyList();
</script>

<style scoped></style>
