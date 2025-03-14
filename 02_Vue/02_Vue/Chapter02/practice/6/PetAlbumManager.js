import { promises } from 'node:fs';

export class PetAlbumManager {
  constructor() {
    this.petRecordList = [];
  }

  async addRecord(record) {
    let type = Object.keys(record).find((key) => key === 'photoPath')
      ? 'Photo'
      : 'Growth Record';

    if (type === 'Photo') {
      const result = this.petRecordList.find(
        (data) => data.photoPath === record.photoPath
      );

      if (result) {
        console.log(`[등록 오류] ${record.name}: 중복된 사진입니다.`);
        return;
      }
    } else if (type === 'Growth Record') {
      const result = this.petRecordList.find(
        (data) => data.description === record.description
      );

      if (result) {
        console.log(`[등록 오류] ${record.name}: 중복된 성장 기록입니다.`);
        return;
      }
    }
    this.petRecordList.push({ ...record, type });
    console.log(`[등록 완료] ${record.name}: ${type}가 등록되었습니다.`);

    await promises.writeFile(
      './pet_album.json',
      `${JSON.stringify(this.petRecordList)}`
    );
    console.log('[파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.');
  }
}
