## 객체의 생성과 삭제
* 객체를 만들어야 하는 시점과 그 방법
* 객체 생성을 피해야 하는 경우 그 방법
* 적절한 순간에 객체가 삭제되도록 보장하는 방법
* 삭제 전에 반드시 이루어져야 하는 청소 작업 관리 방법


>규칙1. 생성자 대신 정적 팩터리 메서드를 사용할 수 없는지 생각해보라.

Static factory method 예제 코드
```java
public static Boolean valueOf(boolean b) {
return b ? Boolean.TRUE : Boolean.FALSE;
}
```

* 장점
  - 생성자와는 달리 정적 팩터리 메서드에는 이름이 있다.
  - 생성자와는 달리 매번 호출 할 때마다 객체를 생성하지 않아도 된다.
  - 자기 자신만 반환할 수 있는 생성자와는 다르게 반환값 자료형의 하위 자료형 객체를 반환할 수 있다.
  - 형인자 자료형(parameterized type)객체를 만들 때 편하다. 
    
    *1.7버전부터 생성자도 자료형 유추를 사용할 수 있다.*
        
    ```java
    //Constructor
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    ```
    정적 팩터리 메서드를 사용하면 컴파일러가 형인자를 스스로 알 수 있다.(자료형 유추 type inference)
    ```java
    //Static factory method
    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<K, V>();  
    }  
  
    Map<String, List<String>> m = HashMap.newInstance();
    ```
   
* 단점
  - `public`이나 `protected` 로 선언된 생성자가 없으므로 하위 클래스를 만들 수 없다. 
  ```java
           
  ```
  - 정적 팩터리 메서드가 다른 정적 메서드와 확연히 구분되지 않는다. 주석(comment)을 통해 알리는 수 밖에..


> 규칙2. 생성자가 많을 때는 Builder패턴 적용을 고려하라.
 * 빌더 패턴은 인자가 많은 생성자나 정적 팩터리가 필요한 클래스를 설계할때, 대부분의 인자가 선택적 인자인 상황에 유용하다.
 ```java
 public class Member {
      private final String userId;
      private final String name;
      private final String address;
      private final int phoneNumber;
      private final int height;
 
      public static class Builder {
         private String userId;
         private String name;
         private String address = null;
         private int phoneNumber = 0;
         private int height = 0;
 
         public Builder(String userId, String name) {
             this.userId = userId;
             this.name = name;
         }
 
         public Builder address(String address) {
             this.address = address;
             return this;
         }
 
         public Builder phoneNumber(int phoneNumber) {
             this.phoneNumber = phoneNumber;
             return this;
         }
 
         public Builder height(int height) {
             this.height = height;
             return this;
         }
 
         public Member build() {
             return new Member(this);
         }
      }
 
      private Member(Builder builder) {
          userId = builder.userId;
          name = builder.name;
          address = builder.address;
          phoneNumber = builder.phoneNumber;
          height = builder.height;
      }
  }
```
설정 메소드 호출
```java
Member yeonjong = new Builder("yjshin", "yj")
                     .address("Seoul")
                     .height(164)
                     .build();
```

> 규칙3. private 생성자나 enum 자료형은 싱글턴 패턴을 따르도록 설계하라


