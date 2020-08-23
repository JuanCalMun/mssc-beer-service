package guru.springframework.msscbeerservice.controller;

import guru.springframework.msscbeerservice.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerRestController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBeer(@RequestBody BeerDto beerDto) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity update(@PathVariable UUID beerId,
                                 @RequestBody BeerDto beerDto) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity update(@PathVariable UUID beerId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
