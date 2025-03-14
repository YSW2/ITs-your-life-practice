import fs from 'node:fs';

const filePath = './logs/workout_log.txt';
const backupPath = './logs/backup_log.txt';

const rs = fs.createReadStream(filePath, 'utf-8').on('error', (err) => {
  console.log(`백업 중 오류가 발생했습니다. ${err}`);
});
const ws = fs.createWriteStream(backupPath).on('finish', () => {
  console.log('백업이 완료되었습니다.');
});

rs.pipe(ws);
