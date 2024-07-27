package q2.service;

import java.util.List;

import q2.dto.CustomerDTO;

public interface CustomerService {
	public List<CustomerDTO> getCustomers(int page, int pageSize, String sortBy, String sortOrder) throws Exception;
}
