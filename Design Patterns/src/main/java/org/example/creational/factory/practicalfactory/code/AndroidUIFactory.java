package org.example.creational.factory.practicalfactory.code;

import org.example.creational.factory.practicalfactory.code.components.button.AndroidButton;
import org.example.creational.factory.practicalfactory.code.components.dropdown.AndroidDropDown;
import org.example.creational.factory.practicalfactory.code.components.menu.AndroidMenu;

public class AndroidUIFactory implements UIFactory {

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
