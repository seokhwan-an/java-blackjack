# java-blackjack

## 🃏블랙잭 미션 저장소

## 🚀프로젝트 설명

---
블랙잭 게임을 변형한 프로그램을 구현하는 프로젝트이다. 
블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임입니다.
### 💡소프트 17 규칙
딜러는 첫 두장에 받은 카드 중 Ace가 포함되어 있다면 Ace카드 값을 11로 생각한다. 단, Ace 카드가 2장이 들어온 경우 하나만 11로 판단한다.

## 📝기능 목록

---

### 참가자 (추상클래스)
- [x] 참가자는 카드를 받는다.
- [x] 자기 자신의 점수를 계산한다.
- [x] 자신이 ACE 카드를 가지고 있는지 판단한다.
- [x] 자기 자신이 카드를 받을 수 있는지 판단한다.

### 참가자 이름
- [x] 참가자의 이름을 검증한다.
  - [x] null,빈 공간 체크
  - [x] 한글, 영어, 숫자 체크
  
### 플레이어 (참가자 클래스 상속)
- [x] 플레이어는 카드를 받는다.
- [x] 자신 점수 계산하기
  - [x] 에이스 카드를 1로 할지 혹은 11로 할지를 결정한다.
  - [x] 21에 가까운 숫자를 계산하기

### 배팅금액
- [x] 플레이어의 배팅 금액을 가지고 있는다.
  - [x] 배팅 금액은 정수의 숫자만을 가진다.
  - [x] 배팅 금액은 음수가 아니다.

### 딜러 (참가자 클래스 상속)
- [x] 딜러는 카드를 받는다.
- [x] 자신 점수 계산하기
  - [x] 딜러는 (처음 받은 2장이) 16이하의 숫자이면 무조건 카드 한장을 추가로 받아야 하고 17이상이면 추가로 받을 수 없다.
  - [x] 에이스 카드를 1로 할지 혹은 11로 할지를 결정한다.
  - [x] 21에 가까운 숫자를 계산한다.
- [x] 자신과 플레이어의 승패를 판단한다.
  - [x] 블랙잭인지 판단한다.

### 카드
- [x] 랜덤한 카드를 제공한다.
  - [x] 카드는 6개의 카드 뭉치를 사용한다.

### 결과 판독기
- [x] 딜러과 플레이어의 결과를 판독한다.
  - [x] 딜러가 이기는 조건
    - 딜러의 점수가 21이하일 때 딜러가 플레이어보다 점수가 높은 경우
    - 딜러의 점수가 21이하일 때 플레이어의 점수가 21초과인 경우
    - 딜러가 블랙잭이고 플레이어가 블랙잭이 아닌 경우
    - 둘 다 버스트인 경우
  - [x] 딜러와 플레이어가 비기는 경우
    - 딜러와 플레이어의 점수가 모두 21미만이고 같은 경우
    - 둘 다 블랙잭인 경우
    - 둘 다 블랙잭이 아닌 21점을 가지는 경우
  - [x] 딜러가 지는 조건
    - 플레이어의 점수가 21이하일 때 딜러보다 점수가 높은 경우
    - 플레이어의 점수가 21이하일 때 딜러의 점수가 21초과인 경우
    - 플레이어가 블랙잭이고 딜러가 블랙잭이 아닌 경우

### 상금
- [x] 플레이어의 배팅금액에 따른 수익결과와 딜러의 수익을 제공한다.
  - [x] 플레이어가 상금을 추가로 얻는 경우
    - 결과 판독기에서 딜러가 지는 경우 단, 플레이어가 블랙잭인 경우에는 상금의 1.5배를 추가로 받는다.
  - [x] 플레이어가 상금을 잃는 경우
    - 결과 판독기에서 딜러가 이기는 경우
  - [x] 플레이어가 상금이 0원인 경우
    - 결과 판독기에서 딜러와 플레이어가 비기는 경우

### 블랙잭 게임
- [x] 승패를 결정한다.(플레이어와 딜러간의 승패를 남긴다)
  - [x] 플레이어의 승패를 결정한다.
  - [x] 딜러의 승패를 결정한다.
- [x] 처음 2장의 카드를 나눠준다.

### 최종결과
- [x] 게임의 최종 결과를 관리한다.

### 입력
- [x] 플레이어 이름을 입력받는다.
    - [x] delimiter는 ","로 한다.
- [x] 플레이어의 배팅금액을 입력받는다.
- [x] 카드를 추가로 받을지 말지 입력받는다.

### 출력
- [x] 참가자를 출력한다.
- [x] 게임의 최종 결과를 출력한다.
- [x] 딜러와 플레이어의 승/패를 출력한다.
- [x] 플레이어의 카드 현황을 출력한다.
  - [x] 처음 받은 두 장의 카드 현황을 출력한다.
  - [x] 추가로 받은 카드의 현활을 출력한다.
- [x] 딜러가 카드의 hit을 알리는 메세지를 출력한다.

### 예외처리
- [x] 사용자의 입력이 공백인지 null인지 검증한다.
  - [x] 플레이어 이름을 입력받을 떼
  - [x] 카드를 받는 여부를 입력받을 때
- [x] 사용자의 이름이 한글, 영어, 숫자인지 검증한다.
- [x] 카드를 받는 여부를 입력받을 때 y 혹은 n 인지 검증한다.

### 리팩토링
- [x] 빠른 리턴을 통한 불필요한 변수 생성하지 않기
- [x] 매직넘버를 이해하기 쉬운 상수로 변경하기
- [x] Paticipants에서 딜러와 플레이어를 물어보는 기능 추가
- [x] Controller가 추상화된 클래스의 구체 타입 모르게 하기
- [x] 책임 소재 수정하기
  - [x] 딜러와 플레이어의 결과를 비교하는 객체 생성
  - [x] Cards에 카드를 뽑는 전략을 인스턴스 필드로 가지게 하기
  - [x] Participant에서 카드와 관련된 기능을 Hand객체로 이관
    - 카드를 받는 기능
    - 에이스카드를 포함하고 있는지 확인하는 기능
    - 카드 점수를 계산하는 기능
    - 블랙잭인지 검증하는 기능
- [x] 공통된 기능 하나로 처리하기
- [x] 카드 객체를 cache로 관리하기

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
