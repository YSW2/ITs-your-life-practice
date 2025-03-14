const reserveLargeRoom = () => '✅ 대형 룸이 예약되었습니다.';

const reserveStandardSeat = () => '✅ 일반석이 예약되었습니다.';

export const getReservation = (man) => {
  if (man >= 5) return reserveLargeRoom;
  else return reserveStandardSeat;
};
