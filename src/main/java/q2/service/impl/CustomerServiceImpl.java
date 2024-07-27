package q2.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import q2.dto.CustomerDTO;
import q2.entity.CustomerEntity;
import q2.repository.CustomerRepository;
import q2.service.CustomerService;
import q2.constant.Constants;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerDTO> getCustomers(int page, int pageSize, String sortBy, String sortOrder) throws Exception {
		try {
			System.out.println("For Q2::" + this.getClass().getName() + "::getCustomers::started");

			Pageable pagination;
			Page<CustomerEntity> entities = null;

			if (Constants.SORT_DESC.toLowerCase().equals(sortOrder.toLowerCase())) {
				System.out.println("For Q2::" + this.getClass().getName() + "::getCustomers::sortType::desc");
				pagination = PageRequest.of(page, pageSize, Sort.by(sortBy).descending());
			} else {
				System.out.println("For Q2::" + this.getClass().getName() + "::getCustomers::sortType::asc");
				pagination = PageRequest.of(page, pageSize, Sort.by(sortBy).ascending());
			}

			if (pagination != null) {
				entities = customerRepository.findAll(pagination);
			}

			if (entities != null) {
				/*-
				 * 1. In this demo, CustomerDTO only return name even though SampleCustomer Entity have other fields
				 * 2. Created custom static method to map Entity to DTO in CustomerDTO.java, opt to use other 
				 * open source libraries to like MapStruct for actual development.
				*/
				return entities.getContent().stream().map(CustomerDTO::toDTO).collect(Collectors.toList());
			}

			return Collections.emptyList();
		} catch (Exception e) {
			System.out.println("For Q2::" + this.getClass().getName() + "::getCustomers::error");
			/*-
			 * Should be replace with a Logger library like log4j. 
			 */
			e.printStackTrace();
			throw e;
		} finally {
			System.out.println("For Q2::" + this.getClass().getName() + "::getCustomers::ended");
		}

	}

}
