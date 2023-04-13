package org.github.copilotx.copilotx.api;

import org.junit.jupiter.api.Test;

public class HelloResourceTests {

    @Test
    public void testHello() {
        HelloResource helloResource = new HelloResource();
        String result = helloResource.hello();

        assert (result.equals("Hello World!"));
    }




}
