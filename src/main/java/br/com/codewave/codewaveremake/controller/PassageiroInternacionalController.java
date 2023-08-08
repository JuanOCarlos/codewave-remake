package br.com.codewave.codewaveremake.controller;

import br.com.codewave.codewaveremake.model.Motorista;
import br.com.codewave.codewaveremake.model.Passageiro;
import br.com.codewave.codewaveremake.model.PassageiroInternacional;
import br.com.codewave.codewaveremake.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/passageirointernacional")
public class PassageiroInternacionalController {

    @Autowired
    private PassageiroInternacionalService passageiroInternacionalService;

    @Autowired
    private CorridaInternacionalService corridaInternacionalService;

    @Autowired
    private MotoristaService motoristaService;



    @PostMapping(value = "/novo")
    @Operation(summary = "Cria um passageiro" , description = "Método que acessa o método adicionar do service e cria passageiro")
    @ApiResponses({
            @ApiResponse(responseCode = "201" ,description = "Created - Passageiro criado com sucesso!"),
            @ApiResponse(responseCode = "404" ,description = "Erro - Parametro não localizado!"),
            @ApiResponse(responseCode = "500" ,description = "Erro inesperado!")
    })
    public ResponseEntity novoPassageiro(@Valid @RequestBody PassageiroInternacional passageiroInternacional) {
        try {
            passageiroInternacionalService.adicionar(passageiroInternacional);
        }catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel cadastrar um passageiro!" , HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Passageiro cadastrada com sucesso" , HttpStatus.CREATED);
    }

    @GetMapping(value = "/listartodas")
    @Operation(summary = "Lista todos os passageiros" , description = "Método que acessa o método listarTodos do service e lista todos os passageiros")
    @ApiResponses({
            @ApiResponse(responseCode = "200" ,description = "OK - passageiros listados com sucesso!"),
            @ApiResponse(responseCode = "404" ,description = "Erro - Lista de passageiros não localizada!"),
            @ApiResponse(responseCode = "500" ,description = "Erro inesperado!")
    })
    public ResponseEntity listarTodas() {
        try {
            return new ResponseEntity(passageiroInternacionalService.lsitarTodos() , HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel achar uma historico de passageiros!" , HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/listar/{cpf}")
    @Operation(summary = "Lista um passageiro" , description = "Método que acessa o método acharPorId do service e lista um passageiro")
    @ApiResponses({
            @ApiResponse(responseCode = "200" ,description = "OK - Passageiro listado com sucesso!"),
            @ApiResponse(responseCode = "404" ,description = "Erro - CPF do passageiro não localizado!"),
            @ApiResponse(responseCode = "500" ,description = "Erro inesperado!")
    })
    public ResponseEntity listarCorrida(@PathVariable String passaporte) {
        try {
            return new ResponseEntity(passageiroInternacionalService.acharPorPassaporte(passaporte) , HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Esse id não existe!" , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/atualizar/{cpf}")
    @Operation(summary = "Atualiza passageiro" , description = "Método que acessa o método atualizar do service e atualiza o passageiro")
    @ApiResponses({
            @ApiResponse(responseCode = "200" ,description = "OK - Passageiro atualizado com sucesso!"),
            @ApiResponse(responseCode = "404" ,description = "Erro - CPF do passageiro não localizado!"),
            @ApiResponse(responseCode = "500" ,description = "Erro inesperado!")
    })
    public ResponseEntity atualizar(@PathVariable String passaprte , @RequestBody PassageiroInternacional passageiroInternacional) {
        passageiroInternacionalService.atualizar(passaprte, passageiroInternacional);
        try {
            return new ResponseEntity("Passageiro atualizado com sucesso!" , HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Esse id não existe!" , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deletar/{cpf}")
    @Operation(summary = "Remove passageiro" , description = "Método que acessa o método remove do service e remove o passageiro")
    @ApiResponses({
            @ApiResponse(responseCode = "200" ,description = "OK - Passageiro removido com sucesso!"),
            @ApiResponse(responseCode = "404" ,description = "Erro - CPF do passageiro não localizado!"),
            @ApiResponse(responseCode = "500" ,description = "Erro inesperado!")
    })
    public ResponseEntity deletar(@PathVariable String passaporte) {
        passageiroInternacionalService.remove(passaporte);
        try {
            return new ResponseEntity("Passageiro " + passaporte + " deletado!" , HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Esse id não existe!" , HttpStatus.NOT_FOUND);
        }
    }

}



