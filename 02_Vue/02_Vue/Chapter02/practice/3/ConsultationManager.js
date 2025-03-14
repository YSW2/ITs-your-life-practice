export class ConsultationManager {
  constructor() {
    this.customerList = [];
  }

  findDuplication(customer) {
    for (let data of this.customerList) {
      if (data.name === customer.name) return true;
    }
    return false;
  }

  checkPhoneNumber(phone) {
    let parsedPhone = phone.split('-');

    return !(
      parsedPhone[0] !== '010' ||
      parsedPhone[1].length !== 4 ||
      parsedPhone[2].length !== 4
    );
  }
  registerConsultation(customer) {
    if (this.findDuplication(customer)) {
      console.log(
        `[상담 중복 오류] ${customer.name}: 이미 등록된 상담 기록입니다.`
      );
      return;
    }
    if (!this.checkPhoneNumber(customer.phone)) {
      console.log(
        `[상담 등록 오류] ${customer.name}: 잘못된 전화번호 형식입니다.`
      );
      return;
    }
    console.log(`[상담 등록] ${customer.name} - 선호 펫: ${customer.pet}`);
    setTimeout(() => {
      console.log(`[저장 완료] 홍길동 상담 기록 저장 완료!`);
    }, 1000);
    this.customerList.push(customer);
  }

  autoEndConsultation() {
    setTimeout(() => console.log('[상담 기록 저장 종료]'), 5000);
  }
}
