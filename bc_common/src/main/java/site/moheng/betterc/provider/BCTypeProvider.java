package site.moheng.betterc.provider;

import static site.moheng.betterc.antlr.BCParser.AccessSymbolContext;
import static site.moheng.betterc.antlr.BCParser.BooleanLiteralContext;
import static site.moheng.betterc.antlr.BCParser.CombinatorialLogicExpressionContext;
import static site.moheng.betterc.antlr.BCParser.ComparativeLogicExpressionContext;
import static site.moheng.betterc.antlr.BCParser.ExpressionContext;
import static site.moheng.betterc.antlr.BCParser.FloatLiteralContext;
import static site.moheng.betterc.antlr.BCParser.IntLiteralContext;
import static site.moheng.betterc.antlr.BCParser.LiteralContext;
import static site.moheng.betterc.antlr.BCParser.LiteralExpressionContext;
import static site.moheng.betterc.antlr.BCParser.MathsExpressionContext;
import static site.moheng.betterc.antlr.BCParser.MethodDeclarationContext;
import static site.moheng.betterc.antlr.BCParser.NotExpressionContext;
import static site.moheng.betterc.antlr.BCParser.StringLiteralContext;
import static site.moheng.betterc.antlr.BCParser.StructDeclarationContext;
import static site.moheng.betterc.antlr.BCParser.StructFieldContext;
import static site.moheng.betterc.antlr.BCParser.VariableExpressionContext;

import org.jetbrains.annotations.NotNull;
import site.moheng.betterc.symbol.BCLibrarySymbol;
import site.moheng.betterc.symbol.BCMethodSymbol;
import site.moheng.betterc.symbol.BCStructFieldSymbol;
import site.moheng.betterc.symbol.BCStructSymbol;
import site.moheng.betterc.symbol.BCTypeSymbol;
import site.moheng.betterc.symbol.IBCTypeSymbol;

public class BCTypeProvider {
  public IBCTypeSymbol getType(@NotNull ExpressionContext expression) {
    return switch (expression) {
      case NotExpressionContext ignored -> BCTypeSymbol.BOOLEAN;
      case CombinatorialLogicExpressionContext ignored -> BCTypeSymbol.BOOLEAN;
      case ComparativeLogicExpressionContext ignored -> BCTypeSymbol.BOOLEAN;
      case MathsExpressionContext context -> getType(context);
      case VariableExpressionContext context -> getType(context.accessSymbol());
      case LiteralExpressionContext context -> getType(context.literal());
      default -> throw new IllegalStateException("Unexpected value: " + expression);
    };
  }

  public BCLibrarySymbol getType(String packageName, String path) {
    return BCLibrarySymbol.of(packageName + ":" + path);
  }

  public BCStructFieldSymbol getType(@NotNull BCLibrarySymbol library,
                                     @NotNull StructFieldContext field) {
    return null;
  }

  public BCStructSymbol getType(@NotNull BCLibrarySymbol library,
                                @NotNull StructDeclarationContext declaration) {
    return BCStructSymbol.of(library, declaration.name.id.getText(),
        declaration.fields.stream().map((field) -> getType(library, field)).toList());
  }

  public BCMethodSymbol getType(@NotNull MethodDeclarationContext method) {
    /// TODO
    return null;
  }

  public IBCTypeSymbol getType(@NotNull AccessSymbolContext symbol) {
    /// TODO
    return null;
  }

  public IBCTypeSymbol getType(@NotNull MathsExpressionContext expression) {
    /// TODO
    return null;
  }

  public IBCTypeSymbol getType(@NotNull LiteralContext literal) {
    return switch (literal) {
      case BooleanLiteralContext ignored -> BCTypeSymbol.BOOLEAN;
      case IntLiteralContext ignored -> BCTypeSymbol.INT;
      case FloatLiteralContext ignored -> BCTypeSymbol.FLOAT;
      case StringLiteralContext ignored -> BCTypeSymbol.STRING;
      default -> throw new IllegalStateException("Unexpected value: " + literal);
    };
  }
}
