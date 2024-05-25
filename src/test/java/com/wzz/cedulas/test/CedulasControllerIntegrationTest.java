package com.wzz.cedulas.test;

import com.wzz.cedulas.dto.CedulasDto;
import com.wzz.cedulas.service.CedulasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CedulasControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CedulasService cedulasService;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllCedulas() throws Exception {
        CedulasDto cedula1 = new CedulasDto();
        cedula1.setId(1L);
        cedula1.setTipo("REAL");
        cedula1.setValor(100.00);
        cedula1.setTipoCedula("123456789");
        cedula1.setPossuiNotaFiscal(true);
        cedula1.setDescricao("Cédula de Real");

        CedulasDto cedula2 = new CedulasDto();
        cedula2.setId(2L);
        cedula2.setTipo("DOLAR");
        cedula2.setValor(50.00);
        cedula2.setTipoCedula("987654321");
        cedula2.setPossuiNotaFiscal(false);
        cedula2.setDescricao("Cédula de Dólar");

        when(cedulasService.getAllCedulas()).thenReturn(Arrays.asList(cedula1, cedula2));

        mockMvc.perform(get("/v1/cedulas/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-Example-Header", "ExampleHeaderValue"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].valorFormatado", is("R$ 100.00")))
                .andExpect(jsonPath("$[1].valorFormatado", is("U$ 50.00")));
    }

    @Test
    public void testGetAllCedulasContainsValorFormatado() throws Exception {
        CedulasDto cedula1 = new CedulasDto();
        cedula1.setId(1L);
        cedula1.setTipo("REAL");
        cedula1.setValor(100.00);
        cedula1.setTipoCedula("123456789");
        cedula1.setPossuiNotaFiscal(true);
        cedula1.setDescricao("Cédula de Real");

        CedulasDto cedula2 = new CedulasDto();
        cedula2.setId(2L);
        cedula2.setTipo("DOLAR");
        cedula2.setValor(50.00);
        cedula2.setTipoCedula("987654321");
        cedula2.setPossuiNotaFiscal(false);
        cedula2.setDescricao("Cédula de Dólar");

        when(cedulasService.getAllCedulas()).thenReturn(Arrays.asList(cedula1, cedula2));

        mockMvc.perform(get("/v1/cedulas/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-Example-Header", "ExampleHeaderValue"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]", hasKey("valorFormatado")))
                .andExpect(jsonPath("$[1]", hasKey("valorFormatado")));
    }
}
