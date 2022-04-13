package dev.mokua.conectiontests;

import dev.mokua.utilities.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.sql.Connection;


public class ConnectionTests {

        @Test
        void can_connect(){
            Connection conn = ConnectionUtil.createConnection();
            Assertions.assertNotNull(conn);
        }
}

