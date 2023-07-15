package base.core;

import org.openqa.selenium.By;

public class LocatorParser {
    public static By parseLocator(By by, Object... args) {
        String locatorFormat = locatorPattern(by.toString(), args);
        String locatorType = getLocatorTypeName(by);

        return switch (locatorType) {
            case "ByCssSelector" -> By.cssSelector(locatorFormat);
            case "ById" -> By.id(locatorFormat);
            case "ByName" -> By.name(locatorFormat);
            case "ByClassName" -> By.className(locatorFormat);
            case "ByTagName" -> By.tagName(locatorFormat);
            default -> By.xpath(locatorFormat);
        };
    }

    private static String locatorPattern(String str, Object... args) {
        return String.format(str.replaceAll("By\\.[^:]*:", "").trim(), args);
    }

    private static String getLocatorTypeName(By by) {
        return by.getClass().getSimpleName();
    }


}