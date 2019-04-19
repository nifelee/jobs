package com.nifelee.modern;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AmountService {

  private final AmountRepository amountRepository;

  public long getAmount() {
    return 100L;
  }

  public void saveAmount(int a) {
    Amount amount = new Amount(a);

    amountRepository.saveAmount(amount);
    amountRepository.saveAmount(amount);
  }

  public class AmountRepository {

    public void saveAmount(Amount amount) {
      log.debug("{}", amount);
    }

  }

  @ToString
  @AllArgsConstructor
  public static class Amount {
    final int amount;
  }

}
