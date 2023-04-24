package br.com.maria.Calculadora.controller;

import br.com.maria.Calculadora.exceptions.InvalidNumberOperationException;
import br.com.maria.Calculadora.model.Calculadora;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CalculadoraController {

    @RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
    public float sum(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if(!isNumeric(n1)||!isNumeric(n2)){
            throw new InvalidNumberOperationException("Please, set valid numeric values");
        }
        return Calculadora.sum(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/sub/{n1}/{n2}", method = RequestMethod.GET)
    public float minus(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if(!isNumeric(n1)||!isNumeric(n2)){
            throw new InvalidNumberOperationException("Please, set valid numeric values");
        }
        return Calculadora.sub(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/mult/{n1}/{n2}", method = RequestMethod.GET)
    public float mult(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if(!isNumeric(n1)||!isNumeric(n2)){
            throw new InvalidNumberOperationException("Please, set valid numeric values");
        }
        return Calculadora.mult(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/div/{n1}/{n2}", method = RequestMethod.GET)
    public float div(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if(!isNumeric(n1)||!isNumeric(n2)) {
            throw new InvalidNumberOperationException("Please, set valid numeric values");
        }
        return Calculadora.div(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    public boolean isNumeric(String value){
        try{
            Float.parseFloat(value);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isNull(String value) {
        if (value.isBlank() || value == null) {
            return true;
        }else{
            return false;
        }
    }
}
