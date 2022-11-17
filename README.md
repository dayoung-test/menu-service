
# 설치 / 빌드 방법

```bash
git clone https://github.com/dayoung-test/menu-service.git
cd 클론_받은_프로젝트_디렉토리
./gradlew bootRun
```

<br/>
<br/>

# API 응답 구조

```json
{
    "code": "0000",
    "message": "SUCCESS",
    "data": {}
}
```

| Name | Type | Description |
| --- | --- | --- |
| code | String | 응답 코드 |
| message | String | 응답 메시지 |
| data | Object | 응답 데이터 |

<br/>

## API 응답 코드

| Code | Messagae | Description |
| --- | --- | --- |
| 0000 | SUCCESS | 성공 |
| 4000 | 요청한 값이 올바르지 않습니다. | 파라리터 오류 |
| 5000 | 일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요. | 서버 오류 |

<br/>
<br/>

# API 목록

## 1) 배너 File 추가 API

실제 File 업로드가 아닌, 임시로 File 테이블에 추가되는 방식으로 구현했습니다

### **Requset**

URL

```
POST http://localhost:8080/api/v1/files
```

### Response

데이터로 신규 등록된 File의 Token 값을 응답

```json
{
    "code": "0000",
    "message": "SUCCESS",
    "data": "file_YQRZw9LYwE5cCx8"
}
```

<br/>

## 2) 메뉴 등록 API

### Request

URL

```
POST http://localhost:8080/api/v1/menus
```

ResponseBody

| Name | Type | Description | Required |
| --- | --- | --- | --- |
| topMenuToken | String | 상위 메뉴 토큰 | X |
| title | String | 메뉴 타이틀 | O |
| ordering | Integer | 메뉴 순서 | O |
| bannerRequestList | List | 상위 메뉴 배너의 이미지 정보 | X |

RequestBody 예시

```json
{
    "topMenuToken": null,
    "title": "상의",
    "ordering": 1,
    "bannerRequestList": [{
        "bannerFileToken": "file_YQRZw9LYwE5cCx8",
        "ordering": 1
    }]
}
```

### Reponse

데이터로 신규 등록된 Menu의 Token 값을 응답

```json
{
    "code": "0000",
    "message": "SUCCESS",
    "data": {
        "menuToken": "menu_lJJEZKZh0BBsXvp"
    }
}
```

<br/>

## 3) 메뉴 조회 API

### Request

URL

```
GET http://localhost:8080/api/v1/menus/{menuToken}
```

Parameter

| Name | Type | Description | Required |
| --- | --- |-------------| --- |
| menuToken | String | 조회할 메뉴 토큰   | O |

### Reponse

data

| Level 1 | Level 2 | Type | Description |
| --- | --- | --- | --- |
| menuToken |  | String | 메뉴 토큰 |
| title |  | String | 메뉴 타이블 |
| ordering |  | Integer | 메뉴 순서 |
| subMenuList |  | List | 하위 메뉴 리스트 |
|  | menuToken | String | 메뉴 토큰 |
|  | title | String | 메뉴 타이틀 |
|  | ordering | Integer | 메뉴 순서 |
|  | subMenuList | List | 하위 메뉴 리스트 |
|  | bannerList | List | 메뉴의 배너 목록 |
| bannerList |  | List | 메뉴의 배너 목록 |
|  | url | String | 배너 이미지 URL |
|  | ordering | Integer | 배너 순서 |

Response 예시
```json
{
    "code": "0000",
    "message": "SUCCESS",
    "data": {
        "menuToken": "menuToken_1",
        "title": "top1",
        "ordering": 1,
        "subMenuList": [
            {
                "menuToken": "menuToken_2",
                "title": "1_sub1",
                "ordering": 1,
                "subMenuList": [
                    {
                        "menuToken": "menuToken_3",
                        "title": "1_sub1_sub1",
                        "ordering": 1,
                        "subMenuList": [],
                        "bannerList": []
                    },
                    {
                        "menuToken": "menuToken_4",
                        "title": "1_sub1_sub2",
                        "ordering": 2,
                        "subMenuList": [],
                        "bannerList": []
                    }
                ],
                "bannerList": []
            }
        ],
        "bannerList": [
            {
                "url": "http://1",
                "ordering": 1
            },
            {
                "url": "http://2",
                "ordering": 2
            },
            {
                "url": "http://3",
                "ordering": 3
            }
        ]
    }
}
```

💡Flyway를 사용해 테스트를 위한 기초 데이터가 insert 되도록 구현했습니다. 프로젝트를 실행하면 아래 데이터가 insert 됩니다. insert 되어 있는 `MENU_TOKEN` 으로 조회를 하면 쉽게 데이터를 확인할 수 있습니다.

**Menu 데이터**

![스크린샷 2022-11-18 오전 5.56.06.png](https://user-images.githubusercontent.com/114453642/202561422-88a8f281-b95d-4a51-b49d-1e7245b9ad43.png)

**File 데이터**

![스크린샷 2022-11-18 오전 5.56.27.png](https://user-images.githubusercontent.com/114453642/202561603-507fdb37-b409-4ffa-9840-a6c01514f11d.png)

**Banner 데이터**
![스크린샷 2022-11-18 오전 5.56.27.png](https://user-images.githubusercontent.com/114453642/202561734-ca01d92e-2ce5-402c-b71e-1e2cb0ff763b.png)

<br/>

## 4) 메뉴 수정 API

### Request

URL

```
PUT http://localhost:8080/api/v1/menus
```

ResponseBody

| Name | Type | Description               | Required |
| --- | --- |---------------------------| --- |
| menuToken | String | 수정할 메뉴 토큰                 | O |
| topMenuToken | String | 상위 메뉴 토큰, 상위 메뉴를 변경할 때 요청 | X |
| title | String | 메뉴 타이틀, 타이틀을 변경할 때 요청     | X |
| ordering | Integer | 메뉴 순서, 순서를 변경할 때 요청       | X |

RequestBody 예시

```json
{
    "menuToken": "menu_lJJEZKZh0BBsXvp",
    "topMenuToken": null,
    "title": "2_sub5",
    "ordering": 5
}
```

### Reponse

```json
{
    "code": "0000",
    "message": "SUCCESS",
    "data": null
}
```

<br/>

## 5) 메뉴 삭제 API

하위 메뉴가 있는 경우 함께 삭제됩니다

### Request

URL

```
DELETE http://localhost:8080/api/v1/menus/{menuToken}
```
Parameter

| Name | Type | Description | Required |
| --- | --- |-------------| --- |
| menuToken | String | 삭제할 메뉴 토큰   | O |

### Reponse

```json
{
    "code": "0000",
    "message": "SUCCESS",
    "data": null
}
```
<br/>
<br/>

