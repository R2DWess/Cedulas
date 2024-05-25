package com.wzz.cedulas.controller;

import com.wzz.cedulas.dto.CedulasDto;
import com.wzz.cedulas.service.CedulasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cedulas")
public class CedulasController {

    @Autowired
    private CedulasService cedulasService;

    @PostMapping("/create")
    public CedulasDto createCedula(@RequestBody CedulasDto cedulaDto) {
        return cedulasService.createCedula(cedulaDto);
    }

    @GetMapping("/all")
    public List<CedulasDto> getAllCedulas(@RequestHeader(value = "X-Example-Header", required = false) String exampleHeader) {
        // Use o valor do header conforme necessário
        System.out.println("Received header: " + exampleHeader);
        return cedulasService.getAllCedulas();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCedula(@PathVariable Long id) {
        cedulasService.deleteCedula(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCedulas() {
        cedulasService.deleteAllCedulas();
    }

    @PutMapping("/update")
    public void updateCedula(@RequestBody CedulasDto cedulaDto) {
        cedulasService.updateCedula(cedulaDto);
    }
}
