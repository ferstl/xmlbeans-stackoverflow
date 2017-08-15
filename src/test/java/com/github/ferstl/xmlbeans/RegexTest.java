package com.github.ferstl.xmlbeans;

import javax.management.MBeanServerFactory;
import org.apache.xmlbeans.impl.regex.Match;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.junit.Test;

public class RegexTest {

  private static final char[] CHARS = {'0','1','2','3','4','5','6','7','8','9'};

  @Test
  public void stackoverflow() {
    RegularExpression regex = new RegularExpression("[a-zA-Z0-9.,:'+-/()? ]+");
    char[] chars = createCharArray(5500);

    Match match = new Match();
    boolean matches = regex.matches(chars, 0, chars.length, match);

    System.out.println("Charachters: " + chars.length + ", Matches: " + matches + ", Groups:" + match.getNumberOfGroups());
  }


  private static char[] createCharArray(int size) {
    char[] chars = new char[size];

    int rest = size % 10;
    for (int i = 0; i < size - rest; i += 10) {
      chars[i] = CHARS[0];
      chars[i+1] = CHARS[1];
      chars[i+2] = CHARS[2];
      chars[i+3] = CHARS[3];
      chars[i+4] = CHARS[4];
      chars[i+5] = CHARS[5];
      chars[i+6] = CHARS[6];
      chars[i+7] = CHARS[7];
      chars[i+8] = CHARS[8];
      chars[i+9] = CHARS[9];
    }

    for (int i = size - rest; i < size; i++) {
      chars[i] = CHARS[i % 10];
    }

    return chars;
  }
}
