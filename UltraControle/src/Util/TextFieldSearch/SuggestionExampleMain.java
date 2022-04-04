/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.TextFieldSearch;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author celiobj
 */
public class SuggestionExampleMain {
  public static void main(String[] args) {
      JFrame frame = createFrame();
      JTextField textField = new JTextField(10);
      SuggestionDropDownDecorator.decorate(textField, new TextComponentSuggestionClient(SuggestionExampleMain::getSuggestions));
      JTextPane textPane = new JTextPane();
      SuggestionDropDownDecorator.decorate(textPane,new TextComponentWordSuggestionClient(SuggestionExampleMain::getSuggestions));
      frame.add(textField, BorderLayout.NORTH);
      frame.add(new JScrollPane(textPane));
      frame.setVisible(true);
  }

  private static List<String> words =
          RandomUtil.getWords(2, 400).stream().map(String::toLowerCase).collect(Collectors.toList());

  private static List<String> getSuggestions(String input) {
      //the suggestion provider can control text search related stuff, e.g case insensitive match, the search  limit etc.
      if (input.isEmpty()) {
          return null;
      }
      return words.stream()
                  .filter(s -> s.startsWith(input))
                  .limit(20)
                  .collect(Collectors.toList());
  }

  private static JFrame createFrame() {
      JFrame frame = new JFrame("Suggestion Dropdown Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(600, 300));
      return frame;
  }
}