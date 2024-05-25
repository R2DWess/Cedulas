package com.wzz.cedulas.test;

import com.wzz.cedulas.dto.CedulasDto;
import com.wzz.cedulas.enums.CedulasEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CedulasDtoTest {

    @Test
    public void testGetValorFormatadoReal() {
        CedulasDto cedula = new CedulasDto();
        cedula.setTipoCedula("123456789");
        cedula.setValor(100.00);

        String valorFormatado = cedula.getValorFormatado();
        assertEquals("R$ 100.00", valorFormatado);
    }

    @Test
    public void testGetValorFormatadoDolar() {
        CedulasDto cedula = new CedulasDto();
        cedula.setTipoCedula("987654321");
        cedula.setValor(50.00);

        String valorFormatado = cedula.getValorFormatado();
        assertEquals("U$ 50.00", valorFormatado);
    }

    @Test
    public void testGetValorFormatadoEuro() {
        CedulasDto cedula = new CedulasDto();
        cedula.setTipoCedula("112233445");
        cedula.setValor(75.00);

        String valorFormatado = cedula.getValorFormatado();
        assertEquals("€ 75.00", valorFormatado);
    }

    @Test
    public void testGetValorFormatadoMoedaNaoEncontrada() {
        CedulasDto cedula = new CedulasDto();
        cedula.setTipoCedula("000000000");
        cedula.setValor(100.00);

        String valorFormatado = cedula.getValorFormatado();
        assertEquals("Moeda não encontrada", valorFormatado);
    }
}
