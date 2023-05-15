package com.subham;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    private DemoUtils demoUtils;

    /*gets called before each test method*/
    @BeforeEach
    void setupBeforeEach(){
       // System.out.println("@BeforeEach gets called before each test method");
        demoUtils = new DemoUtils();
    }


    @Test
    @DisplayName("Equal or not equal")
    @Order(1)
    @Disabled("Dont run until JIRA 123 story is resolved")
     void testEqualorNotEqualAdd(){
        //System.out.println("Run test: testEqualorNotEqualAdd");
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null or not null")
    @Order(2)
    @EnabledOnOs(OS.MAC)
     void testNullOrNotNull(){
        //System.out.println("Run test: testNullOrNotNull");
        String str1 = "Hello World";
        String str2 = null;
        assertNull(demoUtils.checkNull(str2));
        assertNotNull(demoUtils.checkNull(str1));
    }

    @Test
    @DisplayName("same or not same")
    @Order(3)
    @EnabledOnOs(OS.LINUX)
     void testSameOrNotSame(){

        String str = "Luv2Code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Should not refer to the same object");
    }

    @Test
    @DisplayName("Iterable Equal")
    @Order(4)
     void testIterable(){
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList());
    }

    @Test
    @DisplayName("Lines Match")
    @Order(5)
     void testLineMatch(){
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList());
    }

    @Test
    @DisplayName("Throws and does not throws")
    @Order(6)
     void testhrowAndDoesNotThrow(){
        assertThrows(Exception.class, ()->{
            demoUtils.throwException(-1);
        });

        assertDoesNotThrow(()->{demoUtils.throwException(9);});
    }

    @Test
    @DisplayName("Array Equal or Not")
    @Order(7)
     void testArrayEqualOrNot(){
        String[] str = {"A", "B", "C"};

        assertArrayEquals(str, demoUtils.getFirstThreeLettersOfAlphabet());
    }

    @Test
    @DisplayName("Multyply result")
    @Order(8)
     void testMultiply(){
        assertEquals(6, demoUtils.multiply(2,3));
    }

    @Test
    @DisplayName("Greater or not")
    @Order(9)
     void testGreaterOrNot(){
        assertTrue(demoUtils.isGreater(2,1));
    }

    @Test
    @DisplayName("Greater or not2")
    @Order(10)
     void testGreaterOrNot2(){
        assertFalse(demoUtils.isGreater(1, 2));
    }

    @Test
    @DisplayName("Timeout same or not")
    @Order(11)
     void testTimeout() throws InterruptedException {
        assertTimeout(Duration.ofSeconds(3),()->{
            demoUtils.checkTimeout();
        });
    }




    //
//    /*gets called after each test method*/
//    @AfterEach
//    void setupAfterEach(){
//        System.out.println("@AfterEach gets called after each test method");
//    }
//
//    /*gets called once before all the test method*/
//    @BeforeAll
//    static void setupBeforeAll(){
//        System.out.println("@BeforeAll gets called once before all the test method ");
//    }
//
//    /*gets called once after all the test method*/
//    @AfterAll
//    static void setupAfterAll(){
//        System.out.println("@AfterAll gets called once after all the test method ");
//    }

}