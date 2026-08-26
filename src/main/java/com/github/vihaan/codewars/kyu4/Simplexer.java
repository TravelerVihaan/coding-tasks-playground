package com.github.vihaan.codewars.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/// You'll need to implement a simple lexer type Simplexer, which, when constructed with a given string containing an expression in a simple language, transforms that string into a stream of Tokens.
/// Simplexer
///
/// Your Simplexer type is created with the expression it should tokenize. It should act like an iterator, yielding Token items until there are no more items to yield, at which point it should do whatever the appropriate action is for your chosen language.
///
/// Objects of the Simplexer class are instantiated with a string and should implement the Iterator<token> interface, meaning the Simplexer class must define the Token next() and the boolean hasNext() methods.
/// Tokens
/// </token>
///
/// Tokens are represented by Token objects, which are preloaded for you and take the following shape:
///```
/// public class Token {
///
/// public final String text;
///     public final String type;
///
/// public Token(String text, String type) {
///         this.text = text;
///         this.type = type;
///     }
/// }
///```
/// Token.text is the value of the matched portion of the expression
///     Token.type is the type of the token (see below)
///
/// Language Grammar
///```
/// The language for this task has a simple grammar, consisting of the following constructs and their associated token types:
///
/// Type         Construct
///
/// integer:     Any sequence of one or more decimal digits (leading zeroes allowed, no negative numbers)
///
/// boolean:     Any of the following words: [true, false]
///
/// string:      Any sequence of zero or more characters surrounded by "double quotes"
///
/// operator:    Any of the following characters: [+, -, \*, /, %, (, ), =]
///
/// keyword:     Any of the following words: if, else, for, while, return, func, break
///
/// whitespace:  Any sequence of the following characters: [' ', '\t', '\n']
///              \- Consecutive whitespace should be collapsed into a single token
///
/// identifier:  Any sequence of alphanumeric characters, as well as '\_' and '$'
///              \- Must not start with a digit
///              \- Make sure that keywords and booleans aren't matched as identifiers
///```
/// Notes
///
/// Individual constructs are disambiguated by whitespace if necessary, so
///         `true123` is an identifier, as opposed to boolean followed by integer
///         `123true` is an integer followed by boolean
///         `"123"true` is a string followed by boolean
///         `x+y` is identifier op identifier
///
/// Any character is permissable between double quotes, including keywords, numbers and arbitrary whitespace, so "true" and "123" are strings. The quotes "" are to be included in the Token.
///
/// The input strings are guaranteed to be lexically valid according to the grammar above. Specifically:
///         Input will consist only of valid constructs that can be mapped unambiguously to one of the above tokens
///         No assumptions need be made regarding the structure of tokens in the input, i.e. syntax.
///         Input may be the empty string
///
/// That means the input will not contain any surprising characters, there is no need for error handling, and quotes will always appear in balanced pairs. This does not mean that the input needs to make semantic or syntactic sense. For example, if 123) return else"five")( is valid input for this task.
///
/// After all, the job of a lexer is not to interpret the given input, merely transform it into tokens that could then be passed on to e.g. a parser, which would then check that the tokens received are syntactically valid and imbue them with semantics.
public class Simplexer implements Iterator<Simplexer.Token> {

    private int currentPosition = 0;
    private final List<Token> tokens = new ArrayList<>();

    public Simplexer(String buffer) {
        if (buffer == null) {
            return;
        }
        var currentBuffer = buffer;
        while (!currentBuffer.isEmpty()) {
            for (TokenType tokenType : TOKEN_TYPES_PRIORITY) {
                Pattern p = tokenType.getPattern();
                Matcher m = p.matcher(currentBuffer);
                if (m.lookingAt()) {
                    String tokenText = m.group();
                    Token newToken = new Token(tokenText, tokenType.getName());
                    currentBuffer = currentBuffer.replaceFirst(tokenType.getPattern().toString(), "");
                    tokens.add(newToken);
                    break;
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return currentPosition < tokens.size();
    }

    @Override
    public Token next() {
        var nextToken = tokens.get(currentPosition);
        currentPosition += 1;
        return nextToken;
    }

    public static class Token {

        public final String text;
        public final String type;

        public Token(String text, String type) {
            this.text = text;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Token token = (Token) o;
            return Objects.equals(text, token.text) && Objects.equals(type, token.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text, type);
        }

        @Override
        public String toString() {
            return "Token{" +
                "text='" + text + '\'' +
                ", type='" + type + '\'' +
                '}';
        }
    }

    private enum TokenType {
        INTEGER("\\d+", 3),
        BOOLEAN("\\b(true|false)\\b", 2),
        STRING("\"[^\"]*\"", 1),
        OPERATOR("[+\\-*/%()=]", 3),
        KEYWORD("\\b(if|else|for|while|return|func|break)\\b", 2),
        WHITESPACE("[ \\t\\n]+", 3),
        IDENTIFIER("[a-zA-Z_$][a-zA-Z0-9_$]*", 3);

        private final Pattern pattern;
        private final int priority;

        TokenType(String pattern,int priority) {
            this.pattern = Pattern.compile(pattern);
            this.priority = priority;
        }

        public Pattern getPattern() {
            return pattern;
        }

        public int getPriority() {
            return priority;
        }

        public String getName() {
            return this.name().toLowerCase();
        }
    }

    private static final List<TokenType> TOKEN_TYPES_PRIORITY = Arrays.stream(TokenType.values())
        .sorted(Comparator.comparingInt(TokenType::getPriority))
        .toList();

}