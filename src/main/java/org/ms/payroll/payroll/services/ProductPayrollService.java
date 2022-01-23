package org.ms.payroll.payroll.services;

import org.modelmapper.ModelMapper;
import org.ms.payroll.payroll.dtos.ProductPayrollDTO;
import org.ms.payroll.payroll.entities.ProductPayroll;
import org.ms.payroll.payroll.repositories.ProductPayrollRepository;
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
public class ProductPayrollService implements Serializable {
    @Serial
    private static final long serialVersionUID = 5103377726849728177L;

    @Autowired
    private ProductPayrollRepository productPayrollRepository;
    @Autowired
    private ModelMapper mapper;

    public List<ProductPayrollDTO> findAll() {
       return productPayrollRepository
                .findAll().stream()
                .map(this::fromProductPayrollDTO)
               .collect(Collectors.toList());
    }

    public Page<ProductPayrollDTO> findAll(Pageable pageable) {
        return productPayrollRepository.findAll(pageable).map(this::fromProductPayrollDTO);
    }

    public ProductPayrollDTO save(ProductPayrollDTO entity) {
        ProductPayroll payroll = productPayrollRepository
                .save(fromProductvPayroll(entity));
        return fromProductPayrollDTO(payroll);
    }

    public ProductPayrollDTO findById(Long id) {
        Optional<ProductPayroll> payroll = productPayrollRepository.findById(id);
        return fromProductPayrollDTO(payroll
                .orElseThrow(() -> new NotFoundProductPayroll("Not found id:" + id)));
    }

    public void deleteById(Long aLong) {
        productPayrollRepository.deleteById(aLong);
    }

    public void delete(ProductPayrollDTO entity) {
        productPayrollRepository.delete(fromProductvPayroll(entity));
    }

    public ProductPayroll fromProductvPayroll(ProductPayrollDTO productPayrollDTO){
        return mapper.map(productPayrollDTO, ProductPayroll.class);
    }

    public ProductPayrollDTO fromProductPayrollDTO(ProductPayroll payroll){
        return mapper.map(payroll, ProductPayrollDTO.class);
    }
}
