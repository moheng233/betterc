package site.moheng.betterc.error;

import lombok.Value;
import org.antlr.v4.runtime.RecognitionException;

@Value(staticConstructor = "of")
public class BCSyntaxError {
  int line;
  int charPositionInLine;
  String msg;
  RecognitionException exception;

}
