package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void showEnterBuyMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public int getBuyMoney() {
        final int buyMoney = scanner.nextInt();
        scanner.nextLine();
        return buyMoney;
    }

    public void showLottoBoughtMessage(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        final List<Lotto> lottoList = lottos.getLottos();
        lottoList.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void showEnterWinNumbersMessage() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
    }

    public List<Integer> getWinNumbers() {
        final String input = scanner.nextLine();
        final String[] inputs = input.split(",");
        return Arrays.stream(inputs)
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}