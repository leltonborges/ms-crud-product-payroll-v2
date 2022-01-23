package org.ms.payroll.payroll.resources;

import org.ms.payroll.payroll.dtos.ProductDTO;
import org.ms.payroll.payroll.dtos.ProductPayrollDTO;
import org.ms.payroll.payroll.services.ProductPayrollService;
import org.ms.payroll.payroll.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/payroll")
public class ProductPayrollResource {

    @Autowired
    private ProductPayrollService productPayrollService;
    @Autowired
    private ProductService productService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Page<ProductPayrollDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "15") Integer limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            @RequestParam(value = "orderType", defaultValue = "id") String  orderType){
        Sort.Direction sort = direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, limit, sort, orderType);
        return ResponseEntity.accepted()
                .body(productPayrollService.findAll(pageable));
    }

    @GetMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductPayrollDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(productPayrollService.findById(id));
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Void> delete(@RequestParam(value = "id")Optional<Long> id){
        if(id.isPresent()){
            ProductPayrollDTO payrollDTO = productPayrollService.findById(id.get());
            productPayrollService.delete(payrollDTO);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(name = "postProductPayroll",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductPayrollDTO> insert(@RequestBody ProductPayrollDTO productPayrollDTO){
        ProductPayrollDTO dto = productPayrollService.save(productPayrollDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(name = "updateProductPayroll",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductPayrollDTO> update(@RequestBody ProductPayrollDTO productDTO){
        ProductPayrollDTO dto = productPayrollService.save(productDTO);
        return ResponseEntity.ok(dto);
    }
}
