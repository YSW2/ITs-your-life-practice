import { promises } from 'node:fs';

export class EducationManager {
  constructor() {
    this.programList = [];
  }

  registerProgram(program) {
    this.programList.push(program);
    console.log(`[등록 완료] 교육 과정: ${program.title}`);
  }

  completeProgramWithFunction(title) {
    console.log(this);

    const program = this.programList.filter((data) => data.title === title);

    program[0].isCompleted = true;
    console.log(`[이수 완료 - 일반 함수] ${title}`);
  }

  completeProgramWithArrowFunction = (title) => {
    console.log(this);

    const program = this.programList.filter((data) => data.title === title);

    program[0].isCompleted = true;
    console.log(`[이수 완료 - 화살표 함수] ${title}`);
  };

  async saveToFile() {
    await promises.writeFile(
      './education_records.json',
      `${JSON.stringify(this.programList)}`
    );
    console.log('[파일 저장 완료] 교육 기록이 파일로 저장되었습니다.');
  }
}
