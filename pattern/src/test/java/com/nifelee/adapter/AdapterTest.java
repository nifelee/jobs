package com.nifelee.adapter;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 한 클래스의 인터페이스를 클라이언트에서 사용하고자하는 다른 인터페이스로 변환
 * 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있음
 * ex) Banner/Print
 *
 * Adapter 패턴은 인터페이스(API)의 차이를 조정하기 위한 패턴입니다. Decorator 패턴은 인터페이스(API)를 수정하지 않고 기능을 추가하는 패턴입니다.
 */
@Slf4j
public class AdapterTest {
  @AllArgsConstructor class Banner {
    private String message;
    void print() { log.debug("({})", message); }
  }

  interface Print {
    void printStrong();
  }

  class PrintBanner extends Banner implements Print {
    PrintBanner(String message) { super(message); }
    @Override
    public void printStrong() { print(); }
  }

  // 클래스에 의한 어댑터 패턴
  @Test
  public void bannerByClass() {
    Print print = new PrintBanner("hi");
    print.printStrong();
  }

  abstract class Print2 {
    abstract void printStrong();
  }

  class Print2Banner extends Print2 {
    private Banner banner;
    Print2Banner(String message) {
      this.banner = new Banner(message);
    }
    @Override
    void printStrong() { banner.print(); }
  }

  // 인스턴스에 의한 어댑터 패턴
  @Test
  public void bannerByInstance() {
    Print2 print2 = new Print2Banner("hi");
    print2.printStrong();
  }

}
