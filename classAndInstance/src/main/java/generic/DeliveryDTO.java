package generic;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO<T> {
    private T foodType;
    private int price;
    private String address;

}
