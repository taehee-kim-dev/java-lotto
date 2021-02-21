package lotto.domain.ticketresult;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.ticketpurchase.PurchasePrice;
import lotto.domain.ticketpurchase.UserPurchase;
import lotto.type.LottoMatchType;

public class LottoResult {
    private static final int MIN_MATCH_NUMBER_COUNT_TO_GET_PRIZE = 3;
    private static final int SECOND_DECIMAL_PLACE = 2;

    private final WinningTicketAndBonusNumber winningLottoNumbers;
    private final Map<LottoMatchType, Integer> resultCounts;
    private final PurchasePrice purchasePrice;
    private long totalLottoWinningMoney;

    public LottoResult(WinningTicketAndBonusNumber winningLottoNumbers, UserPurchase userPurchase) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.resultCounts = new HashMap<>();
        initializeLottoCounts();
        this.purchasePrice = userPurchase.getPurchasePrice();
        this.totalLottoWinningMoney = 0;
    }

    private void initializeLottoCounts() {
        for (LottoMatchType lottoMatchType : LottoMatchType.values()) {
            resultCounts.put(lottoMatchType, 0);
        }
    }

    public void applyOneTicketResult(LottoTicket lottoTicket) {
        MatchedLottoNumbers matchedLottoNumbers = winningLottoNumbers
            .getMatchedLottoNumbers(lottoTicket);
        if (matchedLottoNumbers.getSizeOfNumbersNotIncludingBonusNumber()
            < MIN_MATCH_NUMBER_COUNT_TO_GET_PRIZE) {
            return;
        }
        increaseOneCountOfLottoMatchType(matchedLottoNumbers);
    }

    private void increaseOneCountOfLottoMatchType(MatchedLottoNumbers matchedLottoNumbersToGetPrize) {
        LottoMatchType lottoMatchType
            = LottoMatchType.getLottoMatchType(matchedLottoNumbersToGetPrize);
        resultCounts
            .computeIfPresent(lottoMatchType, (LottoMatchType key, Integer value) -> ++value);
    }

    public void addAllWinningMoney() {
        for (LottoMatchType lottoMatchType : resultCounts.keySet()) {
            int matchedCount = resultCounts.get(lottoMatchType);
            totalLottoWinningMoney += (long) lottoMatchType.getPrizeMoney() * (long) matchedCount;
        }
    }

    public int getCountOfMatchedNumbersOfSpecificType(LottoMatchType lottoMatchType) {
        return resultCounts.get(lottoMatchType);
    }

    public BigDecimal getProfit() {
        return new BigDecimal(String.valueOf(totalLottoWinningMoney))
            .divide(new BigDecimal(String.valueOf(purchasePrice.getPurchasePrice())),
                MathContext.DECIMAL32)
            .setScale(SECOND_DECIMAL_PLACE, BigDecimal.ROUND_HALF_UP);
    }
}
