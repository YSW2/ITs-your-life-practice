class Pet {
  constructor(name, species, vaccination, healthCheckDate) {
    this.name = name;
    this.species = species;
    this.vaccination = vaccination;
    this.healthCheckDate = healthCheckDate;
    this.alreadyWarned = false;
  }
  addVaccination(vaccine) {
    if (this.vaccination.includes(vaccine)) {
      console.log(
        `[예방접종 중복] ${this.name}: ${vaccine}은 이미 등록되어 있습니다.`
      );
      return;
    }
    this.vaccination.push(vaccine);
    console.log(`[예방접종 추가] ${this.name}: ${vaccine}`);
  }
  updateHealthCheckDate(date) {
    this.healthCheckDate = date.toDateString();
    console.log(`[건강검진 업데이트] ${this.name}: ${date.toDateString()}`);
  }
}

class PetHealthManager {
  constructor() {
    this.petList = [];
  }
  registerPet(pet) {
    this.petList.push(pet);
    console.log(
      `[등록] ${pet.species} - ${pet.name} (예방접종: ${
        pet.vaccination
      }, 건강검진: ${pet.healthCheckDate.toDateString()})`
    );
  }
  checkHealthStatus() {
    for (let pet of this.petList) {
      new Promise((resolve) => setTimeout(resolve, 3000));

      if (!pet.alreadyWarned && isOverYear(new Date(), pet.healthCheckDate)) {
        console.log(
          `[건강검진 경고] ${pet.name}: 1년 이상 건강검진을 받지 않았습니다!`
        );
        pet.alreadyWarned = true;
      }
    }
    setTimeout(() => {
      console.log('[검사 종료]');
    }, 10000);
  }
}

const isOverYear = (before, after) =>
  before.getTime() - after.getTime() > 31536000000;

// 🐾 시스템 사용 예시
const manager = new PetHealthManager();

// 펫 등록
const pet1 = new Pet('나비', '고양이', ['종합백신'], new Date('2024-03-10'));
manager.registerPet(pet1);

// 예방접종 추가
pet1.addVaccination('광견병');
pet1.addVaccination('광견병'); // 중복 테스트

// 건강 상태 검사 시작
manager.checkHealthStatus();

// 5초 후 건강검진 업데이트 (경고 초기화 테스트)
setTimeout(() => {
  pet1.updateHealthCheckDate(new Date());
}, 5000);
