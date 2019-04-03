package com.nifelee.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import lombok.AllArgsConstructor;

/**
 * 알고리즘군을 정의하고 각각 캡슐화하여 교환해서 사용할 수 있도록 만듦
 * 알고리즘을 사용하는 클라이언트와는 독립적으로 알고리즘을 변경할수 있음
 * ex) Duck, RubberDuck
 *
 * 디자인 원칙
 * 애플리케이션에서 달라지는 부분을 찾아내고, 달라지지 않는 부분으로부터 분리
 * 상속보다는 구성을 사용
 * 구현이 아닌 인터페이에 맞춰 구현
 */
public class StrategyTest {

  public interface FlyBehavior {
    void fly();
  }

  public class FlyWithWing implements FlyBehavior {
    @Override
    public void fly() { System.out.println("fly~~"); }
  }

  public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() { System.out.println("not fly"); }
  }

  @AllArgsConstructor
  abstract class Duck {
    private FlyBehavior flyBehavior;

    void performFly() {
      flyBehavior.fly();
    }

    abstract void display();
  }

  public class MallardDuck extends Duck {
    MallardDuck(FlyBehavior flyBehavior) { super(flyBehavior); }
    @Override
    void display() { System.out.println("MallardDuck"); }
  }

  public class RubberDuck extends Duck {
    RubberDuck(FlyBehavior flyBehavior) { super(flyBehavior); }
    @Override
    void display() { System.out.println("RubberDuck"); }
  }

  @Test
  public void rubberDuck() {
    Duck duck = new RubberDuck(new FlyNoWay());
    duck.display();
    duck.performFly();
  }

  @Test
  public void mallardDuck() {
    Duck duck = new MallardDuck(new FlyWithWing());
    duck.display();
    duck.performFly();
  }

  @Test
  public void mockDuck() {
    FlyBehavior mockFlyBehavior = mock(FlyBehavior.class);
    Duck duck = new RubberDuck(mockFlyBehavior);
    duck.display();
    duck.performFly();
    verify(mockFlyBehavior).fly();
  }

}
