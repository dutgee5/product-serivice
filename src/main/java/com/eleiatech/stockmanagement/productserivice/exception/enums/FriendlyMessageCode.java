package com.eleiatech.stockmanagement.productserivice.exception.enums;

public enum FriendlyMessageCode implements IFriendlyMessageCode {
    OK(1000),
    Error(1001),
    SUCCESS(1002),
    PRODUCT_NOT_EXCEPTİON(1500),
    PRODUCT_SUCCESSFULLY_CREATED(1501);

    private final int value;

    FriendlyMessageCode(int value) {
        this.value = value;
    }

    @Override
    public int getFriendlyMessageCode() {
        return value;
    }
}
