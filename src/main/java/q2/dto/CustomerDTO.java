package q2.dto;

import q2.entity.CustomerEntity;

public class CustomerDTO {
	
    private String name;

	public CustomerDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	
	public static CustomerDTO toDTO(CustomerEntity customerEntity) {
		if (customerEntity == null) {
			return null;
		}

		return new CustomerDTO(customerEntity.getName());
	}
}
