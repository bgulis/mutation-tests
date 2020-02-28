package uk.co.objectivity;

import java.util.ArrayList;
import java.util.List;

public class WitcherService {
    private static final int MIN_ACCEPTABLE_VALUE = 10;
    private final List<Coin> pouch;
    private int currentPouchSize;
    private final int pouchCapacity;

    public WitcherService(int pouchCapacity) {
        this.pouchCapacity = pouchCapacity;
        pouch = new ArrayList<>(pouchCapacity);
    }

    public boolean toss(Coin coin) {
        if (coin.getValue() < MIN_ACCEPTABLE_VALUE) {
            throw new WitcherDissatisfiedException("zaraza");
        }
        if (coin.getSize() + currentPouchSize > pouchCapacity)
            return false;
        add(coin);
        return true;
    }

    private void add(Coin coin) {
        pouch.add(coin);
        currentPouchSize += coin.getSize();
    }
}
