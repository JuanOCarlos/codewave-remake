package br.com.codewave.codewaveremake.controller;

import br.com.codewave.codewaveremake.model.Corrida;
import br.com.codewave.codewaveremake.model.CorridaInternacional;
import br.com.codewave.codewaveremake.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/corridainternacional")
public class CorridaInternacionalController {

    @Autowired
    private CorridaInternacionalService corridaInternacionalService;

    @Autowired
    private MotoristaService motoristaService;

    @Autowired
    private PassageiroInternacionalService passageiroInternacionalService;
    @Autowired
    private DestinoService destinoService;

    @PostMapping(value = "/nova")
    public ResponseEntity cadastraNovaCorridaInternacional(@RequestBody CorridaInternacional corridaInternacional,
                                                           @RequestParam String cpfMotorista,
                                                           @RequestParam String passaportePassageiro,
                                                           @RequestParam Integer destinoId) {
        corridaInternacional.setMotorista(motoristaService.acharPorId(cpfMotorista));
        corridaInternacional.setPassageiroInternacional(passageiroInternacionalService.acharPorPassaporte(passaportePassageiro));
        corridaInternacional.setDestino(destinoService.acharPorId(destinoId));
        try {
            corridaInternacionalService.adicionar(corridaInternacional);
        }catch (NoSuchElementException e) {
            return new ResponseEntity("Erro inesperado!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Corrida cadastrada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping(value = "/listartodas")
    public ResponseEntity listarTodas() {
        try {
            return new ResponseEntity(corridaInternacionalService.listarTodos() , HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel achar uma historico de corrida!" , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity listarCorrida(@PathVariable Integer id) {
        try {
            return new ResponseEntity(corridaInternacionalService.acharPorId(id) , HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Esse id não existe!" , HttpStatus.NOT_FOUND);
        }catch (NullPointerException e) {
            return new ResponseEntity("" , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Integer id , @RequestBody CorridaInternacional corridaInternacional) {
        corridaInternacionalService.atualizar(id, corridaInternacional);
        try {
            return new ResponseEntity("Corrida atualizada com sucesso!" , HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Esse id não existe!" , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        corridaInternacionalService.remove(id);
        try {
            return new ResponseEntity("Corrida " + id + " cancelada!" , HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Esse id não existe!" , HttpStatus.NOT_FOUND);
        }
    }
}
