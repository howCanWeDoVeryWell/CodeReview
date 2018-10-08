package typing;

/**
 * private A a = new A();
 * 위 경우에는 Constructor 생성자가 호출되기 전에 A가 먼저 생성되어 버린다.
 * 따라서 Constructor 생성자 내부에서 A를 초기화하는 것이 더 좋다.
 *
 * 더 좋은 것은 Constructor에서 A를 주입받는 것이 가장 좋다.
 * 그래야만 A 클래스에대한 의존성을 Constructor에서 제거할 수 있다.
 * 이를 Dependency Injection 이라고 한다.
 * Constructor 클래스는 A의 형태만 알고 있고 실제 객체는 외부에서 주입해야 가장 의존성이 없는 코드다.
 */
public class Constructor {
    private A a;
    {
        /**
         * 이 코드는 private A a = new A(); 와 같다.
         * 이 영역은 일반 properties를 초기화하는 영역으로 생성자보다 먼저 호출된다.
         * static 초기화 영역과는 다른 영역이다.
         */
        this.a = new A();
    }

    public Constructor() {
        System.out.println("Create Constructor!");
    }

    private class A {
        public A () {
            System.out.println("Create A!");
        }
    }

    public static void main(String[] args) {
        new Constructor();
    }
}
