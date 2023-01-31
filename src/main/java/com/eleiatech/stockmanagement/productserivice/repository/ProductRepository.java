package com.eleiatech.stockmanagement.productserivice.repository;

import com.eleiatech.stockmanagement.productserivice.repository.entity.Prdocut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Prdocut,Long> {
    Prdocut getByProductIdAndDeletedFalse(Long productId);

    List<Prdocut> getAllByDeletedFalse();
}
