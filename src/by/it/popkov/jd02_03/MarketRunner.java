package by.it.popkov.jd02_03;

class MarketRunner {
    public static void main(String[] args) {
        Market market = new Market();
        market.writeGoodsMap();
        System.out.println("****** Open shop ******");
        market.letInCashier();
        market.letInAdministrator();
        market.letInBuyers();
        market.waitFinishWork();
        System.out.println("****** Close shop ******");

    }
}
