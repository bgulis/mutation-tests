package uk.co.objectivity;

public final class Coin {
    private final int value;
    private final int size;

    public Coin(int value, int size) {
        this.value = value;
        this.size = size;
    }

    public int getValue() {
        return value;
    }

    public int getSize() {
        return size;
    }
}
