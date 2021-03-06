package io.github.ztkmkoo.dss.core.network.rest.enumeration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.github.ztkmkoo.dss.core.network.rest.exception.NotSupportedRestMethodException;
import io.netty.handler.codec.http.HttpMethod;

/**
 * Project: dss
 * Created by: @ztkmkoo(ztkmkoo@gmail.com)
 * Date: 20. 3. 5. 오전 12:57
 */
class DssRestMethodTypeTest {

    @Test
    void fromNettyHttpMethod() {
        final DssRestMethodType methodType = DssRestMethodType.fromNettyHttpMethod(HttpMethod.GET);
        assertEquals(DssRestMethodType.GET, methodType);
    }

    @Test
    void fromNettyHttpMethodNotSupported() {
        assertThrows(NotSupportedRestMethodException.class,
            () -> DssRestMethodType.fromNettyHttpMethod(HttpMethod.HEAD));
    }

    @Test
    void valueOf() {
        final DssRestMethodType methodType = DssRestMethodType.valueOf("GET");
        assertEquals(DssRestMethodType.GET, methodType);
    }
}