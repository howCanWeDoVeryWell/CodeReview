package classes;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class SomeVo {}

class A {
    private int a;

    private class SomeVo {

    }

    public A () {
        new SomeVo();
    }
}

interface Calculator {
    public int calculator();
}

class CalculatorUtil {
    public static class Min {}
    public static class Multi {}
    public static class Div {
        public static int calculator () {
            return 0;
        }
    }
}

// 정적 스코프, 동적 스코프


interface AA {
    public void test();
}

class AAE implements AA {
    @Override
    public void test() {
        System.out.println("init");
    }
}


public class Inner {
    public static void run (AA a) {
        a.test();
    }

    // 변수를 선언하고 주민번호를 초기화
    public static void main(String[] args) {
        int a = 3;

        if (true) {
            int aa = 3;
        }

        A aaa = new A();
        String indentityNumber = "941222-2222222";
        System.out.println(indentityNumber);

        AA aa = new AA() {
            @Override
            public void test() {

            }
        };

        AA aa1 = new AA() {
            @Override
            public void test() {

            }
        };


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        thread.start();

        Inner.run(
                aa
        );
    }
}



class Test {
    private List<Integer> list = new ArrayList<>();
    private int a = 5;

    {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    public List<Integer> result() {
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0, size = list.size(); i < size; i++) {
            int number = list.get(i);
            if (i % 2 == 0) {
                number++;
            }
            returnList.add(number);
        }

        return returnList;
    }

    public List<Integer> result3() {
        this.list.forEach(System.out::println);

        return this.list
                .stream()
                .map(i -> i % 2 == 0 ? i + 1 : i)
                .collect(Collectors.toList());
    }

    public List<Integer> result1() {
        for (int i = 0, size = list.size(); i < size; i++) {
            if (i % 2 == 0) {
                list.set(i, list.get(i) + 1);
            }
        }
        return list;
    }

    public Integer getA () {
        return this.a;
    }
}

class AAAA {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("inner"));

        Calc sum = (v1, v2) -> v1 + v2;
        Calc min = (v1, v2) -> v1 - v2;
        Calc multi = (v1, v2) -> v1 * v2;
        Calc div = (v1, v2) -> v1 / v2;

        int v1 = 1;
        int v2 = 2;

//        System.out.println(AAAA.executor(v1, v2, sum));;
//        System.out.println(AAAA.executor(v1, v2, min));;
//        System.out.println(AAAA.executor(v1, v2, multi));;
//        System.out.println(AAAA.executor(v1, v2, div));;


//        System.out.println(new Test().result3());
        Construct construct = Test::new;

        System.out.println(construct.newInstance());
    }

    public static int executor (int v1, int v2, Calc calculator) {
        return calculator.calc(v1, v2);
    }
}

@FunctionalInterface
interface Calc {
    int calc(int v1, int v2);

    default void test1 () {
        System.out.println("default methods");
    }
}

@FunctionalInterface
interface Construct {
    Test newInstance();

    default void test1 () {
        System.out.println("default methods");
    }
}








