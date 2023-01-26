package com.eleiatech.stockmanagement.productserivice.exception.enums;

public enum FriendlyMessageCode implements IFriendlyMessageCode {
    OK(1000);
    private final int value;

    FriendlyMessageCode(int value) {
        this.value = value;
    }

    @Override
    public int getFriendlyMessageCode() {
        return value;
    }
}
