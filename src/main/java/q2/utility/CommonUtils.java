package q2.utility;

import java.lang.reflect.Field;

import io.micrometer.common.util.StringUtils;

public class CommonUtils {
	
	/**
	 * This validation assume that the recommended convention which Entity fields name matches Table Column Name is complied. 
	 *
	 * @param clazz Entity Class
	 * @param fieldName field to check if exist.
	 * @return return true if field name exist
	 */
	public static boolean hasField(Class<?> clazz, String fieldName) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                return true;
            }
        }
        return false;
    }

}
