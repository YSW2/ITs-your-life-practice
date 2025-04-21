package ch06.sec08.ex03;

public class Car {
    int gas;

    void setGas (int gas) {
        this.gas = gas;
    }

    boolean isLeftGas () {
        if (gas == 0) {
            System.out.println("gas가 없습니다.");
            return false;
        }
        return true;
    }

    // 무한 루프를 돌면서 루프를 한 번 돌 때마다 gas의 값은 1 감소
// 주행이 가능한 상태라면 "달립니다.(gas잔량: xxx)" 출력
// 주행할 수 없는 상태라면 "멈춥니다.(gas잔량: xxx)" 출력 후 메소드를 종료
    void run () {
        System.out.println("gas가 있습니다.");
        System.out.println("출발합니다.");
        while (true) {
            if (isLeftGas()) {
                System.out.println("달립니다. (gas 잔량: " + this.gas + ")");
                this.gas -= 1;
            } else {
                System.out.println("멈춥니다. (gas 잔량: " + this.gas + ")");
                System.out.println("gas를 주입하세요");
                break;
            }
        }
    }
}