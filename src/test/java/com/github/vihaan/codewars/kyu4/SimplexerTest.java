package com.github.vihaan.codewars.kyu4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplexerTest {

    @Test
    public void testEmpty() {
        Simplexer lexer = new Simplexer("");
        assertEquals(false, lexer.hasNext());
    }

    @Test
    public void testSingle() {
        // Identifier
        Simplexer lexer = new Simplexer("x");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Simplexer.Token("x", "identifier"), lexer.next());
        
        // Boolean
        lexer = new Simplexer("true");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Simplexer.Token("true", "boolean"), lexer.next());
        
        // Integer
        lexer = new Simplexer("12345");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Simplexer.Token("12345", "integer"), lexer.next());
        
        // String
        lexer = new Simplexer("\"Hello\"");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Simplexer.Token("\"Hello\"", "string"), lexer.next());
        
        // Keyword
        lexer = new Simplexer("break");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Simplexer.Token("break", "keyword"), lexer.next());
    }
    
    @Test
    public void testExperession() {
        // Simple expression
        Simplexer lexer = new Simplexer("(1 + 2) - 5");
        assertEquals(Arrays.asList(new Simplexer.Token[] {
            new Simplexer.Token("(", "operator"),
            new Simplexer.Token("1", "integer"),
            new Simplexer.Token(" ", "whitespace"),
            new Simplexer.Token("+", "operator"),
            new Simplexer.Token(" ", "whitespace"),
            new Simplexer.Token("2", "integer"),
            new Simplexer.Token(")", "operator"),
            new Simplexer.Token(" ", "whitespace"),
            new Simplexer.Token("-", "operator"),
            new Simplexer.Token(" ", "whitespace"),
            new Simplexer.Token("5", "integer")
        }), toList(lexer));
    }
    
    @Test
    public void testStatement() {
        // Simple statement.
        Simplexer lexer = new Simplexer("return x + 1");
        assertEquals(Arrays.asList(new Simplexer.Token[] {
            new Simplexer.Token("return", "keyword"),
            new Simplexer.Token(" ", "whitespace"),
            new Simplexer.Token("x", "identifier"),
            new Simplexer.Token(" ", "whitespace"),
            new Simplexer.Token("+", "operator"),
            new Simplexer.Token(" ", "whitespace"),
            new Simplexer.Token("1", "integer")
        }), toList(lexer));
    }
    
    private List<Simplexer.Token> toList(Simplexer lexer) {
        List<Simplexer.Token> tokens = new ArrayList<>();
        lexer.forEachRemaining(tokens::add);
        return tokens;
    }

}
