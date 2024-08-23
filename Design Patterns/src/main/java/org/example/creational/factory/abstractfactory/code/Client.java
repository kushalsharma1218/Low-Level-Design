package org.example.creational.factory.abstractfactory.code;

import org.example.creational.factory.abstractfactory.code.components.button.Button;
import org.example.creational.factory.abstractfactory.code.components.dropdown.DropDown;
import org.example.creational.factory.abstractfactory.code.components.menu.Menu;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        UIFactory uiFactory = flutter.getUIFactory(PlatformEnum.ANDROID);

        /** We are sure now the button meny dropdown we receive will be Android based, client doesn't need to worry about anything else */
        Button button = uiFactory.createButton();
        Menu menu = uiFactory.createMenu();
        DropDown dropDown = uiFactory.createDropDown();

        button.changeSize();
    }
}
