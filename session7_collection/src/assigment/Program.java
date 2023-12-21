package assigment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<GiftConfig> giftConfigs = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        List<GiftHistory> giftHistories = new ArrayList<>();


        giftConfigs.add(new GiftConfig("G001", "Quà 1", 0.5, false, 10, 2));
        giftConfigs.add(new GiftConfig("G002", "Quà 2", 0.3, false, 5, 1));
        giftConfigs.add(new GiftConfig("G003", "Quà 3", 0.2, true, 8, 2));

        players.add(new Player("P001", "Người chơi 1"));
        players.add(new Player("P002", "Người chơi 2"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Nhập mã người chơi để nhận quà");
            System.out.println("2. Xem danh sách quà đã nhận");
            System.out.println("3. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhập mã người chơi: ");
                    String playerCode = scanner.nextLine();
                    Player player = findPlayerByCode(players, playerCode);

                    if (player != null) {
                        GiftConfig gift = getGift(giftConfigs);
                        if (gift == null) {
                            System.out.println("Không còn quà. Nhận quà không giá trị.");
                            gift = getFreeGift(giftConfigs);
                        }

                        if (gift != null) {
                            System.out.println("Đã nhận quà: " + gift.getGiftName());
                            giftHistories.add(new GiftHistory(gift.getGiftCode(), player.getPlayerCode()));
                            updateGiftLimit(giftConfigs, gift);
                        }
                    } else {
                        System.out.println("Người chơi không tồn tại.");
                    }
                    break;

                case 2:
                    System.out.println("Nhập mã người chơi: ");
                    playerCode = scanner.nextLine();
                    displayGiftHistory(giftHistories, playerCode);
                    break;

                case 3:
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);

                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
    }

    private static Player findPlayerByCode(List<Player> players, String playerCode) {
        for (Player player : players) {
            if (player.getPlayerCode().equals(playerCode)) {
                return player;
            }
        }
        return null;
    }

    private static GiftConfig getGift(List<GiftConfig> giftConfigs) {
        Random random = new Random();
        double randomNumber = random.nextDouble();

        for (GiftConfig giftConfig : giftConfigs) {
            if (randomNumber < giftConfig.getRate() && giftConfig.getLimitTotal() > 0 && giftConfig.getLimitPlayer() > 0) {
                return giftConfig;
            }
        }

        return null;
    }

    private static GiftConfig getFreeGift(List<GiftConfig> giftConfigs) {
        for (GiftConfig giftConfig : giftConfigs) {
            if (giftConfig.isFree() && giftConfig.getLimitTotal() > 0 && giftConfig.getLimitPlayer() > 0) {
                return giftConfig;
            }
        }

        return null;
    }

    private static void updateGiftLimit(List<GiftConfig> giftConfigs, GiftConfig gift) {
        for (GiftConfig giftConfig : giftConfigs) {
            if (giftConfig.getGiftCode().equals(gift.getGiftCode())) {
                giftConfig.setLimitTotal();
                giftConfig.setLimitPlayer();
                break;
            }
        }
    }

    private static void displayGiftHistory(List<GiftHistory> giftHistories, String playerCode) {
        System.out.println("Danh sách quà đã nhận:");
        for (GiftHistory giftHistory : giftHistories) {
            if (giftHistory.getPlayerCode().equals(playerCode)) {
                System.out.println("Quà: " + giftHistory.getGiftCode());
            }
        }
    }
}
