package org.example.creational.factory.abstractfactory.code;

import org.example.creational.factory.abstractfactory.code.components.button.AndroidButton;
import org.example.creational.factory.abstractfactory.code.components.button.Button;
import org.example.creational.factory.abstractfactory.code.components.dropdown.AndroidDropDown;
import org.example.creational.factory.abstractfactory.code.components.dropdown.DropDown;
import org.example.creational.factory.abstractfactory.code.components.menu.AndroidMenu;
import org.example.creational.factory.abstractfactory.code.components.menu.Menu;

public class AndroidUIFactory implements UIFactory{

    @Override
    public AndroidButton createButton() {
        return new AndroidButton();
    }

    @Override
    public AndroidMenu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public AndroidDropDown createDropDown() {
        return new AndroidDropDown();
    }
}
