package org.ms.payroll.payroll.services;

import org.modelmapper.ModelMapper;
import org.ms.payroll.payroll.dtos.ProductSeleDTO;
import org.ms.payroll.payroll.entities.ProductSele;
import org.ms.payroll.payroll.repositories.ProductSeleRepository;
import org.ms.payroll.payroll.services.exceptions.NotFoundProductPayroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductSeleService implements Serializable {
    @Serial
    private static final long serialVersionUID = 5103377726849728177L;

    @Autowired
    private ProductSeleRepository productSeleRepository;
    @Autowired
    private ModelMapper mapper;

    public List<ProductSeleDTO> findAll() {
       return productSeleRepository
                .findAll().stream()
                .map(this::fromProductPayrollDTO)
               .collect(Collectors.toList());
    }

    public Page<ProductSeleDTO> findAll(Pageable pageable) {
        return productSeleRepository.findAll(pageable).map(this::fromProductPayrollDTO);
    }

    public ProductSeleDTO save(ProductSeleDTO entity) {
        ProductSele payroll = productSeleRepository
                .save(fromProductSele(entity));
        return fromProductPayrollDTO(payroll);
    }

    public ProductSeleDTO findById(Long id) {
        Optional<ProductSele> payroll = productSeleRepository.findById(id);
        return fromProductPayrollDTO(payroll
                .orElseThrow(() -> new NotFoundProductPayroll("Not found id:" + id)));
    }

    public void deleteById(Long aLong) {
        productSeleRepository.deleteById(aLong);
    }

    public void delete(ProductSeleDTO entity) {
        productSeleRepository.delete(fromProductSele(entity));
    }

    public ProductSele fromProductSele(ProductSeleDTO productSeleDTO){
        return mapper.map(productSeleDTO, ProductSele.class);
    }

    public ProductSeleDTO fromProductPayrollDTO(ProductSele productSele){
        return mapper.map(productSele, ProductSeleDTO.class);
    }
}
