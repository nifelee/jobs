package com.nifelee.decorator;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 객체에 추가적인 요건을 동적으로 첨가
 * 서브클래스를 만드는 것을 통해서 기능을 유연하게 확장할 수 있는 방법을 제공
 * ex) Coffee
 *
 * Adapter 패턴은 인터페이스(API)의 차이를 조정하기 위한 패턴입니다. Decorator 패턴은 인터페이스(API)를 수정하지 않고 기능을 추가하는 패턴입니다.
 */
@Slf4j
public class DecoratorTest {

  abstract class Coffee {
    String desc = "empty";
    public String getDesc() { return desc; }
    public abstract int cost();
  }

  class Espresso extends Coffee {
    Espresso() { this.desc = "Espresso"; }
    @Override
    public int cost() { return 300; }
  }

  class HouseBlend extends Coffee {
    HouseBlend() { this.desc = "HouseBlend"; }
    @Override
    public int cost() { return 400; }
  }

  abstract class CondimentDecorator extends Coffee {
    public abstract String getDesc();
  }

  class Mocha extends CondimentDecorator {
    private Coffee coffee;
    Mocha(Coffee coffee) { this.coffee = coffee; }
    @Override
    public String getDesc() { return coffee.getDesc() + ", Mocha"; }
    @Override
    public int cost() { return coffee.cost() + 50; }
  }

  @Test
  public void coffee() {
    Coffee espresso = new Espresso();
    log.debug("{} : {}", espresso.getDesc(), espresso.cost());

    Coffee houseBlend = new HouseBlend();
    houseBlend = new Mocha(houseBlend);
    log.debug("{} : {}", houseBlend.getDesc(), houseBlend.cost());
  }

}
