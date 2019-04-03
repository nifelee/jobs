package com.nifelee.visitor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 *  알고리즘을 객체 구조에서 분리시키는 패턴
 *  구조를 수정하지 않고도 새로운 동작을 기존의 객체 구조에 추가할 수 있게 됨
 *  객체는 그대로 둔 채 객체에 대한 연산을 분리
 */
@Slf4j
public class VisitorTest {
  interface Element {
    void accept(Visitor visitor);
  }
  class Cart implements Element {
    private List<Element> elementList = new ArrayList<>();
    Cart() { elementList.add(new Milk()); }
    @Override
    public void accept(Visitor visitor) {
      log.debug("Cart 준비");
      visitor.visit(this); //실제 처리를 visitor 에게 위임
      for (Element element : elementList)
        element.accept(visitor);
    }
  }
  class Milk implements Element {
    @Override
    public void accept(Visitor visitor) {
      log.debug("Milk 준비");
      visitor.visit(this);
    }
  }

  interface Visitor {
    void visit(Cart cart); //비지터는 오버로딩으로 처리
    void visit(Milk milk);
  }
  class Shopper implements Visitor {
    @Override
    public void visit(Cart cart) { log.debug("Cart를 이용"); }
    @Override
    public void visit(Milk milk) { log.debug("Milk를 Cart에 넣음"); }
  }

  @Test
  public void visitor() {
    Shopper shopper = new Shopper();
    Cart cart = new Cart();
    cart.accept(shopper);
  }

}
