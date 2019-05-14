package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

//전화번호 목록
//https://programmers.co.kr/learn/courses/30/lessons/42577
@Slf4j
public class Solution_42577 {

  //phone_book	return
  //[119, 97674223, 1195524421]	false
  //[123, 456, 789]	true
  //[12, 123, 1235, 567, 88]	false
  public boolean solution(String[] phone_book) {
    for (int i=0; i<phone_book.length - 1; i++) {
      for (int j=i+1; j<phone_book.length; j++) {
        if (phone_book[j].startsWith(phone_book[i])) return false;
        else if (phone_book[i].startsWith(phone_book[j])) return false;
      }
    }
    return true;
  }

}
