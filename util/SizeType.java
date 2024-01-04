package util;

public enum SizeType {
    NORMAL(1),
    SINGLE(1),
    REGULAR(1),
    DOUBLE(2),
    LARGE(2);

    private final int value;
    SizeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
