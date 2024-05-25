package com.wzz.cedulas.service;

import com.wzz.cedulas.dto.CedulasDto;

import java.util.List;

public interface CedulasService {
    List<CedulasDto> getAllCedulas();
    CedulasDto createCedula(CedulasDto cedulasDto);
    void deleteCedula(Long id);
    void deleteAllCedulas();
    void updateCedula(CedulasDto cedulasDto);
    CedulasDto getCedulaById(Long id);
}
