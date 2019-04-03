package com.nifelee.bridge;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 구현부에서 추상층을 분리하여 각자 독립적으로 변형할 수 있게 하는 패턴
 */
@Slf4j
public class BridgeTest {
  /* Implementor */
  interface Drawing {
    void draw(int x, int y, double radius);
  }
  /* ConcreteImplementor */
  class DrawAPI implements Drawing {
    @Override
    public void draw(int x, int y, double radius) { log.debug("{}:{} {} draw", x, y, radius); }
  }

  /* Abstraction */
  interface Shape {
    void draw();                     //low-level
    void resetRadius(double radius); //height-level
  }
  /* Refined Abstraction */
  class Circle implements Shape {
    int x, y; double radius;
    private Drawing drawing;
    Circle(int x, int y, double radius, Drawing drawing) {
      this.x = x; this.y = y; this.radius = radius;
      this.drawing = drawing;
    }
    @Override
    public void draw() { drawing.draw(x, y, radius); }
    @Override
    public void resetRadius(double pct) { radius *= pct; }
  }

  @Test
  public void bridge() {
    Shape shape = new Circle(1, 2, 1, new DrawAPI());
    shape.resetRadius(1.5);
    shape.draw();
  }

}
