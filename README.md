# 🚀 로또 2단계 - 수동 구매
로또 미션 진행을 위한 저장소

## 기능구현 목록

- ```
  구입 금액을 입력해 주세요.
  ```
  를 출력한다.
  
- 구입금액을 입력받는다.
  - 입력은 자연수여야 한다.
  - 1000원으로 나누어떨어지는 금액이어야 한다.
  
- ```
  수동으로 구매할 로또 수를 입력해 주세요.
  ```
  를 출력한다.


- 수동으로 구매할 로또 수를 입력받는다.
  - 0개 이상, (구입금액 / 1000) 이하의 자연수여야 한다.

- 구매한 모든 티켓의 로또 번호들을
  - 각 티켓의 번호들은 오름차순으로 정렬되어 출력되어야 한다.

- ```
  수동으로 구매할 번호를 입력해 주세요.
  ```
  를 출력한다.

- 수동으로 구매할 로또번호를 수동구매 티켓 수 만큼 반복해서 입력받는다.
  - 티켓 한 개를 입력받을 때 마다 로또티켓 객체를 만들어 저장해놓는다.
    - 각 로또 번호의 범위는 1 ~ 45이다.
    - 각 로또티켓의 로또번호 개수는 6개이다.
  
- 로또 구매 정보에 수동으로 구매한 로또 티켓들을 모두 저장한다.

- 자동구매 티켓들을 발급한다.
  
- 자동 구매 티켓들과 수동 구매 티켓들을 구분해서 저장한다.

- ```
  수동으로 A장, 자동으로 B개를 구매했습니다.
  ```
  를 출력한다.

- ```
  지난 주 당첨 번호를 입력해 주세요.
  ```
  를 출력한다.

- 지난 주 당첨 번호를 입력받는다.
  - 쉼표 + 스페이스를 구분자로 하여 입력받는다.
  - 입력을 토대로 당첨 로또를 발급한다.
  - 당첨 번호끼리는 중복되지 않아야 한다.

- ```
  보너스 볼을 입력해 주세요.
  ```
  를 출력한다.

- 보너스 볼을 입력받는다.
  - 보너스 볼은 당첨 번호와 중복되지 않아야 한다.

- 당첨 계산을 한다.
  - 각각의 등수에 당첨된 티켓의 개수를 센다.
  - 수익률 = 총 당첨 상금 / 총 구매 상금 

- ```
  당첨 통계
  ---------
  3개 일치 (5000원)- a개
  4개 일치 (50000원)- b개
  5개 일치 (1500000원)- c개
  5개 일치, 보너스 볼 일치(30000000원) - d개
  6개 일치 (2000000000원)- e개
  총 수익률은 x%입니다.
  ```
  를 출력한다.
