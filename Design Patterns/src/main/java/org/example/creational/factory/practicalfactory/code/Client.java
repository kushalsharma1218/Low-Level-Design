package org.example.creational.factory.practicalfactory.code;

import org.example.creational.factory.practicalfactory.code.components.button.Button;
import org.example.creational.factory.practicalfactory.code.components.dropdown.DropDown;
import org.example.creational.factory.practicalfactory.code.components.menu.Menu;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter(PlatformEnum.ANDROID);
        UIFactory uiFactory = flutter.getUIFactory();

        /** We are sure now the button, menu, dropdown we receive will be Android based, client doesn't need to worry about anything else */
        Button button = uiFactory.createButton();
        Menu menu = uiFactory.createMenu();
        DropDown dropDown = uiFactory.createDropDown();

        button.changeSize();
    }
}
