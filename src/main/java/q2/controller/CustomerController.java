package q2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import q2.dto.CustomerDTO;
import q2.service.CustomerService;
import q2.validator.CustomerEntityFieldsConstraint;

@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/*-
	 * 1. Consider changing this to POST request if request parameter contain sensitive information to 
	 * prevent information from being stored in server or browser history 
	 * 2. Assuming the customers resource can be filtered and sort with the request parameters 
	 * 3. Added Basic field validation, additional Business Logic Validation can be added.  
	 * 4. Limited number of records can queried per request, to prevent abuse 
	 */
	@GetMapping
	public ResponseEntity<?> getCustomers(
			@RequestParam(name = "page", defaultValue = "0") @Min(value = 0, message = "should be more than or equal to 0") int page,
			@RequestParam(name = "pageSize", defaultValue = "10") @Min(value = 1, message = "should be more than or equal to 1") @Max(value = 20, message = "should be less than or equal to 20") int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "name") @CustomerEntityFieldsConstraint() String sortBy, 
			/* -
			 * @CustomerEntityFieldsConstraint is a custom field validation that only allows fields present in the Entity class.
			 * This is a dynamic class that automatically updates when the fields in the Entity class change.
			 * sortBy must only allow fields in the Entity Class.
			 */
			@RequestParam(name = "sortOrder", defaultValue = "asc") @Pattern(regexp = "(?i)^(asc|desc)$", message = "only asc or desc allowed") String sortOrder) {
		try {
			/*-
			 * Should be replace with a Logger library like log4j. 
			 */
			System.out.println("For Q2::" + this.getClass().getName() + "::getCustomers::started");
			
			List<CustomerDTO> customers = customerService.getCustomers(page, pageSize, sortBy, sortOrder);

			return ResponseEntity.status(HttpStatus.OK).body(customers);
		} catch (Exception e) {
			// Should only be triggered by uncaught exceptions
			System.out.println("For Q2::" + this.getClass().getName() + "::getCustomers::error");
			/*-
			 * Should be replace with a Logger library like log4j. 
			 */
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Unknown Error, Please inform your administrator");
		} finally {
			System.out.println("For Q2::" + this.getClass().getName() + "::getCustomers::ended");
		}
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleValidationExceptions(ConstraintViolationException ex) {
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error: " + ex.getMessage());
	}

}
