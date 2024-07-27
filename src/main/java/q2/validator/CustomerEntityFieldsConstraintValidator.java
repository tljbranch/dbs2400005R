package q2.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import q2.entity.CustomerEntity;
import q2.utility.CommonUtils;


public class CustomerEntityFieldsConstraintValidator implements ConstraintValidator<CustomerEntityFieldsConstraint, String> {

    @Override
    public void initialize(CustomerEntityFieldsConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return CommonUtils.hasField(CustomerEntity.class, value);
    }
}