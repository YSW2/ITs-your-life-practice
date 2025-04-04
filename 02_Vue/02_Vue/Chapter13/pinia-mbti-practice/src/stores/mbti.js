import axios from 'axios';
import { defineStore } from 'pinia';
import { computed, reactive, ref } from 'vue';

export const useMbtiStore = defineStore('mbti', () => {
  const BASEURL = '/api';
  const mbtiList = [
    'INFJ',
    'INFP',
    'INTJ',
    'INTP',
    'ISFJ',
    'ISFP',
    'ISTJ',
    'ISTP',
    'ENFJ',
    'ENFP',
    'ENTJ',
    'ENTP',
    'ESFJ',
    'ESFP',
    'ESTJ',
    'ESTP',
  ];
  const myMBTI = ref('');
  const friendMBTI = ref('');
  const matchMBTI = ref({
    id: 0,
    myMBTI: '',
    friendMBTI: '',
    result: '데이터 없음: 이 조합은 아직 분석되지 않았어요.',
    compatibility: -1,
  });
  const state = reactive({
    savedResults: [],
  });

  const getSavedResult = async () => {
    try {
      const response = await axios.get(BASEURL + '/savedResults');
      if (response.status === 200) {
        state.savedResults = response.data;
      }
    } catch (error) {
      console.error('getSavedResult error', error);
    }
  };

  const getMBTIMatch = async () => {
    try {
      const response = await axios.get(`${BASEURL}/matches`);
      if (response.status === 200) {
        const filteredResponse = response.data.filter(
          (mbti) =>
            mbti.myMBTI === myMBTI.value && mbti.friendMBTI === friendMBTI.value
        );

        if (filteredResponse.length === 0) {
          matchMBTI.value = {
            id: 0,
            myMBTI: '',
            friendMBTI: '',
            result: '데이터 없음: 이 조합은 아직 분석되지 않았어요.',
            compatibility: -1,
          };
        } else {
          matchMBTI.value = filteredResponse[0];
        }
      } else {
        console.error('response error', response);
      }
    } catch (error) {
      console.error('getSavedResult error', error);
    }
  };

  const savedResults = computed(() => state.savedResults);

  return {
    mbtiList,
    savedResults,
    matchMBTI,
    myMBTI,
    friendMBTI,
    getSavedResult,
    getMBTIMatch,
  };
});
