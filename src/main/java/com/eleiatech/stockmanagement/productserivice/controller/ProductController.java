package com.eleiatech.stockmanagement.productserivice.controller;

import com.eleiatech.stockmanagement.productserivice.enums.Language;
import com.eleiatech.stockmanagement.productserivice.exception.enums.FriendlyMessageCode;
import com.eleiatech.stockmanagement.productserivice.exception.utils.FriendlyMessageUtils;
import com.eleiatech.stockmanagement.productserivice.repository.entity.Prdocut;
import com.eleiatech.stockmanagement.productserivice.request.ProductCreateRequest;
import com.eleiatech.stockmanagement.productserivice.response.FriendlyMessage;
import com.eleiatech.stockmanagement.productserivice.response.InternalApiResponse;
import com.eleiatech.stockmanagement.productserivice.response.ProductResponse;
import com.eleiatech.stockmanagement.productserivice.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/1.0/product")
@RequiredArgsConstructor
 class ProductController {
    private final IProductRepositoryService productRepositoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{language}/create")
    public InternalApiResponse<ProductResponse> createProduct(@PathVariable("language")Language language,
                                                              @RequestBody ProductCreateRequest productCreateRequest){
        log.debug("[{}][createdProduct] -> request: {}",this.getClass().getSimpleName(),productCreateRequest);
        Prdocut prdocut =productRepositoryService.createdProduct(language,productCreateRequest);
        ProductResponse productResponse = convertProductResponse(prdocut);
        log.debug("[{}][createProduct] -> response: {}",this.getClass().getSimpleName(),productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCode.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCode.PRODUCT_SUCCESSFULLY_CREATED))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    private static ProductResponse convertProductResponse(Prdocut prdocut) {
        return ProductResponse.builder()
                .productId(prdocut.getProductId())
                .productName(prdocut.getProductName())
                .quantity(prdocut.getQuantity())
                .productCreatedDate(prdocut.getProductCreatedDate().getTime())
                .productUpdatedDate(prdocut.getProductUpdateDate().getTime())
                .build();
    }
}
