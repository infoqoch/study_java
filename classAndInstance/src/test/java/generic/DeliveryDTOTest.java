package generic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryDTOTest {
    @Test
    void 테스트() throws JsonProcessingException {

        DeliveryDTO asian = DeliveryDTO
                .builder()
                .foodType(AsianFood.builder().spoonCnt(5).stickCnt(7).build())
                .address("서울시 서울구 서울동")
                .price(10000)
                .build();

        DeliveryDTO european = DeliveryDTO
                .builder()
                .foodType(EuropeanFood.builder().spoonCnt(3).knifeCnt(6).forkCnt(7).build())
                .address("서울시 울서구 울서동")
                .price(60000)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        final String asianJson = objectMapper.writeValueAsString(asian);
        System.out.println(asianJson);

        final DeliveryDTO returnDTO = objectMapper.readValue(asianJson, DeliveryDTO.class);
        final Object foodType = returnDTO.getFoodType();
        System.out.println(returnDTO);
        System.out.println(foodType.getClass()); // LinkedHashMap
        System.out.println(foodType.toString()); // map이 출력된다.


        if(foodType instanceof AsianFood){
            System.out.println("아시안푸드");
            final AsianFood asianFood = (AsianFood) foodType;
            System.out.println(asianFood);
            System.out.println(asianFood.getClass());
        }else if(foodType instanceof EuropeanFood){
            System.out.println("유로피안푸드");
            final EuropeanFood europeanFood = (EuropeanFood) foodType;
            System.out.println(europeanFood);
            System.out.println(europeanFood.getClass());
        }else{
            System.out.println("뭔지 모르겠어 ㅠ");
        }
    }
}