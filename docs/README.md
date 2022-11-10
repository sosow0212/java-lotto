## 기능 목록 순서

1. 로또 구매
    - 로또의 가격은 1000원
    - 구매시 중복 없는 랜덤 넘버 6개 생성 후 리스트에 저장
    - 구매한 로또의 총액을 저장

2. 당첨 번호 및 보너스 번호 입력
   - 당첨 번호 입력 받기
   - 보너스 번호 입력 받기
   - 당첨 번호와 보너스 번호 사이에 중복은 없는지 예외처리 진행
   - 입력한 번호들에 있어서 1~45의 범위 안에 들어가있는지 예외처리 진행

3. 당첨 확인 및 통계
   - 구매한 것 중 당첨된 것을 카운팅
   - 전체 수익금 계산
   - 수익률 계산
   - View를 통해 사용자로에게 출력

---

## 프로젝트 구조 및 상세한 구현 목록

1. Domain
   - Lotto
     - 당첨 번호 6개 입력 + 보너스 번호 입력 후 저장
   - User
     - 로또 구매 및 저장

2. Enum
   - WinningLotto
     - 로또 등수 별 상금
       - ThirdPrice, FourthPrice ...

3. Util
   - GenerateLottoNumbers
      - 유저가 로또 구매시 번호 추출 및 정렬을 해준다.
   - RoundToTwoDecimalParser
     - 수익률을 소수점 둘째 자리에서 반올림 해준다.
   - SeparatedByCommas
     - 유저 입력 시 ','를 기준으로 나눠준다.


4. Exception
   - UserBuyLottoException
     - 로또 구입 금액 입력 시 1000원 단위로 떨어지는지 확인

   - UserInputLottoNumbersException
     - 1~45의 숫자의 값인지 확인
     - 보너스 번호 입력시 중복이 아닌지 확인
     - 당첨 번호 입력시 쉼표로 잘 받았는지 확인

5. Service
   - LottoViewService
     - View를 통해 입력받은 값을 도메인에 저장한다. (유저가 로또를 사는 경우)
     - View를 통해 계산한 값을 출력한다. (로또 당첨 및 계산)
   - LottoCalculateService
     - 로또 당첨 확인 및 수익률을 계산한다.

6. Controller
   - LottoController
     - Service를 통해 로또의 구입 및 입력, 출력을 명령

7. View
   - InputView
     - 유저의 구입 금액을 입력 받는다.
     - 로또 당첨 번호를 입력 받는다. (+ 보너스 번호)
   - OutputView
     - 로또 구매 시, 랜덤으로 생성된 번호를 출력해준다.
     - 당첨 통계를 출력해준다.