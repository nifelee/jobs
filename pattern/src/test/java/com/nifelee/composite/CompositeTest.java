package com.nifelee.composite;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 일반적인 트리 구조의 데이터 타입을 만드는 것
 * 개별 객체와 다른 객체들로 구성된 복합 객체(composite)를 똑같은 방법으로 다룰 수 있음
 * ex) 폴더 안의 파일
 */
@Slf4j
public class CompositeTest {
  @ToString abstract class Component {
    private String name;
    List<Component> components = new ArrayList<>(); //자기 자신을 가지면서 트리를 만듬
    Component (String name) { this.name = name; }
    void add(Component component) {
      this.components.add(component);
    }
  }

  @ToString(callSuper = true) class Composite extends Component {
    Composite(String name) { super(name); }
  }

  @ToString(callSuper = true) class Leaf extends Component {
    Leaf(String name) { super(name); }
    @Override
    void add(Component component) { throw new UnsupportedOperationException(); }
  }

  @Test
  public void component() {
    Composite root = new Composite("root");
    Composite dir1 = new Composite("dir-1");
    root.add(dir1);
    dir1.add(new Leaf("file-1"));
    root.add(new Composite("dir-2"));
    log.debug(root.toString());
  }

}
