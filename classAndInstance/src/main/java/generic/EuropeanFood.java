package generic;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EuropeanFood {
    private int forkCnt;
    private int spoonCnt;
    private int knifeCnt;
}
