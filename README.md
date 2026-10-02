# 실습과제 05

## 프로젝트 구성

- `01_tdd_arithmetic`: Android 사칙연산 앱과 계산 엔진 JUnit 테스트
- `02_android_image_app`: 이미지 한 장을 화면에 표시하는 Android 앱

## 01 실행

Android Studio에서 `01_tdd_arithmetic` 폴더를 연다. 계산기 숫자·연산자 버튼으로 식을 입력하고 `=` 버튼을 누른다. `C`, `⌫`, `±`, 소수점 입력도 지원한다.

```text
100 + 10 → 110
100 - 10 → 90
100 × 10 → 1000
100 ÷ 10 → 10
```

`CalculatorEngineTest`를 실행하여 계산 엔진 테스트가 통과하는지 확인한다. 테스트 성공 화면과 에뮬레이터에서 실행된 계산기 화면을 캡처하여 저장소에 넣는다.

```text
01_tdd_arithmetic/tdd_test_result.png
01_tdd_arithmetic/calculator_result.png
```

## 02 실행

Android Studio에서 `02_android_image_app` 폴더를 열고 가상 기기 또는 실제 기기에서 앱을 실행한다.

제출할 PNG를 앱에 사용하려면 아래의 임시 벡터 파일을 삭제한다.

```text
02_android_image_app/app/src/main/res/drawable/display_image.xml
```

같은 폴더에 사용할 이미지를 `display_image.png`라는 이름으로 넣는다. 앱 화면을 캡처하여 `02_android_image_app/android_result.png`로 저장한다.
