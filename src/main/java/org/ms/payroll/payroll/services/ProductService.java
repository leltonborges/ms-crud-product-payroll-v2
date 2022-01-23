package org.ms.payroll.payroll.services;

import org.modelmapper.ModelMapper;
import org.ms.payroll.payroll.dtos.ProductDTO;
import org.ms.payroll.payroll.entities.product.Product;
import org.ms.payroll.payroll.repositories.product.ProductRepository;
import org.ms.payroll.payroll.services.exceptions.NotFoundProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

@Service
public class ProductService implements Serializable {
    @Serial
    private static final long serialVersionUID = 999877923538479351L;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return fromDTO(product.orElseThrow(() -> new NotFoundProduct("Not Found id: " + id)));
    }

    public ProductDTO fromDTO(Product product) {
        return mapper.map(product, ProductDTO.class);
    }

    public Product from(ProductDTO productDTO) {
        return mapper.map(productDTO, Product.class);
    }
}
