package enums;

import lombok.Data;

@Data
public class EnumGeneric<T> {
    T fruit;
}
