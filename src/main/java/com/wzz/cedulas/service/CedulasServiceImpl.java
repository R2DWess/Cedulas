package com.wzz.cedulas.service.impl;

import com.wzz.cedulas.dto.CedulasDto;
import com.wzz.cedulas.enums.CedulasEnum;
import com.wzz.cedulas.resource.CedulasResource;
import com.wzz.cedulas.service.CedulasRepository;
import com.wzz.cedulas.service.CedulasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CedulasServiceImpl implements CedulasService {

    @Autowired
    private CedulasRepository cedulasRepository;

    @Override
    public void updateCedula(CedulasDto cedulasDto) {
        CedulasResource cedulasResource = convertToEntity(cedulasDto);
        cedulasRepository.save(cedulasResource);
    }

    @Override
    public List<CedulasDto> getAllCedulas() {
        return cedulasRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CedulasDto createCedula(CedulasDto cedulasDto) {
        CedulasResource cedulasResource = convertToEntity(cedulasDto);
        CedulasResource savedResource = cedulasRepository.save(cedulasResource);
        return convertToDto(savedResource);
    }

    @Override
    public void deleteCedula(Long id) {
        cedulasRepository.deleteById(id);
    }

    @Override
    public void deleteAllCedulas() {
        cedulasRepository.deleteAll();
    }

    @Override
    public CedulasDto getCedulaById(Long id) {
        Optional<CedulasResource> cedulasResource = cedulasRepository.findById(id);
        return cedulasResource.map(this::convertToDto).orElse(null);
    }

    private CedulasDto convertToDto(CedulasResource cedulasResource) {
        CedulasDto cedulasDto = new CedulasDto();
        cedulasDto.setId(cedulasResource.getId());
        cedulasDto.setTipo(cedulasResource.getTipo());
        cedulasDto.setValor(cedulasResource.getValor());
        cedulasDto.setTipoCedula(cedulasResource.getTipoCedula());
        cedulasDto.setPossuiNotaFiscal(cedulasResource.isPossuiNotaFiscal());
        cedulasDto.setDescricao(cedulasResource.getDescricao());
        cedulasDto.setValorFormatado(cedulasDto.getValorFormatado());  // Utilize o método de formatação de CedulasDto

        return cedulasDto;
    }

    private CedulasResource convertToEntity(CedulasDto cedulasDto) {
        CedulasResource cedulasResource = new CedulasResource();
        cedulasResource.setId(cedulasDto.getId());
        cedulasResource.setTipo(cedulasDto.getTipo());
        cedulasResource.setValor(cedulasDto.getValor());
        cedulasResource.setTipoCedula(cedulasDto.getTipoCedula());
        cedulasResource.setPossuiNotaFiscal(cedulasDto.isPossuiNotaFiscal());
        cedulasResource.setValorFormatado(cedulasDto.getValorFormatado());  // Utilize o método de formatação de CedulasDto
        cedulasResource.setDescricao(cedulasDto.getDescricao());
        return cedulasResource;
    }
}
