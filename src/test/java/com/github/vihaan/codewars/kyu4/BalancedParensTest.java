package com.github.vihaan.codewars.kyu4;

import com.github.vihaan.util.UnfinishedTask;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UnfinishedTask
public class BalancedParensTest {
   @Test
   public void testExample() {
      List<String> warriorsList = new ArrayList<String>();
      //test for n = 0
      warriorsList = BalancedParens.balancedParens(0);
      assertEquals(new ArrayList<String>(Arrays.asList(new String[] {""}))
                   ,  warriorsList
                   );
    //test for n = 1
      warriorsList = BalancedParens.balancedParens(1);
      assertEquals(new ArrayList<String>(Arrays.asList(new String[] {"()"}))
                   , warriorsList
                   );
    //test for n =2
      warriorsList = BalancedParens.balancedParens(2);
      Collections.sort(warriorsList);
      assertEquals(new ArrayList<String>(Arrays.asList(new String[] {"(())","()()"}))
                   , warriorsList
                   );
    //test for n = 3
      warriorsList = BalancedParens.balancedParens(3);
      Collections.sort(warriorsList);
      assertEquals(new ArrayList<String>(Arrays.asList(new String[] {"((()))","(()())","(())()","()(())","()()()"}))
                   , warriorsList
                   );
    //test for n = 4
      warriorsList = BalancedParens.balancedParens(4);
      Collections.sort(warriorsList);
      assertEquals(new ArrayList<String>(Arrays.asList(new String[] {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"}))
                  , warriorsList
                  );
    
    }
}