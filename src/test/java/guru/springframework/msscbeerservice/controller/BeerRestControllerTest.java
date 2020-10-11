package guru.springframework.msscbeerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.model.BeerDto;
import guru.springframework.msscbeerservice.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerRestController.class)
class BeerRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(
                get("/api/v1/beer/" + UUID.randomUUID().toString()))
                .andExpect(status().isOk());
    }

    @Test
    void createBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                .beerName("TestingBeer")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .price(BigDecimal.valueOf(1.2))
                .upc(12L)
                .build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                .beerName("TestingBeer")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .price(BigDecimal.valueOf(1.2))
                .upc(12L)
                .build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());

    }
}