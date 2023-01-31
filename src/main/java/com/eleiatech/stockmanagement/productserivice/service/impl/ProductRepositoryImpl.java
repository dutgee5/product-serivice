package com.eleiatech.stockmanagement.productserivice.service.impl;

import com.eleiatech.stockmanagement.productserivice.enums.Language;
import com.eleiatech.stockmanagement.productserivice.exception.enums.FriendlyMessageCode;
import com.eleiatech.stockmanagement.productserivice.exception.exceptions.ProductNotCreatedException;
import com.eleiatech.stockmanagement.productserivice.repository.ProductRepository;
import com.eleiatech.stockmanagement.productserivice.repository.entity.Prdocut;
import com.eleiatech.stockmanagement.productserivice.request.ProductCreateRequest;
import com.eleiatech.stockmanagement.productserivice.request.ProductUpdateRequest;
import com.eleiatech.stockmanagement.productserivice.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductRepositoryImpl implements IProductRepositoryService {

    private final ProductRepository productRepository;



    @Override
    public Prdocut createdProduct(Language language, ProductCreateRequest productCreateRequest) {
        log.debug("[{}][createProduct] -> request: {}",this.getClass().getSimpleName(),productCreateRequest);
        try {
            Prdocut prdocut =Prdocut.builder()
                    .productName(productCreateRequest.getProductName())
                    .quantity(productCreateRequest.getQuantity())
                    .price(productCreateRequest.getPrice())
                    .deleted(false)
                    .build();
            Prdocut prdocutResponse=productRepository.save(prdocut);
            log.debug("[{}][createProduct] -> response: {}",this.getClass().getSimpleName(),prdocutResponse);
            return prdocutResponse;

        }catch (Exception exception){
            throw new ProductNotCreatedException(language , FriendlyMessageCode.PRODUCT_NOT_EXCEPTİON,"product request:"+productCreateRequest.toString());
        }
    }

    @Override
    public Prdocut getProduct(Language language, Long productId) {
        return null;
    }

    @Override
    public List<Prdocut> getProducts(Language language) {
        return null;
    }

    @Override
    public Prdocut updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest) {
        return null;
    }

    @Override
    public Prdocut deleteProduct(Language language, Long productId) {
        return null;
    }
}
