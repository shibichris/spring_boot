package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<Object> handleException(BusinessException e){
		NotFoundExceptionSchema response=new NotFoundExceptionSchema(e.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
}
