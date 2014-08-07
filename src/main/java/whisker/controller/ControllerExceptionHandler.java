package whisker.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import whisker.message.Message;

@Controller
public abstract class ControllerExceptionHandler {
	final static Logger LOG = LoggerFactory.getLogger("ControllerExceptionHandler");
	
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<Message> handleTypeMismatchException(HttpServletRequest req, TypeMismatchException ex){
		LOG.error("TypeMismatchException: "+ex.getMessage());
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		LOG.error(errors.toString());
		
		Message message = new Message(Message.Type.ERROR, "Type mismatch. Please check your request.");
		return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<Message> handleIllegalArgumentException(HttpServletRequest req, IllegalArgumentException ex){
		LOG.error("IllegalArgumentException " + ex.getMessage());
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		LOG.error(errors.toString());
		
		Message message = new Message(Message.Type.ERROR, "Cannot update or delete entity not in database.");
		return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
	}

}
