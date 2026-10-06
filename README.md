# 실습과제 05

- `01_tdd_arithmetic`: Python 사칙연산 클래스와 unittest 테스트 8개
- `02_android_calculator`: Android 사칙연산 앱과 계산 엔진 JUnit 테스트

## 01 콘솔 테스트

WSL Ubuntu에서 실행한다. Python 표준 라이브러리만 사용하므로 추가 패키지는 필요 없다.

```bash
cd /mnt/c/Users/haddo/mobile_web_service/week4/lab05/01_tdd_arithmetic
python3 test_FourBasicOpt.py
```

최종 콘솔의 테스트 8개와 `OK`가 보이는 실제 화면을 캡처하여 `01_tdd_arithmetic/tdd_test_result.png`로 저장한다.

## 02 Android 실행

Windows Android Studio에서 `02_android_calculator` 폴더를 연다. 가상기기 또는 실제 기기에서 실행하고, 첫 번째 숫자 → 연산자 선택 → 두 번째 숫자 → 계산 버튼 순서로 사용한다.

UI와 `CalculatorEngine`은 분리되어 있으며, `CalculatorEngineTest`로 엔진을 검사할 수 있다.

실행 화면은 `02_android_calculator/calculator_result.png`에 포함되어 있다.

## 제출

두 프로젝트의 전체 소스와 실행 캡처를 신규 GitHub 저장소 하나에 올리고 저장소 URL을 제출한다.
