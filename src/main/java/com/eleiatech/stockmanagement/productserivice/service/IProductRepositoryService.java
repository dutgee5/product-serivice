package com.eleiatech.stockmanagement.productserivice.service;


import com.eleiatech.stockmanagement.productserivice.enums.Language;
import com.eleiatech.stockmanagement.productserivice.repository.entity.Prdocut;
import com.eleiatech.stockmanagement.productserivice.request.ProductCreateRequest;
import com.eleiatech.stockmanagement.productserivice.request.ProductUpdateRequest;

import java.util.List;


public interface IProductRepositoryService {
    Prdocut createdProduct(Language language, ProductCreateRequest productCreateRequest);

    Prdocut getProduct(Language language,Long productId);

    List<Prdocut> getProducts(Language language);

    Prdocut updateProduct(Language language , Long productId, ProductUpdateRequest productUpdateRequest);

    Prdocut deleteProduct(Language language,Long productId);

}
