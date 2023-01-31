package com.eleiatech.stockmanagement.productserivice.exception.exceptions;

import com.eleiatech.stockmanagement.productserivice.enums.Language;
import com.eleiatech.stockmanagement.productserivice.exception.enums.IFriendlyMessageCode;
import com.eleiatech.stockmanagement.productserivice.exception.utils.FriendlyMessageUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ProductNotCreatedException extends RuntimeException{
    private final Language language;
    private final IFriendlyMessageCode friendlyMessageCode;


    public ProductNotCreatedException(Language language, IFriendlyMessageCode friendlyMessageCode, String message) {
        super(FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode));
        this.language = language;
        this.friendlyMessageCode = friendlyMessageCode;
        log.error("[ProductNotException] -> message: {} developer message: {}",FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode),message);

    }
}
