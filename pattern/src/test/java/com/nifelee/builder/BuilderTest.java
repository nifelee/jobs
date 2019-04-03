package com.nifelee.builder;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import lombok.AllArgsConstructor;

/**
 * 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴
 * ex) StringBuffer/StringBuilder 의 append() 로 연결 후 최종 toString()
 *
 * 텔레스코핑 방식
 * : 생성자의 파라미터가 점진적으로 증가하여 최종 모든 속성을 가진 마스터 생성자를 사용하여 객체를 생성하는 방식
 *
 * Fluent API 방식
 */
public class BuilderTest {
  @AllArgsConstructor static class Pet {
    private String name;
    private String ownerName;
    private String address;
    private String phone;

    static class Builder {
      private String name;
      private String ownerName;
      private String address;
      private String phone;

      Builder withName(String name) { this.name = name; return this; }
      Builder withOwnerName(String ownerName) { this.ownerName = ownerName; return this; }
      Builder withAddress(String address) { this.address = address; return this; }
      Builder withPhone(String phone) { this.phone = phone; return this; }

      Pet build() {
        if (name == null || ownerName == null || address == null)
          throw new IllegalStateException("cannot create pet");
        return new Pet(name, ownerName, address, phone);
      }
    }
  }

  @Test
  public void builder() {
    Pet.Builder build = new Pet.Builder();
    Pet pet = build.withName("Pet")
                   .withOwnerName("Owner")
                   .withAddress("Seoul")
                   .build();
    assertNotNull(pet);
  }
}
