package whisker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import whisker.message.Message;

public interface ControllerInterface <T> {

	public ResponseEntity<Message> get(Integer id);
	
	public ResponseEntity<Message> save(T t, BindingResult bindingResult);
	
	public ResponseEntity<Message> update(T t, BindingResult bindingResult);
	
	public ResponseEntity<Message> delete(Integer id);
}
