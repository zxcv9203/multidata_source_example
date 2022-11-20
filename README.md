# MultiDataSource 환경에서 Custom Dialect Example

![img.png](image/img.png)

- 테스트는 테스트 컨테이너로 진행

## 프로그램 실행 방법
* 프로그램 실행전 docker와 docker-compose 설치가 필요합니다.

```shell
cd docker
sh restart-env.sh
```

### 실행전 주의 사항
.env 파일 docker 디렉터리에 위치시켜 환경변수 처리한 부분들의 값을 추가해주셔야 합니다.

현재 상황에서 변수를 추가적으로 만들지 않았다고 가정했을 때, .env를 다음과 같이 만들고 값을 지정해주시면 됩니다. 

```dotenv
APPLICATION_IMAGE=???
APPLICATION_NAME=???
DB_IMAGE=???
MASTER_DB_NAME=???
SLAVE_DB_NAME=???
LOCAL_SLAVE_REPOSITORY_PATH=???
LOCAL_MASTER_REPOSITORY_PATH=???
```

jib을 이용하여 스프링 애플리케이션을 자동으로 컨테이너화 시키므로 이미지 이름을 변경해야 합니다. 

다음은 도커허브를 사용했을 때의 예시입니다.

```groovy
jib {
    ...
    ...
    to {
        image = "도커허브 계정/${project.name.toLowerCase()}"
        tags = ["${project.version.toString().toLowerCase()}"]
    }
    ...
}
```