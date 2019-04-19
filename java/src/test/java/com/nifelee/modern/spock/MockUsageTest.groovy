package com.nifelee.modern.spock

import com.nifelee.modern.AmountService
import com.nifelee.modern.FeeCalculateType
import spock.lang.Specification

class MockUsageTest extends Specification {

  def "API를 통해 받은 값을 원단위 버림 계산한다." () {
    given:
      def mockAmountService = Mock(AmountService.class)

    when:
      long amount = mockAmountService.getAmount()

    then:
      mockAmountService.getAmount() >> 999L
      999L == amount
      990L == FeeCalculateType.WON_UNIT_CUT.calculate(amount)
  }

  def "Repository 두번 호출하는지 확인" () {
    given:
      def mockRepository = Mock(AmountService.AmountRepository.class)
      def amountService = new AmountService(mockRepository)
      int amount = 100;

    when:
      amountService.saveAmount(amount)

    then:
      //2 * mockRepository.saveAmount(new AmountService.Amount(amount))
      2 * mockRepository.saveAmount(_) //어떠한 파라미터가 와도 2번 실행
      //(3.._) * mockRepository.saveAmount(_) //최소 3번 이상
      //(_..3) * mockRepository.saveAmount(_) //최대 3번
  }
}
