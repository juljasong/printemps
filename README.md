# 20210908_ Initialize Project
using https://start.spring.io/
- Gradle Project
- 2.5.4
- Dependencies
-- Spring Web
-- Thymeleaf

# 20210911_ [ADD] Welcome Page, Controller

Example of Controller.java
```java
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello"; // return -> viewResolver
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model) { // required 기본은 true
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // response body 부분에 return 데이터 그대로 출력
    public String helloString(@RequestParam("name") String name) {
        return "<h1>hello " + name + "</h1>";
    }

    // 데이터 반환 시
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // JSON 출력
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
```

### How to Build And Run
- 프로젝트 폴더 이동 후
```
$ ./gradlew build
$ cd build/libs
$ ls // jar 파일명 copy
java -jar [paste].jar // 실행
$^c // 종료

// build 파일에 문제 있는 경우
$ ./gradlew clean build
```

## MVC : Model-View-Controller

# 20210911_ [ADD] MemoryMemberRepositoryTest
## Test Case
- @Test가 여러 개 존재할 때 실행 순서는 랜덤.
- @Test가 끝날 때 마다 저장소 데이터 클리어 해 주어야 함 -> @afterEach 사용


# 20210912_ [ADD] MemberController

### 컴포넌트 스캔과 자동 의존관계 설정
- @Component : @Controller, @Service, @Repository
- @Autowired : 생성자 DI 자동 주입
- +) 스프링 컨테이너에 스프링 빈 등록 시, 기본으로 싱글톤으로 등록(하나만 등록하여 공유)
   = 같은 스프링 빈이면 모두 같은 인스턴스.

### 자바 코드로 스프링 빈 등록
- AppConfig.java
- @Bean으로 직접 등록

# 20210912_ [ADD] ddl.sql
- ADD ddl.sql
- JDBC 설정
  - application.properties
  - build.gradle

# 20210912_ [ADD] MemberServiceIntegrationTest.java
- @SpringBootTest
- @Transactional : ROLLBACK-> DB 반영하지 않음(For test)

- 순수 단위 테스트 : 순수 Java 테스트
- 통합 테스트 : 스프링 컨테이너 + 테스트

# 20210912_ 스프링 JdbcTemplate

# 20210912_ JPA
````
spring.datasource.url=jdbc:h2:tcp://localhost/~/test
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none // <-> create. 객체를 참조하여 테이블을 자동 생성해주지만, 이미 테이블 만들어져 있기 때문에 none
````

- @Entity : JPA 관리 요소
- @Id @GeneratedValue(strategy = GenerationType.IDENTITY) <- PK
- @Column(name="username") : 테이블명과 domain명이 다를 때 매핑

# 20210912_ Spring Data JPA
- 인터페이스로 생성
- ~Config.java에서 빈 생성해주지 않아도 자동으로 객체 생성해줌

SpringDataMemberRepository.java
````java
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    
}
````
