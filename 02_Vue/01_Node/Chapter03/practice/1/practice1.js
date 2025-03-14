import fs from 'node:fs';
import path from 'node:path';

const dir = './members/kim_jong_kook.txt';

fs.writeFileSync(dir, '김종국, 나이: 45, 체중: 80kg, 운동: 벤치프레스 100kg');
console.log('파일 생성 완료!');

const parsedDir = path.parse(dir);

console.log(`디렉터리 경로: ${parsedDir.dir}`);
console.log(`파일 이름: ${parsedDir.base}`);
console.log(`파일 확장자: ${parsedDir.ext}`);
console.log(`파일 이름(확장자 제외): ${parsedDir.name}`);
