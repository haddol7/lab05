# 실습과제 05

## 프로젝트 구성

- `01_tdd_arithmetic`: `unittest`로 먼저 작성한 8개 테스트와 사칙연산 구현
- `02_android_image_app`: 이미지 한 장을 화면에 표시하는 Android 앱

## 01 실행

WSL에서 다음 폴더로 이동한 뒤 실행한다.

```bash
cd /mnt/c/Users/haddo/mobile_web_service/week4/lab05/01_tdd_arithmetic
python3 -m unittest -v
```

최종 `OK`가 보이는 콘솔을 캡처하여 `01_tdd_arithmetic/tdd_console.png`로 저장한다.

## 02 실행

Android Studio에서 `02_android_image_app` 폴더를 열고 가상 기기 또는 실제 기기에서 앱을 실행한다.

제출할 PNG를 앱에 사용하려면 아래의 임시 벡터 파일을 삭제한다.

```text
02_android_image_app/app/src/main/res/drawable/display_image.xml
```

같은 폴더에 사용할 이미지를 `display_image.png`라는 이름으로 넣는다. 앱 화면을 캡처하여 `02_android_image_app/android_result.png`로 저장한다.
