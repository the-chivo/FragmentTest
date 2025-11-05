package com.example.tickets;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.tickets.Model.Calculadora;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void testSuma(){
        assertEquals(5, Calculadora.sumar(2,3));
    }
    @Test(expected = ArithmeticException.class)  //Si divides por 0 salta aritmetic exception pero si le añades el expected ya no salta.
    public void testDivision(){
        assertEquals(5, Calculadora.dividir(10, 0));
    }
}