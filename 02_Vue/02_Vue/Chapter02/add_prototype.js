// const ysw = {
//   firstName: 'sungwook',
//   lastName: 'yang',
//   getFullName: function () {
//     return `${this.firstName} ${this.lastName}`;
//   },
// };

// console.log(ysw.getFullName());

function user(first, last) {
  this.firstName = first;
  this.lastName = last;
}

//프로토타입에 추가된 함수는 객체 전체가 공유한다
user.prototype.getFullName = function () {
  return `${this.firstName} ${this.lastName}`;
};

const ysw = new user('sungwook', 'yang');
const jungwoo = new user('jungwoo', 'moon');

console.log(jungwoo.getFullName());
