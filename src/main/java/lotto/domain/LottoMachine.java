package lotto.domain;

public class LottoMachine {
    private final LottoGenerator lottoGenerator;

    public LottoMachine() {
        this.lottoGenerator = new LottoGenerator();
    }

    public PurchasedLottoTickets purchaseLottoTicket(UserPurchase userPurchase) {
        return lottoGenerator.generatePurchasedTickets(userPurchase.getNumberOfTicket());
    }
}
