package org.example.creational.factory.practicalfactory.code;

import org.example.creational.factory.practicalfactory.code.components.button.IosButton;
import org.example.creational.factory.practicalfactory.code.components.dropdown.IosDropDown;
import org.example.creational.factory.practicalfactory.code.components.menu.IosMenu;

public class IosUIFactory implements UIFactory {

    @Override
    public IosButton createButton() {
        return new IosButton();
    }

    @Override
    public IosMenu createMenu() {
        return new IosMenu();
    }

    @Override
    public IosDropDown createDropDown() {
        return new IosDropDown();
    }
}
