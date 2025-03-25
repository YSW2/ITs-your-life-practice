<template>
  <div class="option-container">
    <h2>{{ selectedDrink }} 옵션 선택</h2>
    <p>사이즈:</p>
    <div class="mb-3">
      <label class="me-2">
        <input
          type="radio"
          value="small"
          name="size"
          v-model="selectedOptions.size"
          @change="$emit('options-changed', { selectedOptions })"
        />
        Small
      </label>
      <label class="me-2">
        <input
          type="radio"
          value="medium"
          name="size"
          v-model="selectedOptions.size"
          @change="$emit('options-changed', { selectedOptions })"
        />
        Medium </label
      ><label class="me-2">
        <input
          type="radio"
          value="large"
          name="size"
          v-model="selectedOptions.size"
          @change="$emit('options-changed', { selectedOptions })"
        />
        Large
      </label>
    </div>
    <div class="mb-3">
      <label
        ><input
          type="checkbox"
          v-model="selectedOptions.extraShot"
          @change="$emit('options-changed', { selectedOptions })"
        />
        샷 추가</label
      >
    </div>
    <div class="mb-3">
      <span>얼음 양: </span
      ><select
        name="ice"
        v-model="selectedOptions.ice"
        @change="$emit('options-changed', { selectedOptions })"
      >
        <option value="적게">적게</option>
        <option value="보통" selected>보통</option>
        <option value="많이">많이</option>
      </select>
    </div>
  </div>
</template>

<script>
export default {
  name: 'DrinkOptions',
  props: ['selectedDrink'],
  data() {
    return {
      selectedOptions: {
        size: 'medium',
        extraShot: false,
        ice: '적게',
      },
    };
  },
  mounted() {
    this.$emit('options-changed', { selectedOptions: this.selectedOptions });
  },
};
</script>
