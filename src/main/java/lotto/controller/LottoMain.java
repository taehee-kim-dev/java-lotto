package lotto.controller;

import lotto.domain.ticketgenerator.LottoGenerator;
import lotto.domain.ticketpurchase.LottoTickets;
import lotto.domain.ticketpurchase.UserPurchase;
import lotto.domain.ticketresult.LottoComparator;
import lotto.domain.ticketresult.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        UserPurchase userPurchase = getUserPurchaseInput();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoTickets purchasedLottoTickets = lottoGenerator.purchaseTickets(userPurchase);
        OutputView.printLottoTickets(purchasedLottoTickets);
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbersInput();
        LottoComparator lottoComparator = new LottoComparator(winningLottoNumbers, userPurchase);
        OutputView.printResult(lottoComparator.getLottoResult(purchasedLottoTickets));
    }

    private static UserPurchase getUserPurchaseInput() {
        try {
            return InputView.getUserPurchase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getUserPurchaseInput();
        }
    }

    private static WinningLottoNumbers getWinningLottoNumbersInput() {
        try {
            return InputView.getWinningLottoNumbers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getWinningLottoNumbersInput();
        }
    }
}
