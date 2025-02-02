package com.ontariotechu.sofe3980U;
import com.ontariotechu.sofe3980U.BinaryAPIResult;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/add_json")
public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                               @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
    Binary number1 = new Binary(operand1);
    Binary number2 = new Binary(operand2);
    Binary result = Binary.add(number1, number2);
    
    // Return the result as an object with a 'value' field
    return new BinaryAPIResult(number1, "add", number2, result);
}

	 @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                           @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.multiply(number1, number2).getValue();
        // Example URL: http://localhost:8080/multiply?operand1=1010&operand2=11
    }
     @GetMapping("/multiply_json")
    public BinaryAPIResult multiplyJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                       @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "multiply", number2, Binary.multiply(number1, number2));
        // Example URL: http://localhost:8080/multiply_json?operand1=1010&operand2=11
    }
    @GetMapping("/and")
    public String and(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                      @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.and(number1, number2).getValue();
        // Example URL: http://localhost:8080/and?operand1=1100&operand2=1010
    }
    @GetMapping("/and_json")
    public BinaryAPIResult andJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                   @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "and", number2, Binary.and(number1, number2));
        // Example URL: http://localhost:8080/and_json?operand1=1100&operand2=1010
    }
    @GetMapping("/or")
    public String or(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                     @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.or(number1, number2).getValue();
        // Example URL: http://localhost:8080/or?operand1=1010&operand2=1100
    }
    @GetMapping("/or_json")
    public BinaryAPIResult orJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                  @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "or", number2, Binary.or(number1, number2));
        // Example URL: http://localhost:8080/or_json?operand1=1010&operand2=1100
    }
}