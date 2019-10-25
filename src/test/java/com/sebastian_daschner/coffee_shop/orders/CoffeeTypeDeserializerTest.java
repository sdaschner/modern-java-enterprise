package com.sebastian_daschner.coffee_shop.orders;

import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CoffeeTypeDeserializerTest {

    private CoffeeTypeDeserializer deserializer;

    @BeforeEach
    void setUp() {
        deserializer = new CoffeeTypeDeserializer();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testDeserialize(String serializedType, CoffeeType expectedType) {
        assertThat(deserializer.adaptFromJson(serializedType)).isEqualTo(expectedType);
    }

    private static Object[][] testData() {
        return new Object[][]{
                new Object[]{"Espresso", CoffeeType.ESPRESSO},
                new Object[]{"ESPRESSO", CoffeeType.ESPRESSO},
                new Object[]{"espresso", CoffeeType.ESPRESSO},
                new Object[]{"Latte", CoffeeType.LATTE},
                new Object[]{"LAtte", CoffeeType.LATTE},
                new Object[]{"pour_over", CoffeeType.POUR_OVER}
        };
    }

}