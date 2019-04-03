package com.nifelee.prototype;

import org.junit.Test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 생성할 객체들의 타입이 프로토타입인 인스턴스로부터 결정되도록 하며, 인스턴스는 새 객체를 만들기 위해 자신을 복제(clone)하게 됨
 * 비슷한 인스턴스를 지속적으로 생성할 때 유용
 */
@Slf4j
public class PrototypeTest {
  @ToString class Cookie implements Cloneable { //Cloneable 상속
    private String info;
    @Getter @Setter private String var;
    Cookie(String info) { this.info = info; }
    @Override
    protected Cookie clone() throws CloneNotSupportedException {
      return (Cookie) super.clone();
    }
  }

  @Test
  public void prototype() throws CloneNotSupportedException {
    Cookie cookie1 = new Cookie("요리 방법");
    cookie1.setVar("xx");
    Cookie cookie2 = cookie1.clone();
    cookie2.setVar("yy");
    log.debug("{}", cookie2);
  }
}
